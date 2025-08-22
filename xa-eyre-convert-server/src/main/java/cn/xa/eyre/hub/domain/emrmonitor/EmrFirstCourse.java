package cn.xa.eyre.hub.domain.emrmonitor;

import java.util.Date;

import cn.xa.eyre.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 住院首次病程记录对象 emr_first_course
 *
 * @author ruoyi
 * @date 2025-06-11
 */
public class EmrFirstCourse extends BaseEntity
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

    /** 主诉 */
    private String chiefComplaint;

    /** 病例特点 */
    private String presentIllnessHis;

    /** 中医"四诊"观察结果 */
    private String observationResult;

    /** 诊断依据 */
    private String diagnosisBasis;

    /** 初步诊断-西医诊断代码 */
    private String wmInitalDiagnosisCode;

    /** 初步诊断-西医诊断名称 */
    private String wmInitalDiagnosisName;

    /** 初步诊断-中医病名代码 */
    private String tcmInitalDiagnosisCode;

    /** 初步诊断-中医病名名称 */
    private String tcmInitalDiagnosisName;

    /** 初步诊断-中医证候代码 */
    private String tcmInitalSyndromeCode;

    /** 初步诊断-中医证候名称 */
    private String tcmInitalSyndromeName;

    /** 鉴别诊断-西医诊断代码 */
    private String wmDiffDiagnosisCode;

    /** 鉴别诊断-西医诊断名称 */
    private String wmDiffDiagnosisName;

    /** 鉴别诊断-中医病名代码 */
    private String tcmPrimaryDiagnosisCode;

    /** 鉴别诊断-中医病名名称 */
    private String tcmPrimaryDiagnosisName;

    /** 鉴别诊断-中医证候代码 */
    private String tcmPrimarySyndromeCode;

    /** 鉴别诊断-中医证候名称 */
    private String tcmPrimarySyndromeName;

    /** 诊疗计划 */
    private String treatmentPlan;

    /** 治则治法 */
    private String treatment;

    /** 住院医师ID */
    private String residentPhysicianId;

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

    /** 作废标志(0有效1作废) */
    private String invalidFlag;

    /** 数据状态(0未传输1已传输) */
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
    public void setObservationResult(String observationResult)
    {
        this.observationResult = observationResult;
    }

    public String getObservationResult()
    {
        return observationResult;
    }
    public void setDiagnosisBasis(String diagnosisBasis)
    {
        this.diagnosisBasis = diagnosisBasis;
    }

    public String getDiagnosisBasis()
    {
        return diagnosisBasis;
    }
    public void setWmInitalDiagnosisCode(String wmInitalDiagnosisCode)
    {
        this.wmInitalDiagnosisCode = wmInitalDiagnosisCode;
    }

    public String getWmInitalDiagnosisCode()
    {
        return wmInitalDiagnosisCode;
    }
    public void setWmInitalDiagnosisName(String wmInitalDiagnosisName)
    {
        this.wmInitalDiagnosisName = wmInitalDiagnosisName;
    }

    public String getWmInitalDiagnosisName()
    {
        return wmInitalDiagnosisName;
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
    public void setWmDiffDiagnosisCode(String wmDiffDiagnosisCode)
    {
        this.wmDiffDiagnosisCode = wmDiffDiagnosisCode;
    }

    public String getWmDiffDiagnosisCode()
    {
        return wmDiffDiagnosisCode;
    }
    public void setWmDiffDiagnosisName(String wmDiffDiagnosisName)
    {
        this.wmDiffDiagnosisName = wmDiffDiagnosisName;
    }

    public String getWmDiffDiagnosisName()
    {
        return wmDiffDiagnosisName;
    }
    public void setTcmPrimaryDiagnosisCode(String tcmPrimaryDiagnosisCode)
    {
        this.tcmPrimaryDiagnosisCode = tcmPrimaryDiagnosisCode;
    }

    public String getTcmPrimaryDiagnosisCode()
    {
        return tcmPrimaryDiagnosisCode;
    }
    public void setTcmPrimaryDiagnosisName(String tcmPrimaryDiagnosisName)
    {
        this.tcmPrimaryDiagnosisName = tcmPrimaryDiagnosisName;
    }

    public String getTcmPrimaryDiagnosisName()
    {
        return tcmPrimaryDiagnosisName;
    }
    public void setTcmPrimarySyndromeCode(String tcmPrimarySyndromeCode)
    {
        this.tcmPrimarySyndromeCode = tcmPrimarySyndromeCode;
    }

    public String getTcmPrimarySyndromeCode()
    {
        return tcmPrimarySyndromeCode;
    }
    public void setTcmPrimarySyndromeName(String tcmPrimarySyndromeName)
    {
        this.tcmPrimarySyndromeName = tcmPrimarySyndromeName;
    }

    public String getTcmPrimarySyndromeName()
    {
        return tcmPrimarySyndromeName;
    }
    public void setTreatmentPlan(String treatmentPlan)
    {
        this.treatmentPlan = treatmentPlan;
    }

    public String getTreatmentPlan()
    {
        return treatmentPlan;
    }
    public void setTreatment(String treatment)
    {
        this.treatment = treatment;
    }

    public String getTreatment()
    {
        return treatment;
    }
    public void setResidentPhysicianId(String residentPhysicianId)
    {
        this.residentPhysicianId = residentPhysicianId;
    }

    public String getResidentPhysicianId()
    {
        return residentPhysicianId;
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
                .append("createTime", getCreateTime())
                .append("chiefComplaint", getChiefComplaint())
                .append("presentIllnessHis", getPresentIllnessHis())
                .append("observationResult", getObservationResult())
                .append("diagnosisBasis", getDiagnosisBasis())
                .append("wmInitalDiagnosisCode", getWmInitalDiagnosisCode())
                .append("wmInitalDiagnosisName", getWmInitalDiagnosisName())
                .append("tcmInitalDiagnosisCode", getTcmInitalDiagnosisCode())
                .append("tcmInitalDiagnosisName", getTcmInitalDiagnosisName())
                .append("tcmInitalSyndromeCode", getTcmInitalSyndromeCode())
                .append("tcmInitalSyndromeName", getTcmInitalSyndromeName())
                .append("wmDiffDiagnosisCode", getWmDiffDiagnosisCode())
                .append("wmDiffDiagnosisName", getWmDiffDiagnosisName())
                .append("tcmPrimaryDiagnosisCode", getTcmPrimaryDiagnosisCode())
                .append("tcmPrimaryDiagnosisName", getTcmPrimaryDiagnosisName())
                .append("tcmPrimarySyndromeCode", getTcmPrimarySyndromeCode())
                .append("tcmPrimarySyndromeName", getTcmPrimarySyndromeName())
                .append("treatmentPlan", getTreatmentPlan())
                .append("treatment", getTreatment())
                .append("residentPhysicianId", getResidentPhysicianId())
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
