package cn.xa.eyre.system.dict.mapper;

import cn.xa.eyre.system.dict.domain.DictDiseaseIcd10;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictDiseaseIcd10Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictDiseaseIcd10 record);

    int insertSelective(DictDiseaseIcd10 record);

    DictDiseaseIcd10 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictDiseaseIcd10 record);

    int updateByPrimaryKey(DictDiseaseIcd10 record);

    DictDiseaseIcd10 selectByEmrCode(@Param("emrCode") String emrCode);

    List<DictDiseaseIcd10> selectByEmrCodeList(@Param("diagCodes") String[] diagCodes);
}