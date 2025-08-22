package cn.xa.eyre.system.dict.mapper;

import cn.xa.eyre.system.dict.domain.DictDrugType;

public interface DictDrugTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictDrugType record);

    int insertSelective(DictDrugType record);

    DictDrugType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictDrugType record);

    int updateByPrimaryKey(DictDrugType record);

    DictDrugType selectByEmrCode(String emrCode);

}