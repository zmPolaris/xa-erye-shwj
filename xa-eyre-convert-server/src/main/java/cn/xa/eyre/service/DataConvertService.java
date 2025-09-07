package cn.xa.eyre.service;

import cn.xa.eyre.common.core.domain.R;
import cn.xa.eyre.common.core.kafka.DBMessage;
import cn.xa.eyre.common.utils.DateUtils;
import cn.xa.eyre.common.utils.FuzzyMatcher;
import cn.xa.eyre.hub.service.SynchroBaseService;
import cn.xa.eyre.system.dict.domain.DdDiseaseIcd;
import cn.xa.eyre.system.dict.domain.DictDisDept;
import cn.xa.eyre.system.dict.domain.DictDiseaseIcd10;
import cn.xa.eyre.system.dict.domain.DictSpecimenCategory;
import cn.xa.eyre.system.dict.mapper.DdDiseaseIcdMapper;
import cn.xa.eyre.system.dict.mapper.DictDisDeptMapper;
import cn.xa.eyre.system.dict.mapper.DictDiseaseIcd10Mapper;
import cn.xa.eyre.system.dict.mapper.DictSpecimenCategoryMapper;
import cn.xa.eyre.system.temp.domain.DictTemp;
import cn.xa.eyre.system.temp.domain.HisDeptDict;
import cn.xa.eyre.system.temp.mapper.DictTempMapper;
import cn.xa.eyre.system.temp.mapper.HisDeptDictMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DataConvertService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private HisDeptDictMapper hisDeptDictMapper;// oracle数据
    @Autowired
    private DictTempMapper dictTempMapper;// 前置软件数据
    @Autowired
    private DictDisDeptMapper dictDisDeptMapper;// 转码表
    @Autowired
    private DictDiseaseIcd10Mapper dictDiseaseIcd10Mapper;// 转码表
    @Autowired
    private DdDiseaseIcdMapper ddDiseaseIcdMapper;// 前置软件诊断代码表
    @Autowired
    private DictSpecimenCategoryMapper dictSpecimenCategoryMapper;

    @Resource
    SynchroBaseService synchroBaseService;

    public boolean convertDept() {
        List<HisDeptDict> merList = hisDeptDictMapper.selectAll();

        List<DictTemp> hubList = dictTempMapper.selectAll();

        String hisName = null;
        DictDisDept dictDisDept = new DictDisDept();
        dictDisDept.setStatus(0);
        dictDisDept.setIsDefault(1);
        dictDisDept.setCreateTime(DateUtils.getNowDate());
        for (HisDeptDict his:merList) {
            boolean exist = false;
            hisName = his.getDeptName();
            // 精准匹配
            for (DictTemp temp: hubList) {
                if(temp.getName().equals(hisName)){
                    exist = true;
                    dictDisDept.setRemark("精准匹配");
                    dictDisDept.setEmrCode(his.getDeptCode());
                    dictDisDept.setEmrName(his.getDeptName());
                    dictDisDept.setHubCode(temp.getCode());
                    dictDisDept.setHubName(temp.getName());
                    break;
                }
            }
            // 模糊匹配
            if (!exist){
                // 模糊匹配
                for (DictTemp temp: hubList) {
                    if (FuzzyMatcher.fuzzyMatch(temp.getName(), hisName)) {
                        exist = true;
                        dictDisDept.setRemark("模糊匹配");
                        dictDisDept.setEmrCode(his.getDeptCode());
                        dictDisDept.setEmrName(his.getDeptName());
                        dictDisDept.setHubCode(temp.getCode());
                        dictDisDept.setHubName(temp.getName());
                        break;
                    }
                }
            }

            // 没找到
            if(!exist){
                dictDisDept.setRemark("在前置软件中没有同名的");
                dictDisDept.setEmrCode(his.getDeptCode());
                dictDisDept.setEmrName(his.getDeptName());
                dictDisDept.setHubCode("D99");
                dictDisDept.setHubName("其他科室");
            }
            dictDisDeptMapper.insertSelective(dictDisDept);
        }

        /*// 把HIS中没有的写入
        List<DictDisDept> list = dictDisDeptMapper.selectAll();
        for (DictTemp temp: hubList) {
            boolean exist = false;
            for (DictDisDept dept:list) {
                if(dept.getHubCode().equals(temp.getCode())){
                    exist = true;
                    break;// 优先匹配第一个
                }
            }
            if (!exist){
                dictDisDept.setRemark("在HIS中没有");
                dictDisDept.setHubCode(temp.getCode());
                dictDisDept.setHubName(temp.getName());
                dictDisDeptMapper.insertSelective(dictDisDept);
            }
        }*/

        return true;
    }

    public void baseDept(DBMessage dbMessage) {
        logger.debug("医院信息系统科室信息接口");
      //  synchroBaseService.syncBaseDept(dbMessage.getAfterData(), "add");
    }

    public void baseUser(DBMessage dbMessage) {
        logger.debug("医院信息系统用户信息接口");

    }

    public boolean convertDiseaseIcd() {
        /*List<DdDiseaseIcd> hubIcds = ddDiseaseIcdMapper.selectAll();
        R<List<GysybIcd10>> icd10ListResult = insuranceFeignClient.getGysybIcd10List();
        if (R.SUCCESS == icd10ListResult.getCode() && !icd10ListResult.getData().isEmpty()){
            for (GysybIcd10 emricd : icd10ListResult.getData()) {
                DictDiseaseIcd10 dictDiseaseIcd10 = new DictDiseaseIcd10();
                dictDiseaseIcd10.setEmrCode(emricd.getIcdCode());
                dictDiseaseIcd10.setEmrName(emricd.getIcdName());
                boolean match = false;
                // 精准怕匹配
                for (DdDiseaseIcd hubicd : hubIcds) {
                    if (hubicd.getName().equals(emricd.getIcdName())){
                        dictDiseaseIcd10.setRemark("精准匹配");
                        dictDiseaseIcd10.setHubCode(hubicd.getCode());
                        dictDiseaseIcd10.setHubName(hubicd.getName());
                        match = true;
                        break;
                    }
                }
                 if (!match){
                     // 模糊匹配
                     for (DdDiseaseIcd hubicd : hubIcds) {
                         if (FuzzyMatcher.fuzzyMatch(hubicd.getName(), emricd.getIcdName())){
                             dictDiseaseIcd10.setRemark("模糊匹配");
                             dictDiseaseIcd10.setHubCode(hubicd.getCode());
                             dictDiseaseIcd10.setHubName(hubicd.getName());
                             match = true;
                             break;
                         }
                     }
                 }

                if (!match){
                    // 查询默认
                    dictDiseaseIcd10.setRemark("未匹配到，其他类");
                    dictDiseaseIcd10.setHubCode("143");
                    dictDiseaseIcd10.setHubName("其他");
                }
                dictDiseaseIcd10Mapper.insertSelective(dictDiseaseIcd10);
            }
        }*/
        return true;
    }

    public boolean convertBb() {
        List<DictSpecimenCategory> dictSpecimenCategories = dictSpecimenCategoryMapper.selectAll();
        List<DictTemp> hubList = dictTempMapper.selectAll();
        for (DictSpecimenCategory sp : dictSpecimenCategories) {
            boolean match = false;
            for (DictTemp temp: hubList) {
                if (temp.getName().equals(sp.getEmrName())){
                    sp.setRemark("精准匹配");
                    sp.setHubCode(temp.getCode());
                    sp.setHubName(temp.getName());
                    match = true;
                    break;
                }
            }
            if (!match){
                // 模糊匹配
                for (DictTemp temp2: hubList) {
                    if (FuzzyMatcher.fuzzyMatch(temp2.getName(), sp.getEmrName())){
                        sp.setRemark("模糊匹配");
                        sp.setHubCode(temp2.getCode());
                        sp.setHubName(temp2.getName());
                        match = true;
                        break;
                    }
                }
            }
            if (!match){
                // 查询默认
                sp.setRemark("未匹配到，其他类");
                sp.setHubCode("99");
                sp.setHubName("其他");
            }
            dictSpecimenCategoryMapper.updateByPrimaryKey(sp);

        }
        return true;
    }
}
