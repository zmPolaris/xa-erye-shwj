package cn.xa.eyre.hub.service;

import cn.hutool.json.JSONUtil;
import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.utils.DateUtils;
import cn.xa.eyre.common.utils.http.HttpClientUtils;
import cn.xa.eyre.hub.domain.SynchroResponseVo;
import cn.xa.eyre.hub.domain.emrmonitor.*;
import cn.xa.eyre.hub.staticvalue.SyncApiStaticValue;
import cn.xa.eyre.system.log.domain.LogSynchroApiWithBLOBs;
import cn.xa.eyre.system.log.mapper.LogSynchroApiMapper;
import cn.xa.eyre.system.system.service.ISysConfigService;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 常规监测数据同步
 */
@Service
public class SynchroEmrMonitorService {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ISysConfigService sysConfigService;
    @Autowired
    private LogSynchroApiMapper logSynchroApiMapper;
    private String serviceUrl;
    private boolean isSaveLog = false;

    /**
     * 门（急）诊病历表数据操作 API 接口
     * @param emrOutpatientRecord
     * @param method
     * @return
     */
    public void syncEmrOutpatientRecord(EmrOutpatientRecord emrOutpatientRecord, String method){
        init();
        String apiUrl = serviceUrl + SyncApiStaticValue.API_EMR_OUTPATIENT_RECORD;
        LogSynchroApiWithBLOBs log = new LogSynchroApiWithBLOBs();
        log.setUrl(apiUrl);
        log.setMethodName(method);
        log.setInputParams(JSONUtil.toJsonStr(emrOutpatientRecord));
        logger.info("->{},url:{},request:{},method:{}", "门（急）诊病历表数据操作 API 接口", apiUrl, JSONUtil.toJsonStr(emrOutpatientRecord), method);
        try {
            String result = HttpClientUtils.sendHttpRequest(apiUrl, JSONUtil.toJsonStr(emrOutpatientRecord), method);
            logger.info("->{},response:{}", "门（急）诊病历表数据操作 API 接口", result);
            SynchroResponseVo synchroResponseVo = JSONObject.parseObject(result, new TypeReference<SynchroResponseVo>(){});
            log.setOutputParams(JSONUtil.toJsonStr(synchroResponseVo));
            if (synchroResponseVo.isResult()){
                log.setResult(Constants.API_STATUS_SUCCESS);
            }else {
                log.setResult(Constants.API_STATUS_FAIL);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.setResult(Constants.API_STATUS_FAIL);
        }
        if(isSaveLog){
            log.setAddTime(DateUtils.getNowDate());
            logSynchroApiMapper.insertSelective(log);
        }
    }

    /**
     * 门（急）诊留观记录表数据操作 API 接口
     * @param emrOutpatientObs
     * @param method
     * @return
     */
    public void syncEmrOutpatientObs(EmrOutpatientObs emrOutpatientObs, String method){
        init();
        String apiUrl = serviceUrl + SyncApiStaticValue.API_EMR_OUTPATIENT_OBS;
        LogSynchroApiWithBLOBs log = new LogSynchroApiWithBLOBs();
        log.setUrl(apiUrl);
        log.setMethodName(method);
        log.setInputParams(JSONUtil.toJsonStr(emrOutpatientObs));
        logger.info("->{},url:{},request:{},method:{}", "门（急）诊留观记录表数据操作 API 接口", apiUrl, JSONUtil.toJsonStr(emrOutpatientObs), method);
        try {
            String result = HttpClientUtils.sendHttpRequest(apiUrl, JSONUtil.toJsonStr(emrOutpatientObs), method);
            logger.info("->{},response:{}", "门（急）诊留观记录表数据操作 API 接口", result);
            SynchroResponseVo synchroResponseVo =  JSONObject.parseObject(result, new TypeReference<SynchroResponseVo>(){});
            log.setOutputParams(JSONUtil.toJsonStr(synchroResponseVo));
            if (synchroResponseVo.isResult()){
                log.setResult(Constants.API_STATUS_SUCCESS);
            }else {
                log.setResult(Constants.API_STATUS_FAIL);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.setResult(Constants.API_STATUS_FAIL);
        }
        if(isSaveLog){
            log.setAddTime(DateUtils.getNowDate());
            logSynchroApiMapper.insertSelective(log);
        }
    }

    /**
     * 入院记录表数据操作 API 接口
     * @param emrAdmissionInfo
     * @param method
     * @return
     */
    public void syncEmrAdmissionInfo(EmrAdmissionInfo emrAdmissionInfo, String method){
        init();
        String apiUrl = serviceUrl + SyncApiStaticValue.API_EMR_ADMISSION_INFO;
        LogSynchroApiWithBLOBs log = new LogSynchroApiWithBLOBs();
        log.setUrl(apiUrl);
        log.setMethodName(method);
        log.setInputParams(JSONUtil.toJsonStr(emrAdmissionInfo));
        logger.info("->{},url:{},request:{},method:{}", "入院记录表数据操作 API 接口", apiUrl, JSONUtil.toJsonStr(emrAdmissionInfo), method);
        try {
            String result = HttpClientUtils.sendHttpRequest(apiUrl, JSONUtil.toJsonStr(emrAdmissionInfo), method);
            logger.info("->{},response:{}", "入院记录表数据操作 API 接口", result);
            SynchroResponseVo synchroResponseVo =  JSONObject.parseObject(result, new TypeReference<SynchroResponseVo>(){});
            log.setOutputParams(JSONUtil.toJsonStr(synchroResponseVo));
            if (synchroResponseVo.isResult()){
                log.setResult(Constants.API_STATUS_SUCCESS);
            }else {
                log.setResult(Constants.API_STATUS_FAIL);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.setResult(Constants.API_STATUS_FAIL);
        }
        if(isSaveLog){
            log.setAddTime(DateUtils.getNowDate());
            logSynchroApiMapper.insertSelective(log);
        }
    }

    /**
     * 住院首次病程记录表数据操作 API 接口
     * @param emrFirstCourse
     * @param method
     * @return
     */
    public void syncEmrFirstCourse(EmrFirstCourse emrFirstCourse, String method){
        init();
        String apiUrl = serviceUrl + SyncApiStaticValue.API_EMR_FIRST_COURSE;
        LogSynchroApiWithBLOBs log = new LogSynchroApiWithBLOBs();
        log.setUrl(apiUrl);
        log.setMethodName(method);
        log.setInputParams(JSONUtil.toJsonStr(emrFirstCourse));
        logger.info("->{},url:{},request:{},method:{}", "住院首次病程记录表数据操作 API 接口", apiUrl, JSONUtil.toJsonStr(emrFirstCourse), method);
        try {
            String result = HttpClientUtils.sendHttpRequest(apiUrl, JSONUtil.toJsonStr(emrFirstCourse), method);
            logger.info("->{},response:{}", "住院首次病程记录表数据操作 API 接口", result);
            SynchroResponseVo synchroResponseVo = JSONObject.parseObject(result, new TypeReference<SynchroResponseVo>(){});
            log.setOutputParams(JSONUtil.toJsonStr(synchroResponseVo));
            if (synchroResponseVo.isResult()){
                log.setResult(Constants.API_STATUS_SUCCESS);
            }else {
                log.setResult(Constants.API_STATUS_FAIL);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.setResult(Constants.API_STATUS_FAIL);
        }
        if(isSaveLog){
            log.setAddTime(DateUtils.getNowDate());
            logSynchroApiMapper.insertSelective(log);
        }
    }

    /**
     * 住院日常病程记录表数据操作 API 接口
     * @param emrDailyCourse
     * @param method
     * @return
     */
    public void syncEmrDailyCourse(EmrDailyCourse emrDailyCourse, String method){
        init();
        String apiUrl = serviceUrl + SyncApiStaticValue.API_EMR_DAILY_COURSE;
        LogSynchroApiWithBLOBs log = new LogSynchroApiWithBLOBs();
        log.setUrl(apiUrl);
        log.setMethodName(method);
        log.setInputParams(JSONUtil.toJsonStr(emrDailyCourse));
        logger.info("->{},url:{},request:{},method:{}", "住院日常病程记录表数据操作 API 接口", apiUrl, JSONUtil.toJsonStr(emrDailyCourse), method);
        try {
            String result = HttpClientUtils.sendHttpRequest(apiUrl, JSONUtil.toJsonStr(emrDailyCourse), method);
            logger.info("->{},response:{}", "住院日常病程记录表数据操作 API 接口", result);
            SynchroResponseVo synchroResponseVo =  JSONObject.parseObject(result, new TypeReference<SynchroResponseVo>(){});
            log.setOutputParams(JSONUtil.toJsonStr(synchroResponseVo));
            if (synchroResponseVo.isResult()){
                log.setResult(Constants.API_STATUS_SUCCESS);
            }else {
                log.setResult(Constants.API_STATUS_FAIL);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.setResult(Constants.API_STATUS_FAIL);
        }
        if(isSaveLog){
            log.setAddTime(DateUtils.getNowDate());
            logSynchroApiMapper.insertSelective(log);
        }
    }

    /**
     * 住院病案首页表数据操作 API 接口
     * @param emrAdmissionRecord
     * @param method
     * @return
     */
    public void syncEmrAdmissionRecord(EmrAdmissionRecord emrAdmissionRecord, String method){
        init();
        String apiUrl = serviceUrl + SyncApiStaticValue.API_EMR_ADMISSION_RECORD;
        LogSynchroApiWithBLOBs log = new LogSynchroApiWithBLOBs();
        log.setUrl(apiUrl);
        log.setMethodName(method);
        log.setInputParams(JSONUtil.toJsonStr(emrAdmissionRecord));
        logger.info("->{},url:{},request:{},method:{}", "住院病案首页表数据操作 API 接口", apiUrl, JSONUtil.toJsonStr(emrAdmissionRecord), method);
        try {
            String result = HttpClientUtils.sendHttpRequest(apiUrl, JSONUtil.toJsonStr(emrAdmissionRecord), method);
            logger.info("->{},response:{}", "住院病案首页表数据操作 API 接口", result);
            SynchroResponseVo synchroResponseVo =  JSONObject.parseObject(result, new TypeReference<SynchroResponseVo>(){});
            log.setOutputParams(JSONUtil.toJsonStr(synchroResponseVo));
            if (synchroResponseVo.isResult()){
                log.setResult(Constants.API_STATUS_SUCCESS);
            }else {
                log.setResult(Constants.API_STATUS_FAIL);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.setResult(Constants.API_STATUS_FAIL);
        }
        if(isSaveLog){
            log.setAddTime(DateUtils.getNowDate());
            logSynchroApiMapper.insertSelective(log);
        }
    }

    /**
     * 出院记录表数据操作 API 接口
     * @param emrDischargeInfo
     * @param method
     * @return
     */
    public void syncEmrDischargeInfo(EmrDischargeInfo emrDischargeInfo, String method){
        init();
        String apiUrl = serviceUrl + SyncApiStaticValue.API_EMR_DISCHARGE_INFO;
        LogSynchroApiWithBLOBs log = new LogSynchroApiWithBLOBs();
        log.setUrl(apiUrl);
        log.setMethodName(method);
        log.setInputParams(JSONUtil.toJsonStr(emrDischargeInfo));
        logger.info("->{},url:{},request:{},method:{}", "出院记录表数据操作 API 接口", apiUrl, JSONUtil.toJsonStr(emrDischargeInfo), method);
        try {
            String result = HttpClientUtils.sendHttpRequest(apiUrl, JSONUtil.toJsonStr(emrDischargeInfo), method);
            logger.info("->{},response:{}", "出院记录表数据操作 API 接口", result);
            SynchroResponseVo synchroResponseVo = JSONObject.parseObject(result, new TypeReference<SynchroResponseVo>(){});
            log.setOutputParams(JSONUtil.toJsonStr(synchroResponseVo));
            if (synchroResponseVo.isResult()){
                log.setResult(Constants.API_STATUS_SUCCESS);
            }else {
                log.setResult(Constants.API_STATUS_FAIL);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.setResult(Constants.API_STATUS_FAIL);
        }
        if(isSaveLog){
            log.setAddTime(DateUtils.getNowDate());
            logSynchroApiMapper.insertSelective(log);
        }
    }

    /**
     * 检查报告表数据操作 API 接口
     * @param emrExClinical
     * @param method
     * @return
     */
    public void syncEmrExClinical(EmrExClinical emrExClinical, String method){
        init();
        String apiUrl = serviceUrl + SyncApiStaticValue.API_EMR_EX_CLINICAL;
        LogSynchroApiWithBLOBs log = new LogSynchroApiWithBLOBs();
        log.setUrl(apiUrl);
        log.setMethodName(method);
        log.setInputParams(JSONUtil.toJsonStr(emrExClinical));
        logger.info("->{},url:{},request:{},method:{}", "检查报告表数据操作 API 接口", apiUrl, JSONUtil.toJsonStr(emrExClinical), method);
        try {
            String result = HttpClientUtils.sendHttpRequest(apiUrl, JSONUtil.toJsonStr(emrExClinical), method);
            logger.info("->{},response:{}", "检查报告表数据操作 API 接口", result);
            SynchroResponseVo synchroResponseVo =  JSONObject.parseObject(result, new TypeReference<SynchroResponseVo>(){});
            log.setOutputParams(JSONUtil.toJsonStr(synchroResponseVo));
            if (synchroResponseVo.isResult()){
                log.setResult(Constants.API_STATUS_SUCCESS);
            }else {
                log.setResult(Constants.API_STATUS_FAIL);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.setResult(Constants.API_STATUS_FAIL);
        }
        if(isSaveLog){
            log.setAddTime(DateUtils.getNowDate());
            logSynchroApiMapper.insertSelective(log);
        }
    }

    /**
     * 检查报告项目表数据操作 API 接口
     * @param emrExClinicalItem
     * @param method
     * @return
     */
    public void syncEmrExClinicalItem(EmrExClinicalItem emrExClinicalItem, String method){
        init();
        String apiUrl = serviceUrl + SyncApiStaticValue.API_EMR_EX_CLINICAL_ITEM;
        LogSynchroApiWithBLOBs log = new LogSynchroApiWithBLOBs();
        log.setUrl(apiUrl);
        log.setMethodName(method);
        log.setInputParams(JSONUtil.toJsonStr(emrExClinicalItem));
        logger.info("->{},url:{},request:{},method:{}", "检查报告项目表数据操作 API 接口", apiUrl, JSONUtil.toJsonStr(emrExClinicalItem), method);
        try {
            String result = HttpClientUtils.sendHttpRequest(apiUrl, JSONUtil.toJsonStr(emrExClinicalItem), method);
            logger.info("->{},response:{}", "检查报告项目表数据操作 API 接口", result);
            SynchroResponseVo synchroResponseVo =  JSONObject.parseObject(result, new TypeReference<SynchroResponseVo>(){});
            log.setOutputParams(JSONUtil.toJsonStr(synchroResponseVo));
            if (synchroResponseVo.isResult()){
                log.setResult(Constants.API_STATUS_SUCCESS);
            }else {
                log.setResult(Constants.API_STATUS_FAIL);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.setResult(Constants.API_STATUS_FAIL);
        }
        if(isSaveLog){
            log.setAddTime(DateUtils.getNowDate());
            logSynchroApiMapper.insertSelective(log);
        }
    }

    /**
     * 检验报告表数据操作 API 接口
     * @param emrExLab
     * @param method
     * @return
     */
    public void syncEmrExLab(EmrExLab emrExLab, String method){
        init();
        String apiUrl = serviceUrl + SyncApiStaticValue.API_EMR_EX_LAB;
        LogSynchroApiWithBLOBs log = new LogSynchroApiWithBLOBs();
        log.setUrl(apiUrl);
        log.setMethodName(method);
        log.setInputParams(JSONUtil.toJsonStr(emrExLab));
        logger.info("->{},url:{},request:{},method:{}", "检验报告表数据操作 API 接口", apiUrl, JSONUtil.toJsonStr(emrExLab), method);
        try {
            String result = HttpClientUtils.sendHttpRequest(apiUrl, JSONUtil.toJsonStr(emrExLab), method);
            logger.info("->{},response:{}", "检验报告表数据操作 API 接口", result);
            SynchroResponseVo synchroResponseVo = JSONObject.parseObject(result, new TypeReference<SynchroResponseVo>(){});
            log.setOutputParams(JSONUtil.toJsonStr(synchroResponseVo));
            if (synchroResponseVo.isResult()){
                log.setResult(Constants.API_STATUS_SUCCESS);
            }else {
                log.setResult(Constants.API_STATUS_FAIL);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.setResult(Constants.API_STATUS_FAIL);
        }
        if(isSaveLog){
            log.setAddTime(DateUtils.getNowDate());
            logSynchroApiMapper.insertSelective(log);
        }
    }

    /**
     * 检验报告项目表数据操作 API 接口
     * @param emrExLabItem
     * @param method
     * @return
     */
    public void syncEmrExLabItem(EmrExLabItem emrExLabItem, String method){
        init();
        String apiUrl = serviceUrl + SyncApiStaticValue.API_EMR_EX_LAB_ITEM;
        LogSynchroApiWithBLOBs log = new LogSynchroApiWithBLOBs();
        log.setUrl(apiUrl);
        log.setMethodName(method);
        log.setInputParams(JSONUtil.toJsonStr(emrExLabItem));
        logger.info("->{},url:{},request:{},method:{}", "检验报告项目表数据操作 API 接口", apiUrl, JSONUtil.toJsonStr(emrExLabItem), method);
        try {
            String result = HttpClientUtils.sendHttpRequest(apiUrl, JSONUtil.toJsonStr(emrExLabItem), method);
            logger.info("->{},response:{}", "检验报告项目表数据操作 API 接口", result);
            SynchroResponseVo synchroResponseVo =  JSONObject.parseObject(result, new TypeReference<SynchroResponseVo>(){});
            log.setOutputParams(JSONUtil.toJsonStr(synchroResponseVo));
            if (synchroResponseVo.isResult()){
                log.setResult(Constants.API_STATUS_SUCCESS);
            }else {
                log.setResult(Constants.API_STATUS_FAIL);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.setResult(Constants.API_STATUS_FAIL);
        }
        if(isSaveLog){
            log.setAddTime(DateUtils.getNowDate());
            logSynchroApiMapper.insertSelective(log);
        }
    }

    /**
     * 医嘱处方信息表数据操作 API 接口
     * @param emrOrder
     * @param method
     * @return
     */
    public void syncEmrOrder(EmrOrder emrOrder, String method){
        init();
        String apiUrl = serviceUrl + SyncApiStaticValue.API_EMR_ORDER;
        LogSynchroApiWithBLOBs log = new LogSynchroApiWithBLOBs();
        log.setUrl(apiUrl);
        log.setMethodName(method);
        log.setInputParams(JSONUtil.toJsonStr(emrOrder));
        logger.info("->{},url:{},request:{},method:{}", "医嘱处方信息表数据操作 API 接口", apiUrl, JSONUtil.toJsonStr(emrOrder), method);
        try {
            String result = HttpClientUtils.sendHttpRequest(apiUrl, JSONUtil.toJsonStr(emrOrder), method);
            logger.info("->{},response:{}", "医嘱处方信息表数据操作 API 接口", result);
            SynchroResponseVo synchroResponseVo =  JSONObject.parseObject(result, new TypeReference<SynchroResponseVo>(){});
            log.setOutputParams(JSONUtil.toJsonStr(synchroResponseVo));
            if (synchroResponseVo.isResult()){
                log.setResult(Constants.API_STATUS_SUCCESS);
            }else {
                log.setResult(Constants.API_STATUS_FAIL);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.setResult(Constants.API_STATUS_FAIL);
        }
        if(isSaveLog){
            log.setAddTime(DateUtils.getNowDate());
            logSynchroApiMapper.insertSelective(log);
        }
    }

    /**
     * 医嘱处方条目表数据操作 API 接口
     * @param emrOrderItem
     * @param method
     * @return
     */
    public void syncEmrOrderItem(EmrOrderItem emrOrderItem, String method){
        init();
        String apiUrl = serviceUrl + SyncApiStaticValue.API_EMR_ORDER_ITEM;
        LogSynchroApiWithBLOBs log = new LogSynchroApiWithBLOBs();
        log.setUrl(apiUrl);
        log.setMethodName(method);
        log.setInputParams(JSONUtil.toJsonStr(emrOrderItem));
        logger.info("->{},url:{},request:{},method:{}", "医嘱处方条目表数据操作 API 接口", apiUrl, JSONUtil.toJsonStr(emrOrderItem), method);
        try {
            String result = HttpClientUtils.sendHttpRequest(apiUrl, JSONUtil.toJsonStr(emrOrderItem), method);
            logger.info("->{},response:{}", "医嘱处方条目表数据操作 API 接口", result);
            SynchroResponseVo synchroResponseVo = JSONObject.parseObject(result, new TypeReference<SynchroResponseVo>(){});
            log.setOutputParams(JSONUtil.toJsonStr(synchroResponseVo));
            if (synchroResponseVo.isResult()){
                log.setResult(Constants.API_STATUS_SUCCESS);
            }else {
                log.setResult(Constants.API_STATUS_FAIL);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.setResult(Constants.API_STATUS_FAIL);
        }
        if(isSaveLog){
            log.setAddTime(DateUtils.getNowDate());
            logSynchroApiMapper.insertSelective(log);
        }
    }

    /**
     * 死亡信息表数据操作 API 接口
     * @param emrDeathInfo
     * @param method
     * @return
     */
    public void syncEmrDeathInfo(EmrDeathInfo emrDeathInfo, String method){
        init();
        String apiUrl = serviceUrl + SyncApiStaticValue.API_EMR_DEATH_INFO;
        LogSynchroApiWithBLOBs log = new LogSynchroApiWithBLOBs();
        log.setUrl(apiUrl);
        log.setMethodName(method);
        log.setInputParams(JSONUtil.toJsonStr(emrDeathInfo));
        logger.info("->{},url:{},request:{},method:{}", "死亡信息表数据操作 API 接口", apiUrl, JSONUtil.toJsonStr(emrDeathInfo), method);
        try {
            String result = HttpClientUtils.sendHttpRequest(apiUrl, JSONUtil.toJsonStr(emrDeathInfo), method);
            logger.info("->{},response:{}", "死亡信息表数据操作 API 接口", result);
            SynchroResponseVo synchroResponseVo =  JSONObject.parseObject(result, new TypeReference<SynchroResponseVo>(){});
            log.setOutputParams(JSONUtil.toJsonStr(synchroResponseVo));
            if (synchroResponseVo.isResult()){
                log.setResult(Constants.API_STATUS_SUCCESS);
            }else {
                log.setResult(Constants.API_STATUS_FAIL);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.setResult(Constants.API_STATUS_FAIL);
        }
        if(isSaveLog){
            log.setAddTime(DateUtils.getNowDate());
            logSynchroApiMapper.insertSelective(log);
        }
    }

    /**
     * 生命体征护理记录单数据操作 API 接口
     * @param emrVitalSignsRecord
     * @param method
     * @return
     */
    public void syncEmrVitalSignsRecord(EmrVitalSignsRecord emrVitalSignsRecord, String method){
        init();
        String apiUrl = serviceUrl + SyncApiStaticValue.API_EMR_VITAL_SIGNS_RECORD;
        LogSynchroApiWithBLOBs log = new LogSynchroApiWithBLOBs();
        log.setUrl(apiUrl);
        log.setMethodName(method);
        log.setInputParams(JSONUtil.toJsonStr(emrVitalSignsRecord));
        logger.info("->{},url:{},request:{},method:{}", "生命体征护理记录单数据操作 API 接口", apiUrl, JSONUtil.toJsonStr(emrVitalSignsRecord), method);
        try {
            String result = HttpClientUtils.sendHttpRequest(apiUrl, JSONUtil.toJsonStr(emrVitalSignsRecord), method);
            logger.info("->{},response:{}", "生命体征护理记录单数据操作 API 接口", result);
            SynchroResponseVo synchroResponseVo =  JSONObject.parseObject(result, new TypeReference<SynchroResponseVo>(){});
            log.setOutputParams(JSONUtil.toJsonStr(synchroResponseVo));
            if (synchroResponseVo.isResult()){
                log.setResult(Constants.API_STATUS_SUCCESS);
            }else {
                log.setResult(Constants.API_STATUS_FAIL);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.setResult(Constants.API_STATUS_FAIL);
        }
        if(isSaveLog){
            log.setAddTime(DateUtils.getNowDate());
            logSynchroApiMapper.insertSelective(log);
        }
    }

    private void init(){
        serviceUrl = sysConfigService.selectConfigByKey(Constants.CONFIG_XA_ERYE_HUB_SERVICE_URL);
        int saveLog = Integer.valueOf(sysConfigService.selectConfigByKey(Constants.CONFIG_XA_ERYE_SAVE_API_LOG));
        if (saveLog == Constants.SAVE_API_LOG_YES){
            isSaveLog = true;
        }
    }
}
