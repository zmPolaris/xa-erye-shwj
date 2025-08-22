package cn.xa.eyre.hub.domain.emrmonitor;

import java.util.Date;

import cn.xa.eyre.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 出院记录对象 emr_discharge_info
 *
 * @author ruoyi
 * @date 2025-06-11
 */
public class EmrDischargeInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 患者基本信息ID */
    private String patientId;

    /** 住院号 */
    private String serialNumber;

    /** 患者姓名 */
    private String patientName;

    /** 身份证件类别 */
    private String idCardTypeCode;

    /** 身份证件类别名称 */
    private String idCardTypeName;

    /** 身份证件号 */
    private String idCard;

    /** 病区名称 */
    private String wardName;

    /** 病房号 */
    private String wardNo;

    /** 病床号 */
    private String bedNo;

    /** 入院日期时间 */
    private String admissionDate;

    /** 入院情况 */
    private String admissionDesc;

    /** 入院诊断编码 */
    private String admissionDiagnosisCode;

    /** 入院诊断名称 */
    private String admissionDiagnosisName;

    /** 阳性辅助检查结果 */
    private String studiesSummaryResult;

    /** 中医“四诊”观察结果 */
    private String observationResult;

    /** 治则治法 */
    private String treatment;

    /** 诊疗过程描述 */
    private String treatmentDesc;

    /** 中药煎煮方法 */
    private String tcmDecoctionMethod;

    /** 中药用药方法 */
    private String tcmUseMethod;

    /** 出院情况 */
    private String dischargeDesc;

    /** 出院日期时间 */
    private String dischargeDate;

    /** 出院诊断-西医诊断 */
    private String dischargeDiagnosisName;

    /** 出院诊断-西医诊断编码 */
    private String dischargeDiagnosisCode;

    /** 出院诊断-中医病名代码 */
    private String tcmDischargeDiagnosisCode;

    /** 出院诊断-中医病名名称 */
    private String tcmDischargeDiagnosisName;

    /** 出院诊断-中医证候代码 */
    private String tcmDischargeSyndromeCode;

    /** 出院诊断-中医证候名称 */
    private String tcmDischargeSyndromeName;

    /** 出院时症状与体征 */
    private String dischargeSymptomsSigns;

    /** 出院医嘱 */
    private String dischargeOrder;

    /** 住院医师ID */
    private String residentPhysicianId;

    /** 主治医师ID */
    private String chiefPhysicianId;

    /** 医疗机构代码 */
    private String orgCode;

    /** 医疗机构名称 */
    private String orgName;

    /** 科室代码 */
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

    /** 病情转归代码 */
    private String diseaseProgressionCode;

    /** 病情转归名称 */
    private String diseaseProgressionName;

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
    public void setAdmissionDate(String admissionDate)
    {
        this.admissionDate = admissionDate;
    }

    public String getAdmissionDate()
    {
        return admissionDate;
    }
    public void setAdmissionDesc(String admissionDesc)
    {
        this.admissionDesc = admissionDesc;
    }

    public String getAdmissionDesc()
    {
        return admissionDesc;
    }
    public void setAdmissionDiagnosisCode(String admissionDiagnosisCode)
    {
        this.admissionDiagnosisCode = admissionDiagnosisCode;
    }

    public String getAdmissionDiagnosisCode()
    {
        return admissionDiagnosisCode;
    }
    public void setAdmissionDiagnosisName(String admissionDiagnosisName)
    {
        this.admissionDiagnosisName = admissionDiagnosisName;
    }

    public String getAdmissionDiagnosisName()
    {
        return admissionDiagnosisName;
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
    public void setTreatmentDesc(String treatmentDesc)
    {
        this.treatmentDesc = treatmentDesc;
    }

    public String getTreatmentDesc()
    {
        return treatmentDesc;
    }
    public void setTcmDecoctionMethod(String tcmDecoctionMethod)
    {
        this.tcmDecoctionMethod = tcmDecoctionMethod;
    }

    public String getTcmDecoctionMethod()
    {
        return tcmDecoctionMethod;
    }
    public void setTcmUseMethod(String tcmUseMethod)
    {
        this.tcmUseMethod = tcmUseMethod;
    }

    public String getTcmUseMethod()
    {
        return tcmUseMethod;
    }
    public void setDischargeDesc(String dischargeDesc)
    {
        this.dischargeDesc = dischargeDesc;
    }

    public String getDischargeDesc()
    {
        return dischargeDesc;
    }
    public void setDischargeDate(String dischargeDate)
    {
        this.dischargeDate = dischargeDate;
    }

    public String getDischargeDate()
    {
        return dischargeDate;
    }
    public void setDischargeDiagnosisName(String dischargeDiagnosisName)
    {
        this.dischargeDiagnosisName = dischargeDiagnosisName;
    }

    public String getDischargeDiagnosisName()
    {
        return dischargeDiagnosisName;
    }
    public void setDischargeDiagnosisCode(String dischargeDiagnosisCode)
    {
        this.dischargeDiagnosisCode = dischargeDiagnosisCode;
    }

    public String getDischargeDiagnosisCode()
    {
        return dischargeDiagnosisCode;
    }
    public void setTcmDischargeDiagnosisCode(String tcmDischargeDiagnosisCode)
    {
        this.tcmDischargeDiagnosisCode = tcmDischargeDiagnosisCode;
    }

    public String getTcmDischargeDiagnosisCode()
    {
        return tcmDischargeDiagnosisCode;
    }
    public void setTcmDischargeDiagnosisName(String tcmDischargeDiagnosisName)
    {
        this.tcmDischargeDiagnosisName = tcmDischargeDiagnosisName;
    }

    public String getTcmDischargeDiagnosisName()
    {
        return tcmDischargeDiagnosisName;
    }
    public void setTcmDischargeSyndromeCode(String tcmDischargeSyndromeCode)
    {
        this.tcmDischargeSyndromeCode = tcmDischargeSyndromeCode;
    }

    public String getTcmDischargeSyndromeCode()
    {
        return tcmDischargeSyndromeCode;
    }
    public void setTcmDischargeSyndromeName(String tcmDischargeSyndromeName)
    {
        this.tcmDischargeSyndromeName = tcmDischargeSyndromeName;
    }

    public String getTcmDischargeSyndromeName()
    {
        return tcmDischargeSyndromeName;
    }
    public void setDischargeSymptomsSigns(String dischargeSymptomsSigns)
    {
        this.dischargeSymptomsSigns = dischargeSymptomsSigns;
    }

    public String getDischargeSymptomsSigns()
    {
        return dischargeSymptomsSigns;
    }
    public void setDischargeOrder(String dischargeOrder)
    {
        this.dischargeOrder = dischargeOrder;
    }

    public String getDischargeOrder()
    {
        return dischargeOrder;
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
    public void setDiseaseProgressionCode(String diseaseProgressionCode)
    {
        this.diseaseProgressionCode = diseaseProgressionCode;
    }

    public String getDiseaseProgressionCode()
    {
        return diseaseProgressionCode;
    }
    public void setDiseaseProgressionName(String diseaseProgressionName)
    {
        this.diseaseProgressionName = diseaseProgressionName;
    }

    public String getDiseaseProgressionName()
    {
        return diseaseProgressionName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("patientId", getPatientId())
                .append("serialNumber", getSerialNumber())
                .append("patientName", getPatientName())
                .append("idCardTypeCode", getIdCardTypeCode())
                .append("idCardTypeName", getIdCardTypeName())
                .append("idCard", getIdCard())
                .append("wardName", getWardName())
                .append("wardNo", getWardNo())
                .append("bedNo", getBedNo())
                .append("admissionDate", getAdmissionDate())
                .append("admissionDesc", getAdmissionDesc())
                .append("admissionDiagnosisCode", getAdmissionDiagnosisCode())
                .append("admissionDiagnosisName", getAdmissionDiagnosisName())
                .append("studiesSummaryResult", getStudiesSummaryResult())
                .append("observationResult", getObservationResult())
                .append("treatment", getTreatment())
                .append("treatmentDesc", getTreatmentDesc())
                .append("tcmDecoctionMethod", getTcmDecoctionMethod())
                .append("tcmUseMethod", getTcmUseMethod())
                .append("dischargeDesc", getDischargeDesc())
                .append("dischargeDate", getDischargeDate())
                .append("dischargeDiagnosisName", getDischargeDiagnosisName())
                .append("dischargeDiagnosisCode", getDischargeDiagnosisCode())
                .append("tcmDischargeDiagnosisCode", getTcmDischargeDiagnosisCode())
                .append("tcmDischargeDiagnosisName", getTcmDischargeDiagnosisName())
                .append("tcmDischargeSyndromeCode", getTcmDischargeSyndromeCode())
                .append("tcmDischargeSyndromeName", getTcmDischargeSyndromeName())
                .append("dischargeSymptomsSigns", getDischargeSymptomsSigns())
                .append("dischargeOrder", getDischargeOrder())
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
                .append("diseaseProgressionCode", getDiseaseProgressionCode())
                .append("diseaseProgressionName", getDiseaseProgressionName())
                .toString();
    }
}
