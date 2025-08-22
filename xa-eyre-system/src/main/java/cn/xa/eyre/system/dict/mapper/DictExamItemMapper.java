package cn.xa.eyre.system.dict.mapper;

import cn.xa.eyre.system.dict.domain.DictExamItem;
import org.apache.ibatis.annotations.Param;

public interface DictExamItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictExamItem record);

    int insertSelective(DictExamItem record);

    DictExamItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictExamItem record);

    int updateByPrimaryKey(DictExamItem record);

    DictExamItem selectByEmrName(@Param("emrName") String emrName);
}