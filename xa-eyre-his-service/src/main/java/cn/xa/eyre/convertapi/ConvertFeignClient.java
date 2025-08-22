package cn.xa.eyre.convertapi;


import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.core.domain.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(name = "convertService", url = Constants.CONVERT_URL)
public interface ConvertFeignClient {

    @PostMapping("/test/getCofig")
    public AjaxResult getCofig();
}
