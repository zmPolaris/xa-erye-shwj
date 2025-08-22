package cn.xa.eyre.lab.mapper;

import cn.xa.eyre.lab.domain.LabResult;
import cn.xa.eyre.lab.domain.LabResultKey;
import cn.xa.eyre.lab.domain.LabResultVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LabResultMapper {
    int deleteByPrimaryKey(LabResultKey key);

    int insert(LabResult record);

    int insertSelective(LabResult record);

    LabResult selectByPrimaryKey(LabResultKey key);

    int updateByPrimaryKeySelective(LabResult record);

    int updateByPrimaryKey(LabResult record);

    List<LabResultVo> selectResultItemsByTestNo(@Param("testNo") String testNo);
}