package cn.xa.eyre.outpdoct.mapper;

import cn.xa.eyre.outpdoct.domain.OutpMr;
import cn.xa.eyre.outpdoct.domain.OutpMrKey;

public interface OutpMrMapper {
    int deleteByPrimaryKey(OutpMrKey key);

    int insert(OutpMr record);

    int insertSelective(OutpMr record);

    OutpMr selectByPrimaryKey(OutpMrKey key);

    int updateByPrimaryKeySelective(OutpMr record);

    int updateByPrimaryKey(OutpMr record);
}