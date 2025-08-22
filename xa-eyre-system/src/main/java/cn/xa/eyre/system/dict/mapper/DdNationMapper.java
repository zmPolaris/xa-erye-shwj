package cn.xa.eyre.system.dict.mapper;

import cn.xa.eyre.system.dict.domain.DdNation;

public interface DdNationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DdNation record);

    int insertSelective(DdNation record);

    DdNation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DdNation record);

    int updateByPrimaryKey(DdNation record);

    DdNation selectByName(String nation);
}