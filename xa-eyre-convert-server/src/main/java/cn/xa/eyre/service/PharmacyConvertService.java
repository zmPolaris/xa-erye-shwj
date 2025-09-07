package cn.xa.eyre.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.xa.eyre.comm.domain.Users;
import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.core.domain.R;
import cn.xa.eyre.common.core.kafka.DBMessage;
import cn.xa.eyre.common.utils.DateUtils;
import cn.xa.eyre.common.utils.StringUtils;
import cn.xa.eyre.common.utils.bean.BeanUtils;
import cn.xa.eyre.hisapi.*;
import cn.xa.eyre.hub.domain.emrmonitor.EmrOrder;
import cn.xa.eyre.hub.domain.emrmonitor.EmrOrderItem;
import cn.xa.eyre.hub.domain.emrreal.EmrActivityInfo;
import cn.xa.eyre.hub.service.SynchroEmrMonitorService;
import cn.xa.eyre.hub.service.SynchroEmrRealService;
import cn.xa.eyre.hub.staticvalue.HubCodeEnum;
import cn.xa.eyre.inpadm.domain.PatsInHospital;
import cn.xa.eyre.medrec.domain.PatMasterIndex;
import cn.xa.eyre.ordadm.domain.Orders;
import cn.xa.eyre.outpdoct.domain.OutpMr;
import cn.xa.eyre.pharmacy.domain.DrugPrescDetail;
import cn.xa.eyre.pharmacy.domain.DrugPrescMaster;
import cn.xa.eyre.system.dict.domain.DictDisDept;
import cn.xa.eyre.system.dict.domain.DictDiseaseIcd10;
import cn.xa.eyre.system.dict.domain.DictDrugType;
import cn.xa.eyre.system.dict.mapper.DictDisDeptMapper;
import cn.xa.eyre.system.dict.mapper.DictDrugTypeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PharmacyConvertService {

    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    SynchroEmrRealService synchroEmrRealService;
    @Autowired
    DictDrugTypeMapper dictDrugTypeMapper;
    @Autowired
    SynchroEmrMonitorService synchroEmrMonitorService;
    @Autowired
    private OutpdoctFeignClient outpdoctFeignClient;
    @Autowired
    private InpadmFeignClient inpadmFeignClient;
    @Autowired
    private DictDisDeptMapper dictDisDeptMapper;
    @Autowired
    private MedrecFeignClient medrecFeignClient;
    @Autowired
    private CommFeignClient commFeignClient;
    @Autowired
    private PharmacyFeignClient pharmacyFeignClient;
    @Autowired
    private HubToolService hubToolService;

    public static void main(String[] args) {
        long epochMilli = 1755613113000L;
        Date date = new Date(epochMilli);
        System.out.println(date);
        String prescDateStr = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD, date);
        System.out.println("prescDateStr:{}" + prescDateStr);
    }

    public void drugPrescMaster(DBMessage dbMessage) {
        logger.debug("药品处方主记录DRUG_PRESC_MASTER变更接口");
        logger.debug("DRUG_PRESC_MASTER变更需调用emrOrder, emrOrderItem同步接口");

        String httpMethod = null;
        DrugPrescMaster drugPrescMaster;
        Map<String, String> data;
        if (dbMessage.getOperation().equalsIgnoreCase("DELETE")) {
            httpMethod = Constants.HTTP_METHOD_DELETE;
            data = dbMessage.getBeforeData();
        } else {
            httpMethod = Constants.HTTP_METHOD_POST;
            data = dbMessage.getAfterData();
        }
//        drugPrescMaster = BeanUtil.toBeanIgnoreError(data, DrugPrescMaster.class);
//        drugPrescMaster.setPrescDate(DateUtils.getLongDate(data.get("prescDate")));
        try {
            drugPrescMaster = BeanUtils.mapToObject(data, DrugPrescMaster.class);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        // 反查数据

        EmrOrder emrOrder = new EmrOrder();
        String id = DigestUtil.md5Hex(DateUtils.dateTime(drugPrescMaster.getPrescDate()) + drugPrescMaster.getPrescNo());
        emrOrder.setId(id);
        String patientId = drugPrescMaster.getPatientId();
        R<PatMasterIndex> medrecResult = medrecFeignClient.getPatMasterIndex(patientId);
        if (R.SUCCESS == medrecResult.getCode()) {
            // 更新推送患者信息
            hubToolService.syncPatInfo(medrecResult.getData());
            PatMasterIndex patMasterIndex = medrecResult.getData();
            emrOrder.setPatientId(patientId);
            Short prescSource = drugPrescMaster.getPrescSource();
            String preNo = "";
            if (prescSource == 0) {
                // 门诊
                emrOrder.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_OUTPATIENT.getName());
                emrOrder.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_OUTPATIENT.getCode());
                OutpMr outpMr = new OutpMr();
                outpMr.setPatientId(patientId);
                outpMr.setVisitDateStr(DateUtils.dateTime(drugPrescMaster.getPrescDate()));
                R<List<OutpMr>> mrResult = outpdoctFeignClient.getOutpMrByCondition(outpMr);
                if (R.SUCCESS == mrResult.getCode()) {
                    outpMr = mrResult.getData().get(0);
                    emrOrder.setSerialNumber(DigestUtil.md5Hex(patientId + outpMr.getVisitNo()));
                } else {
                    emrOrder.setSerialNumber(DigestUtil.md5Hex(patientId + drugPrescMaster.getPrescNo()+ drugPrescMaster.getPrescDate()));
                }
                preNo = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, drugPrescMaster.getPrescDate()) + drugPrescMaster.getPrescNo();

            } else {
                // 住院
                emrOrder.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_HOSPITALIZATION.getName());
                emrOrder.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_HOSPITALIZATION.getCode());
                R<PatsInHospital> hospitalResult = inpadmFeignClient.getPatsInHospitalByPatientId(patientId);
                if (R.SUCCESS == hospitalResult.getCode()) {
                    PatsInHospital pats = hospitalResult.getData();
                    emrOrder.setSerialNumber(DigestUtil.md5Hex(patientId + pats.getVisitId()));
                }else {
                    emrOrder.setSerialNumber(DigestUtil.md5Hex(patientId + drugPrescMaster.getPrescNo()+ drugPrescMaster.getPrescDate()));
                }
                preNo = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD, drugPrescMaster.getPrescDate()) + drugPrescMaster.getPrescNo();
            }
            emrOrder.setPatientName(drugPrescMaster.getName());
            emrOrder.setIdCardTypeCode(HubCodeEnum.ID_CARD_TYPE.getCode());
            emrOrder.setIdCardTypeName(HubCodeEnum.ID_CARD_TYPE.getName());
            emrOrder.setIdCard(patMasterIndex.getIdNo());
            emrOrder.setPrescriptionNo(preNo);
            Short prescType = drugPrescMaster.getPrescType();
            if (prescType == 0) {
                emrOrder.setPrescriptionTypeCode("0");
            } else if (prescType == 1) {
                emrOrder.setPrescriptionTypeCode("1");
            }
            emrOrder.setPrescriptionIssuanceDate(drugPrescMaster.getPrescDate());
            R<Users> user = commFeignClient.getUserByName(drugPrescMaster.getPrescribedBy());
            if (R.SUCCESS == user.getCode() && user.getData() != null) {
                emrOrder.setPrescriptionIssuanceId(user.getData().getUserId());
            }
            user = commFeignClient.getUserByName(drugPrescMaster.getDispensingProvider());
            if (R.SUCCESS == user.getCode() && user.getData() != null) {
                emrOrder.setPrescriptionDispensingId(user.getData().getUserId());
            }
            DictDisDept dictDisDept = hubToolService.getDept(drugPrescMaster.getOrderedBy());

            emrOrder.setDeptCode(dictDisDept.getHubCode());
            emrOrder.setDeptName(dictDisDept.getHubName());

            emrOrder.setOrgCode(HubCodeEnum.ORG_CODE.getCode());
            emrOrder.setOrgName(HubCodeEnum.ORG_CODE.getName());

            emrOrder.setOperationTime(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD, DateUtils.getNowDate()));
            emrOrder.setOperatorId(emrOrder.getPrescriptionIssuanceId());
            synchroEmrMonitorService.syncEmrOrder(emrOrder, httpMethod);

//                logger.debug("构造emrActivityInfo(首次病程)接口数据...");
//                EmrActivityInfo emrActivityInfo = new EmrActivityInfo();
//                emrActivityInfo.setId(id);
//                emrActivityInfo.setPatientId(emrOrder.getPatientId());
//                emrActivityInfo.setActivityTypeCode(HubCodeEnum.DIAGNOSIS_ACTIVITIES_FIRST_COURSE.getCode());
//                emrActivityInfo.setActivityTypeName(HubCodeEnum.DIAGNOSIS_ACTIVITIES_FIRST_COURSE.getName());
//                emrActivityInfo.setSerialNumber(emrOrder.getSerialNumber());
//                emrActivityInfo.setActivityTime(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD, drugPrescMaster.getPrescDate()));
//                emrActivityInfo.setIdCardTypeCode(emrOrder.getIdCardTypeCode());
//                emrActivityInfo.setIdCardTypeName(emrOrder.getIdCardTypeName());
//                emrActivityInfo.setIdCard(emrOrder.getIdCard());
//                emrActivityInfo.setPatientName(emrOrder.getPatientName());
//                emrActivityInfo.setDiagnoseTime(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD, drugPrescMaster.getPrescDate()));
//                emrActivityInfo.setWmDiseaseCode("-");
//                emrActivityInfo.setWmDiseaseName("-");
//                emrActivityInfo.setFillDoctor(drugPrescMaster.getPrescribedBy());
//                emrActivityInfo.setOperatorId(emrOrder.getOperatorId());
//                emrActivityInfo.setDeptCode(emrOrder.getDeptCode());
//                emrActivityInfo.setDeptName(emrOrder.getDeptName());
//                emrActivityInfo.setOrgCode(emrOrder.getOrgCode());
//                emrActivityInfo.setOrgName(emrOrder.getOrgName());
//                emrActivityInfo.setOperationTime(HubCodeEnum.DIAGNOSIS_ACTIVITIES_FIRST_COURSE.getCode());
//                synchroEmrRealService.syncEmrActivityInfo(emrActivityInfo, httpMethod);

            logger.debug("构造emrOrderItem接口数据...");
            DrugPrescDetail drugPrescDetail = new DrugPrescDetail();
            drugPrescDetail.setPrescNo(drugPrescMaster.getPrescNo());
            drugPrescDetail.setPrescDate(drugPrescMaster.getPrescDate());
//                R<List<DrugPrescDetail>> details = pharmacyFeignClient.getDrugPrescDetailByVisitInfo(drugPrescDetail);
            R<List<DrugPrescDetail>> details = pharmacyFeignClient.getDrugPrescDetailByPrescNo(drugPrescDetail);
            if (details.getCode() == R.SUCCESS && details.getData() != null) {
                for (DrugPrescDetail prescDetail : details.getData()) {
                    String drugCode = prescDetail.getDrugCode();
                    EmrOrderItem emrOrderItem = new EmrOrderItem();
                    id = DigestUtil.md5Hex(DateUtils.dateTime(prescDetail.getPrescDate()) + prescDetail.getPrescNo() + prescDetail.getItemNo());
                    emrOrderItem.setId(id);
                    emrOrderItem.setOrderId(emrOrder.getId());
                    emrOrderItem.setDrugSpecifications(prescDetail.getDrugSpec());
                    emrOrderItem.setOperatorId(emrOrder.getOperatorId());
                    emrOrderItem.setOperationTime(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD, DateUtils.getNowDate()));
                    DictDrugType drugType = dictDrugTypeMapper.selectByEmrCode(drugCode);
                    if (StringUtils.isNotBlank(drugType.getHubCode())) {
                        emrOrderItem.setDrugCode(drugType.getHubCode());
                        emrOrderItem.setDrugName(drugType.getHubName());
                    } else {
                        emrOrderItem.setDrugCode(drugCode);
                        emrOrderItem.setDrugName(prescDetail.getDrugName());
                    }
                    synchroEmrMonitorService.syncEmrOrderItem(emrOrderItem, Constants.HTTP_METHOD_POST);
                }

            }

        } else {
            logger.error("{}对应PatMasterIndex信息信息为空，无法同步", patientId);
        }
    }
}
