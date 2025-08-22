package cn.xa.eyre.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.xa.eyre.comm.domain.Users;
import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.core.domain.R;
import cn.xa.eyre.common.core.kafka.DBMessage;
import cn.xa.eyre.common.utils.DateUtils;
import cn.xa.eyre.common.utils.StringUtils;
import cn.xa.eyre.common.utils.bean.BeanUtils;
import cn.xa.eyre.hisapi.CommFeignClient;
import cn.xa.eyre.hisapi.MedrecFeignClient;
import cn.xa.eyre.hisapi.OutpadmFeignClient;
import cn.xa.eyre.hisapi.OutpdoctFeignClient;
import cn.xa.eyre.hub.domain.emrmonitor.EmrOutpatientRecord;
import cn.xa.eyre.hub.domain.emrreal.EmrActivityInfo;
import cn.xa.eyre.hub.service.SynchroEmrMonitorService;
import cn.xa.eyre.hub.service.SynchroEmrRealService;
import cn.xa.eyre.hub.staticvalue.HubCodeEnum;
import cn.xa.eyre.medrec.domain.OutpMrYb;
import cn.xa.eyre.medrec.domain.OutpMrYbKey;
import cn.xa.eyre.medrec.domain.PatMasterIndex;
import cn.xa.eyre.outpadm.domain.ClinicMaster;
import cn.xa.eyre.outpdoct.domain.OutpMr;
import cn.xa.eyre.outpdoct.domain.OutpWaitQueue;
import cn.xa.eyre.system.dict.domain.DictDisDept;
import cn.xa.eyre.system.dict.domain.DictDiseaseIcd10;
import cn.xa.eyre.system.dict.mapper.DictDisDeptMapper;
import cn.xa.eyre.system.dict.mapper.DictDiseaseIcd10Mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@Service
public class OutpdoctConvertService {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MedrecFeignClient medrecFeignClient;
    @Autowired
    private OutpadmFeignClient outpadmFeignClient;
    @Autowired
    private DictDisDeptMapper dictDisDeptMapper;// 科室代码转码表
    @Autowired
    private SynchroEmrMonitorService synchroEmrMonitorService;
    @Autowired
    SynchroEmrRealService synchroEmrRealService;
    @Autowired
    private CommFeignClient commFeignClient;
    @Autowired
    private DictDiseaseIcd10Mapper dictDiseaseIcd10Mapper;// ICD10转码表
    @Autowired
    private OutpdoctFeignClient outpdoctFeignClient;
    @Autowired
    private HubToolService hubToolService;

    public void outpMr(DBMessage dbMessage) {
        logger.debug("OUTP_MR表变更接口");
        logger.debug("OUTP_MR表变更需调用emrActivityInfo、emrOutpatientRecord同步接口");

        String httpMethod = null;
        OutpMr outpMr;
        Map<String, String> data;
        if(dbMessage.getOperation().equalsIgnoreCase("DELETE")){
            httpMethod = Constants.HTTP_METHOD_DELETE;
            data = dbMessage.getBeforeData();
        }else {
            httpMethod = Constants.HTTP_METHOD_POST;
            data = dbMessage.getAfterData();
        }
//        outpMr = BeanUtil.toBeanIgnoreError(data, OutpMr.class);
//        outpMr.setVisitDate(DateUtils.getLongDate(data.get("visitDate")));

        try {
            outpMr = BeanUtils.mapToObject(data, OutpMr.class);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        if (StringUtils.isNotBlank(outpMr.getPatientId())){
            logger.debug("构造emrOutpatientRecord接口数据...");
            R<PatMasterIndex> medrecResult = medrecFeignClient.getPatMasterIndex(outpMr.getPatientId());
            R<ClinicMaster> outpadmResult = outpadmFeignClient.getClinicMaster(outpMr.getPatientId(), outpMr.getVisitNo(), DateUtils.dateTime(outpMr.getVisitDate()));
            if (R.SUCCESS == medrecResult.getCode() && medrecResult.getData() != null
                    && R.SUCCESS == outpadmResult.getCode() && outpadmResult.getData() != null){
                // 军队医改不推送
                if (outpadmResult.getData().getChargeType().equals(Constants.CHARGE_TYPE_JDYG)){
                    logger.error("费别为军队医改，不推送数据");
                    return;
                }
                // 更新推送患者信息
                hubToolService.syncPatInfo(medrecResult.getData());
                EmrOutpatientRecord emrOutpatientRecord = new EmrOutpatientRecord();
                // ID使用OUTP_MR表联合主键拼接计算MD5
                String id = DigestUtil.md5Hex(DateUtils.dateTime(outpMr.getVisitDate()) + outpMr.getVisitNo() + outpMr.getOrdinal());
                emrOutpatientRecord.setId(id);
                emrOutpatientRecord.setPatientId(outpMr.getPatientId());
                emrOutpatientRecord.setSerialNumber(DigestUtil.md5Hex(outpMr.getPatientId() + outpMr.getVisitNo()));
                emrOutpatientRecord.setOutpatientDate(outpMr.getVisitDate());
                emrOutpatientRecord.setInitalDiagnosisCode(String.valueOf(1)); // 初诊标识，表中没有这个字段
                emrOutpatientRecord.setChiefComplaint(outpMr.getIllnessDesc());
                emrOutpatientRecord.setPresentIllnessHis(outpMr.getMedHistory());
                emrOutpatientRecord.setPastIllnessHis(outpMr.getAnamnesis());
                emrOutpatientRecord.setOperationHis(outpMr.getMedicalRecord());
                emrOutpatientRecord.setMaritalHis(outpMr.getMarrital());
                if(StringUtils.isNotBlank(outpMr.getIndividual())){
                    emrOutpatientRecord.setAllergyHisFlag("1");
                    emrOutpatientRecord.setAllergyHis(outpMr.getIndividual());
                }
                emrOutpatientRecord.setMenstrualHis(outpMr.getMenses());
                emrOutpatientRecord.setFamilyHis(outpMr.getFamilyIll());
                emrOutpatientRecord.setPhysicalExamination(outpMr.getBodyExam());
                emrOutpatientRecord.setStudiesSummaryResult(outpMr.getAssistExam());

                // 诊断代码
                emrOutpatientRecord.setWmDiagnosisCode(HubCodeEnum.DISEASE_ICD10_CODE.getCode());
                emrOutpatientRecord.setWmDiagnosisName(HubCodeEnum.DISEASE_ICD10_CODE.getName());
                OutpMrYb outpMrYbKey = new OutpMrYb();
                BeanUtil.copyProperties(outpMr, outpMrYbKey);
                outpMrYbKey.setVisitDateStr(DateUtils.dateTime(outpMr.getVisitDate()));
                R<OutpMrYb> outpMrYbResult = medrecFeignClient.getOutpMrYb(outpMrYbKey);
                Users doctor = null;
                if(outpMrYbResult.getCode() == R.SUCCESS && outpMrYbResult.getData() != null){
                    if (StringUtils.isNotBlank(outpMrYbResult.getData().getIcdCode01())){
                        DictDiseaseIcd10 dictDiseaseIcd10 = dictDiseaseIcd10Mapper.selectByEmrCode(outpMrYbResult.getData().getIcdCode01());
                        if(dictDiseaseIcd10 == null || dictDiseaseIcd10.getHubCode().equals(HubCodeEnum.DISEASE_ICD10_CODE.getCode())){
                            emrOutpatientRecord.setWmDiagnosisCode(outpMrYbResult.getData().getIcdCode01());
                            emrOutpatientRecord.setWmDiagnosisName(outpMrYbResult.getData().getIcdName01());
                        }else {
                            emrOutpatientRecord.setWmDiagnosisCode(dictDiseaseIcd10.getHubCode());
                            emrOutpatientRecord.setWmDiagnosisName(dictDiseaseIcd10.getHubName());
                        }
                        if (StringUtils.isNotBlank(outpMrYbResult.getData().getIcdCode02())){
                            DictDiseaseIcd10 dictDiseaseIcd102 = dictDiseaseIcd10Mapper.selectByEmrCode(outpMrYbResult.getData().getIcdCode02());
                            if(dictDiseaseIcd102 == null || dictDiseaseIcd102.getHubCode().equals(HubCodeEnum.DISEASE_ICD10_CODE.getCode())){
                                emrOutpatientRecord.setWmDiagnosisCode(emrOutpatientRecord.getWmDiagnosisCode() + "||" + outpMrYbResult.getData().getIcdCode02());
                                emrOutpatientRecord.setWmDiagnosisName(emrOutpatientRecord.getWmDiagnosisName() + "||" + outpMrYbResult.getData().getIcdName02());
                            }else {
                                emrOutpatientRecord.setWmDiagnosisCode(emrOutpatientRecord.getWmDiagnosisCode() + "||" + dictDiseaseIcd102.getHubCode());
                                emrOutpatientRecord.setWmDiagnosisName(emrOutpatientRecord.getWmDiagnosisName() + "||" + dictDiseaseIcd102.getHubName());
                            }
                        }
                    }
                    if (StringUtils.isNotBlank(outpMrYbResult.getData().getDoctor())){
                        R<Users> user = commFeignClient.getUserByName(outpMrYbResult.getData().getDoctor());
                        if (R.SUCCESS == user.getCode() && user.getData() != null){
                            doctor = user.getData();
                            emrOutpatientRecord.setOperatorId(doctor.getUserId());
                        }
                    }
                }else {
                    if (StringUtils.isNotBlank(outpMr.getDiagnosisCodeMz1())){
                        DictDiseaseIcd10 dictDiseaseIcd10 = dictDiseaseIcd10Mapper.selectByEmrCode(outpMr.getDiagnosisCodeMz1());
                        if(dictDiseaseIcd10 == null || dictDiseaseIcd10.getHubCode().equals(HubCodeEnum.DISEASE_ICD10_CODE.getCode())){
                            emrOutpatientRecord.setWmDiagnosisCode(outpMr.getDiagnosisCodeMz1());
                            emrOutpatientRecord.setWmDiagnosisName(outpMr.getDiagnosisMz1());
                        }else {
                            emrOutpatientRecord.setWmDiagnosisCode(dictDiseaseIcd10.getHubCode());
                            emrOutpatientRecord.setWmDiagnosisName(dictDiseaseIcd10.getHubName());
                        }
                        if (StringUtils.isNotBlank(outpMr.getDiagnosisCodeMz2())){
                            DictDiseaseIcd10 dictDiseaseIcd102 = dictDiseaseIcd10Mapper.selectByEmrCode(outpMr.getDiagnosisCodeMz2());
                            if(dictDiseaseIcd102 == null || dictDiseaseIcd102.getHubCode().equals(HubCodeEnum.DISEASE_ICD10_CODE.getCode())){
                                emrOutpatientRecord.setWmDiagnosisCode(emrOutpatientRecord.getWmDiagnosisCode() + "||" + outpMr.getDiagnosisCodeMz2());
                                emrOutpatientRecord.setWmDiagnosisName(emrOutpatientRecord.getWmDiagnosisName() + "||" + outpMr.getDiagnosisMz2());
                            }else {
                                emrOutpatientRecord.setWmDiagnosisCode(emrOutpatientRecord.getWmDiagnosisCode() + "||" + dictDiseaseIcd102.getHubCode());
                                emrOutpatientRecord.setWmDiagnosisName(emrOutpatientRecord.getWmDiagnosisName() + "||" + dictDiseaseIcd102.getHubName());
                            }
                        }
                    }
                }
//                emrOutpatientRecord.setTreatment(outpMr.getAdvice());

                PatMasterIndex patMasterIndex = medrecResult.getData();
                emrOutpatientRecord.setPatientName(patMasterIndex.getName());
                if (StringUtils.isBlank(patMasterIndex.getIdNo())){
                    emrOutpatientRecord.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE_OTHER.getCode());
                    emrOutpatientRecord.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE_OTHER.getName());
                    emrOutpatientRecord.setIdCard("-");
                }else {
                    emrOutpatientRecord.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE.getCode());
                    emrOutpatientRecord.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE.getName());
                    emrOutpatientRecord.setIdCard(patMasterIndex.getIdNo());
                }

                ClinicMaster clinicMaster = outpadmResult.getData();
                DictDisDept dictDisDept = hubToolService.getDept(clinicMaster.getVisitDept());

                // 查询操作员ID
                if (StringUtils.isBlank(emrOutpatientRecord.getOperatorId())){
                    R<Users> user = commFeignClient.getUserByName(outpMr.getDoctor());
                    if (R.SUCCESS == user.getCode() && user.getData() != null){
                        doctor = user.getData();
                        emrOutpatientRecord.setOperatorId(doctor.getUserId());
                    }
                }
                if(StringUtils.isBlank(emrOutpatientRecord.getOperatorId())){
                    OutpWaitQueue queue = new OutpWaitQueue();
                    queue.setVisitDateStr(DateUtils.dateTime(outpMr.getVisitDate()));
                    queue.setVisitNo(Integer.valueOf(outpMr.getVisitNo()));
                    R<OutpWaitQueue> outpWaitQueueResult = outpdoctFeignClient.getOutpWaitQueueByCondition(queue);
                    if (outpWaitQueueResult.getCode() == R.SUCCESS && outpWaitQueueResult.getData() != null){
                        R<Users> user = commFeignClient.getUserByName(outpWaitQueueResult.getData().getDoctor());
                        if (R.SUCCESS == user.getCode() && user.getData() != null){
                            doctor = user.getData();
                            emrOutpatientRecord.setOperatorId(doctor.getUserId());
                        }
                    }
                }

                emrOutpatientRecord.setDeptCode(dictDisDept.getHubCode());
                emrOutpatientRecord.setDeptName(dictDisDept.getHubName());

                emrOutpatientRecord.setOrgCode(HubCodeEnum.ORG_CODE.getCode());
                emrOutpatientRecord.setOrgName(HubCodeEnum.ORG_CODE.getName());
                emrOutpatientRecord.setOperationTime(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, DateUtils.getNowDate()));
                synchroEmrMonitorService.syncEmrOutpatientRecord(emrOutpatientRecord, httpMethod);

                logger.debug("构造emrActivityInfo(门诊/急诊)接口数据...");
                EmrActivityInfo emrActivityInfo = new EmrActivityInfo();
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
                emrActivityInfo.setSerialNumber(emrOutpatientRecord.getSerialNumber());
                emrActivityInfo.setActivityTime(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, outpMr.getVisitDate()));
                String idNo = patMasterIndex.getIdNo();
                if (StringUtils.isNotBlank(idNo)) {
                    emrActivityInfo.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE.getCode());
                    emrActivityInfo.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE.getName());
                    emrActivityInfo.setIdCard(idNo);
                } else {
                    emrActivityInfo.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE_OTHER.getCode());
                    emrActivityInfo.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE_OTHER.getName());
                    emrActivityInfo.setIdCard("-");
                }
                emrActivityInfo.setPatientName(patMasterIndex.getName());

                emrActivityInfo.setChiefComplaint(outpMr.getIllnessDesc());
                emrActivityInfo.setPresentIllnessHis(outpMr.getMedHistory());
                emrActivityInfo.setPhysicalExamination(outpMr.getBodyExam());
                emrActivityInfo.setStudiesSummaryResult(outpMr.getAssistExam());
                emrActivityInfo.setDiagnoseTime(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, outpMr.getVisitDate()));

                // 诊断代码
                if (StringUtils.isNotBlank(emrOutpatientRecord.getWmDiagnosisCode())){
                    emrActivityInfo.setWmDiseaseCode(emrOutpatientRecord.getWmDiagnosisCode());
                    emrActivityInfo.setWmDiseaseName(emrOutpatientRecord.getWmDiagnosisName());
                }else {
                    emrActivityInfo.setWmDiseaseCode(HubCodeEnum.DISEASE_ICD10_CODE.getCode());
                    emrActivityInfo.setWmDiseaseName(HubCodeEnum.DISEASE_ICD10_CODE.getName());
                }

                emrActivityInfo.setFillDoctor(doctor.getUserName());

                emrActivityInfo.setDeptCode(dictDisDept.getHubCode());
                emrActivityInfo.setDeptName(dictDisDept.getHubName());

                emrActivityInfo.setOrgCode(HubCodeEnum.ORG_CODE.getCode());
                emrActivityInfo.setOrgName(HubCodeEnum.ORG_CODE.getName());
                emrActivityInfo.setOperationTime(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, DateUtils.getNowDate()));
                emrActivityInfo.setOperatorId(emrOutpatientRecord.getOperatorId());
                if (StringUtils.isBlank(emrOutpatientRecord.getOperatorId())){
                    emrActivityInfo.setOperatorId("-");
                }
                synchroEmrRealService.syncEmrActivityInfo(emrActivityInfo, httpMethod);
            }else {
                logger.error("{}对应PatMasterIndex信息或ClinicMaster信息为空，无法同步", outpMr.getPatientId());
            }
        }else {
            logger.error("patientId为空，无法同步");
        }
    }
}
