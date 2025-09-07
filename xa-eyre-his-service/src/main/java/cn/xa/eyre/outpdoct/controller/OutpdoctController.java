package cn.xa.eyre.outpdoct.controller;

import cn.xa.eyre.common.core.domain.AjaxResult;
import cn.xa.eyre.outpdoct.domain.OutpMr;
import cn.xa.eyre.outpdoct.mapper.OutpMrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outpdoct")
public class OutpdoctController {

    @Autowired
    private OutpMrMapper outpMrMapper;

    @GetMapping("/getOutpMrList")
    public AjaxResult getOutpMrList(@RequestParam("num") Integer num){
        return AjaxResult.success("接口调用成功", outpMrMapper.selectOutpMrList(num));
    }

    @PostMapping("/getOutpMrByCondition")
    public AjaxResult getOutpMrByCondition(@RequestBody OutpMr outpMr){
        return AjaxResult.success("接口调用成功", outpMrMapper.selectOutpMrByCondition(outpMr));
    }
}
