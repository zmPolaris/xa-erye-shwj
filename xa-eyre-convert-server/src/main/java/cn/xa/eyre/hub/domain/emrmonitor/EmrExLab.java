package cn.xa.eyre.hub.domain.emrmonitor;

import java.util.Date;

import cn.xa.eyre.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 检验报告主对象 emr_ex_lab
 *
 * @author ruoyi
 * @date 2025-06-11
 */
public class EmrExLab extends BaseEntity
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

    /** 检验申请机构 */
    private String applyOrgName;

    /** 检验申请机构 */
    private String applyOrgCode;

    /** 检验申请科室 */
    private String applyDeptName;

    /** 检验申请科室 */
    private String applyDeptCode;

    /** 检验申请医师ID */
    private String applyPhysicianId;

    /** 检验标本号 */
    private String specimenNo;

    /** 标本采样日期时间 */
    private String specimenSamplingDate;

    /** 接收标本日期时间 */
    private String specimenReceivingDate;

    /** 检验医师ID */
    private String examinationPhysicianId;

    /** 检验日期 */
    private String examinationDate;

    /** 检验报告单编号 */
    private String examinationReportNo;

    /** 检验报告结果-客观所见 */
    private String examinationObjectiveDesc;

    /** 检验报告结果-主观提示 */
    private String examinationSubjectiveDesc;

    /** 检验报告备注 */
    private String examinationNotes;

    /** 检验报告日期 */
    private String examinationReportDate;

    /** 报告医师ID */
    private String examinationReportId;

    /** 检验报告机构 */
    private String orgCode;

    /** 检验报告机构 */
    private String orgName;

    /** 检验报告科室 */
    private String deptCode;

    /** 检验报告科室 */
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

    /** 标本类别代码 */
    private String specimenCategoryCode;

    /** 标本类别名称 */
    private String specimenCategoryName;

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
    public void setApplyOrgName(String applyOrgName)
    {
        this.applyOrgName = applyOrgName;
    }

    public String getApplyOrgName()
    {
        return applyOrgName;
    }
    public void setApplyOrgCode(String applyOrgCode)
    {
        this.applyOrgCode = applyOrgCode;
    }

    public String getApplyOrgCode()
    {
        return applyOrgCode;
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
    public void setApplyPhysicianId(String applyPhysicianId)
    {
        this.applyPhysicianId = applyPhysicianId;
    }

    public String getApplyPhysicianId()
    {
        return applyPhysicianId;
    }
    public void setSpecimenNo(String specimenNo)
    {
        this.specimenNo = specimenNo;
    }

    public String getSpecimenNo()
    {
        return specimenNo;
    }
    public void setSpecimenSamplingDate(String specimenSamplingDate)
    {
        this.specimenSamplingDate = specimenSamplingDate;
    }

    public String getSpecimenSamplingDate()
    {
        return specimenSamplingDate;
    }
    public void setSpecimenReceivingDate(String specimenReceivingDate)
    {
        this.specimenReceivingDate = specimenReceivingDate;
    }

    public String getSpecimenReceivingDate()
    {
        return specimenReceivingDate;
    }
    public void setExaminationPhysicianId(String examinationPhysicianId)
    {
        this.examinationPhysicianId = examinationPhysicianId;
    }

    public String getExaminationPhysicianId()
    {
        return examinationPhysicianId;
    }
    public void setExaminationDate(String examinationDate)
    {
        this.examinationDate = examinationDate;
    }

    public String getExaminationDate()
    {
        return examinationDate;
    }
    public void setExaminationReportNo(String examinationReportNo)
    {
        this.examinationReportNo = examinationReportNo;
    }

    public String getExaminationReportNo()
    {
        return examinationReportNo;
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
    public void setSpecimenCategoryCode(String specimenCategoryCode)
    {
        this.specimenCategoryCode = specimenCategoryCode;
    }

    public String getSpecimenCategoryCode()
    {
        return specimenCategoryCode;
    }
    public void setSpecimenCategoryName(String specimenCategoryName)
    {
        this.specimenCategoryName = specimenCategoryName;
    }

    public String getSpecimenCategoryName()
    {
        return specimenCategoryName;
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
                .append("applyOrgName", getApplyOrgName())
                .append("applyOrgCode", getApplyOrgCode())
                .append("applyDeptName", getApplyDeptName())
                .append("applyDeptCode", getApplyDeptCode())
                .append("applyPhysicianId", getApplyPhysicianId())
                .append("specimenNo", getSpecimenNo())
                .append("specimenSamplingDate", getSpecimenSamplingDate())
                .append("specimenReceivingDate", getSpecimenReceivingDate())
                .append("examinationPhysicianId", getExaminationPhysicianId())
                .append("examinationDate", getExaminationDate())
                .append("examinationReportNo", getExaminationReportNo())
                .append("examinationObjectiveDesc", getExaminationObjectiveDesc())
                .append("examinationSubjectiveDesc", getExaminationSubjectiveDesc())
                .append("examinationNotes", getExaminationNotes())
                .append("examinationReportDate", getExaminationReportDate())
                .append("examinationReportId", getExaminationReportId())
                .append("orgCode", getOrgCode())
                .append("orgName", getOrgName())
                .append("deptCode", getDeptCode())
                .append("deptName", getDeptName())
                .append("operatorId", getOperatorId())
                .append("operationTime", getOperationTime())
                .append("invalidFlag", getInvalidFlag())
                .append("dataStatus", getDataStatus())
                .append("createDate", getCreateDate())
                .append("specimenCategoryCode", getSpecimenCategoryCode())
                .append("specimenCategoryName", getSpecimenCategoryName())
                .toString();
    }
}
