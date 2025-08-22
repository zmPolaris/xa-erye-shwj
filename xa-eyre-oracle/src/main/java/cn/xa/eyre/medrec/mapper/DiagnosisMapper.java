package cn.xa.eyre.medrec.mapper;

import cn.xa.eyre.medrec.domain.Diagnosis;
import cn.xa.eyre.medrec.domain.DiagnosisKey;

public interface DiagnosisMapper {
    int deleteByPrimaryKey(DiagnosisKey key);

    int insert(Diagnosis record);

    int insertSelective(Diagnosis record);

    Diagnosis selectByPrimaryKey(DiagnosisKey key);

    int updateByPrimaryKeySelective(Diagnosis record);

    int updateByPrimaryKey(Diagnosis record);
}