package cn.xa.eyre.outpdoct.mapper;

import cn.xa.eyre.outpdoct.domain.OutpWaitQueue;
import cn.xa.eyre.outpdoct.domain.OutpWaitQueueKey;

import java.util.List;

public interface OutpWaitQueueMapper {
    int deleteByPrimaryKey(OutpWaitQueueKey key);

    int insert(OutpWaitQueue record);

    int insertSelective(OutpWaitQueue record);

    OutpWaitQueue selectByPrimaryKey(OutpWaitQueueKey key);

    int updateByPrimaryKeySelective(OutpWaitQueue record);

    int updateByPrimaryKey(OutpWaitQueue record);

    List<OutpWaitQueue> selectOutpWaitQueueByCondition(OutpWaitQueue outpWaitQueue);
}