package cn.xa.eyre.medrec.controller;

import cn.xa.eyre.common.core.domain.AjaxResult;
import cn.xa.eyre.common.core.domain.R;
import cn.xa.eyre.convertapi.ConvertFeignClient;
import cn.xa.eyre.framework.config.openfegin.CharsetUtil;
import cn.xa.eyre.medrec.domain.*;
import cn.xa.eyre.medrec.mapper.PatVisitMapper;
import cn.xa.eyre.medrec.service.MedrecService;
import cn.xa.eyre.pharmacy.domain.DrugPrescMaster;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/medrec")
public class MedrecController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MedrecService medrecService;
    @Autowired
    private ConvertFeignClient convertFeignClient;

    @GetMapping("/getPatMasterIndex/{patientId}")
    public AjaxResult getPatMasterIndex(@PathVariable("patientId") String patientId){
        return AjaxResult.success("接口调用成功", CharsetUtil.convertObject(medrecService.selectPatMasterIndex(patientId)));
    }

    @GetMapping("/getPatMasterIndexList")
    public AjaxResult getPatMasterIndexList(@RequestParam("num") Integer num){
        return AjaxResult.success("接口调用成功", CharsetUtil.convertObjectList(medrecService.selectPatMasterIndexList(num)));
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

    @PostMapping("/selectPatVisitDeathInfoList")
    public AjaxResult selectPatVisitDeathInfoList(){
        return AjaxResult.success("接口调用成功", medrecService.selectPatVisitDeathInfoList());
    };

    @PostMapping("/getTransfer")
    public AjaxResult getTransfer(){
        return AjaxResult.success("接口调用成功", medrecService.selectTransfer());
    }

    @PostMapping("/getCPAPDeptInfo")
    public AjaxResult getCPAPDeptInfo(@RequestBody List<String> cpapInfoList){
        return AjaxResult.success("接口调用成功", medrecService.getCPAPDeptInfo(cpapInfoList));
    }

    @PostMapping("/getDiagnosticDescCode")
    public AjaxResult getDiagnosticDescCode(@RequestBody String patientId){
        return AjaxResult.success("接口调用成功", medrecService.getDiagnosticDescCode(patientId));
    }

    @GetMapping("/getIdNo/{patientId}")
    public AjaxResult getIdNo(@PathVariable("patientId") String patientId){
        return AjaxResult.success("接口调用成功", medrecService.selectIdNo(patientId));
    }
}
