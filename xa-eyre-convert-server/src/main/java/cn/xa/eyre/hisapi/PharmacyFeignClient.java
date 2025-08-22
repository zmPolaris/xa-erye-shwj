package cn.xa.eyre.hisapi;


import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.core.domain.R;
import cn.xa.eyre.outpdoct.domain.OutpMr;
import cn.xa.eyre.outpdoct.domain.OutpWaitQueue;
import cn.xa.eyre.pharmacy.domain.DrugPrescDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(name = "pharmacyService", url = Constants.HIS_URL)
public interface PharmacyFeignClient {

    @PostMapping("/pharmacy/getDrugPrescDetailByVisitInfo")
    public R<List<DrugPrescDetail>> getDrugPrescDetailByVisitInfo(@RequestBody DrugPrescDetail drugPrescDetail);

    @PostMapping("/pharmacy/getDrugPrescDetailByPrescNo")
    public R<List<DrugPrescDetail>> getDrugPrescDetailByPrescNo(@RequestBody DrugPrescDetail drugPrescDetail);
}
