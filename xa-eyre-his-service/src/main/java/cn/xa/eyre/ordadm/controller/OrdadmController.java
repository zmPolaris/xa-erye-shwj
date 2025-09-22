package cn.xa.eyre.ordadm.controller;

import cn.xa.eyre.common.core.domain.AjaxResult;
import cn.xa.eyre.framework.config.openfegin.CharsetUtil;
import cn.xa.eyre.ordadm.mapper.OrdersMapper;
import cn.xa.eyre.outpadm.mapper.ClinicMasterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ordadm")
public class OrdadmController {

    @Resource
    OrdersMapper ordersMapper;

    @GetMapping("/getDeathInfo")
    public AjaxResult getDeathInfo(){
        return AjaxResult.success("接口调用成功", CharsetUtil.convertObjectList(ordersMapper.getDeathInfo()));
    }
}
