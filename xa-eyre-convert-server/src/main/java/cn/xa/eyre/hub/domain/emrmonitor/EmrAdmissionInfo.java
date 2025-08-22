package cn.xa.eyre.hub.domain.emrmonitor;

import java.util.Date;

import cn.xa.eyre.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 入院记录——对象 emr_admission_info
 *
 * @author ruoyi
 * @date 2025-06-11
 */
public class EmrAdmissionInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 患者基本信息ID */
    private String patientId;

    /** 住院号 */
    private String serialNumber;

    /** 病区名称 */
    private String wardName;

    /** 病房号 */
    private String wardNo;

    /** 病床号 */
    private String bedNo;

    /** 患者姓名 */
    private String patientName;

    /** 身份证件类别 */
    private String idCardTypeCode;

    /** 身份证件类别（注意：此处可能存在字段重复，需确认是否保留两个相同意义的字段） */
    private String idCardTypeName;

    /** 身份证件号 */
    private String idCard;

    /** 入院日期时间 */
    private String admissionDate;

    /** 主诉 */
    private String chiefComplaint;

    /** 现病史 */
    private String presentIllnessHis;

    /** 一般健康状况标志 */
    private String healthStatusCode;

    /** 疾病史(含外伤） */
    private String pastIllnessHis;

    /** 患者传染性标志 */
    private String infectionCode;

    /** 传染病史 */
    private String infectionHis;

    /** 预防接种史 */
    private String vaccinationHis;

    /** 手术史 */
    private String operationHis;

    /** 输血史 */
    private String bloodTransfusion;

    /** 过敏史 */
    private String allergyHis;

    /** 个人史 */
    private String personalHis;

    /** 婚育史 */
    private String maritalHis;

    /** 月经史 */
    private String menstrualHis;

    /** 家族史 */
    private String familyHis;

    /** 体格检查 */
    private String physicalExamination;

    /** 专科情况 */
    private String specializedExamination;

    /** 辅助检查 */
    private String studiesSummaryResult;

    /** 中医“四诊”观察结果 */
    private String observationResult;

    /** 治则治法 */
    private String treatment;

    /** 初步诊断-西医诊断 */
    private String wmInitalDiagnosisName;

    /** 初步诊断-西医诊断编码（注意：此处可能存在字段意义重复，需确认是否保留两个相同意义的字段，或是否应为不同的编码） */
    private String wmInitalDiagnosisCode;

    /** 初步诊断-中医病名名称 */
    private String tcmInitalDiagnosisName;

    /** 初步诊断-中医病名代码 */
    private String tcmInitalDiagnosisCode;

    /** 初步诊断-中医证候名称 */
    private String tcmInitalSyndromeName;

    /** 初步诊断-中医证候代码 */
    private String tcmInitalSyndromeCode;

    /** 初步诊断日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date initalDiagnosisDate;

    /** 修正诊断-西医诊断 */
    private String wmRevisedDiagnosisName;

    /** 修正诊断-西医诊断编码 */
    private String wmRevisedDiagnosisCode;

    /** 修正诊断-中医病名名称 */
    private String tcmRevisedDiagnosisName;

    /** 修正诊断-中医病名代码 */
    private String tcmRevisedDiagnosisCode;

    /** 修正诊断-中医证候名称 */
    private String tcmRevisedSyndromeName;

    /** 修正诊断-中医证候代码 */
    private String tcmRevisedSyndromeCode;

    /** 修正诊断日期 */
    private String revisedDiagnosisDate;

    /** 确定诊断-西医诊断 */
    private String wmConfirmedDiagnosisName;

    /** 确定诊断-西医诊断编码 */
    private String wmConfirmedDiagnosisCode;

    /** 确定诊断-中医病名名称 */
    private String tcmConfirmedDiagnosisName;

    /** 确定诊断-中医病名代码 */
    private String tcmConfirmedDiagnosisCode;

    /** 确定诊断-中医证候名称 */
    private String tcmConfirmedSyndromeName;

    /** 确定诊断-中医证候代码 */
    private String tcmConfirmedSyndromeCode;

    /** 确定诊断日期 */
    private String confirmedDiagnosisDate;

    /** 补充诊断名称 */
    private String complementaryDiagnosisName;

    /** 补充诊断编码 */
    private String complementaryDiagnosisCode;

    /** 补充诊断日期 */
    private String complementaryDiagnosisDate;

    /** 入院诊断顺位 */
    private String admissionDiagnosisOrder;

    /** 接诊医师ID */
    private String visitingPhysicianId;

    /** 住院医师ID */
    private String residentPhysicianId;

    /** 主治医师ID */
    private String chiefPhysicianId;

    /** 医疗机构编码 */
    private String orgCode;

    /** 医疗机构名称（注意：此处可能存在字段意义重复，需确认是否保留两个相同意义的字段，或org_code是否应为其他含义） */
    private String orgName;

    /** 科室编码 */
    private String deptCode;

    /** 科室名称 */
    private String deptName;

    /** 操作人ID */
    private String operatorId;

    /** 操作时间 */
    private String operationTime;

    /** 作废标志 */
    private String invalidFlag;

    /** 数据状态 0 未传输 1已传输 */
    private String dataStatus;

    /** 入库日期 */
    private String createDate;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setPatientId(String patientId)
    {
        this.patientId = patientId;
    }

    public String getPatientId()
    {
        return patientId;
    }
    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber()
    {
        return serialNumber;
    }
    public void setWardName(String wardName)
    {
        this.wardName = wardName;
    }

    public String getWardName()
    {
        return wardName;
    }
    public void setWardNo(String wardNo)
    {
        this.wardNo = wardNo;
    }

    public String getWardNo()
    {
        return wardNo;
    }
    public void setBedNo(String bedNo)
    {
        this.bedNo = bedNo;
    }

    public String getBedNo()
    {
        return bedNo;
    }
    public void setPatientName(String patientName)
    {
        this.patientName = patientName;
    }

    public String getPatientName()
    {
        return patientName;
    }
    public void setIdCardTypeCode(String idCardTypeCode)
    {
        this.idCardTypeCode = idCardTypeCode;
    }

    public String getIdCardTypeCode()
    {
        return idCardTypeCode;
    }
    public void setIdCardTypeName(String idCardTypeName)
    {
        this.idCardTypeName = idCardTypeName;
    }

    public String getIdCardTypeName()
    {
        return idCardTypeName;
    }
    public void setIdCard(String idCard)
    {
        this.idCard = idCard;
    }

    public String getIdCard()
    {
        return idCard;
    }
    public void setAdmissionDate(String admissionDate)
    {
        this.admissionDate = admissionDate;
    }

    public String getAdmissionDate()
    {
        return admissionDate;
    }
    public void setChiefComplaint(String chiefComplaint)
    {
        this.chiefComplaint = chiefComplaint;
    }

    public String getChiefComplaint()
    {
        return chiefComplaint;
    }
    public void setPresentIllnessHis(String presentIllnessHis)
    {
        this.presentIllnessHis = presentIllnessHis;
    }

    public String getPresentIllnessHis()
    {
        return presentIllnessHis;
    }
    public void setHealthStatusCode(String healthStatusCode)
    {
        this.healthStatusCode = healthStatusCode;
    }

    public String getHealthStatusCode()
    {
        return healthStatusCode;
    }
    public void setPastIllnessHis(String pastIllnessHis)
    {
        this.pastIllnessHis = pastIllnessHis;
    }

    public String getPastIllnessHis()
    {
        return pastIllnessHis;
    }
    public void setInfectionCode(String infectionCode)
    {
        this.infectionCode = infectionCode;
    }

    public String getInfectionCode()
    {
        return infectionCode;
    }
    public void setInfectionHis(String infectionHis)
    {
        this.infectionHis = infectionHis;
    }

    public String getInfectionHis()
    {
        return infectionHis;
    }
    public void setVaccinationHis(String vaccinationHis)
    {
        this.vaccinationHis = vaccinationHis;
    }

    public String getVaccinationHis()
    {
        return vaccinationHis;
    }
    public void setOperationHis(String operationHis)
    {
        this.operationHis = operationHis;
    }

    public String getOperationHis()
    {
        return operationHis;
    }
    public void setBloodTransfusion(String bloodTransfusion)
    {
        this.bloodTransfusion = bloodTransfusion;
    }

    public String getBloodTransfusion()
    {
        return bloodTransfusion;
    }
    public void setAllergyHis(String allergyHis)
    {
        this.allergyHis = allergyHis;
    }

    public String getAllergyHis()
    {
        return allergyHis;
    }
    public void setPersonalHis(String personalHis)
    {
        this.personalHis = personalHis;
    }

    public String getPersonalHis()
    {
        return personalHis;
    }
    public void setMaritalHis(String maritalHis)
    {
        this.maritalHis = maritalHis;
    }

    public String getMaritalHis()
    {
        return maritalHis;
    }
    public void setMenstrualHis(String menstrualHis)
    {
        this.menstrualHis = menstrualHis;
    }

    public String getMenstrualHis()
    {
        return menstrualHis;
    }
    public void setFamilyHis(String familyHis)
    {
        this.familyHis = familyHis;
    }

    public String getFamilyHis()
    {
        return familyHis;
    }
    public void setPhysicalExamination(String physicalExamination)
    {
        this.physicalExamination = physicalExamination;
    }

    public String getPhysicalExamination()
    {
        return physicalExamination;
    }
    public void setSpecializedExamination(String specializedExamination)
    {
        this.specializedExamination = specializedExamination;
    }

    public String getSpecializedExamination()
    {
        return specializedExamination;
    }
    public void setStudiesSummaryResult(String studiesSummaryResult)
    {
        this.studiesSummaryResult = studiesSummaryResult;
    }

    public String getStudiesSummaryResult()
    {
        return studiesSummaryResult;
    }
    public void setObservationResult(String observationResult)
    {
        this.observationResult = observationResult;
    }

    public String getObservationResult()
    {
        return observationResult;
    }
    public void setTreatment(String treatment)
    {
        this.treatment = treatment;
    }

    public String getTreatment()
    {
        return treatment;
    }
    public void setWmInitalDiagnosisName(String wmInitalDiagnosisName)
    {
        this.wmInitalDiagnosisName = wmInitalDiagnosisName;
    }

    public String getWmInitalDiagnosisName()
    {
        return wmInitalDiagnosisName;
    }
    public void setWmInitalDiagnosisCode(String wmInitalDiagnosisCode)
    {
        this.wmInitalDiagnosisCode = wmInitalDiagnosisCode;
    }

    public String getWmInitalDiagnosisCode()
    {
        return wmInitalDiagnosisCode;
    }
    public void setTcmInitalDiagnosisName(String tcmInitalDiagnosisName)
    {
        this.tcmInitalDiagnosisName = tcmInitalDiagnosisName;
    }

    public String getTcmInitalDiagnosisName()
    {
        return tcmInitalDiagnosisName;
    }
    public void setTcmInitalDiagnosisCode(String tcmInitalDiagnosisCode)
    {
        this.tcmInitalDiagnosisCode = tcmInitalDiagnosisCode;
    }

    public String getTcmInitalDiagnosisCode()
    {
        return tcmInitalDiagnosisCode;
    }
    public void setTcmInitalSyndromeName(String tcmInitalSyndromeName)
    {
        this.tcmInitalSyndromeName = tcmInitalSyndromeName;
    }

    public String getTcmInitalSyndromeName()
    {
        return tcmInitalSyndromeName;
    }
    public void setTcmInitalSyndromeCode(String tcmInitalSyndromeCode)
    {
        this.tcmInitalSyndromeCode = tcmInitalSyndromeCode;
    }

    public String getTcmInitalSyndromeCode()
    {
        return tcmInitalSyndromeCode;
    }
    public void setInitalDiagnosisDate(Date initalDiagnosisDate)
    {
        this.initalDiagnosisDate = initalDiagnosisDate;
    }

    public Date getInitalDiagnosisDate()
    {
        return initalDiagnosisDate;
    }
    public void setWmRevisedDiagnosisName(String wmRevisedDiagnosisName)
    {
        this.wmRevisedDiagnosisName = wmRevisedDiagnosisName;
    }

    public String getWmRevisedDiagnosisName()
    {
        return wmRevisedDiagnosisName;
    }
    public void setWmRevisedDiagnosisCode(String wmRevisedDiagnosisCode)
    {
        this.wmRevisedDiagnosisCode = wmRevisedDiagnosisCode;
    }

    public String getWmRevisedDiagnosisCode()
    {
        return wmRevisedDiagnosisCode;
    }
    public void setTcmRevisedDiagnosisName(String tcmRevisedDiagnosisName)
    {
        this.tcmRevisedDiagnosisName = tcmRevisedDiagnosisName;
    }

    public String getTcmRevisedDiagnosisName()
    {
        return tcmRevisedDiagnosisName;
    }
    public void setTcmRevisedDiagnosisCode(String tcmRevisedDiagnosisCode)
    {
        this.tcmRevisedDiagnosisCode = tcmRevisedDiagnosisCode;
    }

    public String getTcmRevisedDiagnosisCode()
    {
        return tcmRevisedDiagnosisCode;
    }
    public void setTcmRevisedSyndromeName(String tcmRevisedSyndromeName)
    {
        this.tcmRevisedSyndromeName = tcmRevisedSyndromeName;
    }

    public String getTcmRevisedSyndromeName()
    {
        return tcmRevisedSyndromeName;
    }
    public void setTcmRevisedSyndromeCode(String tcmRevisedSyndromeCode)
    {
        this.tcmRevisedSyndromeCode = tcmRevisedSyndromeCode;
    }

    public String getTcmRevisedSyndromeCode()
    {
        return tcmRevisedSyndromeCode;
    }
    public void setRevisedDiagnosisDate(String revisedDiagnosisDate)
    {
        this.revisedDiagnosisDate = revisedDiagnosisDate;
    }

    public String getRevisedDiagnosisDate()
    {
        return revisedDiagnosisDate;
    }
    public void setWmConfirmedDiagnosisName(String wmConfirmedDiagnosisName)
    {
        this.wmConfirmedDiagnosisName = wmConfirmedDiagnosisName;
    }

    public String getWmConfirmedDiagnosisName()
    {
        return wmConfirmedDiagnosisName;
    }
    public void setWmConfirmedDiagnosisCode(String wmConfirmedDiagnosisCode)
    {
        this.wmConfirmedDiagnosisCode = wmConfirmedDiagnosisCode;
    }

    public String getWmConfirmedDiagnosisCode()
    {
        return wmConfirmedDiagnosisCode;
    }
    public void setTcmConfirmedDiagnosisName(String tcmConfirmedDiagnosisName)
    {
        this.tcmConfirmedDiagnosisName = tcmConfirmedDiagnosisName;
    }

    public String getTcmConfirmedDiagnosisName()
    {
        return tcmConfirmedDiagnosisName;
    }
    public void setTcmConfirmedDiagnosisCode(String tcmConfirmedDiagnosisCode)
    {
        this.tcmConfirmedDiagnosisCode = tcmConfirmedDiagnosisCode;
    }

    public String getTcmConfirmedDiagnosisCode()
    {
        return tcmConfirmedDiagnosisCode;
    }
    public void setTcmConfirmedSyndromeName(String tcmConfirmedSyndromeName)
    {
        this.tcmConfirmedSyndromeName = tcmConfirmedSyndromeName;
    }

    public String getTcmConfirmedSyndromeName()
    {
        return tcmConfirmedSyndromeName;
    }
    public void setTcmConfirmedSyndromeCode(String tcmConfirmedSyndromeCode)
    {
        this.tcmConfirmedSyndromeCode = tcmConfirmedSyndromeCode;
    }

    public String getTcmConfirmedSyndromeCode()
    {
        return tcmConfirmedSyndromeCode;
    }
    public void setConfirmedDiagnosisDate(String confirmedDiagnosisDate)
    {
        this.confirmedDiagnosisDate = confirmedDiagnosisDate;
    }

    public String getConfirmedDiagnosisDate()
    {
        return confirmedDiagnosisDate;
    }
    public void setComplementaryDiagnosisName(String complementaryDiagnosisName)
    {
        this.complementaryDiagnosisName = complementaryDiagnosisName;
    }

    public String getComplementaryDiagnosisName()
    {
        return complementaryDiagnosisName;
    }
    public void setComplementaryDiagnosisCode(String complementaryDiagnosisCode)
    {
        this.complementaryDiagnosisCode = complementaryDiagnosisCode;
    }

    public String getComplementaryDiagnosisCode()
    {
        return complementaryDiagnosisCode;
    }
    public void setComplementaryDiagnosisDate(String complementaryDiagnosisDate)
    {
        this.complementaryDiagnosisDate = complementaryDiagnosisDate;
    }

    public String getComplementaryDiagnosisDate()
    {
        return complementaryDiagnosisDate;
    }
    public void setAdmissionDiagnosisOrder(String admissionDiagnosisOrder)
    {
        this.admissionDiagnosisOrder = admissionDiagnosisOrder;
    }

    public String getAdmissionDiagnosisOrder()
    {
        return admissionDiagnosisOrder;
    }
    public void setVisitingPhysicianId(String visitingPhysicianId)
    {
        this.visitingPhysicianId = visitingPhysicianId;
    }

    public String getVisitingPhysicianId()
    {
        return visitingPhysicianId;
    }
    public void setResidentPhysicianId(String residentPhysicianId)
    {
        this.residentPhysicianId = residentPhysicianId;
    }

    public String getResidentPhysicianId()
    {
        return residentPhysicianId;
    }
    public void setChiefPhysicianId(String chiefPhysicianId)
    {
        this.chiefPhysicianId = chiefPhysicianId;
    }

    public String getChiefPhysicianId()
    {
        return chiefPhysicianId;
    }
    public void setOrgCode(String orgCode)
    {
        this.orgCode = orgCode;
    }

    public String getOrgCode()
    {
        return orgCode;
    }
    public void setOrgName(String orgName)
    {
        this.orgName = orgName;
    }

    public String getOrgName()
    {
        return orgName;
    }
    public void setDeptCode(String deptCode)
    {
        this.deptCode = deptCode;
    }

    public String getDeptCode()
    {
        return deptCode;
    }
    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    public String getDeptName()
    {
        return deptName;
    }
    public void setOperatorId(String operatorId)
    {
        this.operatorId = operatorId;
    }

    public String getOperatorId()
    {
        return operatorId;
    }
    public void setOperationTime(String operationTime)
    {
        this.operationTime = operationTime;
    }

    public String getOperationTime()
    {
        return operationTime;
    }
    public void setInvalidFlag(String invalidFlag)
    {
        this.invalidFlag = invalidFlag;
    }

    public String getInvalidFlag()
    {
        return invalidFlag;
    }
    public void setDataStatus(String dataStatus)
    {
        this.dataStatus = dataStatus;
    }

    public String getDataStatus()
    {
        return dataStatus;
    }
    public void setCreateDate(String createDate)
    {
        this.createDate = createDate;
    }

    public String getCreateDate()
    {
        return createDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("patientId", getPatientId())
                .append("serialNumber", getSerialNumber())
                .append("wardName", getWardName())
                .append("wardNo", getWardNo())
                .append("bedNo", getBedNo())
                .append("patientName", getPatientName())
                .append("idCardTypeCode", getIdCardTypeCode())
                .append("idCardTypeName", getIdCardTypeName())
                .append("idCard", getIdCard())
                .append("admissionDate", getAdmissionDate())
                .append("chiefComplaint", getChiefComplaint())
                .append("presentIllnessHis", getPresentIllnessHis())
                .append("healthStatusCode", getHealthStatusCode())
                .append("pastIllnessHis", getPastIllnessHis())
                .append("infectionCode", getInfectionCode())
                .append("infectionHis", getInfectionHis())
                .append("vaccinationHis", getVaccinationHis())
                .append("operationHis", getOperationHis())
                .append("bloodTransfusion", getBloodTransfusion())
                .append("allergyHis", getAllergyHis())
                .append("personalHis", getPersonalHis())
                .append("maritalHis", getMaritalHis())
                .append("menstrualHis", getMenstrualHis())
                .append("familyHis", getFamilyHis())
                .append("physicalExamination", getPhysicalExamination())
                .append("specializedExamination", getSpecializedExamination())
                .append("studiesSummaryResult", getStudiesSummaryResult())
                .append("observationResult", getObservationResult())
                .append("treatment", getTreatment())
                .append("wmInitalDiagnosisName", getWmInitalDiagnosisName())
                .append("wmInitalDiagnosisCode", getWmInitalDiagnosisCode())
                .append("tcmInitalDiagnosisName", getTcmInitalDiagnosisName())
                .append("tcmInitalDiagnosisCode", getTcmInitalDiagnosisCode())
                .append("tcmInitalSyndromeName", getTcmInitalSyndromeName())
                .append("tcmInitalSyndromeCode", getTcmInitalSyndromeCode())
                .append("initalDiagnosisDate", getInitalDiagnosisDate())
                .append("wmRevisedDiagnosisName", getWmRevisedDiagnosisName())
                .append("wmRevisedDiagnosisCode", getWmRevisedDiagnosisCode())
                .append("tcmRevisedDiagnosisName", getTcmRevisedDiagnosisName())
                .append("tcmRevisedDiagnosisCode", getTcmRevisedDiagnosisCode())
                .append("tcmRevisedSyndromeName", getTcmRevisedSyndromeName())
                .append("tcmRevisedSyndromeCode", getTcmRevisedSyndromeCode())
                .append("revisedDiagnosisDate", getRevisedDiagnosisDate())
                .append("wmConfirmedDiagnosisName", getWmConfirmedDiagnosisName())
                .append("wmConfirmedDiagnosisCode", getWmConfirmedDiagnosisCode())
                .append("tcmConfirmedDiagnosisName", getTcmConfirmedDiagnosisName())
                .append("tcmConfirmedDiagnosisCode", getTcmConfirmedDiagnosisCode())
                .append("tcmConfirmedSyndromeName", getTcmConfirmedSyndromeName())
                .append("tcmConfirmedSyndromeCode", getTcmConfirmedSyndromeCode())
                .append("confirmedDiagnosisDate", getConfirmedDiagnosisDate())
                .append("complementaryDiagnosisName", getComplementaryDiagnosisName())
                .append("complementaryDiagnosisCode", getComplementaryDiagnosisCode())
                .append("complementaryDiagnosisDate", getComplementaryDiagnosisDate())
                .append("admissionDiagnosisOrder", getAdmissionDiagnosisOrder())
                .append("visitingPhysicianId", getVisitingPhysicianId())
                .append("residentPhysicianId", getResidentPhysicianId())
                .append("chiefPhysicianId", getChiefPhysicianId())
                .append("orgCode", getOrgCode())
                .append("orgName", getOrgName())
                .append("deptCode", getDeptCode())
                .append("deptName", getDeptName())
                .append("operatorId", getOperatorId())
                .append("operationTime", getOperationTime())
                .append("invalidFlag", getInvalidFlag())
                .append("dataStatus", getDataStatus())
                .append("createDate", getCreateDate())
                .toString();
    }
}
