package cn.xa.eyre.outpadm.mapper;

import cn.xa.eyre.outpadm.domain.ClinicIndex;

public interface ClinicIndexMapper {
    int deleteByPrimaryKey(String clinicLabel);

    int insert(ClinicIndex record);

    int insertSelective(ClinicIndex record);

    ClinicIndex selectByPrimaryKey(String clinicLabel);

    int updateByPrimaryKeySelective(ClinicIndex record);

    int updateByPrimaryKey(ClinicIndex record);
}