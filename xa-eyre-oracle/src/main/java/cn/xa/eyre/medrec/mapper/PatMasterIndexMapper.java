package cn.xa.eyre.medrec.mapper;

import cn.xa.eyre.medrec.domain.PatMasterIndex;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatMasterIndexMapper {
    int deleteByPrimaryKey(String patientId);

    int insert(PatMasterIndex record);

    int insertSelective(PatMasterIndex record);

    PatMasterIndex selectByPrimaryKey(String patientId);

    int updateByPrimaryKeySelective(PatMasterIndex record);

    int updateByPrimaryKey(PatMasterIndex record);

    List<PatMasterIndex> selectPatMasterIndexList(@Param("num") Integer num);
}