package cn.xa.eyre.hisapi;

import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.core.domain.R;
import cn.xa.eyre.ordadm.domain.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@FeignClient(name = "ordadmService", url = Constants.HIS_URL)
public interface OrdadmFeignClient {


    @GetMapping("/ordadm/getDeathInfo")
    R<List<Orders>> getDeathInfo();
}
