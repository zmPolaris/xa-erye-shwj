package cn.xa.eyre.hisapi;


import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.core.domain.R;
import cn.xa.eyre.outpdoct.domain.OutpMr;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(name = "outdoctService", url = Constants.HIS_URL)
public interface OutpdoctFeignClient {

    @GetMapping("/outpdoct/getOutpMrList")
    public R<List<OutpMr>> getOutpMrList(@RequestParam("num") Integer num);

    @PostMapping("/outpdoct/getOutpMrByCondition")
    public R<List<OutpMr>> getOutpMrByCondition(@RequestBody OutpMr outpMr);

}
