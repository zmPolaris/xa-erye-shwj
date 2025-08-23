package cn.xa.eyre.hisapi;


import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.core.domain.R;
import cn.xa.eyre.outpadm.domain.ClinicMaster;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "outpadmService", url = Constants.HIS_URL)
public interface OutpadmFeignClient {

    @GetMapping("/outpadm/getClinicMaster")
    public R<ClinicMaster> getClinicMaster(@RequestParam("patientId") String patientId, @RequestParam("serialNo") Short serialNo, @RequestParam("visitDate") String visitDate);
}
