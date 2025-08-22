package cn.xa.eyre.system.dict.mapper;

import cn.xa.eyre.system.dict.domain.DictDisActivityType;

public interface DictDisActivityTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictDisActivityType record);

    int insertSelective(DictDisActivityType record);

    DictDisActivityType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictDisActivityType record);

    int updateByPrimaryKey(DictDisActivityType record);
}