package cn.xa.eyre.medrec.controller;

import cn.xa.eyre.common.core.domain.AjaxResult;
import cn.xa.eyre.common.core.domain.R;
import cn.xa.eyre.convertapi.ConvertFeignClient;
import cn.xa.eyre.medrec.domain.*;
import cn.xa.eyre.medrec.mapper.PatVisitMapper;
import cn.xa.eyre.medrec.service.MedrecService;
import cn.xa.eyre.pharmacy.domain.DrugPrescMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/medrec")
public class MedrecController {

    @Autowired
    private MedrecService medrecService;
    @Autowired
    private ConvertFeignClient convertFeignClient;

    @GetMapping("/getPatMasterIndex/{patientId}")
    public AjaxResult getPatMasterIndex(@PathVariable("patientId") String patientId){
        return AjaxResult.success("接口调用成功", medrecService.selectPatMasterIndex(patientId));
    }

    @GetMapping("/getPatMasterIndexList")
    public AjaxResult getPatMasterIndexList(@RequestParam("num") Integer num){
        return AjaxResult.success("接口调用成功", medrecService.selectPatMasterIndexList(num));
    }

    @PostMapping("/getDiagnosticCategory")
    public AjaxResult getDiagnosticCategory(@RequestBody DiagnosticCategoryKey diagnosticCategoryKey){
        return AjaxResult.success("接口调用成功", medrecService.selectDiagnosticCategory(diagnosticCategoryKey));
    }

    @PostMapping("/getDiagnosis")
    public AjaxResult getDiagnosis(@RequestBody DiagnosisKey diagnosisKey){
        return AjaxResult.success("接口调用成功", medrecService.selectDiagnosis(diagnosisKey));
    }

    @PostMapping("/getPatVisit")
    public AjaxResult getPatVisit(@RequestBody PatVisitKey patVisitKey){
        return AjaxResult.success("接口调用成功", medrecService.selectPatVisit(patVisitKey));
    }

    @PostMapping("/getCofig")
    public AjaxResult getCofig(){
        return convertFeignClient.getCofig();
    }

    @PostMapping("/getDrugPrescMaster")
    public AjaxResult getDrugPrescMaster(@RequestBody DrugPrescMaster drugPrescMaster){
        return AjaxResult.success("接口调用成功", medrecService.selectDrugPrescMaster(drugPrescMaster));
    };

    @PostMapping("/selectDrugPrescMasterByPatientId")
    public AjaxResult selectDrugPrescMasterByPatientId(@RequestBody DrugPrescMaster drugPrescMaster){
        return AjaxResult.success("接口调用成功", medrecService.selectDrugPrescMasterByPatientId(drugPrescMaster));
    };
}
