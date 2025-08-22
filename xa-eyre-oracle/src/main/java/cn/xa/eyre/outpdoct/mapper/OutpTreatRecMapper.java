package cn.xa.eyre.outpdoct.mapper;

import cn.xa.eyre.outpdoct.domain.OutpTreatRec;
import cn.xa.eyre.outpdoct.domain.OutpTreatRecKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OutpTreatRecMapper {
    int deleteByPrimaryKey(OutpTreatRecKey key);

    int insert(OutpTreatRec record);

    int insertSelective(OutpTreatRec record);

    OutpTreatRec selectByPrimaryKey(OutpTreatRecKey key);

    int updateByPrimaryKeySelective(OutpTreatRec record);

    int updateByPrimaryKey(OutpTreatRec record);

    List<OutpTreatRec> selectOutpTreatRec(@Param("appointNo") String appointNo);
}