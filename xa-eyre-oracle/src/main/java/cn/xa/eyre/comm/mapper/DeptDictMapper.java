package cn.xa.eyre.comm.mapper;

import cn.xa.eyre.comm.domain.DeptDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptDictMapper {
    int deleteByPrimaryKey(String deptCode);

    int insert(DeptDict record);

    int insertSelective(DeptDict record);

    DeptDict selectByPrimaryKey(String deptCode);

    int updateByPrimaryKeySelective(DeptDict record);

    int updateByPrimaryKey(DeptDict record);

    List<DeptDict> selectDeptList(@Param("num") Integer num);
}