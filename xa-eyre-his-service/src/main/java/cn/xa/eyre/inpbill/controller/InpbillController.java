package cn.xa.eyre.inpbill.controller;

import cn.xa.eyre.common.core.domain.AjaxResult;
import cn.xa.eyre.inpbill.service.InpbillService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/inpbill")
public class InpbillController {

    @Resource
    InpbillService inpbillService;

    @PostMapping("/getCPAPInfo")
    public AjaxResult getCPAPInfo(){
        return AjaxResult.success("接口调用成功", inpbillService.selectCPAPInfo());
    }
}
