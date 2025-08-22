package cn.xa.eyre.hub.domain.emrmonitor;

import java.util.Date;

import cn.xa.eyre.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 门（急）诊留观记录对象 emr_outpatient_obs
 *
 * @author ruoyi
 * @date 2025-06-11
 */
public class EmrOutpatientObs extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 患者基本信息ID */
    private String patientId;

    /** 门（急）诊号 */
    private String serialNumber;

    /** 患者姓名 */
    private String patientName;

    /** 身份证件类别 */
    private String idCardTypeCode;

    /** 身份证件类别名称 */
    private String idCardTypeName;

    /** 身份证件号 */
    private String idCard;

    /** 过敏史标志 */
    private String allergyHisFlag;

    /** 过敏史 */
    private String allergyHis;

    /** 就诊日期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date outpatientDate;

    /** 初诊标志代码 */
    private String initalDiagnosisCode;

    /** 主诉 */
    private String chiefComplaint;

    /** 现病史 */
    private String presentIllnessHis;

    /** 既往史 */
    private String pastIllnessHis;

    /** 体格检查 */
    private String physicalExamination;

    /** 中医"四诊"观察结果 */
    private String observationResult;

    /** 辅助检查 */
    private String studiesSummaryResult;

    /** 初步诊断-西医诊断代码 */
    private String wmDiagnosisCode;

    /** 初步诊断-西医诊断名称 */
    private String wmDiagnosisName;

    /** 初步诊断-中医病名代码 */
    private String tcmInitalDiagnosisCode;

    /** 初步诊断-中医病名名称 */
    private String tcmInitalDiagnosisName;

    /** 初步诊断-中医证候代码 */
    private String tcmInitalSyndromeCode;

    /** 初步诊断-中医证候名称 */
    private String tcmInitalSyndromeName;

    /** 辨证依据 */
    private String differentiationBasis;

    /** 治则治法 */
    private String treatment;

    /** 急诊留观病程记录 */
    private String course;

    /** 收人观察室日期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date observationDate;

    /** 注意事项 */
    private String notes;

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
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private String operationTime;

    /** 作废标志 */
    private String invalidFlag;

    /** 数据状态 0未传输 1已传输 */
    private String dataStatus;

    /** 入库日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

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
    public void setAllergyHisFlag(String allergyHisFlag)
    {
        this.allergyHisFlag = allergyHisFlag;
    }

    public String getAllergyHisFlag()
    {
        return allergyHisFlag;
    }
    public void setAllergyHis(String allergyHis)
    {
        this.allergyHis = allergyHis;
    }

    public String getAllergyHis()
    {
        return allergyHis;
    }
    public void setOutpatientDate(Date outpatientDate)
    {
        this.outpatientDate = outpatientDate;
    }

    public Date getOutpatientDate()
    {
        return outpatientDate;
    }
    public void setInitalDiagnosisCode(String initalDiagnosisCode)
    {
        this.initalDiagnosisCode = initalDiagnosisCode;
    }

    public String getInitalDiagnosisCode()
    {
        return initalDiagnosisCode;
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
    public void setPastIllnessHis(String pastIllnessHis)
    {
        this.pastIllnessHis = pastIllnessHis;
    }

    public String getPastIllnessHis()
    {
        return pastIllnessHis;
    }
    public void setPhysicalExamination(String physicalExamination)
    {
        this.physicalExamination = physicalExamination;
    }

    public String getPhysicalExamination()
    {
        return physicalExamination;
    }
    public void setObservationResult(String observationResult)
    {
        this.observationResult = observationResult;
    }

    public String getObservationResult()
    {
        return observationResult;
    }
    public void setStudiesSummaryResult(String studiesSummaryResult)
    {
        this.studiesSummaryResult = studiesSummaryResult;
    }

    public String getStudiesSummaryResult()
    {
        return studiesSummaryResult;
    }
    public void setWmDiagnosisCode(String wmDiagnosisCode)
    {
        this.wmDiagnosisCode = wmDiagnosisCode;
    }

    public String getWmDiagnosisCode()
    {
        return wmDiagnosisCode;
    }
    public void setWmDiagnosisName(String wmDiagnosisName)
    {
        this.wmDiagnosisName = wmDiagnosisName;
    }

    public String getWmDiagnosisName()
    {
        return wmDiagnosisName;
    }
    public void setTcmInitalDiagnosisCode(String tcmInitalDiagnosisCode)
    {
        this.tcmInitalDiagnosisCode = tcmInitalDiagnosisCode;
    }

    public String getTcmInitalDiagnosisCode()
    {
        return tcmInitalDiagnosisCode;
    }
    public void setTcmInitalDiagnosisName(String tcmInitalDiagnosisName)
    {
        this.tcmInitalDiagnosisName = tcmInitalDiagnosisName;
    }

    public String getTcmInitalDiagnosisName()
    {
        return tcmInitalDiagnosisName;
    }
    public void setTcmInitalSyndromeCode(String tcmInitalSyndromeCode)
    {
        this.tcmInitalSyndromeCode = tcmInitalSyndromeCode;
    }

    public String getTcmInitalSyndromeCode()
    {
        return tcmInitalSyndromeCode;
    }
    public void setTcmInitalSyndromeName(String tcmInitalSyndromeName)
    {
        this.tcmInitalSyndromeName = tcmInitalSyndromeName;
    }

    public String getTcmInitalSyndromeName()
    {
        return tcmInitalSyndromeName;
    }
    public void setDifferentiationBasis(String differentiationBasis)
    {
        this.differentiationBasis = differentiationBasis;
    }

    public String getDifferentiationBasis()
    {
        return differentiationBasis;
    }
    public void setTreatment(String treatment)
    {
        this.treatment = treatment;
    }

    public String getTreatment()
    {
        return treatment;
    }
    public void setCourse(String course)
    {
        this.course = course;
    }

    public String getCourse()
    {
        return course;
    }
    public void setObservationDate(Date observationDate)
    {
        this.observationDate = observationDate;
    }

    public Date getObservationDate()
    {
        return observationDate;
    }
    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public String getNotes()
    {
        return notes;
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
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public Date getCreateDate()
    {
        return createDate;
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
                .append("allergyHisFlag", getAllergyHisFlag())
                .append("allergyHis", getAllergyHis())
                .append("outpatientDate", getOutpatientDate())
                .append("initalDiagnosisCode", getInitalDiagnosisCode())
                .append("chiefComplaint", getChiefComplaint())
                .append("presentIllnessHis", getPresentIllnessHis())
                .append("pastIllnessHis", getPastIllnessHis())
                .append("physicalExamination", getPhysicalExamination())
                .append("observationResult", getObservationResult())
                .append("studiesSummaryResult", getStudiesSummaryResult())
                .append("wmDiagnosisCode", getWmDiagnosisCode())
                .append("wmDiagnosisName", getWmDiagnosisName())
                .append("tcmInitalDiagnosisCode", getTcmInitalDiagnosisCode())
                .append("tcmInitalDiagnosisName", getTcmInitalDiagnosisName())
                .append("tcmInitalSyndromeCode", getTcmInitalSyndromeCode())
                .append("tcmInitalSyndromeName", getTcmInitalSyndromeName())
                .append("differentiationBasis", getDifferentiationBasis())
                .append("treatment", getTreatment())
                .append("course", getCourse())
                .append("observationDate", getObservationDate())
                .append("notes", getNotes())
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
