package cn.xa.eyre.system.dict.mapper;

import cn.xa.eyre.system.dict.domain.DdExQuantification;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DdExQuantificationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DdExQuantification record);

    int insertSelective(DdExQuantification record);

    DdExQuantification selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DdExQuantification record);

    int updateByPrimaryKey(DdExQuantification record);

    DdExQuantification selectByName(@Param("name") String name);

    List<DdExQuantification> selectAll();
}