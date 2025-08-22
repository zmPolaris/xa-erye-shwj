package cn.xa.eyre.insurance.mapper;

import cn.xa.eyre.insurance.domain.GysybIcd10;

import java.util.List;

public interface GysybIcd10Mapper {
    int insert(GysybIcd10 record);

    int insertSelective(GysybIcd10 record);

    List<GysybIcd10> selectList();
}