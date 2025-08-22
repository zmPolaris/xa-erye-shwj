package cn.xa.eyre.pharmacy.controller;

import cn.xa.eyre.common.core.domain.AjaxResult;
import cn.xa.eyre.pharmacy.domain.DrugPrescDetail;
import cn.xa.eyre.pharmacy.mapper.DrugPrescDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pharmacy")
public class PharmacyController {

    @Autowired
    private DrugPrescDetailMapper drugPrescDetailMapper;

    @PostMapping("/getDrugPrescDetailByVisitInfo")
    public AjaxResult getDrugPrescDetailByVisitInfo(@RequestBody DrugPrescDetail drugPrescDetail) {
        return AjaxResult.success("接口调用成功", drugPrescDetailMapper.getDrugPrescDetailByVisitInfo(drugPrescDetail));
    }

    @PostMapping("/getDrugPrescDetailByPrescNo")
    public AjaxResult getDrugPrescDetailByPrescNo(@RequestBody DrugPrescDetail drugPrescDetail) {
        return AjaxResult.success("接口调用成功", drugPrescDetailMapper.getDrugPrescDetailByVisitInfo(drugPrescDetail));
    }
}
