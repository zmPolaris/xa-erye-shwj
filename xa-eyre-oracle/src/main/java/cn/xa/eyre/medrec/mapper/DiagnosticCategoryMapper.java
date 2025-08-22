package cn.xa.eyre.medrec.mapper;

import cn.xa.eyre.medrec.domain.DiagnosticCategory;
import cn.xa.eyre.medrec.domain.DiagnosticCategoryKey;

public interface DiagnosticCategoryMapper {
    int deleteByPrimaryKey(DiagnosticCategoryKey key);

    int insert(DiagnosticCategory record);

    int insertSelective(DiagnosticCategory record);

    DiagnosticCategory selectByPrimaryKey(DiagnosticCategoryKey key);

    int updateByPrimaryKeySelective(DiagnosticCategory record);

    int updateByPrimaryKey(DiagnosticCategory record);
}