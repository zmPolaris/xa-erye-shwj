package cn.xa.eyre.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.xa.eyre.comm.domain.Users;
import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.core.domain.R;
import cn.xa.eyre.common.core.kafka.DBMessage;
import cn.xa.eyre.common.utils.DateUtils;
import cn.xa.eyre.common.utils.StringUtils;
import cn.xa.eyre.common.utils.bean.BeanUtils;
import cn.xa.eyre.hisapi.CommFeignClient;
import cn.xa.eyre.hisapi.InpadmFeignClient;
import cn.xa.eyre.hisapi.MedrecFeignClient;
import cn.xa.eyre.hub.domain.emrmonitor.EmrDailyCourse;
import cn.xa.eyre.hub.domain.emrreal.EmrActivityInfo;
import cn.xa.eyre.hub.service.SynchroEmrMonitorService;
import cn.xa.eyre.hub.service.SynchroEmrRealService;
import cn.xa.eyre.hub.staticvalue.HubCodeEnum;
import cn.xa.eyre.lqt2024.domain.LqtCrbZd;
import cn.xa.eyre.medrec.domain.PatMasterIndex;
import cn.xa.eyre.medrec.domain.PatVisit;
import cn.xa.eyre.medrec.domain.PatVisitKey;
import cn.xa.eyre.system.dict.domain.DictDisDept;
import cn.xa.eyre.system.dict.mapper.DictDisDeptMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@Service
public class Lqt2024ConvertService {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MedrecFeignClient medrecFeignClient;
    @Autowired
    private SynchroEmrMonitorService synchroEmrMonitorService;
    @Autowired
    private CommFeignClient commFeignClient;
    @Autowired
    private HubToolService hubToolService;
    @Autowired
    private SynchroEmrRealService synchroEmrRealService;


    public void lqtCrbZd(DBMessage dbMessage) {
        logger.debug("住院诊断表LQT_CRB_ZD变更接口");
        logger.debug("LQT_CRB_ZD变更需调用emrDailyCourse、emrActivityInfo同步接口");
        String httpMethod = null;
        LqtCrbZd lqtCrbZd;
        Map<String, String> data;
        if(dbMessage.getOperation().equalsIgnoreCase("DELETE")){
            httpMethod = Constants.HTTP_METHOD_DELETE;
            data = dbMessage.getBeforeData();
        }else {
            httpMethod = Constants.HTTP_METHOD_POST;
            data = dbMessage.getAfterData();
        }
//        lqtCrbZd = BeanUtil.toBeanIgnoreError(data, LqtCrbZd.class);
//        lqtCrbZd.setActivityTime(DateUtils.getLongDate(data.get("activityTime")));
//        lqtCrbZd.setCreateTime(DateUtils.getLongDate(data.get("createTime")));
        try {
            lqtCrbZd = BeanUtils.mapToObject(data, LqtCrbZd.class);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        R<PatMasterIndex> medrecResult = medrecFeignClient.getPatMasterIndex(lqtCrbZd.getPatientId());
        PatVisitKey patVisitKey = new PatVisitKey();
        BeanUtil.copyProperties(lqtCrbZd, patVisitKey);
        R<PatVisit> patVisitResult = medrecFeignClient.getPatVisit(patVisitKey);
        if (R.SUCCESS == patVisitResult.getCode() && patVisitResult.getData() != null
                && R.SUCCESS == medrecResult.getCode() && medrecResult.getData() != null){
            // 更新推送患者信息
            hubToolService.syncPatInfo(medrecResult.getData());
            EmrDailyCourse emrDailyCourse = new EmrDailyCourse();
            // ID使用LQT_CRB_ZD表patientId、visitId、diagnosisNo拼接计算MD5
            String id = DigestUtil.md5Hex(lqtCrbZd.getPatientId() + lqtCrbZd.getVisitId() + lqtCrbZd.getDiagnosisNo());
            logger.debug("构造emrDailyCourse接口数据...");
            emrDailyCourse.setId(id);
            emrDailyCourse.setPatientId(lqtCrbZd.getPatientId());
            emrDailyCourse.setSerialNumber(DigestUtil.md5Hex(lqtCrbZd.getPatientId() + lqtCrbZd.getVisitId()));
            emrDailyCourse.setCreateDate(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, lqtCrbZd.getCreateTime()));
            emrDailyCourse.setCourse(lqtCrbZd.getIcd10name());

            emrDailyCourse.setPatientName(medrecResult.getData().getName());
            if (StringUtils.isBlank(medrecResult.getData().getIdNo())){
                emrDailyCourse.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE_OTHER.getCode());
                emrDailyCourse.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE_OTHER.getName());
                emrDailyCourse.setIdCard("-");
            }else {
                emrDailyCourse.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE.getCode());
                emrDailyCourse.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE.getName());
                emrDailyCourse.setIdCard(medrecResult.getData().getIdNo());
            }
            R<Users> user = commFeignClient.getUserByName(lqtCrbZd.getFillDoctor());
            if (R.SUCCESS == user.getCode() && user.getData() != null){
                emrDailyCourse.setOperatorId(user.getData().getUserId());
            }

            DictDisDept dictDisDept = hubToolService.getDept(lqtCrbZd.getDeptCode());

            emrDailyCourse.setDeptCode(dictDisDept.getHubCode());
            emrDailyCourse.setDeptName(dictDisDept.getHubName());

            emrDailyCourse.setOrgCode(HubCodeEnum.ORG_CODE.getCode());
            emrDailyCourse.setOrgName(HubCodeEnum.ORG_CODE.getName());
            emrDailyCourse.setOperationTime(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, lqtCrbZd.getActivityTime()));

            synchroEmrMonitorService.syncEmrDailyCourse(emrDailyCourse, httpMethod);

            logger.debug("构造emrActivityInfo(日常病程)接口数据...");
            EmrActivityInfo emrActivityInfo = new EmrActivityInfo();
            emrActivityInfo.setId(id);
            emrActivityInfo.setPatientId(emrDailyCourse.getPatientId());
            emrActivityInfo.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_HOSPITALIZATION.getCode());
            emrActivityInfo.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_HOSPITALIZATION.getName());
            emrActivityInfo.setSerialNumber(emrDailyCourse.getSerialNumber());
            emrActivityInfo.setActivityTime(emrDailyCourse.getOperationTime());
            emrActivityInfo.setIdCardTypeCode(emrDailyCourse.getIdCardTypeCode());
            emrActivityInfo.setIdCardTypeName(emrDailyCourse.getIdCardTypeName());
            emrActivityInfo.setIdCard(emrDailyCourse.getIdCard());
            emrActivityInfo.setPatientName(emrDailyCourse.getPatientName());
            emrActivityInfo.setDiagnoseTime(emrDailyCourse.getCreateDate());
            emrActivityInfo.setWmDiseaseCode(lqtCrbZd.getIcd10());
            emrActivityInfo.setWmDiseaseName(lqtCrbZd.getIcd10name());
            emrActivityInfo.setFillDoctor(lqtCrbZd.getFillDoctor());
            emrActivityInfo.setOperatorId(emrDailyCourse.getOperatorId());
            if (StringUtils.isBlank(emrDailyCourse.getOperatorId())){
                emrActivityInfo.setOperatorId("-");
            }
            emrActivityInfo.setDeptCode(emrDailyCourse.getDeptCode());
            emrActivityInfo.setDeptName(emrDailyCourse.getDeptName());
            emrActivityInfo.setOrgCode(emrDailyCourse.getOrgCode());
            emrActivityInfo.setOrgName(emrDailyCourse.getOrgName());
            emrActivityInfo.setOperationTime(DateUtils.getTime());
            synchroEmrRealService.syncEmrActivityInfo(emrActivityInfo, httpMethod);
        }else {
            logger.error("{}对应PatMasterIndex或PatVisit信息为空，无法同步", lqtCrbZd.getPatientId());
        }
    }
}
