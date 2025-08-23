package cn.xa.eyre.comm.mapper;

import cn.xa.eyre.comm.domain.DiagnosisDict;

public interface DiagnosisDictMapper {
    int insert(DiagnosisDict record);

    int insertSelective(DiagnosisDict record);
}