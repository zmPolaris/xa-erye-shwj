package cn.xa.eyre.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.lang.Validator;
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
import cn.xa.eyre.exam.domain.ExamReport;
import cn.xa.eyre.hisapi.CommFeignClient;
import cn.xa.eyre.hisapi.InpadmFeignClient;
import cn.xa.eyre.hisapi.LabFeignClient;
import cn.xa.eyre.hisapi.MedrecFeignClient;
import cn.xa.eyre.hub.domain.emrmonitor.EmrExLab;
import cn.xa.eyre.hub.domain.emrmonitor.EmrExLabItem;
import cn.xa.eyre.hub.service.SynchroEmrMonitorService;
import cn.xa.eyre.hub.staticvalue.HubCodeEnum;
import cn.xa.eyre.inpadm.domain.PatsInHospital;
import cn.xa.eyre.lab.domain.*;
import cn.xa.eyre.medrec.domain.PatMasterIndex;
import cn.xa.eyre.system.dict.domain.DdExQuantification;
import cn.xa.eyre.system.dict.domain.DictDisDept;
import cn.xa.eyre.system.dict.domain.DictExamType;
import cn.xa.eyre.system.dict.domain.DictSpecimenCategory;
import cn.xa.eyre.system.dict.mapper.DdExQuantificationMapper;
import cn.xa.eyre.system.dict.mapper.DictDisDeptMapper;
import cn.xa.eyre.system.dict.mapper.DictSpecimenCategoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LabConvertService {
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
    private LabFeignClient labFeignClient;
    @Autowired
    private HubToolService hubToolService;
    @Autowired
    private DictSpecimenCategoryMapper dictSpecimenCategoryMapper;// 标本转码表
    @Autowired
    private DdExQuantificationMapper ddExQuantificationMapper;// 检验结果

    public void labTestMaster(DBMessage dbMessage) {
        logger.debug("检验主表LAB_TEST_MASTER变更接口");
        logger.debug("LAB_TEST_MASTER变更需调用emrExLab、emrExLabItem同步接口");
        String httpMethod = null;
        LabTestMaster labTestMaster;
        Map<String, String> data;
        if(dbMessage.getOperation().equalsIgnoreCase("DELETE")){
            httpMethod = Constants.HTTP_METHOD_DELETE;
            data = dbMessage.getBeforeData();
        }else {
            httpMethod = Constants.HTTP_METHOD_POST;
            data = dbMessage.getAfterData();
        }
        labTestMaster = BeanUtil.toBeanIgnoreError(data, LabTestMaster.class);
        // 反查数据
        labTestMaster = labFeignClient.getLabTestMaster(labTestMaster.getTestNo()).getData();

        if(labTestMaster == null || StringUtils.isBlank(labTestMaster.getResultStatus()) || !"4".equals(labTestMaster.getResultStatus())){
            logger.error("检查报告未确认，无法同步");
            return;
        }

        R<List<LabResult>> resultItemsResult = labFeignClient.getResultByTestNo(labTestMaster.getTestNo());
        R<PatMasterIndex> medrecResult = medrecFeignClient.getPatMasterIndex(labTestMaster.getPatientId());
        if (R.SUCCESS == medrecResult.getCode() && medrecResult.getData() != null
        && R.SUCCESS == resultItemsResult.getCode() && !resultItemsResult.getData().isEmpty()){
            // 更新推送患者信息
            hubToolService.syncPatInfo(medrecResult.getData());
            DictDisDept dept = new DictDisDept();
            dept.setStatus(Constants.STATUS_NORMAL);
            dept.setIsDefault(Constants.IS_DEFAULT);
            DictDisDept dictDisDeptDefault = dictDisDeptMapper.selectByCondition(dept);

            for (LabResult labResult : resultItemsResult.getData()) {
                logger.debug("构造emrExLab接口数据...");
                EmrExLab emrExLab = new EmrExLab();
                EmrExLabItem emrExLabItem = new EmrExLabItem();
                // ID使用LAB_RESULT表联合主键拼接计算MD5
                String id = DigestUtil.md5Hex(labResult.getTestNo() + labResult.getItemNo() + labResult.getPrintOrder());
                emrExLab.setId(id);
                emrExLab.setApplicationFormNo(String.valueOf(labResult.getItemNo()));
                emrExLab.setExaminationDate(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, labTestMaster.getResultsRptDateTime()));
                emrExLab.setExaminationReportDate(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, labResult.getResultDateTime()));
                emrExLab.setExaminationReportNo(id);
                emrExLab.setExaminationObjectiveDesc(labResult.getResult());
                emrExLab.setExaminationSubjectiveDesc(labResult.getResult());
                emrExLab.setExaminationNotes(labResult.getReportItemName());

                emrExLab.setPatientId(labTestMaster.getPatientId());
                if("1".equals(labTestMaster.getPatientSource()) || labTestMaster.getVisitNo() != null ){
                    emrExLab.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_OUTPATIENT.getCode());
                    emrExLab.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_OUTPATIENT.getName());
                    emrExLab.setSerialNumber(DigestUtil.md5Hex(labTestMaster.getPatientId() + labTestMaster.getVisitNo()));
                }else if("2".equals(labTestMaster.getPatientSource()) || labTestMaster.getVisitId() != null ){
                    emrExLab.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_HOSPITALIZATION.getCode());
                    emrExLab.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_HOSPITALIZATION.getName());
                    emrExLab.setSerialNumber(DigestUtil.md5Hex(labTestMaster.getPatientId() + labTestMaster.getVisitId()));
                    R<PatsInHospital> hospitalResult = inpadmFeignClient.getPatsInHospital(labTestMaster.getPatientId(), labTestMaster.getVisitId().shortValue());
                    if (R.SUCCESS == hospitalResult.getCode() && hospitalResult.getData() != null){
                        emrExLab.setWardNo(hospitalResult.getData().getWardCode());
                        emrExLab.setBedNo(String.valueOf(hospitalResult.getData().getBedNo()));
                    }
                }else {
                    logger.error("PATIENT_SOURCE:{}, 非门诊和住院，无法同步", labTestMaster.getPatientSource());
                    return;
                }
                emrExLab.setApplyOrgCode(HubCodeEnum.ORG_CODE.getCode());
                emrExLab.setApplyOrgName(HubCodeEnum.ORG_CODE.getName());
                emrExLab.setOrgCode(HubCodeEnum.ORG_CODE.getCode());
                emrExLab.setOrgName(HubCodeEnum.ORG_CODE.getName());
                if(StringUtils.isNotBlank(labTestMaster.getOrderingDept())){
                    DictDisDept dictDisDept = hubToolService.getDept(labTestMaster.getOrderingDept());
                    emrExLab.setApplyDeptCode(dictDisDept.getHubCode());
                    emrExLab.setApplyDeptName(dictDisDept.getHubName());
                }
                R<Users> user = commFeignClient.getUserByName(labTestMaster.getOrderingProvider());
                if (R.SUCCESS == user.getCode() && user.getData() != null){
                    emrExLab.setApplyPhysicianId(user.getData().getUserId());
                }
                emrExLab.setExaminationReportDate(DateUtils.dateTime(labResult.getResultDateTime()));
                DictSpecimenCategory dictSpecimenCategory = dictSpecimenCategoryMapper.selectByEmrName(labTestMaster.getSpecimen().trim());
                if(dictSpecimenCategory == null){
                    emrExLab.setSpecimenCategoryCode(HubCodeEnum.PAY_TYPE_OTHER.getCode());
                    emrExLab.setSpecimenCategoryName(labTestMaster.getSpecimen());
                }else {
                    emrExLab.setSpecimenCategoryCode(dictSpecimenCategory.getHubCode());
                    emrExLab.setSpecimenCategoryName(dictSpecimenCategory.getHubName());
                }
                if (labTestMaster.getSpcmSampleDateTime()!= null && labTestMaster.getSpcmReceivedDateTime() != null){
                    // 标本号
                    String specimenNo = DigestUtil.md5Hex(labTestMaster.getSpecimen() +
                            DateUtils.getYyyyMMddHHmmssString(labTestMaster.getSpcmSampleDateTime()) + DateUtils.getYyyyMMddHHmmssString(labTestMaster.getSpcmReceivedDateTime()));
                    emrExLab.setSpecimenNo(specimenNo);
                    emrExLab.setSpecimenSamplingDate(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, labTestMaster.getSpcmSampleDateTime()));
                    emrExLab.setSpecimenReceivingDate(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, labTestMaster.getSpcmReceivedDateTime()));
                }
                if(StringUtils.isNotBlank(labTestMaster.getTranscriptionist())){
                    R<Users> usero = commFeignClient.getUserByName(labTestMaster.getOrderingProvider());
                    if (R.SUCCESS == usero.getCode() && usero.getData() != null){
                        emrExLab.setExaminationPhysicianId(usero.getData().getUserId());
                        emrExLab.setExaminationReportId(usero.getData().getUserId());
                        emrExLab.setOperatorId(usero.getData().getUserId());
                    }
                }else {
                    emrExLab.setExaminationPhysicianId("-");
                    emrExLab.setExaminationReportId("-");
                    emrExLab.setOperatorId("-");
                }
                if (StringUtils.isNotBlank(labTestMaster.getPerformedBy())){
                    DictDisDept dictDisDept = hubToolService.getDept(labTestMaster.getPerformedBy());
                    emrExLab.setDeptCode(dictDisDept.getHubCode());
                    emrExLab.setDeptName(dictDisDept.getHubName());
                }else {
                    emrExLab.setDeptCode(dictDisDeptDefault.getHubCode());
                    emrExLab.setDeptName(dictDisDeptDefault.getHubName());
                }
                emrExLab.setOperationTime(DateUtils.getTime());

                emrExLab.setPatientName(medrecResult.getData().getName());
                if (StringUtils.isBlank(medrecResult.getData().getIdNo())){
                    emrExLab.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE_OTHER.getCode());
                    emrExLab.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE_OTHER.getName());
                    emrExLab.setIdCard(medrecResult.getData().getIdNo());
                }else {
                    emrExLab.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE.getCode());
                    emrExLab.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE.getName());
                    emrExLab.setIdCard(medrecResult.getData().getIdNo());
                }
                synchroEmrMonitorService.syncEmrExLab(emrExLab, httpMethod);

                logger.debug("构造emrExLabItem接口数据...");
                emrExLabItem.setId(id);
                emrExLabItem.setExLabId(id);

                emrExLabItem.setItemCode(labResult.getReportItemCode());
                emrExLabItem.setItemName(labResult.getReportItemName());

                if(StringUtils.isNotBlank(labResult.getResult())){
                    if (Validator.hasChinese(labResult.getResult())){
                        // 定性
                        emrExLabItem.setSourceExaminationResultCode(DigestUtil.md5Hex(labResult.getResult()));
                        emrExLabItem.setSourceExaminationResultCode(labResult.getResult());
                        List<DdExQuantification> ddExQuantifications = ddExQuantificationMapper.selectAll();
                        DdExQuantification ddExQuantification = null;
                        for (DdExQuantification dd : ddExQuantifications) {
                            if (labResult.getResult().equals(dd.getName())){
                                ddExQuantification = dd;
                                break;
                            }
                            if (labResult.getResult().startsWith(dd.getName())){
                                ddExQuantification = dd;
                                break;
                            }
                        }
//                        ddExQuantification = ddExQuantificationMapper.selectByName(labResult.getResult());
                        if (ddExQuantification == null){
                            emrExLabItem.setExaminationResultCode("07");
                            emrExLabItem.setExaminationResultName(labResult.getResult());
                        }else {
                            emrExLabItem.setExaminationResultCode(ddExQuantification.getCode());
                            emrExLabItem.setExaminationResultName(ddExQuantification.getName());
                        }
                    }else {
                        if (labResult.getResult().equals("-")){
                            emrExLabItem.setSourceExaminationResultCode(DigestUtil.md5Hex(labResult.getResult()));
                            emrExLabItem.setSourceExaminationResultCode(labResult.getResult());
                            emrExLabItem.setExaminationResultCode("02");
                            emrExLabItem.setExaminationResultName("阴性");
                        }else if(labResult.getResult().equals("+")){
                            emrExLabItem.setSourceExaminationResultCode(DigestUtil.md5Hex(labResult.getResult()));
                            emrExLabItem.setSourceExaminationResultCode(labResult.getResult());
                            emrExLabItem.setExaminationResultCode("01");
                            emrExLabItem.setExaminationResultName("阳性");
                        }else {
                            // 定量
                            emrExLabItem.setExaminationQuantification(labResult.getResult());
                            emrExLabItem.setExaminationQuantificationUnit(labResult.getUnits());
                            if (StringUtils.isNotBlank(labResult.getAbnormalIndicator())){
                                if (labResult.getAbnormalIndicator().equals("H")){
                                    emrExLabItem.setExaminationQuantificationRi("2");
                                }else if (labResult.getAbnormalIndicator().equals("L")){
                                    emrExLabItem.setExaminationQuantificationRi("1");
                                }else {
                                    emrExLabItem.setExaminationQuantificationRi("0");
                                }
                            }else {
                                emrExLabItem.setExaminationQuantificationRi(String.valueOf(checkNumberInRange(labResult.getPrintContext(), labResult.getResult())));
                            }

                            if (labResult.getPrintContext().contains("健康非妊娠绝经前女性")){
                                emrExLabItem.setExaminationQuantificationLower("0");
                                emrExLabItem.setExaminationQuantificationUpper("7184");
                            }else {
                                String between = StrUtil.removeAll(labResult.getPrintContext(), "");
                                String[] betweens = between.split("-");
                                if (betweens.length == 1){
                                    emrExLabItem.setExaminationQuantificationLower(betweens[0]);
                                    emrExLabItem.setExaminationQuantificationUpper(betweens[0]);
                                } else {
                                    emrExLabItem.setExaminationQuantificationLower(betweens[0]);
                                    emrExLabItem.setExaminationQuantificationUpper(betweens[1]);
                                }
                            }
                        }
                    }
                }else {
                    emrExLabItem.setSourceExaminationResultCode(UUID.fastUUID().toString());
                    emrExLabItem.setSourceExaminationResultCode("无");
                    emrExLabItem.setExaminationResultCode("07");
                    emrExLabItem.setExaminationResultName("未检出");
                }

                emrExLabItem.setOperatorId(emrExLab.getOperatorId());
                emrExLabItem.setOperationTime(DateUtils.getTime());
                synchroEmrMonitorService.syncEmrExLabItem(emrExLabItem, httpMethod);
            }
        }else {
            logger.error("{}PatMasterIndex或LabResultVo信息为空或报告未确认，无法同步", labTestMaster.getTestNo());
        }
    }

    /**
     * 判断数字是否在参考范围内
     * @param rangeStr 范围字符串，格式如"3.5--9.5"或"40--75"
     * @param number 要判断的数字
     * @return 0-在区间内 1-低于 2-超出
     * @throws IllegalArgumentException 当输入格式无效时抛出异常
     */
    public static int checkNumberInRange(String rangeStr, String number) {
        // 使用正则表达式提取两个数字
        Pattern pattern = Pattern.compile("^(-?\\d+(?:\\.\\d+)?)--(-?\\d+(?:\\.\\d+)?)$");
        Matcher matcher = pattern.matcher(rangeStr.trim());

        if (!matcher.find()) {
//            throw new IllegalArgumentException("无效的范围格式，请使用'min--max'格式");
            return 0;
        }

        try {
            double lower = Double.parseDouble(matcher.group(1));
            double upper = Double.parseDouble(matcher.group(2));

            if (lower > upper) {
//                throw new IllegalArgumentException("下限值不能大于上限值");
                return 0;
            }
            double num = Double.valueOf(number);
            if (num < lower) {
                return 1; // 低于下限
            } else if (num > upper) {
                return 2; // 超出上限
            } else {
                return 0; // 在区间内
            }
        } catch (NumberFormatException e) {
//            throw new IllegalArgumentException("范围中包含非数字字符");
            return 0;
        }
    }
}
