package cn.xa.eyre.lab.controller;

import cn.xa.eyre.common.core.domain.AjaxResult;
import cn.xa.eyre.lab.domain.LabTestItemsKey;
import cn.xa.eyre.lab.mapper.LabResultMapper;
import cn.xa.eyre.lab.mapper.LabTestItemsMapper;
import cn.xa.eyre.lab.mapper.LabTestMasterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lab")
public class LabController {

    @Autowired
    private LabTestMasterMapper labTestMasterMapper;
    @Autowired
    private LabTestItemsMapper labTestItemsMapper;
    @Autowired
    private LabResultMapper labResultMapper;

    @GetMapping("/getLabTestMaster/{testNo}")
    public AjaxResult getLabTestMaster(@PathVariable("testNo") String testNo){
        return AjaxResult.success("接口调用成功", labTestMasterMapper.selectByPrimaryKey(testNo));
    }

    @PostMapping("/getLabTestItems")
    public AjaxResult getLabTestMaster(@RequestBody LabTestItemsKey labTestItemsKey){
        return AjaxResult.success("接口调用成功", labTestItemsMapper.selectByPrimaryKey(labTestItemsKey));
    }

    @GetMapping("/getResultItemsByTestNo/{testNo}")
    public AjaxResult getResultItemsByTestNo(@PathVariable("testNo") String testNo){
        return AjaxResult.success("接口调用成功", labResultMapper.selectResultItemsByTestNo(testNo));
    }
}
