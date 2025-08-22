package cn.xa.eyre.system.dict.mapper;

import cn.xa.eyre.system.dict.domain.DictMarryState;

public interface DictMarryStateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictMarryState record);

    int insertSelective(DictMarryState record);

    DictMarryState selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictMarryState record);

    int updateByPrimaryKey(DictMarryState record);
}