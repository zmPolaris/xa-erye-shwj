package cn.xa.eyre.medrec.mapper;

import cn.xa.eyre.medrec.domain.Diagnosis;
import cn.xa.eyre.medrec.domain.DiagnosisKey;

import java.util.List;

public interface DiagnosisMapper {
    int deleteByPrimaryKey(DiagnosisKey key);

    int insert(Diagnosis record);

    int insertSelective(Diagnosis record);

    Diagnosis selectByPrimaryKey(DiagnosisKey key);

    int updateByPrimaryKeySelective(Diagnosis record);

    int updateByPrimaryKey(Diagnosis record);

    List<Diagnosis> selectByPartPrimaryKey(DiagnosisKey key);
}