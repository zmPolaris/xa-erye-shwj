package cn.xa.eyre.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.xa.eyre.comm.domain.Users;
import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.core.domain.R;
import cn.xa.eyre.common.core.kafka.DBMessage;
import cn.xa.eyre.common.utils.DateUtils;
import cn.xa.eyre.common.utils.StringUtils;
import cn.xa.eyre.common.utils.bean.BeanUtils;
import cn.xa.eyre.exam.domain.ExamMaster;
import cn.xa.eyre.exam.domain.ExamReport;
import cn.xa.eyre.hisapi.*;
import cn.xa.eyre.hub.domain.emrmonitor.EmrExClinical;
import cn.xa.eyre.hub.domain.emrmonitor.EmrExClinicalItem;
import cn.xa.eyre.hub.service.SynchroEmrMonitorService;
import cn.xa.eyre.hub.staticvalue.HubCodeEnum;
import cn.xa.eyre.inpadm.domain.PatsInHospital;
import cn.xa.eyre.medrec.domain.PatMasterIndex;
import cn.xa.eyre.system.dict.domain.DictDisDept;
import cn.xa.eyre.system.dict.domain.DictExamItem;
import cn.xa.eyre.system.dict.domain.DictExamType;
import cn.xa.eyre.system.dict.mapper.DictDisDeptMapper;
import cn.xa.eyre.system.dict.mapper.DictExamItemMapper;
import cn.xa.eyre.system.dict.mapper.DictExamTypeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@Service
public class ExamConvertService {
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
    private InpadmFeignClient inpadmFeignClient;
    @Autowired
    private DictExamTypeMapper dictExamTypeMapper;
    @Autowired
    private DictExamItemMapper dictExamItemMapper;
    @Autowired
    private ExamFeignClient examFeignClient;
    @Autowired
    private HubToolService hubToolService;
    @Autowired
    private OutpdoctFeignClient outpdoctFeignClient;

    public void examMaster(DBMessage dbMessage) {
        logger.debug("检查主表EXAM_MASTER变更接口");
        logger.debug("EXAM_MASTER变更需调用emrExClinical、emrExClinicalItem同步接口");
        String httpMethod = null;
        ExamMaster examMaster;
        Map<String, String> data;
        if(dbMessage.getOperation().equalsIgnoreCase("DELETE")){
            httpMethod = Constants.HTTP_METHOD_DELETE;
            data = dbMessage.getBeforeData();
        }else {
            httpMethod = Constants.HTTP_METHOD_POST;
            data = dbMessage.getAfterData();
        }
        examMaster = BeanUtil.toBeanIgnoreError(data, ExamMaster.class);
        // 反查数据
        examMaster = examFeignClient.getExamMaster(examMaster.getExamNo()).getData();

        if(examMaster == null || StringUtils.isBlank(examMaster.getResultStatus()) || !"4".equals(examMaster.getResultStatus())){
            logger.error("检查报告未确认，无法同步");
            return;
        }

        R<ExamReport> examReportResult = examFeignClient.getExamReport(examMaster.getExamNo());
        R<PatMasterIndex> medrecResult = medrecFeignClient.getPatMasterIndex(examMaster.getPatientId());
        if (R.SUCCESS == examReportResult.getCode() && examReportResult.getData() != null
        && R.SUCCESS == medrecResult.getCode() && medrecResult.getData() != null){
            // 更新推送患者信息
            hubToolService.syncPatInfo(medrecResult.getData());
            DictDisDept dept = new DictDisDept();
            dept.setStatus(Constants.STATUS_NORMAL);
            dept.setIsDefault(Constants.IS_DEFAULT);
            DictDisDept dictDisDeptDefault = dictDisDeptMapper.selectByCondition(dept);

            ExamReport examReport = examReportResult.getData();

            logger.debug("构造emrExClinical接口数据...");
            EmrExClinical emrExClinical = new EmrExClinical();
            EmrExClinicalItem emrExClinicalItem = new EmrExClinicalItem();
            emrExClinical.setId(examMaster.getExamNo());
            emrExClinical.setPatientId(examMaster.getPatientId());
            if("2".equals(examMaster.getPatientSource()) || examMaster.getVisitId() != null){
                emrExClinical.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_HOSPITALIZATION.getCode());
                emrExClinical.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_HOSPITALIZATION.getName());
                emrExClinical.setSerialNumber(DigestUtil.md5Hex(examMaster.getPatientId() + examMaster.getVisitId()));
                R<PatsInHospital> hospitalResult = inpadmFeignClient.getPatsInHospital(examMaster.getPatientId(), examMaster.getVisitId());
                if (R.SUCCESS == hospitalResult.getCode() && hospitalResult.getData() != null){
                    emrExClinical.setWardNo(hospitalResult.getData().getWardCode());
                    emrExClinical.setBedNo(String.valueOf(hospitalResult.getData().getBedNo()));
                }
            }else if("1".equals(examMaster.getPatientSource()) || StringUtils.isNotBlank(examMaster.getVisitNo())){
                emrExClinical.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_OUTPATIENT.getCode());
                emrExClinical.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_OUTPATIENT.getName());
                emrExClinical.setSerialNumber(DigestUtil.md5Hex(examMaster.getPatientId() + examMaster.getVisitNo()));
            }else {
                logger.error("PATIENT_SOURCE:{}, 非门诊和住院，无法同步", examMaster.getPatientSource());
                return;
            }
            emrExClinical.setApplicationFormNo(examMaster.getPatientLocalId());
            if(StringUtils.isBlank(examMaster.getFacility())){
                emrExClinical.setApplyOrgCode(HubCodeEnum.ORG_CODE.getCode());
                emrExClinical.setApplyOrgName(HubCodeEnum.ORG_CODE.getName());
                emrExClinical.setOrgCode(HubCodeEnum.ORG_CODE.getCode());
                emrExClinical.setOrgName(HubCodeEnum.ORG_CODE.getName());
            }else {
                emrExClinical.setApplyOrgCode("-");
                emrExClinical.setApplyOrgName(examMaster.getFacility());
                emrExClinical.setOrgCode("-");
                emrExClinical.setOrgName(examMaster.getFacility());
            }
            if(StringUtils.isNotBlank(examMaster.getReqDept())){
                DictDisDept dictDisDept = hubToolService.getDept(examMaster.getReqDept());
                emrExClinical.setApplyDeptCode(dictDisDept.getHubCode());
                emrExClinical.setApplyDeptName(dictDisDept.getHubName());
            }
            emrExClinical.setSymptomDesc(examMaster.getClinDiag());
            DictExamType dictExamType = dictExamTypeMapper.selectByEmrName(examMaster.getExamClass());
            if (dictExamType == null){
                emrExClinical.setExaminationTypeCode(HubCodeEnum.PAY_TYPE_OTHER.getCode());
                emrExClinical.setExaminationTypeName(examMaster.getClinDiag());
            }else {
                emrExClinical.setExaminationTypeCode(dictExamType.getHubCode());
                emrExClinical.setExaminationTypeName(dictExamType.getHubName());
            }
            emrExClinical.setExaminationReportDate(DateUtils.dateTime(examMaster.getReportDateTime()));

            PatMasterIndex patMasterIndex = medrecResult.getData();
            emrExClinical.setPatientName(patMasterIndex.getName());
            if (StringUtils.isBlank(patMasterIndex.getIdNo())){
                emrExClinical.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE_OTHER.getCode());
                emrExClinical.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE_OTHER.getName());
                emrExClinical.setIdCard(medrecResult.getData().getIdNo());
            }else {
                emrExClinical.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE.getCode());
                emrExClinical.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE.getName());
                emrExClinical.setIdCard(patMasterIndex.getIdNo());
            }

            emrExClinical.setExaminationObjectiveDesc(examReport.getDescription());
            emrExClinical.setExaminationSubjectiveDesc(examReport.getRecommendation());
            // 检查报告编号使用EXAM_REPORT表EXAM_NO、DESCRIPTION拼接计算MD5
            String no = DigestUtil.md5Hex(examReport.getExamNo() + examReport.getDescription());
            emrExClinical.setExaminationReportId(no);
            String reportname = examMaster.getReporter();
            if (StringUtils.isBlank(reportname)){
                reportname = examMaster.getReqPhysician();
            }
            R<Users> user = commFeignClient.getUserByName(reportname);
            if (R.SUCCESS == user.getCode() && user.getData() != null){
                emrExClinical.setExaminationReportId(user.getData().getUserId());
                emrExClinical.setOperatorId(user.getData().getUserId());
                emrExClinicalItem.setOperatorId(user.getData().getUserId());
            }else {
                emrExClinical.setExaminationReportId("-");
                emrExClinical.setOperatorId("-");
                emrExClinicalItem.setOperatorId("-");
            }
            if (StringUtils.isNotBlank(examMaster.getPerformedBy())){
                DictDisDept dictDisDept = hubToolService.getDept(examMaster.getPerformedBy());
                emrExClinical.setDeptCode(dictDisDept.getHubCode());
                emrExClinical.setDeptName(dictDisDept.getHubName());
            }else {
                emrExClinical.setDeptCode(dictDisDeptDefault.getHubCode());
                emrExClinical.setDeptName(dictDisDeptDefault.getHubName());
            }
            emrExClinical.setOperationTime(DateUtils.getTime());
            synchroEmrMonitorService.syncEmrExClinical(emrExClinical, httpMethod);

            logger.debug("构造emrExClinicalItem接口数据...");
            emrExClinicalItem.setId(no);
            emrExClinicalItem.setExClinicalId(examMaster.getExamNo());
            DictExamItem dictExamItem = dictExamItemMapper.selectByEmrName(examMaster.getExamClass());
            if (dictExamItem == null){
                emrExClinicalItem.setItemCode(HubCodeEnum.PAY_TYPE_OTHER.getCode());
                emrExClinicalItem.setItemName(HubCodeEnum.PAY_TYPE_OTHER.getName());
            }else {
                emrExClinicalItem.setItemCode(dictExamItem.getHubCode());
                emrExClinicalItem.setItemName(dictExamItem.getHubName());
            }
            emrExClinicalItem.setExaminationQuantification(examReport.getExamPara());
            if ("1".equals(examReport.getIsAbnormal())){
                emrExClinicalItem.setExaminationResultCode(HubCodeEnum.EXAM_RESULT_ABNORMAL.getCode());
                emrExClinicalItem.setExaminationResultName(HubCodeEnum.EXAM_RESULT_ABNORMAL.getName());
            }else {
                emrExClinicalItem.setExaminationResultCode(HubCodeEnum.EXAM_RESULT_OTHER.getCode());
                emrExClinicalItem.setExaminationResultName(HubCodeEnum.EXAM_RESULT_OTHER.getName());
            }
            emrExClinicalItem.setOperationTime(DateUtils.getTime());
            synchroEmrMonitorService.syncEmrExClinicalItem(emrExClinicalItem, httpMethod);
        }else {
            logger.error("{}对应PatMasterIndex或ExamReport信息为空，无法同步", examMaster.getExamNo());
        }
    }
}
