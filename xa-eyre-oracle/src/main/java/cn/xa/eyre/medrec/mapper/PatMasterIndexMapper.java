package cn.xa.eyre.medrec.mapper;

import cn.xa.eyre.medrec.domain.PatMasterIndex;

public interface PatMasterIndexMapper {
    int deleteByPrimaryKey(String patientId);

    int insert(PatMasterIndex record);

    int insertSelective(PatMasterIndex record);

    PatMasterIndex selectByPrimaryKey(String patientId);

    int updateByPrimaryKeySelective(PatMasterIndex record);

    int updateByPrimaryKey(PatMasterIndex record);
}