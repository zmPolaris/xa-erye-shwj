package cn.xa.eyre.hisapi;

import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.core.domain.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
@FeignClient(name = "inpbillService", url = Constants.HIS_URL)
public interface InpbillFeignClient {

    @PostMapping("/inpbill/getCPAPInfo")
    public R<List<String>> getCPAPInfo();
}
