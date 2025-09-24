package cn.xa.eyre.inpadm.controller;

import cn.xa.eyre.common.core.domain.AjaxResult;
import cn.xa.eyre.framework.config.openfegin.CharsetUtil;
import cn.xa.eyre.inpadm.mapper.PatsInHospitalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/inpadm")
public class InpadmController {

    @Autowired
    private PatsInHospitalMapper patsInHospitalMapper;

    @GetMapping("/getPatsInHospital")
    public AjaxResult getPatsInHospital(@RequestParam("patientId") String patientId, @RequestParam("visitId") Short visitId){
        Map<String, Object> params = new HashMap<>();
        params.put("patientId", patientId);
        params.put("visitId", visitId);
        return AjaxResult.success("接口调用成功", CharsetUtil.convertObject(patsInHospitalMapper.selectPatsInHospital(params)));
    }

    @GetMapping("/selectPatsInHospitalByPatientId")
    public AjaxResult getPatsInHospital(@RequestParam("patientId") String patientId){
        return AjaxResult.success("接口调用成功", CharsetUtil.convertObject(patsInHospitalMapper.selectByPrimaryKey(patientId)));
    }

}
