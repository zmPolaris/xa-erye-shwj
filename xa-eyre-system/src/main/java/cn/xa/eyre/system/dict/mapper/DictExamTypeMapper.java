package cn.xa.eyre.system.dict.mapper;

import cn.xa.eyre.system.dict.domain.DictExamType;
import org.apache.ibatis.annotations.Param;

public interface DictExamTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictExamType record);

    int insertSelective(DictExamType record);

    DictExamType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictExamType record);

    int updateByPrimaryKey(DictExamType record);

    DictExamType selectByEmrName(@Param("emrName") String emrName);
}