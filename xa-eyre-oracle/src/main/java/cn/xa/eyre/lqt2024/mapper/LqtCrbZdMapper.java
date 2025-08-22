package cn.xa.eyre.lqt2024.mapper;

import cn.xa.eyre.lqt2024.domain.LqtCrbZd;
import cn.xa.eyre.lqt2024.domain.LqtCrbZdKey;

public interface LqtCrbZdMapper {
    int deleteByPrimaryKey(LqtCrbZdKey key);

    int insert(LqtCrbZd record);

    int insertSelective(LqtCrbZd record);

    LqtCrbZd selectByPrimaryKey(LqtCrbZdKey key);

    int updateByPrimaryKeySelective(LqtCrbZd record);

    int updateByPrimaryKey(LqtCrbZd record);
}