package cn.xa.eyre.system.dict.mapper;

import cn.xa.eyre.system.dict.domain.DictPeopleCategory;

public interface DictPeopleCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictPeopleCategory record);

    int insertSelective(DictPeopleCategory record);

    DictPeopleCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictPeopleCategory record);

    int updateByPrimaryKey(DictPeopleCategory record);
}