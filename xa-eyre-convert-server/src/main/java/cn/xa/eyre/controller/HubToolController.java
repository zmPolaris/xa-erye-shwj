package cn.xa.eyre.controller;

import cn.xa.eyre.common.core.domain.AjaxResult;
import cn.xa.eyre.service.HubToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/synchro")
public class HubToolController {

    @Autowired
    private HubToolService hubToolService;

    @PostMapping("/user")
    public AjaxResult user(@RequestParam Integer num){
        return AjaxResult.success("同步成功", hubToolService.synchroUser(num));
    }

    @PostMapping("/dept")
    public AjaxResult dept(Integer num){
        return AjaxResult.success("同步成功", hubToolService.synchroDept(num));
    }

    @PostMapping("/patient")
    public AjaxResult patient(@RequestParam Integer num){
        return AjaxResult.success("同步成功", hubToolService.synchroPatient(num));
    }

    @PostMapping("/activity")
    public AjaxResult activity(@RequestParam Integer num){
        return AjaxResult.success("同步成功", hubToolService.synchroActivity(num));
    }

}
