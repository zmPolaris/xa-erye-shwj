package cn.xa.eyre.system.dict.mapper;

import cn.xa.eyre.system.dict.domain.DatasetDiseaseData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DatasetDiseaseDataMapper {
    int insert(DatasetDiseaseData record);

    int insertSelective(DatasetDiseaseData record);

    List<DatasetDiseaseData> selectByCodes(String[] codes);

    List<String> selectDistinctIcd10();
}