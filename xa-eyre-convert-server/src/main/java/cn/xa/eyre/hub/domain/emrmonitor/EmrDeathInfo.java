package cn.xa.eyre.hub.domain.emrmonitor;

import java.util.Date;

import cn.xa.eyre.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 死亡信息对象 emr_death_info
 *
 * @author ruoyi
 * @date 2025-06-11
 */
public class EmrDeathInfo extends BaseEntity
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

    /** 诊疗过程描述 */
    private String treatmentDesc;

    /** 死亡日期时间 */
    private String deadDate;

    /** 直接死亡原因名称 */
    private String directCauseName;

    /** 直接死亡原因编码 */
    private String directCauseCode;

    /** 死亡诊断名称 */
    private String deathDiagnosisName;

    /** 死亡诊断编码 */
    private String deathDiagnosisCode;

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
    public void setTreatmentDesc(String treatmentDesc)
    {
        this.treatmentDesc = treatmentDesc;
    }

    public String getTreatmentDesc()
    {
        return treatmentDesc;
    }
    public void setDeadDate(String deadDate)
    {
        this.deadDate = deadDate;
    }

    public String getDeadDate()
    {
        return deadDate;
    }
    public void setDirectCauseName(String directCauseName)
    {
        this.directCauseName = directCauseName;
    }

    public String getDirectCauseName()
    {
        return directCauseName;
    }
    public void setDirectCauseCode(String directCauseCode)
    {
        this.directCauseCode = directCauseCode;
    }

    public String getDirectCauseCode()
    {
        return directCauseCode;
    }
    public void setDeathDiagnosisName(String deathDiagnosisName)
    {
        this.deathDiagnosisName = deathDiagnosisName;
    }

    public String getDeathDiagnosisName()
    {
        return deathDiagnosisName;
    }
    public void setDeathDiagnosisCode(String deathDiagnosisCode)
    {
        this.deathDiagnosisCode = deathDiagnosisCode;
    }

    public String getDeathDiagnosisCode()
    {
        return deathDiagnosisCode;
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
                .append("treatmentDesc", getTreatmentDesc())
                .append("deadDate", getDeadDate())
                .append("directCauseName", getDirectCauseName())
                .append("directCauseCode", getDirectCauseCode())
                .append("deathDiagnosisName", getDeathDiagnosisName())
                .append("deathDiagnosisCode", getDeathDiagnosisCode())
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
