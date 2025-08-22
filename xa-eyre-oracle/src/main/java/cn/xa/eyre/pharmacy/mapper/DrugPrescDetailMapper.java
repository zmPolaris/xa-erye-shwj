package cn.xa.eyre.pharmacy.mapper;

import cn.xa.eyre.pharmacy.domain.DrugPrescDetail;

import java.util.List;

public interface DrugPrescDetailMapper {
    int insert(DrugPrescDetail record);

    int insertSelective(DrugPrescDetail record);

    List<DrugPrescDetail> getDrugPrescDetailByVisitInfo(DrugPrescDetail drugPrescDetail);

    List<DrugPrescDetail> getDrugPrescDetailByPrescNo(DrugPrescDetail drugPrescDetail);
}