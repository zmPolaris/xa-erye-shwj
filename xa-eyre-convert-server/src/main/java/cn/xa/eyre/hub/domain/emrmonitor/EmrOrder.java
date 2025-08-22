package cn.xa.eyre.hub.domain.emrmonitor;

import java.util.Date;

import cn.xa.eyre.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 医嘱信息对象 emr_order
 *
 * @author ruoyi
 * @date 2025-06-11
 */
public class EmrOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 患者基本信息ID */
    private String patientId;

    /** 就诊记录类型代码 */
    private String activityTypeCode;

    /** 就诊记录类型名称 */
    private String activityTypeName;

    /** 就诊流水号 */
    private String serialNumber;

    /** 患者姓名 */
    private String patientName;

    /** 身份证件类别代码 */
    private String idCardTypeCode;

    /** 身份证件类别名称 */
    private String idCardTypeName;

    /** 身份证件号 */
    private String idCard;

    /** 处方编号 */
    private String prescriptionNo;

    /** 处方类别代码 */
    private String prescriptionTypeCode;

    /** 处方开立日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date prescriptionIssuanceDate;

    /** 处方有效天数 */
    private String prescriptionValidityDays;

    /** 医嘱处方执行日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date excuteDate;

    /** 处方开立医师ID */
    private String prescriptionIssuanceId;

    /** 处方发药药剂师ID */
    private String prescriptionDispensingId;

    /** 处方备注信息 */
    private String prescriptionNotes;

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

    /** 数据状态 0 未传输 1已传输 */
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
    public void setPrescriptionNo(String prescriptionNo)
    {
        this.prescriptionNo = prescriptionNo;
    }

    public String getPrescriptionNo()
    {
        return prescriptionNo;
    }
    public void setPrescriptionTypeCode(String prescriptionTypeCode)
    {
        this.prescriptionTypeCode = prescriptionTypeCode;
    }

    public String getPrescriptionTypeCode()
    {
        return prescriptionTypeCode;
    }
    public void setPrescriptionIssuanceDate(Date prescriptionIssuanceDate)
    {
        this.prescriptionIssuanceDate = prescriptionIssuanceDate;
    }

    public Date getPrescriptionIssuanceDate()
    {
        return prescriptionIssuanceDate;
    }
    public void setPrescriptionValidityDays(String prescriptionValidityDays)
    {
        this.prescriptionValidityDays = prescriptionValidityDays;
    }

    public String getPrescriptionValidityDays()
    {
        return prescriptionValidityDays;
    }
    public void setExcuteDate(Date excuteDate)
    {
        this.excuteDate = excuteDate;
    }

    public Date getExcuteDate()
    {
        return excuteDate;
    }
    public void setPrescriptionIssuanceId(String prescriptionIssuanceId)
    {
        this.prescriptionIssuanceId = prescriptionIssuanceId;
    }

    public String getPrescriptionIssuanceId()
    {
        return prescriptionIssuanceId;
    }
    public void setPrescriptionDispensingId(String prescriptionDispensingId)
    {
        this.prescriptionDispensingId = prescriptionDispensingId;
    }

    public String getPrescriptionDispensingId()
    {
        return prescriptionDispensingId;
    }
    public void setPrescriptionNotes(String prescriptionNotes)
    {
        this.prescriptionNotes = prescriptionNotes;
    }

    public String getPrescriptionNotes()
    {
        return prescriptionNotes;
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
                .append("activityTypeCode", getActivityTypeCode())
                .append("activityTypeName", getActivityTypeName())
                .append("serialNumber", getSerialNumber())
                .append("patientName", getPatientName())
                .append("idCardTypeCode", getIdCardTypeCode())
                .append("idCardTypeName", getIdCardTypeName())
                .append("idCard", getIdCard())
                .append("prescriptionNo", getPrescriptionNo())
                .append("prescriptionTypeCode", getPrescriptionTypeCode())
                .append("prescriptionIssuanceDate", getPrescriptionIssuanceDate())
                .append("prescriptionValidityDays", getPrescriptionValidityDays())
                .append("excuteDate", getExcuteDate())
                .append("prescriptionIssuanceId", getPrescriptionIssuanceId())
                .append("prescriptionDispensingId", getPrescriptionDispensingId())
                .append("prescriptionNotes", getPrescriptionNotes())
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
