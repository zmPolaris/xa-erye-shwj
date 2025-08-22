package cn.xa.eyre.hub.service;

import cn.xa.eyre.system.log.domain.LogSynchroApi;
import cn.xa.eyre.system.log.mapper.LogSynchroApiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogSynchroApiService {
    @Autowired
    private LogSynchroApiMapper logSynchroApiMapper;

    public void saveLog(LogSynchroApi logSynchroApi){
//        LogSynchroApi logSynchroApi = new LogSynchroApi();

    }
}
