package cn.xa.eyre.inpadm.mapper;

import cn.xa.eyre.inpadm.domain.PatsInHospital;

public interface PatsInHospitalMapper {
    int deleteByPrimaryKey(String patientId);

    int insert(PatsInHospital record);

    int insertSelective(PatsInHospital record);

    PatsInHospital selectByPrimaryKey(String patientId);

    int updateByPrimaryKeySelective(PatsInHospital record);

    int updateByPrimaryKey(PatsInHospital record);
}