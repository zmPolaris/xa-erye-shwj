package cn.xa.eyre.outpdoct.controller;

import cn.xa.eyre.common.core.domain.AjaxResult;
import cn.xa.eyre.medrec.domain.OutpMrYbKey;
import cn.xa.eyre.outpdoct.domain.OutpMr;
import cn.xa.eyre.outpdoct.domain.OutpWaitQueue;
import cn.xa.eyre.outpdoct.domain.OutpWaitQueueKey;
import cn.xa.eyre.outpdoct.mapper.OutpMrMapper;
import cn.xa.eyre.outpdoct.mapper.OutpTreatRecMapper;
import cn.xa.eyre.outpdoct.mapper.OutpWaitQueueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outpdoct")
public class OutpdoctController {

    @Autowired
    private OutpMrMapper outpMrMapper;
    @Autowired
    private OutpWaitQueueMapper outpWaitQueueMapper;
    @Autowired
    private OutpTreatRecMapper outpTreatRecMapper;

    @GetMapping("/getOutpMrList")
    public AjaxResult getOutpMrList(@RequestParam("num") Integer num){
        return AjaxResult.success("接口调用成功", outpMrMapper.selectOutpMrList(num));
    }

    @PostMapping("/getOutpMrByCondition")
    public AjaxResult getOutpMrByCondition(@RequestBody OutpMr outpMr){
        return AjaxResult.success("接口调用成功", outpMrMapper.selectOutpMrByCondition(outpMr));
    }

    @PostMapping("/getOutpWaitQueueByCondition")
    public AjaxResult getOutpWaitQueueByCondition(@RequestBody OutpWaitQueue outpWaitQueue){
        List<OutpWaitQueue> outpWaitQueues = outpWaitQueueMapper.selectOutpWaitQueueByCondition(outpWaitQueue);
        return AjaxResult.success("接口调用成功", outpWaitQueues.isEmpty() ? null : outpWaitQueues.get(0));
    }

    @GetMapping("/getOutpTreatRec")
    public AjaxResult getOutpTreatRec(@RequestParam("appointNo") String appointNo){
        return AjaxResult.success("接口调用成功", outpTreatRecMapper.selectOutpTreatRec(appointNo).get(0));
    }
}
