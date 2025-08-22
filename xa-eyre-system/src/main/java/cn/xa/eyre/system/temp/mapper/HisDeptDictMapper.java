package cn.xa.eyre.system.temp.mapper;

import cn.xa.eyre.system.temp.domain.HisDeptDict;

import java.util.List;

public interface HisDeptDictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HisDeptDict record);

    int insertSelective(HisDeptDict record);

    HisDeptDict selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HisDeptDict record);

    int updateByPrimaryKey(HisDeptDict record);

    List<HisDeptDict> selectAll();
}