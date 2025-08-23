package cn.xa.eyre.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONUtil;
import cn.xa.eyre.comm.domain.Users;
import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.core.domain.R;
import cn.xa.eyre.common.core.kafka.DBMessage;
import cn.xa.eyre.common.utils.DateUtils;
import cn.xa.eyre.common.utils.StringUtils;
import cn.xa.eyre.common.utils.bean.BeanUtils;
import cn.xa.eyre.hisapi.CommFeignClient;
import cn.xa.eyre.hisapi.MedrecFeignClient;
import cn.xa.eyre.hisapi.OutpdoctFeignClient;
import cn.xa.eyre.hub.domain.emrmonitor.EmrAdmissionInfo;
import cn.xa.eyre.hub.domain.emrreal.EmrActivityInfo;
import cn.xa.eyre.hub.service.SynchroEmrMonitorService;
import cn.xa.eyre.hub.service.SynchroEmrRealService;
import cn.xa.eyre.hub.staticvalue.HubCodeEnum;
import cn.xa.eyre.inpadm.domain.PatsInHospital;
import cn.xa.eyre.medrec.domain.*;
import cn.xa.eyre.outpdoct.domain.OutpMr;
import cn.xa.eyre.system.dict.domain.DatasetDiseaseData;
import cn.xa.eyre.system.dict.domain.DictDisDept;
import cn.xa.eyre.system.dict.domain.DictDiseaseIcd10;
import cn.xa.eyre.system.dict.mapper.DatasetDiseaseDataMapper;
import cn.xa.eyre.system.dict.mapper.DictDisDeptMapper;
import cn.xa.eyre.system.dict.mapper.DictDiseaseIcd10Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class InpadmConvertService {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MedrecFeignClient medrecFeignClient;
    @Autowired
    private SynchroEmrMonitorService synchroEmrMonitorService;
    @Autowired
    private DictDisDeptMapper dictDisDeptMapper;// 转码表
    @Autowired
    private CommFeignClient commFeignClient;
    @Autowired
    private OutpdoctFeignClient outpdoctFeignClient;
    @Autowired
    private DictDiseaseIcd10Mapper dictDiseaseIcd10Mapper;// ICD10转码表
    @Autowired
    private DatasetDiseaseDataMapper datasetDiseaseDataMapper;// 传染病
    @Autowired
    SynchroEmrRealService synchroEmrRealService;
    @Autowired
    private HubToolService hubToolService;

    public void patsInHospital(DBMessage dbMessage) {
        logger.debug("PATS_IN_HOSPITAL表变更接口");
        logger.debug("PATS_IN_HOSPITAL表变更需调用emrActivityInfo、emrAdmissionInfo同步接口");

        String httpMethod = null;
        PatsInHospital patsInHospital;
        Map<String, String> data;
        if(dbMessage.getOperation().equalsIgnoreCase("DELETE")){
            httpMethod = Constants.HTTP_METHOD_DELETE;
            data = dbMessage.getBeforeData();
        }else {
            httpMethod = Constants.HTTP_METHOD_POST;
            data = dbMessage.getAfterData();
        }
        try {
            patsInHospital = BeanUtils.mapToObject(data, PatsInHospital.class);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        logger.debug("构造emrAdmissionInfo接口数据...");
        R<PatMasterIndex> medrecResult = medrecFeignClient.getPatMasterIndex(patsInHospital.getPatientId());
        DiagnosisKey diagnosisKey = new DiagnosisKey(patsInHospital.getPatientId(), patsInHospital.getVisitId(), "2");
        R<Diagnosis> diagnosisResult = medrecFeignClient.getDiagnosis(diagnosisKey);
        if (R.SUCCESS == medrecResult.getCode() && medrecResult.getData() != null
                && R.SUCCESS == diagnosisResult.getCode() && diagnosisResult.getData() != null){
            // 更新推送患者信息
            hubToolService.syncPatInfo(medrecResult.getData());
            DiagnosticCategoryKey diagnosticCategoryKey = new DiagnosticCategoryKey();
            BeanUtil.copyProperties(diagnosisResult.getData(), diagnosticCategoryKey);
            R<DiagnosticCategory> diagnosticCatResult = medrecFeignClient.getDiagnosticCategory(diagnosticCategoryKey);
            if (R.SUCCESS != diagnosticCatResult.getCode() || diagnosticCatResult.getData() == null){
                logger.error("{}DiagnosticCategory信息为空，无法同步", JSONUtil.toJsonStr(diagnosticCategoryKey));
                return;
            }

            EmrAdmissionInfo emrAdmissionInfo = new EmrAdmissionInfo();
            // ID使用住院表patientId、visitId拼接计算MD5
            String id = DigestUtil.md5Hex(patsInHospital.getPatientId() + patsInHospital.getVisitId());
            emrAdmissionInfo.setId(id);
            emrAdmissionInfo.setPatientId(patsInHospital.getPatientId());
            emrAdmissionInfo.setSerialNumber(id);
            emrAdmissionInfo.setWardNo(patsInHospital.getWardCode());
            emrAdmissionInfo.setBedNo(String.valueOf(patsInHospital.getBedNo()));
            emrAdmissionInfo.setAdmissionDate(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, patsInHospital.getAdmissionDateTime()));
            // 治疗医生
            if (StringUtils.isNotBlank(patsInHospital.getDoctorInCharge())){
                R<Users> user = commFeignClient.getUserByName(patsInHospital.getDoctorInCharge());
                if (R.SUCCESS == user.getCode() && user.getData() != null){
                    emrAdmissionInfo.setResidentPhysicianId(user.getData().getUserId());
                    emrAdmissionInfo.setChiefPhysicianId(user.getData().getUserId());
                }
            }

            PatMasterIndex patMasterIndex = medrecResult.getData();
            emrAdmissionInfo.setPatientName(patMasterIndex.getName());
            if (StringUtils.isBlank(patMasterIndex.getIdNo())){
                emrAdmissionInfo.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE_OTHER.getCode());
                emrAdmissionInfo.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE_OTHER.getName());
                emrAdmissionInfo.setIdCard("-");
            }else {
                emrAdmissionInfo.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE.getCode());
                emrAdmissionInfo.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE.getName());
                emrAdmissionInfo.setIdCard(patMasterIndex.getIdNo());
            }

            DictDisDept dictDisDept = hubToolService.getDept(patsInHospital.getDeptCode());

            emrAdmissionInfo.setDeptCode(dictDisDept.getHubCode());
            emrAdmissionInfo.setDeptName(dictDisDept.getHubName());

            DictDiseaseIcd10 dictDiseaseIcd10 = hubToolService.getDiseaseIcd10(diagnosticCatResult.getData().getDiagnosisCode(), diagnosisResult.getData().getDiagnosisDesc());
            emrAdmissionInfo.setWmConfirmedDiagnosisCode(dictDiseaseIcd10.getHubCode());
            emrAdmissionInfo.setWmConfirmedDiagnosisName(dictDiseaseIcd10.getHubName());

            emrAdmissionInfo.setConfirmedDiagnosisDate(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, diagnosisResult.getData().getDiagnosisDate()));

            emrAdmissionInfo.setOrgCode(HubCodeEnum.ORG_CODE.getCode());
            emrAdmissionInfo.setOrgName(HubCodeEnum.ORG_CODE.getName());

            if (StringUtils.isNotBlank(patsInHospital.getDoctorInCharge())){
                R<Users> user = commFeignClient.getUserByName(patsInHospital.getDoctorInCharge());
                if (R.SUCCESS == user.getCode() && user.getData() != null){
                    emrAdmissionInfo.setOperatorId(user.getData().getUserId());
                }
            }

            emrAdmissionInfo.setOperationTime(DateUtils.getTime());
            synchroEmrMonitorService.syncEmrAdmissionInfo(emrAdmissionInfo, httpMethod);

            logger.debug("构造emrActivityInfo(入院)接口数据...");
            EmrActivityInfo emrActivityInfo = new EmrActivityInfo();
            emrActivityInfo.setId(id);
            emrActivityInfo.setPatientId(emrAdmissionInfo.getPatientId());
            emrActivityInfo.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_ADMISSION.getCode());
            emrActivityInfo.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_ADMISSION.getName());
            emrActivityInfo.setSerialNumber(emrAdmissionInfo.getSerialNumber());
            Date activityTime = new Date();
            if (patsInHospital.getAdmWardDateTime() != null){
                activityTime = patsInHospital.getAdmWardDateTime();
            }
            emrActivityInfo.setActivityTime(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, activityTime));
            emrActivityInfo.setIdCardTypeCode(emrAdmissionInfo.getIdCardTypeCode());
            emrActivityInfo.setIdCardTypeName(emrAdmissionInfo.getIdCardTypeName());
            emrActivityInfo.setIdCard(emrAdmissionInfo.getIdCard());
            emrActivityInfo.setPatientName(emrAdmissionInfo.getPatientName());
            emrActivityInfo.setChiefComplaint(emrAdmissionInfo.getChiefComplaint());
            emrActivityInfo.setPresentIllnessHis(emrAdmissionInfo.getPresentIllnessHis());
            emrActivityInfo.setStudiesSummaryResult(emrAdmissionInfo.getStudiesSummaryResult());
            emrActivityInfo.setDiagnoseTime(emrAdmissionInfo.getConfirmedDiagnosisDate());
            emrActivityInfo.setWmDiseaseCode(emrAdmissionInfo.getWmConfirmedDiagnosisCode());
            emrActivityInfo.setWmDiseaseName(emrAdmissionInfo.getWmConfirmedDiagnosisName());
            emrActivityInfo.setFillDoctor(patsInHospital.getDoctorInCharge());
            emrActivityInfo.setOperatorId(emrAdmissionInfo.getOperatorId());
            if (StringUtils.isBlank(emrAdmissionInfo.getOperatorId())){
                emrAdmissionInfo.setOperatorId("-");
            }
            emrActivityInfo.setDeptCode(emrAdmissionInfo.getDeptCode());
            emrActivityInfo.setDeptName(emrAdmissionInfo.getDeptName());
            emrActivityInfo.setOrgCode(emrAdmissionInfo.getOrgCode());
            emrActivityInfo.setOrgName(emrAdmissionInfo.getOrgName());
            emrActivityInfo.setOperationTime(DateUtils.getTime());
            synchroEmrRealService.syncEmrActivityInfo(emrActivityInfo, httpMethod);

        }else {
            logger.error("{}对应PatMasterIndex或Diagnosis信息为空，无法同步", patsInHospital.getPatientId());
        }
    }
}
