package cn.xa.eyre.service;

import cn.hutool.core.util.IdcardUtil;
import cn.hutool.json.JSONUtil;
import cn.xa.eyre.comm.domain.DeptDict;
import cn.xa.eyre.comm.domain.Users;
import cn.xa.eyre.common.constant.CacheConstants;
import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.core.domain.R;
import cn.xa.eyre.common.core.redis.RedisCache;
import cn.xa.eyre.common.utils.DateUtils;
import cn.xa.eyre.common.utils.StringUtils;
import cn.xa.eyre.hisapi.CommFeignClient;
import cn.xa.eyre.hisapi.MedrecFeignClient;
import cn.xa.eyre.hisapi.OutpadmFeignClient;
import cn.xa.eyre.hisapi.OutpdoctFeignClient;
import cn.xa.eyre.hub.domain.base.BaseDept;
import cn.xa.eyre.hub.domain.base.BaseUser;
import cn.xa.eyre.hub.domain.emrreal.EmrPatientInfo;
import cn.xa.eyre.hub.service.SynchroBaseService;
import cn.xa.eyre.hub.service.SynchroEmrRealService;
import cn.xa.eyre.hub.staticvalue.HubCodeEnum;
import cn.xa.eyre.medrec.domain.PatMasterIndex;
import cn.xa.eyre.system.dict.domain.DdNation;
import cn.xa.eyre.system.dict.domain.DictDisDept;
import cn.xa.eyre.system.dict.domain.DictDiseaseIcd10;
import cn.xa.eyre.system.dict.mapper.DdNationMapper;
import cn.xa.eyre.system.dict.mapper.DictDisDeptMapper;
import cn.xa.eyre.system.dict.mapper.DictDiseaseIcd10Mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class HubToolService {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private SynchroEmrRealService synchroEmrRealService;
    @Autowired
    private DdNationMapper ddNationMapper;
    @Autowired
    private CommFeignClient commFeignClient;
    @Autowired
    private MedrecFeignClient medrecFeignClient;
    @Autowired
    private DictDisDeptMapper dictDisDeptMapper;// 科室代码转码表
    @Autowired
    private OutpdoctFeignClient outpdoctFeignClient;
    @Autowired
    private SynchroBaseService synchroBaseService;
    @Autowired
    private OutpadmFeignClient outpadmFeignClient;
    @Autowired
    private DictDiseaseIcd10Mapper dictDiseaseIcd10Mapper;// ICD10转码表

    @Autowired
    private RedisCache redisCache;

    public boolean synchroPatient(Integer num) {
        /*R<List<PatMasterIndex>> patsResult = medrecFeignClient.getPatMasterIndexList(num);
        if (R.SUCCESS == patsResult.getCode() && !patsResult.getData().isEmpty()){
            for (PatMasterIndex patMasterIndex : patsResult.getData()) {
                EmrPatientInfo emrPatientInfo = new EmrPatientInfo();
                // 构造请求参数
                emrPatientInfo.setId(patMasterIndex.getPatientId());
                emrPatientInfo.setPatientName(patMasterIndex.getName());
                if (StringUtils.isBlank(patMasterIndex.getIdNo())){
                    emrPatientInfo.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE_OTHER.getCode());
                    emrPatientInfo.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE_OTHER.getName());
                    emrPatientInfo.setIdCard(medrecResult.getData().getIdNo());
                }else {
                    emrPatientInfo.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE.getCode());
                    emrPatientInfo.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE.getName());
                    emrPatientInfo.setIdCard(patMasterIndex.getIdNo());
                }
                emrPatientInfo.setGenderCode(patMasterIndex.getSexCode());
                emrPatientInfo.setGenderName(patMasterIndex.getSex());
                emrPatientInfo.setBirthDate(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD, patMasterIndex.getDateOfBirth()));
                if("CN".equals(patMasterIndex.getCitizenship())){
                    emrPatientInfo.setNationalityCode(HubCodeEnum.NATIONALITY_CODE.getCode());
                    emrPatientInfo.setNationalityName(HubCodeEnum.NATIONALITY_CODE.getName());
                }
                DdNation ddNation = ddNationMapper.selectByName(patMasterIndex.getNation());
                if (ddNation != null){
                    emrPatientInfo.setNationCode(ddNation.getCode());
                    emrPatientInfo.setNationName(ddNation.getName());
                }
//                else {
//                    emrPatientInfo.setNationCode(HubCodeEnum.NATION_CODE.getCode());
//                    emrPatientInfo.setNationName(HubCodeEnum.NATION_CODE.getName());
//                }
                emrPatientInfo.setCurrentAddrCode(patMasterIndex.getMailingAreaCode4());
                emrPatientInfo.setCurrentAddrName(patMasterIndex.getMailingAddress());
                emrPatientInfo.setCurrentAddrDetail(patMasterIndex.getNextOfKinAddr());
                emrPatientInfo.setWorkunit(patMasterIndex.getWorkunit());
                if(patMasterIndex.getNextOfKin() != null){
                    emrPatientInfo.setContacts(patMasterIndex.getNextOfKin());
                    emrPatientInfo.setContactsTel(patMasterIndex.getNextOfKinPhone());
                }else {
                    emrPatientInfo.setContacts(patMasterIndex.getGuardianName());
                    emrPatientInfo.setContactsTel(patMasterIndex.getGuardianPhone());
                }
                emrPatientInfo.setOrgCode(HubCodeEnum.ORG_CODE.getCode());
                emrPatientInfo.setOrgName(HubCodeEnum.ORG_CODE.getName());
                // 查询操作员ID
                if (StringUtils.isNotBlank(patMasterIndex.getOperator())){
                    R<Users> user = commFeignClient.getUserByName(patMasterIndex.getOperator());
                    if (R.SUCCESS == user.getCode() && user.getData() != null){
                        emrPatientInfo.setOperatorId(user.getData().getUserId());
                    }
                }
                emrPatientInfo.setOperationTime(DateUtils.getTime());
                synchroEmrRealService.syncEmrPatientInfo(emrPatientInfo, Constants.HTTP_METHOD_POST);
            }
            return true;
        }*/
        return false;
    }

    public boolean synchroUser(Integer num) {
        R<List<Users>> usersResult = commFeignClient.getUserList(num);
        if (R.SUCCESS == usersResult.getCode() && !usersResult.getData().isEmpty()){
            for (Users users : usersResult.getData()){
                BaseUser baseUser = new BaseUser();
                String deptCode = users.getUserDept();
                if(deptCode != null && !deptCode.equals("")){
                    DictDisDept deptParam = new DictDisDept();
                    deptParam.setStatus(Constants.STATUS_NORMAL);
                    deptParam.setEmrCode(deptCode);
                    DictDisDept dictDisDept = dictDisDeptMapper.selectByCondition(deptParam);
                    if (dictDisDept == null){
                        deptParam.setEmrCode(null);
                        deptParam.setIsDefault(Constants.IS_DEFAULT);
                        dictDisDept = dictDisDeptMapper.selectByCondition(deptParam);
                    }
                    baseUser.setDeptCode(dictDisDept.getHubCode());
                    baseUser.setId(users.getUserId());
                    baseUser.setOrgCode(HubCodeEnum.ORG_CODE.getCode());
                    baseUser.setUserName(users.getUserName());
                    baseUser.setLoginName(users.getDbUser());
                    baseUser.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE_OTHER.getCode());
                    baseUser.setIdCard("-");
                    baseUser.setUserTypeCode("2");
                    baseUser.setCreateTime(new Date());
                    synchroBaseService.syncBaseUser(baseUser, Constants.HTTP_METHOD_POST);
                }else {
                    logger.info("用户【{}】部门编码为空，无法同步...", users.getUserId() + baseUser.getUserName());
                }
            }

            return true;
        }

        return false;
    }

    public boolean synchroDept(Integer num) {
        if (num == null){
            List<DictDisDept> list = dictDisDeptMapper.selectAll();
            if(!list.isEmpty()){
                for (DictDisDept dictDisDept : list){
                    BaseDept baseDept = new BaseDept();
                    baseDept.setDeptCode(dictDisDept.getEmrCode());
                    baseDept.setDeptName(dictDisDept.getEmrName());
                    baseDept.setTargetDeptCode(dictDisDept.getHubCode());
                    baseDept.setTargetDeptName(dictDisDept.getHubName());
                    baseDept.setCreateTime(DateUtils.getNowDate());
                    Collection<String> keys = redisCache.keys(CacheConstants.SYS_DICT_DEPT_KEY + "*");
                    redisCache.deleteObject(keys);
                    redisCache.setCacheObject(CacheConstants.SYS_DICT_DEPT_KEY + dictDisDept.getEmrCode(), dictDisDept);
                    synchroBaseService.syncBaseDept(baseDept, Constants.HTTP_METHOD_POST);
                }
                return true;
            }
        }else {
            R<List<DeptDict>> deptsResult = commFeignClient.getDeptList(num);
            if (R.SUCCESS == deptsResult.getCode() && !deptsResult.getData().isEmpty()){
                for (DeptDict deptDict : deptsResult.getData()){
                    BaseDept baseDept = new BaseDept();
                    DictDisDept deptParam = new DictDisDept();
                    deptParam.setStatus(Constants.STATUS_NORMAL);
                    deptParam.setEmrCode(deptDict.getDeptCode());
                    // 根据HIS编码查询转码表，存在使用转码表数据
                    DictDisDept dictDisDept = dictDisDeptMapper.selectByCondition(deptParam);
                    if(dictDisDept == null){
                        dictDisDept = new DictDisDept();
                        List<DictDisDept> list = dictDisDeptMapper.selectAll();
                        boolean isExist = false;
                        for (DictDisDept dict : list) {
                            if(deptDict.getDeptName().contains(dict.getHubName())) {
                                dictDisDept.setHubCode(dict.getHubCode());
                                dictDisDept.setHubName(dict.getHubName());
                                isExist = true;
                                break;
                            }
                        }
                        if (!isExist){
                            dictDisDept.setHubCode("D99");
                            dictDisDept.setHubName("其他科室");
                        }
                        dictDisDept.setEmrCode(deptDict.getDeptCode());
                        dictDisDept.setEmrName(deptDict.getDeptName());
                        dictDisDept.setCreateTime(DateUtils.getNowDate());
                        dictDisDeptMapper.insertSelective(dictDisDept);
                    }else {
                        // 更新转码表
                        dictDisDept.setEmrCode(deptDict.getDeptCode());
                        dictDisDept.setEmrName(deptDict.getDeptName());
                        dictDisDept.setUpdateTime(DateUtils.getNowDate());
                        dictDisDeptMapper.updateByPrimaryKey(dictDisDept);
                    }
                    baseDept.setDeptCode(deptDict.getDeptCode());
                    baseDept.setDeptName(deptDict.getDeptName());
                    baseDept.setTargetDeptCode(dictDisDept.getHubCode());
                    baseDept.setTargetDeptName(dictDisDept.getHubName());
                    baseDept.setCreateTime(DateUtils.getNowDate());
                    logger.info("同步数据：{}", JSONUtil.toJsonStr(baseDept));
                    synchroBaseService.syncBaseDept(baseDept, Constants.HTTP_METHOD_POST);
                }
                return true;
            }
        }
        return false;
    }

    public boolean synchroActivity(Integer num) {
        /*R<List<OutpMr>> outpMrsResult = outpdoctFeignClient.getOutpMrList(num);
        if (R.SUCCESS == outpMrsResult.getCode() && !outpMrsResult.getData().isEmpty()){
            for (OutpMr outpMr : outpMrsResult.getData()){
                R<PatMasterIndex> medrecResult = medrecFeignClient.getPatMasterIndex(outpMr.getPatientId());
                R<ClinicMaster> outpadmResult = outpadmFeignClient.getClinicMaster(outpMr.getPatientId(), outpMr.getVisitNo(), DateUtils.dateTime(outpMr.getVisitDate()));
                if (R.SUCCESS == medrecResult.getCode() && R.SUCCESS == outpadmResult.getCode()
                        && medrecResult.getData() != null && outpadmResult.getData() != null){
                    PatMasterIndex patMasterIndex = medrecResult.getData();
                    ClinicMaster clinicMaster = outpadmResult.getData();

                    EmrActivityInfo emrActivityInfo = new EmrActivityInfo();
                    // ID使用OUTP_MR表联合主键拼接计算MD5
                    String id = DigestUtil.md5Hex(DateUtils.dateTime(outpMr.getVisitDate()) + outpMr.getVisitNo() + outpMr.getOrdinal());
                    emrActivityInfo.setId(id);
                    emrActivityInfo.setPatientId(outpMr.getPatientId());
                    String clinicType = clinicMaster.getClinicType();
                    if (StringUtils.isNotBlank(clinicType)){
                        if (clinicType.contains("急诊号")){
                            emrActivityInfo.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_EMERGENCY.getCode());
                            emrActivityInfo.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_EMERGENCY.getName());
                        } else {
                            emrActivityInfo.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_OUTPATIENT.getCode());
                            emrActivityInfo.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_OUTPATIENT.getName());

                        }
                    }
                    emrActivityInfo.setSerialNumber(DigestUtil.md5Hex(outpMr.getPatientId() + outpMr.getVisitNo()));
                    emrActivityInfo.setActivityTime(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, outpMr.getVisitDate()));
                    String idNo = patMasterIndex.getIdNo();
                    if (StringUtils.isNotBlank(idNo)) {
                        emrActivityInfo.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE.getCode());
                        emrActivityInfo.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE.getName());
                        emrActivityInfo.setIdCard(idNo);
                    } else {
                        emrActivityInfo.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE_OTHER.getCode());
                        emrActivityInfo.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE_OTHER.getName());
                        emrActivityInfo.setIdCard(medrecResult.getData().getIdNo());
                    }
                    emrActivityInfo.setPatientName(patMasterIndex.getName());

                    emrActivityInfo.setChiefComplaint(outpMr.getIllnessDesc());
                    emrActivityInfo.setPresentIllnessHis(outpMr.getMedHistory());
                    emrActivityInfo.setPhysicalExamination(outpMr.getBodyExam());
                    emrActivityInfo.setStudiesSummaryResult(outpMr.getAssistExam());
                    emrActivityInfo.setDiagnoseTime(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, outpMr.getVisitDate()));

                    // 诊断代码
                    if (StringUtils.isNotBlank(outpMr.getDiagnosisCodeMz1())){
                        DictDiseaseIcd10 dictDiseaseIcd10 = dictDiseaseIcd10Mapper.selectByEmrCode(outpMr.getDiagnosisCodeMz1());
                        if(dictDiseaseIcd10 == null){
                            emrActivityInfo.setWmDiseaseCode(HubCodeEnum.DISEASE_ICD10_CODE.getCode());
                            emrActivityInfo.setWmDiseaseName(HubCodeEnum.DISEASE_ICD10_CODE.getName());
                        }else {
                            emrActivityInfo.setWmDiseaseCode(dictDiseaseIcd10.getHubCode());
                            emrActivityInfo.setWmDiseaseName(dictDiseaseIcd10.getHubName());
                        }
                        if (StringUtils.isNotBlank(outpMr.getDiagnosisCodeMz2())){
                            DictDiseaseIcd10 dictDiseaseIcd102 = dictDiseaseIcd10Mapper.selectByEmrCode(outpMr.getDiagnosisCodeMz2());
                            if(dictDiseaseIcd102 == null){
                                emrActivityInfo.setWmDiseaseCode(HubCodeEnum.DISEASE_ICD10_CODE.getCode());
                                emrActivityInfo.setWmDiseaseName(HubCodeEnum.DISEASE_ICD10_CODE.getName());
                            }else {
                                emrActivityInfo.setWmDiseaseCode(emrActivityInfo.getWmDiseaseCode() + "||" + dictDiseaseIcd102.getHubCode());
                                emrActivityInfo.setWmDiseaseName(emrActivityInfo.getWmDiseaseName() + "||" + dictDiseaseIcd102.getHubName());
                            }
                        }
                    }else {
                        emrActivityInfo.setWmDiseaseCode(HubCodeEnum.DISEASE_ICD10_CODE.getCode());
                        emrActivityInfo.setWmDiseaseName(HubCodeEnum.DISEASE_ICD10_CODE.getName());
                    }

                    emrActivityInfo.setFillDoctor(patMasterIndex.getOperator());

                    // 查询操作员ID
                    if (StringUtils.isNotBlank(patMasterIndex.getOperator())){
                        R<Users> user = commFeignClient.getUserByName(patMasterIndex.getOperator());
                        if (R.SUCCESS == user.getCode() && user.getData() != null){
                            emrActivityInfo.setOperatorId(user.getData().getUserId());
                        }
                    }

                    DictDisDept deptParam = new DictDisDept();
                    deptParam.setStatus(Constants.STATUS_NORMAL);
                    deptParam.setEmrCode(clinicMaster.getVisitDept());
                    DictDisDept dictDisDept = dictDisDeptMapper.selectByCondition(deptParam);
                    if (dictDisDept == null){
                        deptParam.setEmrCode(null);
                        deptParam.setIsDefault(Constants.IS_DEFAULT);
                        dictDisDept = dictDisDeptMapper.selectByCondition(deptParam);
                    }
                    emrActivityInfo.setDeptCode(dictDisDept.getHubCode());
                    emrActivityInfo.setDeptName(dictDisDept.getHubName());

                    emrActivityInfo.setOrgCode(HubCodeEnum.ORG_CODE.getCode());
                    emrActivityInfo.setOrgName(HubCodeEnum.ORG_CODE.getName());
                    emrActivityInfo.setOperationTime(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, DateUtils.getNowDate()));
                    synchroEmrRealService.syncEmrActivityInfo(emrActivityInfo, Constants.HTTP_METHOD_POST);
                }else {
                    logger.error("对应PatMasterIndex信息或ClinicMaster信息为空，无法同步");
                }
            }
            return true;
        }*/
        return false;
    }

    /**
     * 同步患者信息
     * @param patMasterIndex
     * @return
     */
    public EmrPatientInfo syncPatInfo(PatMasterIndex patMasterIndex){
        logger.debug("构造emrPatientInfo接口数据...");
        // 构造请求参数
        EmrPatientInfo emrPatientInfo = new EmrPatientInfo();
        emrPatientInfo.setId(patMasterIndex.getPatientId());
        emrPatientInfo.setPatientName(patMasterIndex.getName());
        if (StringUtils.isNotBlank(patMasterIndex.getIdNo())){
            if (IdcardUtil.isValidCard(patMasterIndex.getIdNo())){
                emrPatientInfo.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE.getCode());
                emrPatientInfo.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE.getName());
                emrPatientInfo.setIdCard(patMasterIndex.getIdNo());
            }else {
                emrPatientInfo.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE_OTHER.getCode());
                emrPatientInfo.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE_OTHER.getName());
                emrPatientInfo.setIdCard(patMasterIndex.getIdNo());
            }
        }else {
            // 获取不到证件号码时从医保信息表查询
            R<String> idNoResult = medrecFeignClient.getIdNo(patMasterIndex.getPatientId());
            if (R.SUCCESS == idNoResult.getCode() && idNoResult.getData() != null){
                emrPatientInfo.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE.getCode());
                emrPatientInfo.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE.getName());
                emrPatientInfo.setIdCard(idNoResult.getData());
            }else {
                // 还获取不到，取PatientId
                emrPatientInfo.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE_OTHER.getCode());
                emrPatientInfo.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE_OTHER.getName());
                emrPatientInfo.setIdCard(patMasterIndex.getPatientId());
            }
        }
        if(StringUtils.isNotBlank(patMasterIndex.getSex())){
            if (patMasterIndex.getSex().equals("男")){
                emrPatientInfo.setGenderCode("1");
            } else if (patMasterIndex.getSex().equals("女")) {
                emrPatientInfo.setGenderCode("2");
            } else {
                emrPatientInfo.setGenderCode(HubCodeEnum.SEX_OTHER.getCode());
            }
        }
        emrPatientInfo.setGenderName(patMasterIndex.getSex());
        emrPatientInfo.setBirthDate(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD, patMasterIndex.getDateOfBirth()));
        if("CN".equals(patMasterIndex.getCitizenship())){
            emrPatientInfo.setNationalityCode(HubCodeEnum.NATIONALITY_CODE.getCode());
            emrPatientInfo.setNationalityName(HubCodeEnum.NATIONALITY_CODE.getName());
        }
        DdNation ddNation = ddNationMapper.selectByName(patMasterIndex.getNation());
        if (ddNation != null){
            emrPatientInfo.setNationCode(ddNation.getCode());
            emrPatientInfo.setNationName(ddNation.getName());
        }
        emrPatientInfo.setCurrentAddrName(patMasterIndex.getMailingAddress());
        emrPatientInfo.setCurrentAddrDetail(patMasterIndex.getNextOfKinAddr());
        Date birthDate = patMasterIndex.getDateOfBirth();
        if (null != birthDate) {
            LocalDate localDate = DateUtils.convertDateToLocalDate(birthDate);
            Period period = Period.between(localDate, LocalDate.now());
            if (period.getYears() <= 14) {
                if(patMasterIndex.getNextOfKin() != null){
                    emrPatientInfo.setContacts(patMasterIndex.getNextOfKin());
                    emrPatientInfo.setContactsTel(patMasterIndex.getNextOfKinPhone());
                }
            }
        }
        emrPatientInfo.setOrgCode(HubCodeEnum.ORG_CODE.getCode());
        emrPatientInfo.setOrgName(HubCodeEnum.ORG_CODE.getName());
        // 查询操作员ID
        if (StringUtils.isNotBlank(patMasterIndex.getOperator())){
            R<Users> user = commFeignClient.getUserByName(patMasterIndex.getOperator());
            if (R.SUCCESS == user.getCode() && user.getData() != null){
                emrPatientInfo.setOperatorId(user.getData().getUserId());
            }
        }

        emrPatientInfo.setOperationTime(DateUtils.getTime());
        synchroEmrRealService.syncEmrPatientInfo(emrPatientInfo, Constants.HTTP_METHOD_POST);
        return emrPatientInfo;
    }

    public DictDisDept getDept(String code){
        DictDisDept deptParam = new DictDisDept();
        deptParam.setStatus(Constants.STATUS_NORMAL);
        deptParam.setEmrCode(code);
        DictDisDept dictDisDept = dictDisDeptMapper.selectByCondition(deptParam);
        if (dictDisDept == null || "D99".equals(dictDisDept.getHubCode())){
            R<DeptDict> deptResult = commFeignClient.getDept(code);
            if (deptResult.getCode() == R.SUCCESS && deptResult.getData() != null){
                // 转码表没有的直接传院内编码
                dictDisDept.setHubCode(code);
                dictDisDept.setHubName(deptResult.getData().getDeptName());
            }else {
                deptParam.setEmrCode(null);
                deptParam.setIsDefault(Constants.IS_DEFAULT);
                dictDisDept = dictDisDeptMapper.selectByCondition(deptParam);
            }
        }
        return dictDisDept;
    }

    public DictDiseaseIcd10 getDiseaseIcd10(String code, String name){
        DictDiseaseIcd10 dictDiseaseIcd10 = dictDiseaseIcd10Mapper.selectByEmrCode(code);
        if(dictDiseaseIcd10 == null || dictDiseaseIcd10.getHubCode().equals(HubCodeEnum.DISEASE_ICD10_CODE.getCode())){
            dictDiseaseIcd10 = new DictDiseaseIcd10(code, name);
        }
        return dictDiseaseIcd10;
    }

}
