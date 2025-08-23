package cn.xa.eyre.service;

import cn.hutool.crypto.digest.DigestUtil;
import cn.xa.eyre.comm.domain.Users;
import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.core.domain.R;
import cn.xa.eyre.common.core.kafka.DBMessage;
import cn.xa.eyre.common.utils.DateUtils;
import cn.xa.eyre.common.utils.StringUtils;
import cn.xa.eyre.common.utils.bean.BeanUtils;
import cn.xa.eyre.hisapi.CommFeignClient;
import cn.xa.eyre.hisapi.MedrecFeignClient;
import cn.xa.eyre.hisapi.OutpadmFeignClient;
import cn.xa.eyre.hisapi.OutpdoctFeignClient;
import cn.xa.eyre.hub.domain.emrmonitor.EmrOutpatientRecord;
import cn.xa.eyre.hub.domain.emrreal.EmrActivityInfo;
import cn.xa.eyre.hub.service.SynchroEmrMonitorService;
import cn.xa.eyre.hub.service.SynchroEmrRealService;
import cn.xa.eyre.hub.staticvalue.HubCodeEnum;
import cn.xa.eyre.medrec.domain.PatMasterIndex;
import cn.xa.eyre.outpadm.domain.ClinicMaster;
import cn.xa.eyre.outpdoct.domain.OutpMr;
import cn.xa.eyre.system.dict.domain.DictDisDept;
import cn.xa.eyre.system.dict.domain.DictDiseaseIcd10;
import cn.xa.eyre.system.dict.mapper.DictDisDeptMapper;
import cn.xa.eyre.system.dict.mapper.DictDiseaseIcd10Mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OutpdoctConvertService {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MedrecFeignClient medrecFeignClient;
    @Autowired
    private OutpadmFeignClient outpadmFeignClient;
    @Autowired
    private SynchroEmrMonitorService synchroEmrMonitorService;
    @Autowired
    SynchroEmrRealService synchroEmrRealService;
    @Autowired
    private CommFeignClient commFeignClient;
    @Autowired
    private HubToolService hubToolService;

    public void outpMr(DBMessage dbMessage) {
        logger.debug("OUTP_MR表变更接口");
        logger.debug("OUTP_MR表变更需调用emrActivityInfo、emrOutpatientRecord同步接口");

        String httpMethod = null;
        OutpMr outpMr;
        Map<String, String> data;
        if(dbMessage.getOperation().equalsIgnoreCase("DELETE")){
            httpMethod = Constants.HTTP_METHOD_DELETE;
            data = dbMessage.getBeforeData();
        }else {
            httpMethod = Constants.HTTP_METHOD_POST;
            data = dbMessage.getAfterData();
        }

        try {
            outpMr = BeanUtils.mapToObject(data, OutpMr.class);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        if (StringUtils.isNotBlank(outpMr.getPatientId())){
            logger.debug("构造emrOutpatientRecord接口数据...");
            R<PatMasterIndex> medrecResult = medrecFeignClient.getPatMasterIndex(outpMr.getPatientId());
            R<ClinicMaster> outpadmResult = outpadmFeignClient.getClinicMaster(outpMr.getPatientId(), outpMr.getVisitNo(), DateUtils.dateTime(outpMr.getVisitDate()));
            if (R.SUCCESS == medrecResult.getCode() && medrecResult.getData() != null
                    && R.SUCCESS == outpadmResult.getCode() && outpadmResult.getData() != null){
                // 军队医改不推送
                /*if (outpadmResult.getData().getChargeType().equals(Constants.CHARGE_TYPE_JDYG)){
                    logger.error("费别为军队医改，不推送数据");
                    return;
                }*/
                // 更新推送患者信息
                hubToolService.syncPatInfo(medrecResult.getData());
                EmrOutpatientRecord emrOutpatientRecord = new EmrOutpatientRecord();
                // ID使用OUTP_MR表联合主键拼接计算MD5
                String id = DigestUtil.md5Hex(DateUtils.dateTime(outpMr.getVisitDate()) + outpMr.getVisitNo());
                emrOutpatientRecord.setId(id);
                emrOutpatientRecord.setPatientId(outpMr.getPatientId());
                emrOutpatientRecord.setSerialNumber(DigestUtil.md5Hex(outpMr.getPatientId() + outpMr.getVisitNo()));
                emrOutpatientRecord.setOutpatientDate(outpMr.getVisitDate());
                emrOutpatientRecord.setInitalDiagnosisCode(String.valueOf(1)); // 初诊标识，表中没有这个字段
                emrOutpatientRecord.setChiefComplaint(outpMr.getIllnessDesc());
                emrOutpatientRecord.setPresentIllnessHis(outpMr.getMedHistory());
                emrOutpatientRecord.setPastIllnessHis(outpMr.getAnamnesis());
                emrOutpatientRecord.setOperationHis(outpMr.getMedicalRecord());
                emrOutpatientRecord.setMaritalHis(outpMr.getMarrital());
                if(StringUtils.isNotBlank(outpMr.getIndividual())){
                    emrOutpatientRecord.setAllergyHisFlag("1");
                    emrOutpatientRecord.setAllergyHis(outpMr.getIndividual());
                }
                emrOutpatientRecord.setMenstrualHis(outpMr.getMenses());
                emrOutpatientRecord.setFamilyHis(outpMr.getFamilyIll());
                emrOutpatientRecord.setPhysicalExamination(outpMr.getBodyExam());

                // 诊断代码
                if (StringUtils.isBlank(outpMr.getDiagCode())){
                    // 诊断代码分组匹配
                    String[] diagCodes = outpMr.getDiagCode().split("&");
                    String[] diagNames = outpMr.getDiagDesc().split("&");
//                    dictDiseaseIcd10Mapper.selectByEmrCodeList(diagCodes);
                    List<DictDiseaseIcd10> codes = new ArrayList<>();
                    for (int i = 0; i < diagCodes.length; i++) {
                        DictDiseaseIcd10 dictDiseaseIcd10 = hubToolService.getDiseaseIcd10(diagCodes[i], diagNames[i]);
                        codes.add(dictDiseaseIcd10);
                    }
                    emrOutpatientRecord.setWmDiagnosisCode(codes.stream().map(DictDiseaseIcd10::getHubCode).collect(Collectors.joining("||")));
                    emrOutpatientRecord.setWmDiagnosisName(codes.stream().map(DictDiseaseIcd10::getHubName).collect(Collectors.joining("||")));

                    if (StringUtils.isNotBlank(outpMr.getDoctor())){
                        R<Users> user = commFeignClient.getUserByName(outpMr.getDoctor());
                        if (R.SUCCESS == user.getCode() && user.getData() != null){
                            emrOutpatientRecord.setOperatorId(user.getData().getUserId());
                        }
                    }
                    emrOutpatientRecord.setTreatment(outpMr.getAdvice());

                    PatMasterIndex patMasterIndex = medrecResult.getData();
                    emrOutpatientRecord.setPatientName(patMasterIndex.getName());
                    if (StringUtils.isBlank(patMasterIndex.getIdNo())){
                        emrOutpatientRecord.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE_OTHER.getCode());
                        emrOutpatientRecord.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE_OTHER.getName());
                        emrOutpatientRecord.setIdCard("-");
                    }else {
                        emrOutpatientRecord.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE.getCode());
                        emrOutpatientRecord.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE.getName());
                        emrOutpatientRecord.setIdCard(patMasterIndex.getIdNo());
                    }

                    ClinicMaster clinicMaster = outpadmResult.getData();
                    DictDisDept dictDisDept = hubToolService.getDept(clinicMaster.getVisitDept());

                    emrOutpatientRecord.setDeptCode(dictDisDept.getHubCode());
                    emrOutpatientRecord.setDeptName(dictDisDept.getHubName());

                    emrOutpatientRecord.setOrgCode(HubCodeEnum.ORG_CODE.getCode());
                    emrOutpatientRecord.setOrgName(HubCodeEnum.ORG_CODE.getName());
                    emrOutpatientRecord.setOperationTime(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, DateUtils.getNowDate()));
                    synchroEmrMonitorService.syncEmrOutpatientRecord(emrOutpatientRecord, httpMethod);

                    logger.debug("构造emrActivityInfo(门诊/急诊)接口数据...");
                    EmrActivityInfo emrActivityInfo = new EmrActivityInfo();
                    emrActivityInfo.setId(id);
                    emrActivityInfo.setPatientId(outpMr.getPatientId());
                    String clinicType = clinicMaster.getClinicType();
                    if (StringUtils.isNotBlank(clinicType)){
                        if (clinicType.contains("急诊号")){
                            emrActivityInfo.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_EMERGENCY.getCode());
                            emrActivityInfo.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_EMERGENCY.getName());
                        } else {
                            emrActivityInfo.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_OUTPATIENT.getCode());
                            emrActivityInfo.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_OUTPATIENT.getName());

                        }
                    }
                    emrActivityInfo.setSerialNumber(emrOutpatientRecord.getSerialNumber());
                    emrActivityInfo.setActivityTime(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, outpMr.getVisitDate()));
                    emrActivityInfo.setIdCardTypeCode(emrOutpatientRecord.getIdCardTypeCode());
                    emrActivityInfo.setIdCardTypeName(emrOutpatientRecord.getIdCardTypeName());
                    emrActivityInfo.setPatientName(patMasterIndex.getName());

                    emrActivityInfo.setChiefComplaint(outpMr.getIllnessDesc());
                    emrActivityInfo.setPresentIllnessHis(outpMr.getMedHistory());
                    emrActivityInfo.setPhysicalExamination(outpMr.getBodyExam());
                    emrActivityInfo.setDiagnoseTime(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, outpMr.getVisitDate()));

                    // 诊断代码
                    if (StringUtils.isNotBlank(emrOutpatientRecord.getWmDiagnosisCode())){
                        emrActivityInfo.setWmDiseaseCode(emrOutpatientRecord.getWmDiagnosisCode());
                        emrActivityInfo.setWmDiseaseName(emrOutpatientRecord.getWmDiagnosisName());
                    }else {
                        emrActivityInfo.setWmDiseaseCode(HubCodeEnum.DISEASE_ICD10_CODE.getCode());
                        emrActivityInfo.setWmDiseaseName(HubCodeEnum.DISEASE_ICD10_CODE.getName());
                    }
                    if (StringUtils.isNotBlank(outpMr.getDoctor())){
                        emrActivityInfo.setFillDoctor(outpMr.getDoctor());
                        emrActivityInfo.setOperatorId(emrOutpatientRecord.getOperatorId());
                    }else {
                        emrActivityInfo.setFillDoctor("-");
                        emrActivityInfo.setOperatorId("-");
                    }

                    emrActivityInfo.setDeptCode(dictDisDept.getHubCode());
                    emrActivityInfo.setDeptName(dictDisDept.getHubName());
                    emrActivityInfo.setOrgCode(HubCodeEnum.ORG_CODE.getCode());
                    emrActivityInfo.setOrgName(HubCodeEnum.ORG_CODE.getName());
                    emrActivityInfo.setOperationTime(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, DateUtils.getNowDate()));
                    synchroEmrRealService.syncEmrActivityInfo(emrActivityInfo, httpMethod);
                } else {
                    logger.error("{}，{}对应诊断编码为空，无法同步", outpMr.getPatientId(), DateUtils.dateTime(outpMr.getVisitDate()));
                }

            }else {
                logger.error("{}对应PatMasterIndex信息或ClinicMaster信息为空，无法同步", outpMr.getPatientId());
            }
        }else {
            logger.error("patientId为空，无法同步");
        }
    }
}
