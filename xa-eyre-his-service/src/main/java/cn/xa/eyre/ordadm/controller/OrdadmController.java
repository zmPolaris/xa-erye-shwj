package cn.xa.eyre.ordadm.controller;

import cn.xa.eyre.common.core.domain.AjaxResult;
import cn.xa.eyre.ordadm.mapper.OrdersMapper;
import cn.xa.eyre.outpadm.mapper.ClinicMasterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ordadm")
public class OrdadmController {

    @Autowired
    OrdersMapper ordersMapper;

    @GetMapping("/getICUAndAMVInfo")
    public AjaxResult getICUAndAMVInfo(){
        return AjaxResult.success("接口调用成功", ordersMapper.getICUAndAMVInfo());
    }
}
