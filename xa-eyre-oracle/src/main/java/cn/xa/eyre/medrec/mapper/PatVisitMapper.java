package cn.xa.eyre.medrec.mapper;

import cn.xa.eyre.medrec.domain.PatVisit;
import cn.xa.eyre.medrec.domain.PatVisitKey;

public interface PatVisitMapper {
    int deleteByPrimaryKey(PatVisitKey key);

    int insert(PatVisit record);

    int insertSelective(PatVisit record);

    PatVisit selectByPrimaryKey(PatVisitKey key);

    int updateByPrimaryKeySelective(PatVisit record);

    int updateByPrimaryKey(PatVisit record);
}