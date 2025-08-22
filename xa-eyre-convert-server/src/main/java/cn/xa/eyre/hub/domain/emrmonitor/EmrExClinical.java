package cn.xa.eyre.hub.domain.emrmonitor;

import cn.xa.eyre.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 检查报告对象 emr_ex_clinical
 *
 * @author ruoyi
 * @date 2025-06-11
 */
public class EmrExClinical extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 患者基本信息ID */
    private String patientId;

    /** 就诊记录类型 */
    private String activityTypeCode;

    /** 就诊记录类型 */
    private String activityTypeName;

    /** 就诊流水号 */
    private String serialNumber;

    /** 患者姓名 */
    private String patientName;

    /** 身份证件类别 */
    private String idCardTypeCode;

    /** 身份证件类别 */
    private String idCardTypeName;

    /** 身份证件号 */
    private String idCard;

    /** 病区名称 */
    private String wardName;

    /** 病房号 */
    private String wardNo;

    /** 病床号 */
    private String bedNo;

    /** 电子申请单编号 */
    private String applicationFormNo;

    /** 检查申请机构 */
    private String applyOrgCode;

    /** 检查申请机构 */
    private String applyOrgName;

    /** 检查申请科室 */
    private String applyDeptName;

    /** 检查申请科室 */
    private String applyDeptCode;

    /** 主诉 */
    private String chiefComplaint;

    /** 症状开始时间 */
    private String symptomStartDate;

    /** 症状停止时间 */
    private String symptomEndDate;

    /** 症状描述 */
    private String symptomDesc;

    /** 诊疗过程描述 */
    private String treatmentDesc;

    /** 特殊检查标志 */
    private String specialExaminationCode;

    /** 检查报告结果-客观所见 */
    private String examinationObjectiveDesc;

    /** 检查报告结果-主观提示 */
    private String examinationSubjectiveDesc;

    /** 检查报告备注 */
    private String examinationNotes;

    /** 检查报告单编号 */
    private String examinationReportNo;

    /** 检查报告日期 */
    private String examinationReportDate;

    /** 报告医师ID */
    private String examinationReportId;

    /** 检查报告机构 */
    private String orgCode;

    /** 检查报告机构 */
    private String orgName;

    /** 检查报告科室 */
    private String deptCode;

    /** 检查报告科室 */
    private String deptName;

    /** 操作人ID */
    private String operatorId;

    /** 操作时间 */
    private String operationTime;

    /** 作废标志 */
    private String invalidFlag;

    /** 检查类别代码 */
    private String examinationTypeCode;

    /** 数据状态 0 未传输 1已传输 */
    private String dataStatus;

    /** 入库日期 */
    private String createDate;

    /** 检查类别名称 */
    private String examinationTypeName;

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
    public void setApplicationFormNo(String applicationFormNo)
    {
        this.applicationFormNo = applicationFormNo;
    }

    public String getApplicationFormNo()
    {
        return applicationFormNo;
    }
    public void setApplyOrgCode(String applyOrgCode)
    {
        this.applyOrgCode = applyOrgCode;
    }

    public String getApplyOrgCode()
    {
        return applyOrgCode;
    }
    public void setApplyOrgName(String applyOrgName)
    {
        this.applyOrgName = applyOrgName;
    }

    public String getApplyOrgName()
    {
        return applyOrgName;
    }
    public void setApplyDeptName(String applyDeptName)
    {
        this.applyDeptName = applyDeptName;
    }

    public String getApplyDeptName()
    {
        return applyDeptName;
    }
    public void setApplyDeptCode(String applyDeptCode)
    {
        this.applyDeptCode = applyDeptCode;
    }

    public String getApplyDeptCode()
    {
        return applyDeptCode;
    }
    public void setChiefComplaint(String chiefComplaint)
    {
        this.chiefComplaint = chiefComplaint;
    }

    public String getChiefComplaint()
    {
        return chiefComplaint;
    }
    public void setSymptomStartDate(String symptomStartDate)
    {
        this.symptomStartDate = symptomStartDate;
    }

    public String getSymptomStartDate()
    {
        return symptomStartDate;
    }
    public void setSymptomEndDate(String symptomEndDate)
    {
        this.symptomEndDate = symptomEndDate;
    }

    public String getSymptomEndDate()
    {
        return symptomEndDate;
    }
    public void setSymptomDesc(String symptomDesc)
    {
        this.symptomDesc = symptomDesc;
    }

    public String getSymptomDesc()
    {
        return symptomDesc;
    }
    public void setTreatmentDesc(String treatmentDesc)
    {
        this.treatmentDesc = treatmentDesc;
    }

    public String getTreatmentDesc()
    {
        return treatmentDesc;
    }
    public void setSpecialExaminationCode(String specialExaminationCode)
    {
        this.specialExaminationCode = specialExaminationCode;
    }

    public String getSpecialExaminationCode()
    {
        return specialExaminationCode;
    }
    public void setExaminationObjectiveDesc(String examinationObjectiveDesc)
    {
        this.examinationObjectiveDesc = examinationObjectiveDesc;
    }

    public String getExaminationObjectiveDesc()
    {
        return examinationObjectiveDesc;
    }
    public void setExaminationSubjectiveDesc(String examinationSubjectiveDesc)
    {
        this.examinationSubjectiveDesc = examinationSubjectiveDesc;
    }

    public String getExaminationSubjectiveDesc()
    {
        return examinationSubjectiveDesc;
    }
    public void setExaminationNotes(String examinationNotes)
    {
        this.examinationNotes = examinationNotes;
    }

    public String getExaminationNotes()
    {
        return examinationNotes;
    }
    public void setExaminationReportNo(String examinationReportNo)
    {
        this.examinationReportNo = examinationReportNo;
    }

    public String getExaminationReportNo()
    {
        return examinationReportNo;
    }
    public void setExaminationReportDate(String examinationReportDate)
    {
        this.examinationReportDate = examinationReportDate;
    }

    public String getExaminationReportDate()
    {
        return examinationReportDate;
    }
    public void setExaminationReportId(String examinationReportId)
    {
        this.examinationReportId = examinationReportId;
    }

    public String getExaminationReportId()
    {
        return examinationReportId;
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
    public void setExaminationTypeCode(String examinationTypeCode)
    {
        this.examinationTypeCode = examinationTypeCode;
    }

    public String getExaminationTypeCode()
    {
        return examinationTypeCode;
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
    public void setExaminationTypeName(String examinationTypeName)
    {
        this.examinationTypeName = examinationTypeName;
    }

    public String getExaminationTypeName()
    {
        return examinationTypeName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("patientId", getPatientId())
                .append("activityTypeCode", getActivityTypeCode())
                .append("activityTypeName", getActivityTypeName())
                .append("serialNumber", getSerialNumber())
                .append("patientName", getPatientName())
                .append("idCardTypeCode", getIdCardTypeCode())
                .append("idCardTypeName", getIdCardTypeName())
                .append("idCard", getIdCard())
                .append("wardName", getWardName())
                .append("wardNo", getWardNo())
                .append("bedNo", getBedNo())
                .append("applicationFormNo", getApplicationFormNo())
                .append("applyOrgCode", getApplyOrgCode())
                .append("applyOrgName", getApplyOrgName())
                .append("applyDeptName", getApplyDeptName())
                .append("applyDeptCode", getApplyDeptCode())
                .append("chiefComplaint", getChiefComplaint())
                .append("symptomStartDate", getSymptomStartDate())
                .append("symptomEndDate", getSymptomEndDate())
                .append("symptomDesc", getSymptomDesc())
                .append("treatmentDesc", getTreatmentDesc())
                .append("specialExaminationCode", getSpecialExaminationCode())
                .append("examinationObjectiveDesc", getExaminationObjectiveDesc())
                .append("examinationSubjectiveDesc", getExaminationSubjectiveDesc())
                .append("examinationNotes", getExaminationNotes())
                .append("examinationReportNo", getExaminationReportNo())
                .append("examinationReportDate", getExaminationReportDate())
                .append("examinationReportId", getExaminationReportId())
                .append("orgCode", getOrgCode())
                .append("orgName", getOrgName())
                .append("deptCode", getDeptCode())
                .append("deptName", getDeptName())
                .append("operatorId", getOperatorId())
                .append("operationTime", getOperationTime())
                .append("invalidFlag", getInvalidFlag())
                .append("examinationTypeCode", getExaminationTypeCode())
                .append("dataStatus", getDataStatus())
                .append("createDate", getCreateDate())
                .append("examinationTypeName", getExaminationTypeName())
                .toString();
    }
}
