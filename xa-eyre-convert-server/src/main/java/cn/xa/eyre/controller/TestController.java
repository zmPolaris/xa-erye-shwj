package cn.xa.eyre.controller;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.xa.eyre.common.core.domain.AjaxResult;
import cn.xa.eyre.common.core.domain.R;
import cn.xa.eyre.common.utils.DateUtils;
import cn.xa.eyre.hisapi.MedrecFeignClient;
import cn.xa.eyre.medrec.domain.PatMasterIndex;
import cn.xa.eyre.system.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ISysConfigService sysConfigService;
    @Autowired
    private MedrecFeignClient medrecFeignClient;

    @PostMapping("/getCofig")
    public AjaxResult getCofig(){
        return AjaxResult.success("测试成功", sysConfigService.selectConfigByKey("snca.ycpc.ca.message.templateId"));
    }

    @GetMapping("/getPatMasterIndex/{patientId}")
    public R<PatMasterIndex> getPatMasterIndex(@PathVariable("patientId") String patientId){
        return medrecFeignClient.getPatMasterIndex(patientId);
    }

    public static void main(String[] args) {
//        System.out.println(DigestUtil.md5Hex("2025/8/12" + 2958 +1));
//        System.out.println(DigestUtil.md5Hex("0097028874" + 2958));
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        System.out.println(IdUtil.getSnowflake(1, 1).nextId());
        System.out.println(snowflake.nextId());
        System.out.println(snowflake.nextId());
        System.out.println(snowflake.nextId());
        System.out.println(snowflake.nextId());
        System.out.println(snowflake.nextId());
    }
}
