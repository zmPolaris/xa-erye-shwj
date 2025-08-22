package cn.xa.eyre.insurance.controller;

import cn.xa.eyre.common.core.domain.AjaxResult;
import cn.xa.eyre.insurance.mapper.GysybIcd10Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    private GysybIcd10Mapper gysybIcd10Mapper;

    @GetMapping("/getGysybIcd10List")
    public AjaxResult getGysybIcd10List(){
        return AjaxResult.success("接口调用成功", gysybIcd10Mapper.selectList());
    }
}
