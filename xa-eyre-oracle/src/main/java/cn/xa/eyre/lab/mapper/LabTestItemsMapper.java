package cn.xa.eyre.lab.mapper;

import cn.xa.eyre.lab.domain.LabTestItems;
import cn.xa.eyre.lab.domain.LabTestItemsKey;

public interface LabTestItemsMapper {
    int deleteByPrimaryKey(LabTestItemsKey key);

    int insert(LabTestItems record);

    int insertSelective(LabTestItems record);

    LabTestItems selectByPrimaryKey(LabTestItemsKey key);

    int updateByPrimaryKeySelective(LabTestItems record);

    int updateByPrimaryKey(LabTestItems record);
}