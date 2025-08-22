package cn.xa.eyre.pharmacy.mapper;

import cn.xa.eyre.pharmacy.domain.DrugPrescMaster;
import org.apache.ibatis.annotations.Param;

public interface DrugPrescMasterMapper {
    int insert(DrugPrescMaster record);

    int insertSelective(DrugPrescMaster record);

    DrugPrescMaster selectDrugByPrescNoAndPrescDate(Short prescNo, String prescDateStr);

    DrugPrescMaster selectDrugByPrescNoAndPatientId(@Param("prescNo") Short prescNo, @Param("patientId") String patientId);
}