package cn.xa.eyre.lab.mapper;

import cn.xa.eyre.lab.domain.LabTestMaster;

public interface LabTestMasterMapper {
    int deleteByPrimaryKey(String testNo);

    int insert(LabTestMaster record);

    int insertSelective(LabTestMaster record);

    LabTestMaster selectByPrimaryKey(String testNo);

    int updateByPrimaryKeySelective(LabTestMaster record);

    int updateByPrimaryKey(LabTestMaster record);
}