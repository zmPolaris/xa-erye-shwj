package cn.xa.eyre.hisapi;


import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.core.domain.R;
import cn.xa.eyre.inpadm.domain.PatsInHospital;
import cn.xa.eyre.outpadm.domain.ClinicMaster;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "inpadmService", url = Constants.HIS_URL)
public interface InpadmFeignClient {

    @GetMapping("/inpadm/getPatsInHospital")
    public R<PatsInHospital> getPatsInHospital(@RequestParam("patientId") String patientId, @RequestParam("visitId") Short visitId);

    @GetMapping("/inpadm/selectPatsInHospitalByPatientId")
    public R<PatsInHospital> getPatsInHospitalByPatientId(@RequestParam("patientId") String patientId);
}
