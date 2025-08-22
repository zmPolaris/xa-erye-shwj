package cn.xa.eyre.outpdoct.mapper;

import cn.xa.eyre.outpdoct.domain.OutpMr;
import cn.xa.eyre.outpdoct.domain.OutpMrKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OutpMrMapper {
    int deleteByPrimaryKey(OutpMrKey key);

    int insert(OutpMr record);

    int insertSelective(OutpMr record);

    OutpMr selectByPrimaryKey(OutpMrKey key);

    int updateByPrimaryKeySelective(OutpMr record);

    int updateByPrimaryKey(OutpMr record);

    List<OutpMr> selectOutpMrList(@Param("num") Integer num);

    List<OutpMr> selectOutpMrByCondition(OutpMr outpMr);
}