package cn.xa.eyre.service;

import cn.hutool.core.bean.BeanUtil;
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
import cn.xa.eyre.hisapi.MedrecFeignClient;
import cn.xa.eyre.hisapi.OrdadmFeignClient;
import cn.xa.eyre.hub.domain.emrmonitor.EmrVitalSignsRecord;
import cn.xa.eyre.hub.domain.emrreal.EmrActivityInfo;
import cn.xa.eyre.hub.service.SynchroEmrMonitorService;
import cn.xa.eyre.hub.service.SynchroEmrRealService;
import cn.xa.eyre.hub.staticvalue.HubCodeEnum;
import cn.xa.eyre.medrec.domain.PatMasterIndex;
import cn.xa.eyre.ordadm.domain.Orders;
import cn.xa.eyre.system.dict.domain.DictDisDept;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class OrdadmConvertService {
    private static final String ORDERS_PATIENT_IDS = "ORDERS_PATIENT_IDS";
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

    public static String getCacheKey(String key) {
        return CacheConstants.ORDADM_ICU_AMV_PATIENT_KEY + key;
    }

    @Scheduled(cron = "0 0 */6 * * ?")
    public void ordersInfo() {
        logger.debug("医嘱表ORDERS定时任务执行接口, {}", DateUtils.getNowDate());

        R<List<Orders>> icuAndAMVInfoResult = ordadmFeignClient.getICUAndAMVInfo();
        List<Orders> ordersList = icuAndAMVInfoResult.getData();
        if (R.SUCCESS == icuAndAMVInfoResult.getCode() && ordersList != null
                && !ordersList.isEmpty()) {
            for (Orders order : ordersList) {
                String patientId = order.getPatientId();
                String key = getCacheKey(patientId) + DateUtils.dateTimeNow(DateUtils.YYYY_MM_DD);
                String cache = Convert.toStr(redisCache.getCacheObject(key));
                R<PatMasterIndex> medrecResult = medrecFeignClient.getPatMasterIndex(patientId);
                PatMasterIndex patMasterIndex = medrecResult.getData();
                if (R.SUCCESS == medrecResult.getCode() && patMasterIndex != null) {
                    if (StringUtils.isNotBlank(cache)) {
                        EmrVitalSignsRecord recordBefore = JSONObject.parseObject(cache, EmrVitalSignsRecord.class);
                        EmrVitalSignsRecord recordAfter = JSONObject.parseObject(cache, EmrVitalSignsRecord.class);
                        extractedInfo(order, recordAfter);
                        if (!recordBefore.equals(recordAfter)) {
                            sendSynchroEmrInfo(order, key, recordAfter, patMasterIndex);
                        } else {
                            EmrVitalSignsRecord record = getEmrVitalSignsRecord(order, patientId, patMasterIndex);
                            sendSynchroEmrInfo(order, key, record, patMasterIndex);
                        }
                    }
                } else {
                    logger.error("患者ID查询失败", patientId);
                }
            }

        } else {
            logger.debug("未找到ORDERS数据");
        }

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
}
