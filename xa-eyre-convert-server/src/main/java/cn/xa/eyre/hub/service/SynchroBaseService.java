package cn.xa.eyre.hub.service;

import cn.hutool.json.JSONUtil;
import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.utils.DateUtils;
import cn.xa.eyre.common.utils.http.HttpClientUtils;
import cn.xa.eyre.hub.domain.SynchroResponseVo;
import cn.xa.eyre.hub.domain.base.BaseDept;
import cn.xa.eyre.hub.domain.base.BaseUser;
import cn.xa.eyre.hub.staticvalue.SyncApiStaticValue;
import cn.xa.eyre.system.log.domain.LogSynchroApi;
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
 * 基础表同步
 */
@Service
public class SynchroBaseService {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ISysConfigService sysConfigService;
    @Autowired
    private LogSynchroApiMapper logSynchroApiMapper;
    private String serviceUrl;
    private boolean isSaveLog = false;

    /**
     * 医院信息系统用户信息表数据操作 API 接口
     * @param baseUser
     * @param method
     * @return
     */
    public void syncBaseUser(BaseUser baseUser, String method){
        init();
        String apiUrl = serviceUrl + SyncApiStaticValue.API_BASE_USER;
        LogSynchroApiWithBLOBs log = new LogSynchroApiWithBLOBs();
        log.setUrl(apiUrl);
        log.setMethodName(method);
        log.setInputParams(JSONUtil.toJsonStr(baseUser));
        logger.info("->{},url:{},request:{},method:{}", "医院信息系统用户信息表数据操作 API 接口", apiUrl, JSONUtil.toJsonStr(baseUser), method);
        try {
            String result = HttpClientUtils.sendHttpRequest(apiUrl, JSONUtil.toJsonStr(baseUser), method);
            logger.info("->{},response:{}", "医院信息系统用户信息表数据操作 API 接口", result);
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
     * 医院信息系统科室信息数据操作 API 接口
     * @param baseDept
     * @param method
     * @return
     */
    public void syncBaseDept(BaseDept baseDept, String method){
        init();
        String apiUrl = serviceUrl + SyncApiStaticValue.API_BASE_DEPT;
        LogSynchroApiWithBLOBs log = new LogSynchroApiWithBLOBs();
        log.setUrl(apiUrl);
        log.setMethodName(method);
        log.setInputParams(JSONUtil.toJsonStr(baseDept));
        logger.info("->{},url:{},request:{},method:{}", "医院信息系统科室信息数据操作 API 接口", apiUrl, JSONUtil.toJsonStr(baseDept), method);
        try {
            String result = HttpClientUtils.sendHttpRequest(apiUrl, JSONUtil.toJsonStr(baseDept), method);
            logger.info("->{},response:{}", "医院信息系统科室信息数据操作 API 接口", result);
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
