package cn.xa.eyre.system.dict.mapper;

import cn.xa.eyre.system.dict.domain.DictTreatResult;
import org.apache.ibatis.annotations.Param;

public interface DictTreatResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictTreatResult record);

    int insertSelective(DictTreatResult record);

    DictTreatResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictTreatResult record);

    int updateByPrimaryKey(DictTreatResult record);

    DictTreatResult selectByEmrName(@Param("emrName") String emrName);
}