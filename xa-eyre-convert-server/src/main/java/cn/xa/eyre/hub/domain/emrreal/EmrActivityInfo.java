package cn.xa.eyre.hub.domain.emrreal;

import java.util.Date;

import cn.xa.eyre.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 诊断活动信息对象 emr_activity_info
 *
 * @author ruoyi
 * @date 2025-06-11
 */
public class EmrActivityInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 患者基本信息ID */
    private String patientId;

    /** 诊断活动类型 */
    private String activityTypeCode;

    /** 诊断活动类型 */
    private String activityTypeName;

    /** 就诊流水号 */
    private String serialNumber;

    /** 诊断活动发生日期时间 */
    private String activityTime;

    /** 就诊者姓名 */
    private String patientName;

    /** 身份证件类别 */
    private String idCardTypeCode;

    /** 身份证件类别 */
    private String idCardTypeName;

    /** 身份证件号 */
    private String idCard;

    /** 主诉 */
    private String chiefComplaint;

    /** 现病史/入院情况 */
    private String presentIllnessHis;

    /** 体格检查 */
    private String physicalExamination;

    /** 辅助检查 */
    private String studiesSummaryResult;

    /** 疾病诊断日期 */
    private String diagnoseTime;

    /** 传染病疾病诊断 */
    private String diseaseCode;

    /** 传染病疾病诊断 */
    private String diseaseName;

    /** 西医疾病诊断 */
    private String wmDiseaseCode;

    /** 西医疾病诊断 */
    private String wmDiseaseName;

    /** 中医病名代码 */
    private String tcmDiseaseCode;

    /** 中医病名名称 */
    private String tcmDiseaseName;

    /** 中医证候编码 */
    private String tcmSyndromeCode;

    /** 中医证候名称 */
    private String tcmSyndromeName;

    /** 科室 */
    private String deptCode;

    /** 科室 */
    private String deptName;

    /** 医疗机构 */
    private String orgCode;

    /** 医疗机构 */
    private String orgName;

    /** 操作人ID */
    private String operatorId;

    /** 操作时间 */
    private String operationTime;

    /** 作废标志 */
    private String invalidFlag;

    /** 是否生成index 99 未生成 */
    private String dataStatus;

    /** 入库日期 */
    private String createDate;

    /** 诊断医生姓名 */
    private String fillDoctor;

    /** 数据处理类型 */
    private String qzrjDataType;

    /** 传报卡补充的病种 */
    private String reportDiseaseCode;

    /** 传报卡补充的病种名称 */
    private String reportDiseaseName;

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
    public void setActivityTypeCode(String activityTypeCode)
    {
        this.activityTypeCode = activityTypeCode;
    }

    public String getActivityTypeCode()
    {
        return activityTypeCode;
    }
    public void setActivityTypeName(String activityTypeName)
    {
        this.activityTypeName = activityTypeName;
    }

    public String getActivityTypeName()
    {
        return activityTypeName;
    }
    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber()
    {
        return serialNumber;
    }
    public void setActivityTime(String activityTime)
    {
        this.activityTime = activityTime;
    }

    public String getActivityTime()
    {
        return activityTime;
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
    public void setPhysicalExamination(String physicalExamination)
    {
        this.physicalExamination = physicalExamination;
    }

    public String getPhysicalExamination()
    {
        return physicalExamination;
    }
    public void setStudiesSummaryResult(String studiesSummaryResult)
    {
        this.studiesSummaryResult = studiesSummaryResult;
    }

    public String getStudiesSummaryResult()
    {
        return studiesSummaryResult;
    }
    public void setDiagnoseTime(String diagnoseTime)
    {
        this.diagnoseTime = diagnoseTime;
    }

    public String getDiagnoseTime()
    {
        return diagnoseTime;
    }
    public void setDiseaseCode(String diseaseCode)
    {
        this.diseaseCode = diseaseCode;
    }

    public String getDiseaseCode()
    {
        return diseaseCode;
    }
    public void setDiseaseName(String diseaseName)
    {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseName()
    {
        return diseaseName;
    }
    public void setWmDiseaseCode(String wmDiseaseCode)
    {
        this.wmDiseaseCode = wmDiseaseCode;
    }

    public String getWmDiseaseCode()
    {
        return wmDiseaseCode;
    }
    public void setWmDiseaseName(String wmDiseaseName)
    {
        this.wmDiseaseName = wmDiseaseName;
    }

    public String getWmDiseaseName()
    {
        return wmDiseaseName;
    }
    public void setTcmDiseaseCode(String tcmDiseaseCode)
    {
        this.tcmDiseaseCode = tcmDiseaseCode;
    }

    public String getTcmDiseaseCode()
    {
        return tcmDiseaseCode;
    }
    public void setTcmDiseaseName(String tcmDiseaseName)
    {
        this.tcmDiseaseName = tcmDiseaseName;
    }

    public String getTcmDiseaseName()
    {
        return tcmDiseaseName;
    }
    public void setTcmSyndromeCode(String tcmSyndromeCode)
    {
        this.tcmSyndromeCode = tcmSyndromeCode;
    }

    public String getTcmSyndromeCode()
    {
        return tcmSyndromeCode;
    }
    public void setTcmSyndromeName(String tcmSyndromeName)
    {
        this.tcmSyndromeName = tcmSyndromeName;
    }

    public String getTcmSyndromeName()
    {
        return tcmSyndromeName;
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
    public void setFillDoctor(String fillDoctor)
    {
        this.fillDoctor = fillDoctor;
    }

    public String getFillDoctor()
    {
        return fillDoctor;
    }
    public void setQzrjDataType(String qzrjDataType)
    {
        this.qzrjDataType = qzrjDataType;
    }

    public String getQzrjDataType()
    {
        return qzrjDataType;
    }
    public void setReportDiseaseCode(String reportDiseaseCode)
    {
        this.reportDiseaseCode = reportDiseaseCode;
    }

    public String getReportDiseaseCode()
    {
        return reportDiseaseCode;
    }
    public void setReportDiseaseName(String reportDiseaseName)
    {
        this.reportDiseaseName = reportDiseaseName;
    }

    public String getReportDiseaseName()
    {
        return reportDiseaseName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("patientId", getPatientId())
                .append("activityTypeCode", getActivityTypeCode())
                .append("activityTypeName", getActivityTypeName())
                .append("serialNumber", getSerialNumber())
                .append("activityTime", getActivityTime())
                .append("patientName", getPatientName())
                .append("idCardTypeCode", getIdCardTypeCode())
                .append("idCardTypeName", getIdCardTypeName())
                .append("idCard", getIdCard())
                .append("chiefComplaint", getChiefComplaint())
                .append("presentIllnessHis", getPresentIllnessHis())
                .append("physicalExamination", getPhysicalExamination())
                .append("studiesSummaryResult", getStudiesSummaryResult())
                .append("diagnoseTime", getDiagnoseTime())
                .append("diseaseCode", getDiseaseCode())
                .append("diseaseName", getDiseaseName())
                .append("wmDiseaseCode", getWmDiseaseCode())
                .append("wmDiseaseName", getWmDiseaseName())
                .append("tcmDiseaseCode", getTcmDiseaseCode())
                .append("tcmDiseaseName", getTcmDiseaseName())
                .append("tcmSyndromeCode", getTcmSyndromeCode())
                .append("tcmSyndromeName", getTcmSyndromeName())
                .append("deptCode", getDeptCode())
                .append("deptName", getDeptName())
                .append("orgCode", getOrgCode())
                .append("orgName", getOrgName())
                .append("operatorId", getOperatorId())
                .append("operationTime", getOperationTime())
                .append("invalidFlag", getInvalidFlag())
                .append("dataStatus", getDataStatus())
                .append("createDate", getCreateDate())
                .append("fillDoctor", getFillDoctor())
                .append("qzrjDataType", getQzrjDataType())
                .append("reportDiseaseCode", getReportDiseaseCode())
                .append("reportDiseaseName", getReportDiseaseName())
                .toString();
    }
}
