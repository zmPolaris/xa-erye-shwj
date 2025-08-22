package cn.xa.eyre.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdcardUtil;
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
import cn.xa.eyre.hub.domain.emrmonitor.*;
import cn.xa.eyre.hub.domain.emrreal.EmrActivityInfo;
import cn.xa.eyre.hub.domain.emrreal.EmrPatientInfo;
import cn.xa.eyre.hub.service.SynchroEmrMonitorService;
import cn.xa.eyre.hub.service.SynchroEmrRealService;
import cn.xa.eyre.hub.staticvalue.HubCodeEnum;
import cn.xa.eyre.inpadm.domain.PatsInHospital;
import cn.xa.eyre.medrec.domain.*;
import cn.xa.eyre.system.dict.domain.*;
import cn.xa.eyre.system.dict.mapper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MedrecConvertService {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private SynchroEmrRealService synchroEmrRealService;
    @Autowired
    private DdNationMapper ddNationMapper;
    @Autowired
    private CommFeignClient commFeignClient;
    @Autowired
    private MedrecFeignClient medrecFeignClient;
    @Autowired
    private InpadmFeignClient inpadmFeignClient;
    @Autowired
    private SynchroEmrMonitorService synchroEmrMonitorService;
    @Autowired
    private DictDisDeptMapper dictDisDeptMapper;// 科室转码表
    @Autowired
    private DictChargeTypeMapper dictChargeTypeMapper;// 付费方式转码
    @Autowired
    private DictDiseaseIcd10Mapper dictDiseaseIcd10Mapper;// ICD10转码表
    @Autowired
    private HubToolService hubToolService;
    @Autowired
    private DictTreatResultMapper dictTreatResultMapper;

    @Autowired
    InitDiseaseDataService initDiseaseDataService;

    public void patMasterIndex(DBMessage dbMessage) {
        logger.debug("病人主索引表PAT_MASTER_INDEX变更接口");
        logger.debug("PAT_MASTER_INDEX变更需调用emrPatientInfo同步接口");
        EmrPatientInfo emrPatientInfo = new EmrPatientInfo();
        String httpMethod = null;
        PatMasterIndex patMasterIndex;
        Map<String, String> data;
        if(dbMessage.getOperation().equalsIgnoreCase("DELETE")){
            httpMethod = Constants.HTTP_METHOD_DELETE;
            data = dbMessage.getBeforeData();
        }else {
            httpMethod = Constants.HTTP_METHOD_POST;
            data = dbMessage.getAfterData();
        }
//        patMasterIndex = BeanUtil.toBeanIgnoreError(data, PatMasterIndex.class);
//        patMasterIndex.setDateOfBirth(DateUtils.getLongDate(data.get("dateOfBirth")));
//        patMasterIndex.setLastVisitDate(DateUtils.getLongDate(data.get("lastVisitDate")));
//        patMasterIndex.setCreateDate(DateUtils.getLongDate(data.get("createDate")));
//        patMasterIndex.setModifyTime(DateUtils.getLongDate(data.get("modifyTime")));
//        patMasterIndex.setIdentityExpireDate(DateUtils.getLongDate(data.get("identityExpireDate")));
        try {
            patMasterIndex = BeanUtils.mapToObject(data, PatMasterIndex.class);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        logger.debug("构造emrPatientInfo接口数据...");
        // 构造请求参数
        emrPatientInfo.setId(patMasterIndex.getPatientId());
        emrPatientInfo.setPatientName(patMasterIndex.getName());
        if (StringUtils.isBlank(patMasterIndex.getIdNo())){
            emrPatientInfo.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE_OTHER.getCode());
            emrPatientInfo.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE_OTHER.getName());
            emrPatientInfo.setIdCard("-");
        }else {
            if (IdcardUtil.isValidCard(patMasterIndex.getIdNo())){
                emrPatientInfo.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE.getCode());
                emrPatientInfo.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE.getName());
                emrPatientInfo.setIdCard(patMasterIndex.getIdNo());
            }else {
                emrPatientInfo.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE_OTHER.getCode());
                emrPatientInfo.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE_OTHER.getName());
                emrPatientInfo.setIdCard(patMasterIndex.getIdNo());
            }
        }
        if (StringUtils.isBlank(patMasterIndex.getSexCode())){
            emrPatientInfo.setGenderCode(HubCodeEnum.SEX_OTHER.getCode());
            if(StringUtils.isNotBlank(patMasterIndex.getSex())){
                if (patMasterIndex.getSex().equals("男")){
                    emrPatientInfo.setGenderCode("1");
                } else if (patMasterIndex.getSex().equals("女")) {
                    emrPatientInfo.setGenderCode("2");
                } else {
                    emrPatientInfo.setGenderCode(HubCodeEnum.SEX_OTHER.getCode());
                }
            }
        }else {
            emrPatientInfo.setGenderCode(patMasterIndex.getSexCode());
        }
        emrPatientInfo.setGenderName(patMasterIndex.getSex());
        emrPatientInfo.setBirthDate(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD, patMasterIndex.getDateOfBirth()));
        if("CN".equals(patMasterIndex.getCitizenship())){
            emrPatientInfo.setNationalityCode(HubCodeEnum.NATIONALITY_CODE.getCode());
            emrPatientInfo.setNationalityName(HubCodeEnum.NATIONALITY_CODE.getName());
        }
        DdNation ddNation = ddNationMapper.selectByName(patMasterIndex.getNation());
        if (ddNation != null){
            emrPatientInfo.setNationCode(ddNation.getCode());
            emrPatientInfo.setNationName(ddNation.getName());
        }
//        else {
//            emrPatientInfo.setNationCode(HubCodeEnum.NATION_CODE.getCode());
//            emrPatientInfo.setNationName(HubCodeEnum.NATION_CODE.getName());
//        }
        emrPatientInfo.setCurrentAddrCode(patMasterIndex.getMailingAreaCode4());
        emrPatientInfo.setCurrentAddrName(patMasterIndex.getMailingAddress());
        emrPatientInfo.setCurrentAddrDetail(patMasterIndex.getNextOfKinAddr());
        emrPatientInfo.setWorkunit(patMasterIndex.getWorkunit());
        Date birthDate = patMasterIndex.getDateOfBirth();
        if (null != birthDate) {
            LocalDate localDate = DateUtils.convertDateToLocalDate(birthDate);
            Period period = Period.between(localDate, LocalDate.now());
            if (period.getYears() <= 14) {
                if(patMasterIndex.getNextOfKin() != null){
                    emrPatientInfo.setContacts(patMasterIndex.getNextOfKin());
                    emrPatientInfo.setContactsTel(patMasterIndex.getNextOfKinPhone());
                }else {
                    emrPatientInfo.setContacts(patMasterIndex.getGuardianName());
                    emrPatientInfo.setContactsTel(patMasterIndex.getGuardianPhone());
                }
            }
        }
        emrPatientInfo.setOrgCode(HubCodeEnum.ORG_CODE.getCode());
        emrPatientInfo.setOrgName(HubCodeEnum.ORG_CODE.getName());
        // 查询操作员ID
        if (StringUtils.isNotBlank(patMasterIndex.getOperator())){
            R<Users> user = commFeignClient.getUserByName(patMasterIndex.getOperator());
            if (R.SUCCESS == user.getCode() && user.getData() != null){
                emrPatientInfo.setOperatorId(user.getData().getUserId());
            }
        }

        emrPatientInfo.setOperationTime(DateUtils.getTime());
        synchroEmrRealService.syncEmrPatientInfo(emrPatientInfo, httpMethod);
    }

    public void diagnosis(DBMessage dbMessage) {
        logger.debug("诊断表DIAGNOSIS变更接口");
        logger.debug("DIAGNOSIS变更需调用emrFirstCourse、emrDailyCourse同步接口");
        String httpMethod = null;
        Diagnosis diagnosis;
        Map<String, String> data;
        if(dbMessage.getOperation().equalsIgnoreCase("DELETE")){
            httpMethod = Constants.HTTP_METHOD_DELETE;
            data = dbMessage.getBeforeData();
        }else {
            httpMethod = Constants.HTTP_METHOD_POST;
            data = dbMessage.getAfterData();
        }
//        diagnosis = BeanUtil.toBeanIgnoreError(data, Diagnosis.class);
//        diagnosis.setDiagnosisDate(DateUtils.getLongDate(data.get("diagnosisDate")));
        try {
            diagnosis = BeanUtils.mapToObject(data, Diagnosis.class);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        R<PatMasterIndex> medrecResult = medrecFeignClient.getPatMasterIndex(diagnosis.getPatientId());
        DiagnosticCategoryKey diagnosticCategoryKey = new DiagnosticCategoryKey();
        BeanUtil.copyProperties(diagnosis, diagnosticCategoryKey);
        R<DiagnosticCategory> diagnosticCatResult = medrecFeignClient.getDiagnosticCategory(diagnosticCategoryKey);
        PatVisitKey patVisitKey = new PatVisitKey();
        BeanUtil.copyProperties(diagnosis, patVisitKey);
        R<PatVisit> patVisitResult = medrecFeignClient.getPatVisit(patVisitKey);
//        R<PatsInHospital> hospitalResult = inpadmFeignClient.getPatsInHospital(diagnosis.getPatientId(), diagnosis.getVisitId());
        if (R.SUCCESS == patVisitResult.getCode() && patVisitResult.getData() != null
                && R.SUCCESS == medrecResult.getCode() && medrecResult.getData() != null){
            // 军队医改不推送
            if (patVisitResult.getData().getChargeType().equals(Constants.CHARGE_TYPE_JDYG)){
                logger.error("费别为军队医改，不推送数据");
                return;
            }
            // 更新推送患者信息
            hubToolService.syncPatInfo(medrecResult.getData());
            EmrFirstCourse emrFirstCourse = new EmrFirstCourse();
            EmrDailyCourse emrDailyCourse = new EmrDailyCourse();
            // ID使用DIAGNOSIS表patientId、visitId、diagnosisDate拼接计算MD5
            String id = DigestUtil.md5Hex(diagnosis.getPatientId() + diagnosis.getVisitId() + DateUtils.dateTime(diagnosis.getDiagnosisDate()));

            if (diagnosis.getDiagnosisType().equals(Constants.DIAGNOSIS_TYPE_CODE_RYCZ) || diagnosis.getDiagnosisType().equals(Constants.DIAGNOSIS_TYPE_CODE_MZZD)){
                logger.debug("构造emrFirstCourse接口数据...");
                emrFirstCourse.setId(id);
                emrFirstCourse.setPatientId(diagnosis.getPatientId());
                emrFirstCourse.setSerialNumber(DigestUtil.md5Hex(diagnosis.getPatientId() + diagnosis.getVisitId()));
                emrFirstCourse.setCreateDate(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, diagnosis.getDiagnosisDate()));
                emrFirstCourse.setPresentIllnessHis(diagnosis.getDiagnosisDesc());

                emrFirstCourse.setPatientName(medrecResult.getData().getName());
                if (StringUtils.isBlank(medrecResult.getData().getIdNo())){
                    emrFirstCourse.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE_OTHER.getCode());
                    emrFirstCourse.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE_OTHER.getName());
                    emrFirstCourse.setIdCard("-");
                }else {
                    emrFirstCourse.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE.getCode());
                    emrFirstCourse.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE.getName());
                    emrFirstCourse.setIdCard(medrecResult.getData().getIdNo());
                }

                R<PatsInHospital> hospitalResult = inpadmFeignClient.getPatsInHospital(diagnosis.getPatientId(), diagnosis.getVisitId());
                if (hospitalResult.getCode() == R.SUCCESS && hospitalResult.getData() != null){
                    emrFirstCourse.setWardNo(hospitalResult.getData().getWardCode());
                    emrFirstCourse.setBedNo(String.valueOf(hospitalResult.getData().getBedNo()));
                }

                // 治疗医生
                if (StringUtils.isNotBlank(patVisitResult.getData().getDoctorInCharge())){
                    R<Users> user = commFeignClient.getUserByName(patVisitResult.getData().getDoctorInCharge());
                    if (R.SUCCESS == user.getCode() && user.getData() != null){
                        emrFirstCourse.setResidentPhysicianId(user.getData().getUserId());
                        emrFirstCourse.setOperatorId(user.getData().getUserId());
                    }
                }else {
                    R<Users> user = commFeignClient.getUserByName(hospitalResult.getData().getDoctorInCharge());
                    if (R.SUCCESS == user.getCode() && user.getData() != null){
                        emrFirstCourse.setResidentPhysicianId(user.getData().getUserId());
                        emrFirstCourse.setOperatorId(user.getData().getUserId());
                    }
                }

                if (diagnosticCatResult.getCode() == R.SUCCESS && diagnosticCatResult.getData() != null){
                    DictDiseaseIcd10 dictDiseaseIcd10 = dictDiseaseIcd10Mapper.selectByEmrCode(diagnosticCatResult.getData().getDiagnosisCode());
                    if(dictDiseaseIcd10 == null || dictDiseaseIcd10.getHubCode().equals(HubCodeEnum.DISEASE_ICD10_CODE.getCode())){
                        emrFirstCourse.setWmInitalDiagnosisCode(diagnosticCatResult.getData().getDiagnosisCode());
                        emrFirstCourse.setWmInitalDiagnosisName(diagnosis.getDiagnosisDesc());
                    }else {
                        emrFirstCourse.setWmInitalDiagnosisCode(dictDiseaseIcd10.getHubCode());
                        emrFirstCourse.setWmInitalDiagnosisName(dictDiseaseIcd10.getHubName());
                    }
                }

                if(StringUtils.isNotBlank(diagnosis.getTreatResult())){
                    DictTreatResult dictTreatResult = dictTreatResultMapper.selectByEmrName(diagnosis.getTreatResult());
                    if(dictTreatResult == null || dictTreatResult.getHubCode().equals(HubCodeEnum.TREAT_RESULT_OTHER.getCode())){
                        emrFirstCourse.setDiseaseProgressionCode(HubCodeEnum.TREAT_RESULT_OTHER.getCode());
                        emrFirstCourse.setDiseaseProgressionName(diagnosis.getTreatResult());
                    }else {
                        emrFirstCourse.setDiseaseProgressionCode(dictTreatResult.getHubCode());
                        emrFirstCourse.setDiseaseProgressionName(dictTreatResult.getHubName());
                    }
                }

                DictDisDept dictDisDept = hubToolService.getDept(hospitalResult.getData().getDeptCode());

                emrFirstCourse.setDeptCode(dictDisDept.getHubCode());
                emrFirstCourse.setDeptName(dictDisDept.getHubName());

                emrFirstCourse.setOrgCode(HubCodeEnum.ORG_CODE.getCode());
                emrFirstCourse.setOrgName(HubCodeEnum.ORG_CODE.getName());
                emrFirstCourse.setOperationTime(DateUtils.getTime());

                synchroEmrMonitorService.syncEmrFirstCourse(emrFirstCourse, httpMethod);

                logger.debug("构造emrActivityInfo(首次病程)接口数据...");
                EmrActivityInfo emrActivityInfo = new EmrActivityInfo();
                emrActivityInfo.setId(id);
                emrActivityInfo.setPatientId(emrFirstCourse.getPatientId());
                emrActivityInfo.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_FIRST_COURSE.getCode());
                emrActivityInfo.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_FIRST_COURSE.getName());
                emrActivityInfo.setSerialNumber(emrFirstCourse.getSerialNumber());
                emrActivityInfo.setActivityTime(emrFirstCourse.getCreateDate());
                emrActivityInfo.setIdCardTypeCode(emrFirstCourse.getIdCardTypeCode());
                emrActivityInfo.setIdCardTypeName(emrFirstCourse.getIdCardTypeName());
                emrActivityInfo.setIdCard(emrFirstCourse.getIdCard());
                emrActivityInfo.setPatientName(emrFirstCourse.getPatientName());
                emrActivityInfo.setChiefComplaint(emrFirstCourse.getChiefComplaint());
                emrActivityInfo.setPresentIllnessHis(emrFirstCourse.getPresentIllnessHis());
                emrActivityInfo.setDiagnoseTime(emrFirstCourse.getCreateDate());
                emrActivityInfo.setWmDiseaseCode(emrFirstCourse.getWmInitalDiagnosisCode());
                emrActivityInfo.setWmDiseaseName(emrFirstCourse.getWmInitalDiagnosisName());
                emrActivityInfo.setFillDoctor(patVisitResult.getData().getDoctorInCharge());
                emrActivityInfo.setOperatorId(emrFirstCourse.getOperatorId());
                emrActivityInfo.setDeptCode(emrFirstCourse.getDeptCode());
                emrActivityInfo.setDeptName(emrFirstCourse.getDeptName());
                emrActivityInfo.setOrgCode(emrFirstCourse.getOrgCode());
                emrActivityInfo.setOrgName(emrFirstCourse.getOrgName());
                emrActivityInfo.setOperationTime(DateUtils.getTime());
                synchroEmrRealService.syncEmrActivityInfo(emrActivityInfo, httpMethod);


            }else
//                if (diagnosis.getDiagnosisType().equals(Constants.DIAGNOSIS_TYPE_CODE_QT) && diagnosis.getVisitId() != null)
                {
                logger.debug("构造emrDailyCourse接口数据...");
                emrDailyCourse.setId(id);
                emrDailyCourse.setPatientId(diagnosis.getPatientId());
                emrDailyCourse.setSerialNumber(DigestUtil.md5Hex(diagnosis.getPatientId() + diagnosis.getVisitId()));
                emrDailyCourse.setCreateDate(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, diagnosis.getDiagnosisDate()));
                emrDailyCourse.setCourse(diagnosis.getDiagnosisDesc());

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
                R<Users> user = commFeignClient.getUserByName(patVisitResult.getData().getDoctorInCharge());
                if (R.SUCCESS == user.getCode() && user.getData() != null){
                    emrDailyCourse.setOperatorId(user.getData().getUserId());
                }

                DictDisDept dictDisDept = hubToolService.getDept(patVisitResult.getData().getDeptAdmissionTo());

                emrDailyCourse.setDeptCode(dictDisDept.getHubCode());
                emrDailyCourse.setDeptName(dictDisDept.getHubName());

                emrDailyCourse.setOrgCode(HubCodeEnum.ORG_CODE.getCode());
                emrDailyCourse.setOrgName(HubCodeEnum.ORG_CODE.getName());
                emrDailyCourse.setOperationTime(DateUtils.getTime());

                if(StringUtils.isNotBlank(diagnosis.getTreatResult())){
                    DictTreatResult dictTreatResult = dictTreatResultMapper.selectByEmrName(diagnosis.getTreatResult());
                    if(dictTreatResult == null || dictTreatResult.getHubCode().equals(HubCodeEnum.TREAT_RESULT_OTHER.getCode())){
                        emrDailyCourse.setDiseaseProgressionCode(HubCodeEnum.TREAT_RESULT_OTHER.getCode());
                        emrDailyCourse.setDiseaseProgressionName(diagnosis.getTreatResult());
                    }else {
                        emrDailyCourse.setDiseaseProgressionCode(dictTreatResult.getHubCode());
                        emrDailyCourse.setDiseaseProgressionName(dictTreatResult.getHubName());
                    }
                }

                synchroEmrMonitorService.syncEmrDailyCourse(emrDailyCourse, httpMethod);

                logger.debug("构造emrActivityInfo(日常病程)接口数据...");
                EmrActivityInfo emrActivityInfo = new EmrActivityInfo();
                emrActivityInfo.setId(id);
                emrActivityInfo.setPatientId(emrDailyCourse.getPatientId());
                emrActivityInfo.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_DAILY_COURSE.getCode());
                emrActivityInfo.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_DAILY_COURSE.getName());
                emrActivityInfo.setSerialNumber(emrDailyCourse.getSerialNumber());
                emrActivityInfo.setActivityTime(emrDailyCourse.getCreateDate());
                emrActivityInfo.setIdCardTypeCode(emrDailyCourse.getIdCardTypeCode());
                emrActivityInfo.setIdCardTypeName(emrDailyCourse.getIdCardTypeName());
                emrActivityInfo.setIdCard(emrDailyCourse.getIdCard());
                emrActivityInfo.setPatientName(emrDailyCourse.getPatientName());
                emrActivityInfo.setDiagnoseTime(emrDailyCourse.getCreateDate());
                emrActivityInfo.setWmDiseaseCode(HubCodeEnum.DISEASE_ICD10_CODE.getCode());
                emrActivityInfo.setWmDiseaseName(HubCodeEnum.DISEASE_ICD10_CODE.getName());
                emrActivityInfo.setFillDoctor(patVisitResult.getData().getDoctorInCharge());
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
            }

        }else {
            logger.error("{}对应PatMasterIndex或PatVisit信息为空，无法同步", diagnosis.getPatientId());
        }
    }

    public void patVisit(DBMessage dbMessage) {
        logger.debug("住院表PAT_VISIT变更接口");
        logger.debug("PAT_VISIT变更需调用emrAdmissionRecord、emrDischargeInfo同步接口");
        String httpMethod = null;
        PatVisit patVisit;
        Map<String, String> data;
        if(dbMessage.getOperation().equalsIgnoreCase("DELETE")){
            httpMethod = Constants.HTTP_METHOD_DELETE;
            data = dbMessage.getBeforeData();
        }else {
            httpMethod = Constants.HTTP_METHOD_POST;
            data = dbMessage.getAfterData();
        }
//        patVisit = BeanUtil.toBeanIgnoreError(data, PatVisit.class);
//        patVisit.setAdmissionDateTime(DateUtils.getLongDate(data.get("admissionDateTime")));
//        patVisit.setDischargeDateTime(DateUtils.getLongDate(data.get("dischargeDateTime")));
//        patVisit.setConsultingDate(DateUtils.getLongDate(data.get("consultingDate")));
        try {
            patVisit = BeanUtils.mapToObject(data, PatVisit.class);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 军队医改不推送
        if (patVisit.getChargeType().equals(Constants.CHARGE_TYPE_JDYG)){
            logger.error("费别为军队医改，不推送数据");
            return;
        }

        R<PatMasterIndex> medrecResult = medrecFeignClient.getPatMasterIndex(patVisit.getPatientId());
        // 入院诊断
        DiagnosisKey diagnosisKeyIn = new DiagnosisKey(patVisit.getPatientId(), patVisit.getVisitId(), Constants.DIAGNOSIS_TYPE_CODE_RYCZ);
        R<Diagnosis> diagnosisInResult = medrecFeignClient.getDiagnosis(diagnosisKeyIn);
        DiagnosticCategoryKey diagnosticCategoryKey = new DiagnosticCategoryKey();
        BeanUtil.copyProperties(diagnosisInResult.getData(), diagnosticCategoryKey);
        R<DiagnosticCategory> diagnosticInCatResult = medrecFeignClient.getDiagnosticCategory(diagnosticCategoryKey);
        if ( R.SUCCESS == medrecResult.getCode() && medrecResult.getData() != null
                && R.SUCCESS == diagnosisInResult.getCode() && diagnosisInResult.getData() != null
                && R.SUCCESS == diagnosticInCatResult.getCode() && diagnosticInCatResult.getData() != null){
            EmrAdmissionRecord emrAdmissionRecord = new EmrAdmissionRecord();
            EmrDischargeInfo emrDischargeInfo = new EmrDischargeInfo();
            // ID使用PAT_VISIT表patientId、visitId拼接计算MD5
            String id = DigestUtil.md5Hex(patVisit.getPatientId() + patVisit.getVisitId());
            logger.debug("构造emrAdmissionRecord接口数据...");
            emrAdmissionRecord.setId(id);
            emrAdmissionRecord.setPatientId(patVisit.getPatientId());
            emrAdmissionRecord.setSerialNumber(id);
            if (StringUtils.isNotBlank(patVisit.getChargeType())){
                DictChargeType dictChargeType = dictChargeTypeMapper.selectByEmrCode(patVisit.getChargeType());
                if (dictChargeType == null){
                    emrAdmissionRecord.setPayMethodCode(HubCodeEnum.PAY_TYPE_OTHER.getCode());
                    emrAdmissionRecord.setPayMethodName(HubCodeEnum.PAY_TYPE_OTHER.getName());
                }else {
                    emrAdmissionRecord.setPayMethodCode(dictChargeType.getHubCode());
                    emrAdmissionRecord.setPayMethodName(dictChargeType.getHubName());
                }
            }
            emrAdmissionRecord.setAdmissionNum(String.valueOf(patVisit.getVisitId()));
            emrAdmissionRecord.setRegNo(patVisit.getPatientId());
            emrAdmissionRecord.setAdmissionDate(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, patVisit.getAdmissionDateTime()));
            // 住院医师
            if (StringUtils.isNotBlank(patVisit.getDoctorInCharge())){
                R<Users> user = commFeignClient.getUserByName(patVisit.getDoctorInCharge());
                if (R.SUCCESS == user.getCode() && user.getData() != null){
                    emrAdmissionRecord.setResidentPhysicianId(user.getData().getUserId());
                }
            }
            // 主治医师
            if (StringUtils.isNotBlank(patVisit.getAttendingDoctor())){
                R<Users> user = commFeignClient.getUserByName(patVisit.getAttendingDoctor());
                if (R.SUCCESS == user.getCode() && user.getData() != null){
                    emrAdmissionRecord.setChiefPhysicianId(user.getData().getUserId());
                }
            }
            DictDisDept dictDisDept = hubToolService.getDept(patVisit.getDeptAdmissionTo());
            emrAdmissionRecord.setDeptCode(dictDisDept.getHubCode());
            emrAdmissionRecord.setDeptName(dictDisDept.getHubName());
            emrAdmissionRecord.setAdmissionDeptCode(dictDisDept.getHubCode());
            emrAdmissionRecord.setAdmissionDeptName(dictDisDept.getHubName());
            if (StringUtils.isNotBlank(patVisit.getAlergyDrugs())){
                emrAdmissionRecord.setAllergyCode("1");
                emrAdmissionRecord.setAllergyDrug(patVisit.getAlergyDrugs());
            }else {
                emrAdmissionRecord.setAllergyCode("0");
            }
            if (patVisit.getAutopsyIndicator() != null){
                emrAdmissionRecord.setAutopsyCode(String.valueOf(patVisit.getAutopsyIndicator()));
            }

            DictDiseaseIcd10 inDictDiseaseIcd10 = dictDiseaseIcd10Mapper.selectByEmrCode(diagnosticInCatResult.getData().getDiagnosisCode());
            if(inDictDiseaseIcd10 == null || inDictDiseaseIcd10.getHubCode().equals(HubCodeEnum.DISEASE_ICD10_CODE.getCode())){
                emrAdmissionRecord.setWmOutpatientDiagnosisCode(diagnosticInCatResult.getData().getDiagnosisCode());
                emrAdmissionRecord.setWmOutpatientDiagnosisName(diagnosisInResult.getData().getDiagnosisDesc());
                emrDischargeInfo.setAdmissionDiagnosisCode(diagnosticInCatResult.getData().getDiagnosisCode());
                emrDischargeInfo.setAdmissionDiagnosisName(diagnosisInResult.getData().getDiagnosisDesc());
            }else {
                emrAdmissionRecord.setWmOutpatientDiagnosisCode(inDictDiseaseIcd10.getHubCode());
                emrAdmissionRecord.setWmOutpatientDiagnosisName(inDictDiseaseIcd10.getHubName());
                emrDischargeInfo.setAdmissionDiagnosisCode(inDictDiseaseIcd10.getHubCode());
                emrDischargeInfo.setAdmissionDiagnosisName(inDictDiseaseIcd10.getHubName());
            }

            emrAdmissionRecord.setPatientName(medrecResult.getData().getName());
            if (StringUtils.isBlank(medrecResult.getData().getIdNo())){
                emrAdmissionRecord.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE_OTHER.getCode());
                emrAdmissionRecord.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE_OTHER.getName());
                emrAdmissionRecord.setIdCard("-");
            }else {
                emrAdmissionRecord.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE.getCode());
                emrAdmissionRecord.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE.getName());
                emrAdmissionRecord.setIdCard(medrecResult.getData().getIdNo());
            }

            if (patVisit.getDischargeDateTime() != null){
                // 出院诊断
                DiagnosisKey diagnosisKeyOut = new DiagnosisKey(patVisit.getPatientId(), patVisit.getVisitId(), Constants.DIAGNOSIS_TYPE_CODE_ZYZD);
                R<Diagnosis> diagnosisOutResult = medrecFeignClient.getDiagnosis(diagnosisKeyOut);
                DiagnosticCategoryKey diagnosticCategoryKeyout = new DiagnosticCategoryKey();
                BeanUtil.copyProperties(diagnosisInResult.getData(), diagnosticCategoryKeyout);
                R<DiagnosticCategory> diagnosticOutCatResult = medrecFeignClient.getDiagnosticCategory(diagnosticCategoryKeyout);
                DictDiseaseIcd10 outDictDiseaseIcd10 = dictDiseaseIcd10Mapper.selectByEmrCode(diagnosticOutCatResult.getData().getDiagnosisCode());
                if(outDictDiseaseIcd10 == null || outDictDiseaseIcd10.getHubCode().equals(HubCodeEnum.DISEASE_ICD10_CODE.getCode())){
                    emrAdmissionRecord.setDischargeDiagnosisCode(diagnosticOutCatResult.getData().getDiagnosisCode());
                    emrAdmissionRecord.setDischargeDiagnosisName(diagnosisOutResult.getData().getDiagnosisDesc());
                    emrDischargeInfo.setDischargeDiagnosisCode(diagnosticOutCatResult.getData().getDiagnosisCode());
                    emrDischargeInfo.setDischargeDiagnosisName(diagnosisOutResult.getData().getDiagnosisDesc());
                }else {
                    emrAdmissionRecord.setDischargeDiagnosisCode(outDictDiseaseIcd10.getHubCode());
                    emrAdmissionRecord.setDischargeDiagnosisName(outDictDiseaseIcd10.getHubName());
                    emrDischargeInfo.setDischargeDiagnosisCode(outDictDiseaseIcd10.getHubCode());
                    emrDischargeInfo.setDischargeDiagnosisName(outDictDiseaseIcd10.getHubName());
                }
                if(StringUtils.isNotBlank(diagnosisOutResult.getData().getTreatResult())){
                    DictTreatResult dictTreatResult = dictTreatResultMapper.selectByEmrName(diagnosisOutResult.getData().getTreatResult());
                    if(dictTreatResult == null || dictTreatResult.getHubCode().equals(HubCodeEnum.TREAT_RESULT_OTHER.getCode())){
                        emrDischargeInfo.setDiseaseProgressionCode(HubCodeEnum.TREAT_RESULT_OTHER.getCode());
                        emrDischargeInfo.setDiseaseProgressionName(diagnosisOutResult.getData().getTreatResult());
                        emrDischargeInfo.setTreatmentDesc("无");
                    }else {
                        emrDischargeInfo.setDiseaseProgressionCode(dictTreatResult.getHubCode());
                        emrDischargeInfo.setDiseaseProgressionName(dictTreatResult.getHubName());
                        emrDischargeInfo.setTreatmentDesc(diagnosisOutResult.getData().getTreatResult());
                    }
                }
                emrDischargeInfo.setAdmissionDesc(diagnosisOutResult.getData().getDiagnosisDesc());

                emrAdmissionRecord.setDischargeDate(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, patVisit.getDischargeDateTime()));
                // 计算住院天数
                long betweenDay = DateUtil.between(patVisit.getAdmissionDateTime(), patVisit.getDischargeDateTime(), DateUnit.DAY);
                emrAdmissionRecord.setAdmissionDays(String.valueOf(betweenDay));
                dictDisDept = hubToolService.getDept(patVisit.getDeptDischargeFrom());
                emrAdmissionRecord.setDischargeDeptCode(dictDisDept.getHubCode());
                emrAdmissionRecord.setDischargeDeptName(dictDisDept.getHubName());
            }

            emrAdmissionRecord.setOrgCode(HubCodeEnum.ORG_CODE.getCode());
            emrAdmissionRecord.setOrgName(HubCodeEnum.ORG_CODE.getName());
            emrAdmissionRecord.setOperationTime(DateUtils.getTime());
            synchroEmrMonitorService.syncEmrAdmissionRecord(emrAdmissionRecord, httpMethod);

            if (patVisit.getDischargeDateTime() != null){
                // 出院时间不为空，同步出院记录
                logger.debug("构造emrDischargeInfo接口数据...");
                emrDischargeInfo.setId(id);
                emrDischargeInfo.setPatientId(patVisit.getPatientId());
                emrDischargeInfo.setSerialNumber(id);
                emrDischargeInfo.setDischargeDate(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, patVisit.getDischargeDateTime()));
                emrDischargeInfo.setAdmissionDate(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, patVisit.getAdmissionDateTime()));
                // 住院医师
                if (StringUtils.isNotBlank(patVisit.getDoctorInCharge())){
                    R<Users> user = commFeignClient.getUserByName(patVisit.getDoctorInCharge());
                    if (R.SUCCESS == user.getCode() && user.getData() != null){
                        emrDischargeInfo.setResidentPhysicianId(user.getData().getUserId());
                    }
                }
                // 主治医师
                if (StringUtils.isNotBlank(patVisit.getAttendingDoctor())){
                    R<Users> user = commFeignClient.getUserByName(patVisit.getAttendingDoctor());
                    if (R.SUCCESS == user.getCode() && user.getData() != null){
                        emrDischargeInfo.setChiefPhysicianId(user.getData().getUserId());
                    }
                }

                emrDischargeInfo.setPatientName(medrecResult.getData().getName());
                if (StringUtils.isBlank(medrecResult.getData().getIdNo())){
                    emrDischargeInfo.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE_OTHER.getCode());
                    emrDischargeInfo.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE_OTHER.getName());
                    emrDischargeInfo.setIdCard("-");
                }else {
                    emrDischargeInfo.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE.getCode());
                    emrDischargeInfo.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE.getName());
                    emrDischargeInfo.setIdCard(medrecResult.getData().getIdNo());
                }

                emrDischargeInfo.setDeptCode(dictDisDept.getHubCode());
                emrDischargeInfo.setDeptName(dictDisDept.getHubName());

                emrDischargeInfo.setOrgCode(HubCodeEnum.ORG_CODE.getCode());
                emrDischargeInfo.setOrgName(HubCodeEnum.ORG_CODE.getName());
                emrDischargeInfo.setOperationTime(DateUtils.getTime());
                synchroEmrMonitorService.syncEmrDischargeInfo(emrDischargeInfo, httpMethod);

                logger.debug("构造emrActivityInfo(出院)接口数据...");
                // 更新推送患者信息
                hubToolService.syncPatInfo(medrecResult.getData());
                EmrActivityInfo emrActivityInfo = new EmrActivityInfo();
                emrActivityInfo.setId(id);
                emrActivityInfo.setPatientId(emrDischargeInfo.getPatientId());
                emrActivityInfo.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_DISCHARGE.getCode());
                emrActivityInfo.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_DISCHARGE.getName());
                emrActivityInfo.setSerialNumber(emrDischargeInfo.getSerialNumber());
                emrActivityInfo.setActivityTime(emrDischargeInfo.getDischargeDate());
                emrActivityInfo.setIdCardTypeCode(emrDischargeInfo.getIdCardTypeCode());
                emrActivityInfo.setIdCardTypeName(emrDischargeInfo.getIdCardTypeName());
                emrActivityInfo.setIdCard(emrDischargeInfo.getIdCard());
                emrActivityInfo.setPatientName(emrDischargeInfo.getPatientName());
                emrActivityInfo.setPresentIllnessHis(emrDischargeInfo.getDischargeSymptomsSigns());
                emrActivityInfo.setStudiesSummaryResult(emrDischargeInfo.getStudiesSummaryResult());
                emrActivityInfo.setDiagnoseTime(emrDischargeInfo.getAdmissionDate());
                emrActivityInfo.setWmDiseaseCode(emrDischargeInfo.getDischargeDiagnosisCode());
                emrActivityInfo.setWmDiseaseName(emrDischargeInfo.getDischargeDiagnosisName());
                emrActivityInfo.setFillDoctor(patVisit.getAttendingDoctor());
                emrActivityInfo.setOperatorId(emrDischargeInfo.getChiefPhysicianId());
                emrActivityInfo.setDeptCode(emrDischargeInfo.getDeptCode());
                emrActivityInfo.setDeptName(emrDischargeInfo.getDeptName());
                emrActivityInfo.setOrgCode(emrDischargeInfo.getOrgCode());
                emrActivityInfo.setOrgName(emrDischargeInfo.getOrgName());
                emrActivityInfo.setOperationTime(DateUtils.getTime());
                synchroEmrRealService.syncEmrActivityInfo(emrActivityInfo, httpMethod);

                if ("3".equalsIgnoreCase(patVisit.getDischargeDisposition())) {
                    diagnosisKeyIn = new DiagnosisKey(patVisit.getPatientId(), patVisit.getVisitId(), Constants.DIAGNOSIS_TYPE_CODE_ZYZD);
                    diagnosisInResult = medrecFeignClient.getDiagnosis(diagnosisKeyIn);
                    if (R.SUCCESS == diagnosisInResult.getCode() && diagnosisInResult.getData() != null
                            && "死亡".equalsIgnoreCase(diagnosisInResult.getData().getTreatResult())) {
                        diagnosticCategoryKey = new DiagnosticCategoryKey();
                        BeanUtil.copyProperties(diagnosisInResult.getData(), diagnosticCategoryKey);
                        diagnosticInCatResult = medrecFeignClient.getDiagnosticCategory(diagnosticCategoryKey);
                        if (R.SUCCESS == diagnosticInCatResult.getCode() && diagnosticInCatResult.getData() != null) {
                            logger.debug("构造emrDeathInfo接口数据...");
                            EmrDeathInfo emrDeathInfo = new EmrDeathInfo();
                            emrDeathInfo.setId(id);
                            emrDeathInfo.setPatientId(emrDischargeInfo.getPatientId());
                            emrDeathInfo.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_DISCHARGE.getCode());
                            emrDeathInfo.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_DISCHARGE.getName());
                            emrDeathInfo.setSerialNumber(emrDischargeInfo.getSerialNumber());
                            emrDeathInfo.setPatientId(emrDischargeInfo.getPatientId());
                            emrDeathInfo.setPatientName(emrDischargeInfo.getPatientName());
                            emrDeathInfo.setIdCard(emrDischargeInfo.getIdCard());
                            emrDeathInfo.setIdCardTypeCode(emrDischargeInfo.getIdCardTypeCode());
                            emrDeathInfo.setIdCardTypeName(emrDischargeInfo.getIdCardTypeName());
                            emrDeathInfo.setDeadDate(emrDischargeInfo.getDischargeDate());
                            String code = diagnosticInCatResult.getData().getDiagnosisCode();
                            DictDiseaseIcd10 icd10 = dictDiseaseIcd10Mapper.selectByEmrCode(code);
                            String hubCode = icd10.getHubCode();
                            if ("143".equals(hubCode)) {
                                emrDeathInfo.setDirectCauseCode(code);
                                emrDeathInfo.setDirectCauseName(diagnosisInResult.getData().getDiagnosisDesc());
                            } else {
                                emrDeathInfo.setDirectCauseCode(hubCode);
                                emrDeathInfo.setDirectCauseName(icd10.getHubName());
                                List<String> diseaseDate = initDiseaseDataService.getDiseaseDate();
                                if (diseaseDate.contains(hubCode)) {
                                    emrDeathInfo.setDeathDiagnosisCode(hubCode);
                                    emrDeathInfo.setDeathDiagnosisName(icd10.getHubName());
                                }
                            }

                            emrDeathInfo.setChiefPhysicianId(emrDischargeInfo.getChiefPhysicianId());
                            emrDeathInfo.setOrgCode(emrDischargeInfo.getOrgCode());
                            emrDeathInfo.setOrgName(emrDischargeInfo.getOrgName());
                            emrDeathInfo.setDeptCode(emrDischargeInfo.getDeptCode());
                            emrDeathInfo.setDeptName(emrDischargeInfo.getDeptName());
                            emrDeathInfo.setOperatorId(emrDischargeInfo.getOperatorId());
                            emrDeathInfo.setOperationTime(DateUtils.getTime());

                            synchroEmrMonitorService.syncEmrDeathInfo(emrDeathInfo, httpMethod);

                            logger.debug("构造emrActivityInfo(出院)接口数据...");
                            // 更新推送患者信息
                            hubToolService.syncPatInfo(medrecResult.getData());
                            emrActivityInfo.setWmDiseaseCode(emrDeathInfo.getDeathDiagnosisCode());
                            emrActivityInfo.setWmDiseaseName(emrDeathInfo.getDeathDiagnosisName());
                            synchroEmrRealService.syncEmrActivityInfo(emrActivityInfo, httpMethod);
                        }
                    }
                }
            }
        }else {
            logger.error("{}对应PatMasterIndex信息为空，无法同步", patVisit.getPatientId());
        }
    }
}
