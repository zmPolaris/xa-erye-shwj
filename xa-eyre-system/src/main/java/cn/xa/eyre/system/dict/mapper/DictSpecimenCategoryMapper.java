package cn.xa.eyre.system.dict.mapper;

import cn.xa.eyre.system.dict.domain.DictSpecimenCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictSpecimenCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictSpecimenCategory record);

    int insertSelective(DictSpecimenCategory record);

    DictSpecimenCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictSpecimenCategory record);

    int updateByPrimaryKey(DictSpecimenCategory record);

    List<DictSpecimenCategory> selectAll();

    DictSpecimenCategory selectByEmrName(@Param("emrName") String emrName);
}