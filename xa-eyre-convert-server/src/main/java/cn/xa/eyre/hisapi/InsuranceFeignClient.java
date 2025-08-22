package cn.xa.eyre.hisapi;


import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.core.domain.R;
import cn.xa.eyre.insurance.domain.GysybIcd10;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@FeignClient(name = "insuranceService", url = Constants.HIS_URL)
public interface InsuranceFeignClient {

    @GetMapping("/insurance/getGysybIcd10List")
    public R<List<GysybIcd10>> getGysybIcd10List();
}
