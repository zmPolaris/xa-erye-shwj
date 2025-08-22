package cn.xa.eyre.system.dict.mapper;

import cn.xa.eyre.system.dict.domain.DictChargeType;
import org.apache.ibatis.annotations.Param;

public interface DictChargeTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictChargeType record);

    int insertSelective(DictChargeType record);

    DictChargeType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictChargeType record);

    int updateByPrimaryKey(DictChargeType record);

    DictChargeType selectByEmrCode(@Param("emrCode") String emrCode);
}