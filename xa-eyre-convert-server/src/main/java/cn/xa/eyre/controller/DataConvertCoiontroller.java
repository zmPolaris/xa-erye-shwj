package cn.xa.eyre.controller;

import cn.hutool.json.JSONUtil;
import cn.xa.eyre.common.core.domain.AjaxResult;
import cn.xa.eyre.common.core.kafka.DBMessage;
import cn.xa.eyre.service.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/convert")
public class DataConvertCoiontroller {

    Logger logger = org.slf4j.LoggerFactory.getLogger(DataConvertCoiontroller.class);

    @Autowired
    private DataConvertService dataConvertService;
    @Autowired
    private CommConvertService commConvertService;
    @Autowired
    private MedrecConvertService medrecConvertService;
    @Autowired
    private OutpdoctConvertService outpdoctConvertService;
    @Autowired
    private InpadmConvertService inpadmConvertService;
    @Autowired
    private ExamConvertService examConvertService;
    @Autowired
    private PharmacyConvertService pharmacyConvertService;
    @Autowired
    private LabConvertService labConvertService;

    /**
     * 部门信息转码
     * @param request
     * @return
     */
    @PostMapping("/convertDept")
    public AjaxResult convertDept(HttpServletRequest request){
        return AjaxResult.success("转码成功", dataConvertService.convertDept());
    }

    /**
     * 部门信息转码
     * @param request
     * @return
     */
    @PostMapping("/convertDiseaseIcd")
    public AjaxResult convertDiseaseIcd(HttpServletRequest request){
        return AjaxResult.success("转码成功", dataConvertService.convertDiseaseIcd());
    }

    /**
     * 标本信息转码
     * @param request
     * @return
     */
    @PostMapping("/convertBb")
    public AjaxResult convertBb(HttpServletRequest request){
        return AjaxResult.success("转码成功", dataConvertService.convertBb());
    }

    @PostMapping("/receiveKafkaData")
    public AjaxResult receiveKafkaData(@RequestBody DBMessage dbMessage, HttpServletRequest request, HttpServletResponse response){
        logger.debug("receiveKafkaData:{}", JSONUtil.toJsonStr(dbMessage));
        String schema = dbMessage.getSchema();
        String table = dbMessage.getTable();
        String dbName = (schema + "." + table).toLowerCase();
        switch (dbName) {
            case "comm.users":
                commConvertService.baseUser(dbMessage);
                break;
            case "comm.dept_dict":
                commConvertService.deptDict(dbMessage);
                break;
            case "medrec.pat_master_index":
                medrecConvertService.patMasterIndex(dbMessage);
                break;
            case "outpdoct.outp_mr":
                outpdoctConvertService.outpMr(dbMessage);
                break;
            case "inpadm.pats_in_hospital":
                inpadmConvertService.patsInHospital(dbMessage);
                break;
            case "medrec.diagnosis":
                medrecConvertService.diagnosis(dbMessage);
                break;
            case "medrec.pat_visit":
                medrecConvertService.patVisit(dbMessage);
                break;
            case "exam.exam_master":
                examConvertService.examMaster(dbMessage);
                break;
            case "lab.lab_test_master":
                labConvertService.labTestMaster(dbMessage);
                break;
            case "pharmacy.drug_presc_master":
                pharmacyConvertService.drugPrescMaster(dbMessage);
                break;
            default:

        }
        return AjaxResult.success("转码成功");
    }
}
