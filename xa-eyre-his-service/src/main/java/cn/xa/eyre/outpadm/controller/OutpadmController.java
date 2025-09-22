package cn.xa.eyre.outpadm.controller;

import cn.xa.eyre.common.core.domain.AjaxResult;
import cn.xa.eyre.framework.config.openfegin.CharsetUtil;
import cn.xa.eyre.outpadm.mapper.ClinicMasterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/outpadm")
public class OutpadmController {

    @Autowired
    private ClinicMasterMapper clinicMasterMapper;

    @GetMapping("/getClinicMaster")
    public AjaxResult getClinicMaster(@RequestParam("patientId") String patientId, @RequestParam("serialNo") Short serialNo, @RequestParam("visitDate") String visitDate){
        Map<String, Object> params = new HashMap<>();
        params.put("patientId", patientId);
        params.put("visitNo", serialNo);
        params.put("visitDate", visitDate);
        return AjaxResult.success("接口调用成功", CharsetUtil.convertObject(clinicMasterMapper.selectClinicMaster(params)));
    }
}
