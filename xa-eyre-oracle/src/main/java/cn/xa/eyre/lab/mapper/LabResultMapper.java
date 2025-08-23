package cn.xa.eyre.lab.mapper;

import cn.xa.eyre.lab.domain.LabResult;
import cn.xa.eyre.lab.domain.LabResultKey;

public interface LabResultMapper {
    int deleteByPrimaryKey(LabResultKey key);

    int insert(LabResult record);

    int insertSelective(LabResult record);

    LabResult selectByPrimaryKey(LabResultKey key);

    int updateByPrimaryKeySelective(LabResult record);

    int updateByPrimaryKey(LabResult record);
}