package cn.xa.eyre.hisapi;


import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.core.domain.R;
import cn.xa.eyre.medrec.domain.*;
import cn.xa.eyre.pharmacy.domain.DrugPrescMaster;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(name = "medrecService", url = Constants.HIS_URL)
public interface MedrecFeignClient {

    @GetMapping("/medrec/getPatMasterIndex/{patientId}")
    public R<PatMasterIndex> getPatMasterIndex(@PathVariable("patientId") String patientId);

    @GetMapping("/medrec/getPatMasterIndexList")
    public R<List<PatMasterIndex>> getPatMasterIndexList(@RequestParam("num") Integer num);

    @PostMapping("/medrec/getDiagnosticCategory")
    public R<DiagnosticCategory> getDiagnosticCategory(@RequestBody DiagnosticCategoryKey diagnosticCategoryKey);

    @PostMapping("/medrec/getDiagnosis")
    public R<Diagnosis> getDiagnosis(@RequestBody DiagnosisKey diagnosisKey);

    @PostMapping("/medrec/getOutpMrYb")
    public R<OutpMrYb> getOutpMrYb(@RequestBody OutpMrYb outpMrYb);

    @PostMapping("/medrec/getPatVisit")
    public R<PatVisit> getPatVisit(@RequestBody PatVisitKey patVisitKey);

    @PostMapping("/medrec/getDrugPrescMaster")
    public R<DrugPrescMaster> getDrugPrescMaster(@RequestBody DrugPrescMaster drugPrescMaster);

    @PostMapping("/medrec/selectDrugPrescMasterByPatientId")
    public R<DrugPrescMaster> selectDrugPrescMasterByPatientId(@RequestBody DrugPrescMaster drugPrescMaster);
}
