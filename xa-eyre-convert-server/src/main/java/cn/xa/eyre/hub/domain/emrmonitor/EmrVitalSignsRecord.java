package cn.xa.eyre.hub.domain.emrmonitor;

import java.util.Date;

import cn.xa.eyre.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 生命体征记录对象 emr_vital_signs_record
 *
 * @author ruoyi
 * @date 2025-06-11
 */
public class EmrVitalSignsRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 死亡信息在院内的唯一识别标识 */
    private String id;

    /** 机构内患者基本信息唯一标识 */
    private String patientId;

    /** 关联的就诊活动类别代码 */
    private String activityTypeCode;

    /** 关联的就诊活动类别名称 */
    private String activityTypeName;

    /** 诊疗活动发生在门（急）诊期间时，就诊流水号为门（急）诊号；诊疗活动为住院期间时，就诊流水号为住院号 */
    private String serialNumber;

    /** 患者本人在公安户籍管理部门正式登记注册的姓氏和名称 */
    private String patientName;

    /** 患者身份证件所属类别代码 */
    private String idCardTypeCode;

    /** 患者身份证件所属类别名称 */
    private String idCardTypeName;

    /** 身份证件号码 */
    private String idCard;

    /** 记录创建时间 */
    private String createDate;

    /** 患者是否同意使用呼吸机辅助通气代码 */
    private String ventilatorusedCode;

    /** 患者是否同意使用呼吸机辅助通气名称 */
    private String ventilatorusedName;

    /** 标识患者当前是否属于重症监护中代码 */
    private String criticalCareCode;

    /** 标识患者当前是否属于重症监护中名称 */
    private String criticalCareName;

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
    public void setCreateDate(String createDate)
    {
        this.createDate = createDate;
    }

    public String getCreateDate()
    {
        return createDate;
    }
    public void setVentilatorusedCode(String ventilatorusedCode)
    {
        this.ventilatorusedCode = ventilatorusedCode;
    }

    public String getVentilatorusedCode()
    {
        return ventilatorusedCode;
    }
    public void setVentilatorusedName(String ventilatorusedName)
    {
        this.ventilatorusedName = ventilatorusedName;
    }

    public String getVentilatorusedName()
    {
        return ventilatorusedName;
    }
    public void setCriticalCareCode(String criticalCareCode)
    {
        this.criticalCareCode = criticalCareCode;
    }

    public String getCriticalCareCode()
    {
        return criticalCareCode;
    }
    public void setCriticalCareName(String criticalCareName)
    {
        this.criticalCareName = criticalCareName;
    }

    public String getCriticalCareName()
    {
        return criticalCareName;
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
                .append("createDate", getCreateDate())
                .append("ventilatorusedCode", getVentilatorusedCode())
                .append("ventilatorusedName", getVentilatorusedName())
                .append("criticalCareCode", getCriticalCareCode())
                .append("criticalCareName", getCriticalCareName())
                .append("orgCode", getOrgCode())
                .append("orgName", getOrgName())
                .append("deptCode", getDeptCode())
                .append("deptName", getDeptName())
                .append("operatorId", getOperatorId())
                .append("operationTime", getOperationTime())
                .append("invalidFlag", getInvalidFlag())
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmrVitalSignsRecord that = (EmrVitalSignsRecord) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (activityTypeCode != null ? !activityTypeCode.equals(that.activityTypeCode) : that.activityTypeCode != null)
            return false;
        if (activityTypeName != null ? !activityTypeName.equals(that.activityTypeName) : that.activityTypeName != null)
            return false;
        if (serialNumber != null ? !serialNumber.equals(that.serialNumber) : that.serialNumber != null) return false;
        if (patientName != null ? !patientName.equals(that.patientName) : that.patientName != null) return false;
        if (idCardTypeCode != null ? !idCardTypeCode.equals(that.idCardTypeCode) : that.idCardTypeCode != null)
            return false;
        if (idCardTypeName != null ? !idCardTypeName.equals(that.idCardTypeName) : that.idCardTypeName != null)
            return false;
        if (idCard != null ? !idCard.equals(that.idCard) : that.idCard != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (ventilatorusedCode != null ? !ventilatorusedCode.equals(that.ventilatorusedCode) : that.ventilatorusedCode != null)
            return false;
        if (ventilatorusedName != null ? !ventilatorusedName.equals(that.ventilatorusedName) : that.ventilatorusedName != null)
            return false;
        if (criticalCareCode != null ? !criticalCareCode.equals(that.criticalCareCode) : that.criticalCareCode != null)
            return false;
        if (criticalCareName != null ? !criticalCareName.equals(that.criticalCareName) : that.criticalCareName != null)
            return false;
        if (orgCode != null ? !orgCode.equals(that.orgCode) : that.orgCode != null) return false;
        if (orgName != null ? !orgName.equals(that.orgName) : that.orgName != null) return false;
        if (deptCode != null ? !deptCode.equals(that.deptCode) : that.deptCode != null) return false;
        if (deptName != null ? !deptName.equals(that.deptName) : that.deptName != null) return false;
        if (operatorId != null ? !operatorId.equals(that.operatorId) : that.operatorId != null) return false;
        if (operationTime != null ? !operationTime.equals(that.operationTime) : that.operationTime != null) return false;
        return invalidFlag != null ? invalidFlag.equals(that.invalidFlag) : that.invalidFlag == null;
    }

    public boolean equalsNoDate(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmrVitalSignsRecord that = (EmrVitalSignsRecord) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (activityTypeCode != null ? !activityTypeCode.equals(that.activityTypeCode) : that.activityTypeCode != null)
            return false;
        if (activityTypeName != null ? !activityTypeName.equals(that.activityTypeName) : that.activityTypeName != null)
            return false;
        if (serialNumber != null ? !serialNumber.equals(that.serialNumber) : that.serialNumber != null) return false;
        if (patientName != null ? !patientName.equals(that.patientName) : that.patientName != null) return false;
        if (idCardTypeCode != null ? !idCardTypeCode.equals(that.idCardTypeCode) : that.idCardTypeCode != null)
            return false;
        if (idCardTypeName != null ? !idCardTypeName.equals(that.idCardTypeName) : that.idCardTypeName != null)
            return false;
        if (idCard != null ? !idCard.equals(that.idCard) : that.idCard != null) return false;
//        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (ventilatorusedCode != null ? !ventilatorusedCode.equals(that.ventilatorusedCode) : that.ventilatorusedCode != null)
            return false;
        if (ventilatorusedName != null ? !ventilatorusedName.equals(that.ventilatorusedName) : that.ventilatorusedName != null)
            return false;
        if (criticalCareCode != null ? !criticalCareCode.equals(that.criticalCareCode) : that.criticalCareCode != null)
            return false;
        if (criticalCareName != null ? !criticalCareName.equals(that.criticalCareName) : that.criticalCareName != null)
            return false;
        if (orgCode != null ? !orgCode.equals(that.orgCode) : that.orgCode != null) return false;
        if (orgName != null ? !orgName.equals(that.orgName) : that.orgName != null) return false;
        if (deptCode != null ? !deptCode.equals(that.deptCode) : that.deptCode != null) return false;
        if (deptName != null ? !deptName.equals(that.deptName) : that.deptName != null) return false;
        if (operatorId != null ? !operatorId.equals(that.operatorId) : that.operatorId != null) return false;
//        if (operationTime != null ? !operationTime.equals(that.operationTime) : that.operationTime != null) return false;
        return invalidFlag != null ? invalidFlag.equals(that.invalidFlag) : that.invalidFlag == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        result = 31 * result + (activityTypeCode != null ? activityTypeCode.hashCode() : 0);
        result = 31 * result + (activityTypeName != null ? activityTypeName.hashCode() : 0);
        result = 31 * result + (serialNumber != null ? serialNumber.hashCode() : 0);
        result = 31 * result + (patientName != null ? patientName.hashCode() : 0);
        result = 31 * result + (idCardTypeCode != null ? idCardTypeCode.hashCode() : 0);
        result = 31 * result + (idCardTypeName != null ? idCardTypeName.hashCode() : 0);
        result = 31 * result + (idCard != null ? idCard.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (ventilatorusedCode != null ? ventilatorusedCode.hashCode() : 0);
        result = 31 * result + (ventilatorusedName != null ? ventilatorusedName.hashCode() : 0);
        result = 31 * result + (criticalCareCode != null ? criticalCareCode.hashCode() : 0);
        result = 31 * result + (criticalCareName != null ? criticalCareName.hashCode() : 0);
        result = 31 * result + (orgCode != null ? orgCode.hashCode() : 0);
        result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
        result = 31 * result + (deptCode != null ? deptCode.hashCode() : 0);
        result = 31 * result + (deptName != null ? deptName.hashCode() : 0);
        result = 31 * result + (operatorId != null ? operatorId.hashCode() : 0);
        result = 31 * result + (operationTime != null ? operationTime.hashCode() : 0);
        result = 31 * result + (invalidFlag != null ? invalidFlag.hashCode() : 0);
        return result;
    }
}
