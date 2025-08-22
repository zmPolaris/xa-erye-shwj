package cn.xa.eyre.medrec.mapper;

import cn.xa.eyre.medrec.domain.MrIndex;
import cn.xa.eyre.medrec.domain.MrIndexKey;

public interface MrIndexMapper {
    int deleteByPrimaryKey(MrIndexKey key);

    int insert(MrIndex record);

    int insertSelective(MrIndex record);

    MrIndex selectByPrimaryKey(MrIndexKey key);

    int updateByPrimaryKeySelective(MrIndex record);

    int updateByPrimaryKey(MrIndex record);
}