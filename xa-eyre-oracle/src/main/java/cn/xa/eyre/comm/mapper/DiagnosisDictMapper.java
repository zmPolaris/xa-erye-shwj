package cn.xa.eyre.comm.mapper;

import cn.xa.eyre.comm.domain.DiagnosisDict;
import cn.xa.eyre.comm.domain.DiagnosisDictKey;

public interface DiagnosisDictMapper {
    int deleteByPrimaryKey(DiagnosisDictKey key);

    int insert(DiagnosisDict record);

    int insertSelective(DiagnosisDict record);

    DiagnosisDict selectByPrimaryKey(DiagnosisDictKey key);

    int updateByPrimaryKeySelective(DiagnosisDict record);

    int updateByPrimaryKey(DiagnosisDict record);
}