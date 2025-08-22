package cn.xa.eyre.hub.domain.emrmonitor;

import java.util.Date;

import cn.xa.eyre.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 住院日常病程记录对象 emr_daily_course
 *
 * @author ruoyi
 * @date 2025-06-11
 */
public class EmrDailyCourse extends BaseEntity
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

    /** 住院病程 */
    private String course;

    /** 医嘱内容 */
    private String orderContent;

    /** 中医"四诊"观察结果 */
    private String observationResult;

    /** 辨证论治详细描述 */
    private String treatment;

    /** 医疗机构 */
    private String orgCode;

    /** 医疗机构 */
    private String orgName;

    /** 科室 */
    private String deptCode;

    /** 科室 */
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
    public void setCourse(String course)
    {
        this.course = course;
    }

    public String getCourse()
    {
        return course;
    }
    public void setOrderContent(String orderContent)
    {
        this.orderContent = orderContent;
    }

    public String getOrderContent()
    {
        return orderContent;
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
                .append("course", getCourse())
                .append("orderContent", getOrderContent())
                .append("observationResult", getObservationResult())
                .append("treatment", getTreatment())
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
