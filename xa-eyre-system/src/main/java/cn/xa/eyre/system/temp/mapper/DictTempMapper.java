package cn.xa.eyre.system.temp.mapper;

import cn.xa.eyre.system.temp.domain.DictTemp;

import java.util.List;

public interface DictTempMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictTemp record);

    int insertSelective(DictTemp record);

    DictTemp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictTemp record);

    int updateByPrimaryKey(DictTemp record);

    List<DictTemp> selectAll();
}