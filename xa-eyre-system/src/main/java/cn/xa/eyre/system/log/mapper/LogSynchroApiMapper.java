package cn.xa.eyre.system.log.mapper;

import cn.xa.eyre.system.log.domain.LogSynchroApi;
import cn.xa.eyre.system.log.domain.LogSynchroApiWithBLOBs;

public interface LogSynchroApiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogSynchroApiWithBLOBs record);

    int insertSelective(LogSynchroApiWithBLOBs record);

    LogSynchroApiWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogSynchroApiWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(LogSynchroApiWithBLOBs record);

    int updateByPrimaryKey(LogSynchroApi record);
}