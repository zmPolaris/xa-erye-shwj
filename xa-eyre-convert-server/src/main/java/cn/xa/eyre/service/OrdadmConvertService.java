package cn.xa.eyre.service;

import cn.hutool.core.util.IdcardUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.xa.eyre.comm.domain.Users;
import cn.xa.eyre.common.constant.CacheConstants;
import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.core.domain.R;
import cn.xa.eyre.common.core.redis.RedisCache;
import cn.xa.eyre.common.core.text.Convert;
import cn.xa.eyre.common.utils.DateUtils;
import cn.xa.eyre.hisapi.CommFeignClient;
import cn.xa.eyre.hisapi.InpbillFeignClient;
import cn.xa.eyre.hisapi.MedrecFeignClient;
import cn.xa.eyre.hisapi.OrdadmFeignClient;
import cn.xa.eyre.hub.domain.emrmonitor.EmrDeathInfo;
import cn.xa.eyre.hub.domain.emrmonitor.EmrVitalSignsRecord;
import cn.xa.eyre.hub.domain.emrreal.EmrActivityInfo;
import cn.xa.eyre.hub.domain.emrreal.EmrPatientInfo;
import cn.xa.eyre.hub.service.SynchroEmrMonitorService;
import cn.xa.eyre.hub.service.SynchroEmrRealService;
import cn.xa.eyre.hub.staticvalue.HubCodeEnum;
import cn.xa.eyre.medrec.domain.DiagnosticDescCode;
import cn.xa.eyre.medrec.domain.PatMasterIndex;
import cn.xa.eyre.medrec.domain.Transfer;
import cn.xa.eyre.ordadm.domain.Orders;
import cn.xa.eyre.system.dict.domain.DictDisDept;
import cn.xa.eyre.system.dict.domain.DictDiseaseIcd10;
import cn.xa.eyre.system.dict.mapper.DictDiseaseIcd10Mapper;
import cn.xa.eyre.system.dict.service.DictDisDeptService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class OrdadmConvertService {
    private static final String ORDERS_PATIENT_IDS = "ORDERS_PATIENT_IDS";
    public static final String DEPT_STAYED = "113001";
    Logger logger = LoggerFactory.getLogger(OrdadmConvertService.class);
    @Autowired
    OrdadmFeignClient ordadmFeignClient;
    @Resource
    SynchroEmrMonitorService synchroEmrMonitorService;
    @Autowired
    SynchroEmrRealService synchroEmrRealService;
    @Autowired
    private MedrecFeignClient medrecFeignClient;
    @Autowired
    CommFeignClient commFeignClient;
    @Autowired
    InpbillFeignClient inpbillFeignClient;

    @Resource
    DictDisDeptService dictDisDeptService;

    @Resource
    CommConvertService commConvertService;

    @Resource
    private DictDiseaseIcd10Mapper dictDiseaseIcd10Mapper;

    @Resource
    private RedisCache redisCache;
    @Autowired
    private HubToolService hubToolService;

    private static void extractedInfo(Orders order, EmrVitalSignsRecord record) {
        String orderText = order.getOrderText();
        if (StringUtils.isNotBlank(orderText) && orderText.contains("呼吸机")) {
            record.setVentilatorusedCode("1");
            record.setVentilatorusedName("是");
        } else {
            record.setVentilatorusedCode("0");
            record.setVentilatorusedName("否");
        }
        if (StringUtils.isNotBlank(orderText) && orderText.contains("重症监控")) {
            record.setCriticalCareCode("1");
            record.setCriticalCareCode("是");
        } else {
            record.setCriticalCareCode("0");
            record.setCriticalCareCode("否");
        }
    }

    public static String getICUAndCPAPCacheKey(String key) {
        return CacheConstants.ORDADM_ICU_CPAP_PATIENT_KEY + key;
    }

    public static String getDeathInfoKey(String key) {
        return CacheConstants.ORDADM_PATIENT_DEATH_INFO_KEY + key;
    }

    @Scheduled(cron = "0 0/20 * * * ?")
    public void emrOrders() {
        logger.debug("医嘱表EMR_ORDERS定时任务执行接口, {}", DateUtils.getNowDate());

    }

    @Scheduled(cron = "0 30 2,13,21 * * ?")
    public void emrDeathInfo() {
        logger.debug("死亡信息emr_death_info定时任务执行接口, {}", DateUtils.getNowDate());
//        R<List<PatVisit>> deathInfoList = medrecFeignClient.selectPatVisitDeathInfoList();
        R<List<Orders>> deathInfoList = ordadmFeignClient.getDeathInfo();
        List<Orders> data = deathInfoList.getData();
        if (R.SUCCESS != deathInfoList.getCode() || null == data  || data.isEmpty()) {
            logger.debug("未找到emr_death_info数据");
            return;
        }
        for (Orders order : data) {
            EmrDeathInfo emrDeathInfo = new EmrDeathInfo();
            String patientId = order.getPatientId();
            String key = getDeathInfoKey(patientId) + DateUtils.dateTimeNow(DateUtils.YYYY_MM_DD);
            R<PatMasterIndex> medrecResult = medrecFeignClient.getPatMasterIndex(patientId);
            PatMasterIndex patMasterIndex = medrecResult.getData();
            String id = DigestUtil.md5Hex(patientId + order.getVisitId());
            if (R.SUCCESS == medrecResult.getCode() && patMasterIndex != null) {
                emrDeathInfo.setId(id);
                emrDeathInfo.setPatientId(patientId);
                emrDeathInfo.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_DISCHARGE.getCode());
                emrDeathInfo.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_DISCHARGE.getName());
                emrDeathInfo.setSerialNumber(id);
                emrDeathInfo.setPatientName(patMasterIndex.getName());
                emrDeathInfo.setIdCard(patMasterIndex.getIdNo());
                emrDeathInfo.setIdCardTypeCode(patMasterIndex.getIdentity());
                emrDeathInfo.setIdCardTypeName(patMasterIndex.getIdentity());
                emrDeathInfo.setDeadDate(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, order.getEnterDateTime()));
                R<DiagnosticDescCode> descCode = medrecFeignClient.getDiagnosticDescCode(patientId);
                if (R.SUCCESS == descCode.getCode() && descCode.getData() != null){
                    DiagnosticDescCode codeData = descCode.getData();
                    String code = codeData.getDiagnosisCode();
                    String diagnosisDesc = codeData.getDiagnosisDesc();
                    DictDiseaseIcd10 dictDiseaseIcd10 = dictDiseaseIcd10Mapper.selectByEmrCode(code);
                    if(dictDiseaseIcd10 == null || dictDiseaseIcd10.getHubCode().equals(HubCodeEnum.DISEASE_ICD10_CODE.getCode())){
                        emrDeathInfo.setDirectCauseCode(code);
                        emrDeathInfo.setDirectCauseName(diagnosisDesc);
                    } else {
                        emrDeathInfo.setDirectCauseCode(dictDiseaseIcd10.getHubCode());
                        emrDeathInfo.setDirectCauseName(dictDiseaseIcd10.getHubName());
                        emrDeathInfo.setDeathDiagnosisCode(code);
                        emrDeathInfo.setDeathDiagnosisName(diagnosisDesc);
                    }
                    Users user = commConvertService.getUserByName(order.getDoctor());
                    emrDeathInfo.setChiefPhysicianId(user.getUserId());
                    emrDeathInfo.setOrgCode(HubCodeEnum.ORG_CODE.getCode());
                    emrDeathInfo.setOrgName(HubCodeEnum.ORG_CODE.getName());
                    String dept = order.getOrderingDept();
                    DictDisDept dictDisDept = hubToolService.getDept(dept);
                    emrDeathInfo.setDeptCode(dictDisDept.getHubCode());
                    emrDeathInfo.setDeptName(dictDisDept.getHubName());
                    emrDeathInfo.setOperatorId(user.getUserId());
                    emrDeathInfo.setOperationTime(DateUtils.dateTimeNow(DateUtils.YYYY_MM_DD_HH_MM_SS));

                    EmrDeathInfo cacheRecord = redisCache.getCacheObject(key);
                    if (null == cacheRecord || !emrDeathInfo.equalsNoDate(cacheRecord)) {
                        // 同步患者信息
                        hubToolService.syncPatInfo(patMasterIndex);
                        // 同步诊疗活动信息
                        sendActivityInfo(order, emrDeathInfo);

                        synchroEmrMonitorService.syncEmrDeathInfo(emrDeathInfo, Constants.HTTP_METHOD_POST);
                        redisCache.setCacheObject(key, cacheRecord, 24, TimeUnit.HOURS);
                    } else {
                        logger.info("死亡信息emr_death_info，患者ID：{} 已同步", patientId);
                    }

                } else {
                    logger.error("获取诊断描述失败！患者ID：{}", patientId);
                }

            } else {
                logger.error("获取死亡信息失败！患者ID：{}", patientId);
            }
        }
    }

    private void sendActivityInfo(Orders order, EmrDeathInfo emrDeathInfo) {
        logger.debug("构造emrVitalSignsRecord接口数据...");
        EmrActivityInfo emrActivityInfo = new EmrActivityInfo();
        emrActivityInfo.setId(DigestUtil.md5Hex(emrDeathInfo.getId()));
        emrActivityInfo.setPatientId(emrDeathInfo.getPatientId());
        emrActivityInfo.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_FIRST_COURSE.getCode());
        emrActivityInfo.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_FIRST_COURSE.getName());
        emrActivityInfo.setSerialNumber(emrDeathInfo.getSerialNumber());
        emrActivityInfo.setActivityTime(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, order.getEnterDateTime()));
        emrActivityInfo.setIdCardTypeCode(emrDeathInfo.getIdCardTypeCode());
        emrActivityInfo.setIdCardTypeName(emrDeathInfo.getIdCardTypeName());
        emrActivityInfo.setIdCard(emrDeathInfo.getIdCard());
        emrActivityInfo.setPatientName(emrDeathInfo.getPatientName());
        emrActivityInfo.setDiagnoseTime(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, order.getEnterDateTime()));
        emrActivityInfo.setWmDiseaseCode(emrDeathInfo.getDirectCauseCode());
        emrActivityInfo.setWmDiseaseName(emrDeathInfo.getDirectCauseName());
        emrActivityInfo.setDiseaseCode(emrDeathInfo.getDeathDiagnosisCode());
        emrActivityInfo.setDiseaseName(emrDeathInfo.getDeathDiagnosisName());
        emrActivityInfo.setFillDoctor(order.getDoctor());
        emrActivityInfo.setOperatorId(emrDeathInfo.getOperatorId());
        emrActivityInfo.setDeptCode(emrDeathInfo.getDeptCode());
        emrActivityInfo.setDeptName(emrDeathInfo.getDeptName());
        emrActivityInfo.setOrgCode(emrDeathInfo.getOrgCode());
        emrActivityInfo.setOrgName(emrDeathInfo.getOrgName());
        emrActivityInfo.setOperationTime(DateUtils.getTime());
        synchroEmrRealService.syncEmrActivityInfo(emrActivityInfo, Constants.HTTP_METHOD_POST);
    }


    @Scheduled(cron = "0 30 7,15,23 * * ?")
    public void emrVitalSignsRecord() {
        logger.debug("生命体征护理记录单emr_vital_signs_record定时任务执行接口, {}", DateUtils.getNowDate());
        R<List<Transfer>> transfer = medrecFeignClient.getTransfer();
        List<Transfer> transferList = transfer.getData();
        Map<String, Transfer> transferMap = new HashMap<>();
        List<String> transferIdList = new ArrayList<>();
        if (R.SUCCESS != transfer.getCode() || null == transferList  || transferList.isEmpty()) {
            logger.debug("未找到TRANSFER(ICU)数据");
        } else {
            for (Transfer tran : transferList) {
                String patientId = tran.getPatientId();
                transferIdList.add(patientId);
                transferMap.put(patientId, tran);
            }
        }
        R<List<String>> cpapInfo = inpbillFeignClient.getCPAPInfo();
        List<String> cpapInfoList = cpapInfo.getData();
        if (R.SUCCESS != cpapInfo.getCode() || null == cpapInfoList  || cpapInfoList.isEmpty()) {
            logger.debug("未找到INP_BILL_DETAIL(CPAP)数据");
        }
        R<List<Transfer>> cpapDeptInfo = medrecFeignClient.getCPAPDeptInfo(cpapInfoList);
        List<Transfer> cpapDeptInfoList = cpapDeptInfo.getData();
        Map<String, Transfer> cpapDeptInfoMap = new HashMap<>();
        if (R.SUCCESS != cpapDeptInfo.getCode() || null == cpapDeptInfoList  || cpapDeptInfoList.isEmpty()) {
            logger.debug("未找到TRANSFER(CPAP)数据");
        } else {
            for (Transfer tran : cpapDeptInfoList) {
                String patientId = tran.getPatientId();
                String deptStayed = tran.getDeptStayed();
                if (!DEPT_STAYED.equalsIgnoreCase(deptStayed)){
                    cpapDeptInfoMap.put(patientId, tran);
                }
            }
        }
        // 合并两个list
        List<String> mergedList = Stream.concat(transferIdList.stream(), cpapInfoList.stream()).collect(Collectors.toList());
        // 获取交集
        Set<String> set2 = new HashSet<>(transferIdList);
        List<String> intersection = cpapInfoList.stream().filter(set2::contains).collect(Collectors.toList());
        // 合并两个map
        Map<String, Transfer> mergedMap = new HashMap<>(transferMap);
        mergedMap.putAll(cpapDeptInfoMap);
        for (String patientId : mergedList) {
            EmrVitalSignsRecord record = new EmrVitalSignsRecord();
            R<PatMasterIndex> medrecResult = medrecFeignClient.getPatMasterIndex(patientId);
            PatMasterIndex patMasterIndex = medrecResult.getData();
            if (R.SUCCESS == medrecResult.getCode() && patMasterIndex != null) {
                // 更新推送患者信息
                EmrPatientInfo info = hubToolService.syncPatInfo(medrecResult.getData());
                DictDisDept dictDisDept = dictDisDeptService.getCacheDisDept(DEPT_STAYED);
                String serialNumber = DigestUtil.md5Hex(DateUtils.dateTimeNow(DateUtils.YYYYMMDD) + info.getId() + info.getPatientName());
                buildBaseInfo(record, info, serialNumber);
                record.setDeptCode(dictDisDept.getEmrCode());
                record.setDeptName(dictDisDept.getEmrName());
                Transfer tran = mergedMap.get(patientId);
                Users user = commConvertService.getUserByName(tran.getDoctorInCharge());
                record.setOperatorId(user.getUserId());
                if (intersection.contains(patientId)){
                    // CPAP ICU
                    record.setVentilatorusedCode("1");
                    record.setVentilatorusedName("是");
                    record.setCriticalCareCode("1");
                    record.setCriticalCareName("是");
                } else if (transferIdList.contains(patientId)){
                    // ICU
                    record.setVentilatorusedCode("0");
                    record.setVentilatorusedName("否");
                    record.setCriticalCareCode("1");
                    record.setCriticalCareName("是");
                } else {
                    // CPAP
                    record.setVentilatorusedCode("1");
                    record.setVentilatorusedName("是");
                    record.setCriticalCareCode("0");
                    record.setCriticalCareName("否");
                    DictDisDept disDept = dictDisDeptService.getCacheDisDept(tran.getDeptStayed());
                    record.setDeptCode(disDept.getEmrCode());
                    record.setDeptName(disDept.getEmrName());

                }
                String key = getICUAndCPAPCacheKey(patientId) + DateUtils.dateTimeNow(DateUtils.YYYY_MM_DD);
                EmrVitalSignsRecord cacheRecord = redisCache.getCacheObject(key);
                if (null == cacheRecord || !record.equalsNoDate(cacheRecord)) {
                    // 同步患者信息
                    hubToolService.syncPatInfo(patMasterIndex);
                    // 同步诊疗活动信息
                    sendActivityInfo(record, tran.getDeptStayed());
                    // 同步生命体征记录
                    synchroEmrMonitorService.syncEmrVitalSignsRecord(record, Constants.HTTP_METHOD_POST);
                    redisCache.setCacheObject(key, record, 24, TimeUnit.HOURS);
                } else {
                    logger.info("生命体征护理记录单emr_vital_signs_record，患者ID：{} 已同步", patientId);
                }
            } else {
                logger.error("PAT_MASTER_INDEX表患者ID查询失败,{}", patientId);
            }

        }

    }

    private void buildBaseInfo(EmrVitalSignsRecord record, EmrPatientInfo info, String serialNumber) {
        record.setId(DigestUtil.md5Hex(DateUtils.dateTimeNow(DateUtils.YYYY_MM_DD_HH_MM_SS) + info.getId() + info.getPatientName()));
        record.setPatientId(info.getId());
        record.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_DAILY_COURSE.getCode());
        record.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_DAILY_COURSE.getName());
        record.setSerialNumber(serialNumber);
        record.setPatientName(info.getPatientName());
        record.setIdCardTypeCode(info.getIdCardTypeCode());
        record.setIdCardTypeName(info.getIdCardTypeName());
        record.setIdCard(info.getIdCard());
        record.setCreateDate(DateUtils.dateTimeNow(DateUtils.YYYY_MM_DD_HH_MM_SS));
        record.setOrgCode(info.getOrgCode());
        record.setOrgName(info.getOrgName());
        record.setOperatorId(DateUtils.dateTimeNow(DateUtils.YYYY_MM_DD_HH_MM_SS));
    }

    private EmrVitalSignsRecord getEmrVitalSignsRecord(Orders order, String patientId, PatMasterIndex patMasterIndex) {
        EmrVitalSignsRecord record = new EmrVitalSignsRecord();
        String id = DigestUtil.md5Hex(DateUtils.dateTime(order.getEnterDateTime()) + order.getPatientId() + order.getOrderNo());
        record.setId(id);
        record.setPatientId(patientId);
        record.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_DAILY_COURSE.getCode());
        record.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_DAILY_COURSE.getName());
        record.setSerialNumber(DigestUtil.md5Hex(id));
        record.setPatientName(patMasterIndex.getName());
        if (cn.xa.eyre.common.utils.StringUtils.isBlank(patMasterIndex.getIdNo())){
            record.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE_OTHER.getCode());
            record.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE_OTHER.getName());
            record.setIdCard("-");
        }else {
            if (IdcardUtil.isValidCard(patMasterIndex.getIdNo())){
                record.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE.getCode());
                record.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE.getName());
                record.setIdCard(patMasterIndex.getIdNo());
            }else {
                record.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE_OTHER.getCode());
                record.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE_OTHER.getName());
                record.setIdCard(patMasterIndex.getIdNo());
            }
        }
        record.setCreateDate(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, order.getEnterDateTime()));
        extractedInfo(order, record);
        record.setOrgCode(HubCodeEnum.ORG_CODE.getCode());
        record.setOrgName(HubCodeEnum.ORG_CODE.getName());
        String dept = order.getOrderingDept();
        DictDisDept dictDisDept = hubToolService.getDept(dept);
        record.setDeptCode(dictDisDept.getHubCode());
        record.setDeptName(dictDisDept.getHubName());
        if (cn.xa.eyre.common.utils.StringUtils.isNotBlank(patMasterIndex.getOperator())){
            R<Users> user = commFeignClient.getUserByName(patMasterIndex.getOperator());
            if (R.SUCCESS == user.getCode() && user.getData() != null){
                record.setOperatorId(user.getData().getUserId());
            }
        }
        record.setOperationTime(DateUtils.getTime());
        return record;
    }

    /**
 * 发送同步生命体征护理记录信息的方法
 *
 * @param order 订单对象，包含订单相关信息
 * @param key 缓存键，用于在Redis中缓存生命体征记录
 * @param recordAfter 更新后的生命体征记录对象，表示最新记录
 * @param patMasterIndex 病人主索引对象，包含病人的主要信息
 */
private void sendSynchroEmrInfo(Orders order, String key, EmrVitalSignsRecord recordAfter, PatMasterIndex patMasterIndex) {
    // 将更新后的生命体征记录转换为JSON字符串并缓存到Redis中，设置缓存时间为24小时
    redisCache.setCacheObject(key, JSON.toJSONString(recordAfter), 24, TimeUnit.HOURS);
    // 同步病人信息
    hubToolService.syncPatInfo(patMasterIndex);
    // 同步生命体征记录
    synchroEmrMonitorService.syncEmrVitalSignsRecord(recordAfter, Constants.HTTP_METHOD_POST);
    // 发送活动信息
    sendActivityInfo(order, recordAfter);
}


    private void sendActivityInfo(Orders order, EmrVitalSignsRecord recordAfter) {
        logger.debug("构造emrVitalSignsRecord接口数据...");
        EmrActivityInfo emrActivityInfo = new EmrActivityInfo();
        emrActivityInfo.setId(recordAfter.getId());
        emrActivityInfo.setPatientId(recordAfter.getPatientId());
        emrActivityInfo.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_FIRST_COURSE.getCode());
        emrActivityInfo.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_FIRST_COURSE.getName());
        emrActivityInfo.setSerialNumber(recordAfter.getSerialNumber());
        emrActivityInfo.setActivityTime(recordAfter.getCreateDate());
        emrActivityInfo.setIdCardTypeCode(recordAfter.getIdCardTypeCode());
        emrActivityInfo.setIdCardTypeName(recordAfter.getIdCardTypeName());
        emrActivityInfo.setIdCard(recordAfter.getIdCard());
        emrActivityInfo.setPatientName(recordAfter.getPatientName());
        emrActivityInfo.setDiagnoseTime(recordAfter.getCreateDate());
        emrActivityInfo.setWmDiseaseCode("-");
        emrActivityInfo.setWmDiseaseName("-");
        emrActivityInfo.setFillDoctor(order.getDoctor());
        emrActivityInfo.setOperatorId(recordAfter.getOperatorId());
        emrActivityInfo.setDeptCode(recordAfter.getDeptCode());
        emrActivityInfo.setDeptName(recordAfter.getDeptName());
        emrActivityInfo.setOrgCode(recordAfter.getOrgCode());
        emrActivityInfo.setOrgName(recordAfter.getOrgName());
        emrActivityInfo.setOperationTime(DateUtils.getTime());
        synchroEmrRealService.syncEmrActivityInfo(emrActivityInfo, Constants.HTTP_METHOD_POST);
    }

    private void sendActivityInfo(EmrVitalSignsRecord record, String doctorName) {
        logger.debug("构造emrVitalSignsRecord接口数据...");
        EmrActivityInfo emrActivityInfo = new EmrActivityInfo();
        emrActivityInfo.setId(DigestUtil.md5Hex(record.getId()));
        emrActivityInfo.setPatientId(record.getPatientId());
        emrActivityInfo.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_FIRST_COURSE.getCode());
        emrActivityInfo.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_FIRST_COURSE.getName());
        emrActivityInfo.setSerialNumber(record.getSerialNumber());
        emrActivityInfo.setActivityTime(record.getCreateDate());
        emrActivityInfo.setIdCardTypeCode(record.getIdCardTypeCode());
        emrActivityInfo.setIdCardTypeName(record.getIdCardTypeName());
        emrActivityInfo.setIdCard(record.getIdCard());
        emrActivityInfo.setPatientName(record.getPatientName());
        emrActivityInfo.setDiagnoseTime(record.getCreateDate());
        emrActivityInfo.setWmDiseaseCode("-");
        emrActivityInfo.setWmDiseaseName("-");
        emrActivityInfo.setFillDoctor(doctorName);
        emrActivityInfo.setOperatorId(record.getOperatorId());
        emrActivityInfo.setDeptCode(record.getDeptCode());
        emrActivityInfo.setDeptName(record.getDeptName());
        emrActivityInfo.setOrgCode(record.getOrgCode());
        emrActivityInfo.setOrgName(record.getOrgName());
        emrActivityInfo.setOperationTime(DateUtils.getTime());
        synchroEmrRealService.syncEmrActivityInfo(emrActivityInfo, Constants.HTTP_METHOD_POST);
    }
}
