package cn.xa.eyre.hub.domain.emrreal;

import java.util.Date;

import cn.xa.eyre.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【患者基本信息表】对象 emr_patient_info
 *
 * @author ruoyi
 * @date 2025-06-11
 */
public class EmrPatientInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 就诊者姓名 */
    private String patientName;

    /** 身份证件类别 */
    private String idCardTypeCode;

    /** 身份证件类别 */
    private String idCardTypeName;

    /** 身份证件号 */
    private String idCard;

    /** 性别 */
    private String genderCode;

    /** 性别 */
    private String genderName;

    /** 出生日期 */
    private String birthDate;

    /** 国籍/地区 */
    private String nationalityCode;

    /** 国籍/地区 */
    private String nationalityName;

    /** 民族 */
    private String nationCode;

    /** 民族 */
    private String nationName;

    /** 户籍地址 */
    private String permanentAddrCode;

    /** 户籍地址 */
    private String permanentAddrName;

    /** 户籍详细地址 */
    private String permanentAddrDetail;

    /** 现住地区 */
    private String currentAddrCode;

    /** 现住地区 */
    private String currentAddrName;

    /** 现住详细地址 */
    private String currentAddrDetail;

    /** 工作单位/学校名称 */
    private String workunit;

    /** 婚姻状况代码 */
    private String maritalStatusCode;

    /** 婚姻状况名称 */
    private String maritalStatusName;

    /** 患者电话号码 */
    private String tel;

    /** 联系人/监护人姓名 */
    private String contacts;

    /** 联系人/监护人电话号码 */
    private String contactsTel;

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

    /** 学历代码 */
    private String educationCode;

    /** 学历名称 */
    private String educationName;

    /** 人群分类代码 */
    private String nultitudeTypeCode;

    /** 人群分类名称 */
    private String nultitudeTypeName;

    /** 数据状态 0 未传输 1已传输 */
    private String dataStatus;

    /** 入库日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /** 人群分类其他 */
    private String nultitudeTypeOther;

    /** 数据处理类型 */
    private String qzrjDataType;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
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
    public void setGenderCode(String genderCode)
    {
        this.genderCode = genderCode;
    }

    public String getGenderCode()
    {
        return genderCode;
    }
    public void setGenderName(String genderName)
    {
        this.genderName = genderName;
    }

    public String getGenderName()
    {
        return genderName;
    }
    public void setBirthDate(String birthDate)
    {
        this.birthDate = birthDate;
    }

    public String getBirthDate()
    {
        return birthDate;
    }
    public void setNationalityCode(String nationalityCode)
    {
        this.nationalityCode = nationalityCode;
    }

    public String getNationalityCode()
    {
        return nationalityCode;
    }
    public void setNationalityName(String nationalityName)
    {
        this.nationalityName = nationalityName;
    }

    public String getNationalityName()
    {
        return nationalityName;
    }
    public void setNationCode(String nationCode)
    {
        this.nationCode = nationCode;
    }

    public String getNationCode()
    {
        return nationCode;
    }
    public void setNationName(String nationName)
    {
        this.nationName = nationName;
    }

    public String getNationName()
    {
        return nationName;
    }
    public void setPermanentAddrCode(String permanentAddrCode)
    {
        this.permanentAddrCode = permanentAddrCode;
    }

    public String getPermanentAddrCode()
    {
        return permanentAddrCode;
    }
    public void setPermanentAddrName(String permanentAddrName)
    {
        this.permanentAddrName = permanentAddrName;
    }

    public String getPermanentAddrName()
    {
        return permanentAddrName;
    }
    public void setPermanentAddrDetail(String permanentAddrDetail)
    {
        this.permanentAddrDetail = permanentAddrDetail;
    }

    public String getPermanentAddrDetail()
    {
        return permanentAddrDetail;
    }
    public void setCurrentAddrCode(String currentAddrCode)
    {
        this.currentAddrCode = currentAddrCode;
    }

    public String getCurrentAddrCode()
    {
        return currentAddrCode;
    }
    public void setCurrentAddrName(String currentAddrName)
    {
        this.currentAddrName = currentAddrName;
    }

    public String getCurrentAddrName()
    {
        return currentAddrName;
    }
    public void setCurrentAddrDetail(String currentAddrDetail)
    {
        this.currentAddrDetail = currentAddrDetail;
    }

    public String getCurrentAddrDetail()
    {
        return currentAddrDetail;
    }
    public void setWorkunit(String workunit)
    {
        this.workunit = workunit;
    }

    public String getWorkunit()
    {
        return workunit;
    }
    public void setMaritalStatusCode(String maritalStatusCode)
    {
        this.maritalStatusCode = maritalStatusCode;
    }

    public String getMaritalStatusCode()
    {
        return maritalStatusCode;
    }
    public void setMaritalStatusName(String maritalStatusName)
    {
        this.maritalStatusName = maritalStatusName;
    }

    public String getMaritalStatusName()
    {
        return maritalStatusName;
    }
    public void setTel(String tel)
    {
        this.tel = tel;
    }

    public String getTel()
    {
        return tel;
    }
    public void setContacts(String contacts)
    {
        this.contacts = contacts;
    }

    public String getContacts()
    {
        return contacts;
    }
    public void setContactsTel(String contactsTel)
    {
        this.contactsTel = contactsTel;
    }

    public String getContactsTel()
    {
        return contactsTel;
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
    public void setEducationCode(String educationCode)
    {
        this.educationCode = educationCode;
    }

    public String getEducationCode()
    {
        return educationCode;
    }
    public void setEducationName(String educationName)
    {
        this.educationName = educationName;
    }

    public String getEducationName()
    {
        return educationName;
    }
    public void setNultitudeTypeCode(String nultitudeTypeCode)
    {
        this.nultitudeTypeCode = nultitudeTypeCode;
    }

    public String getNultitudeTypeCode()
    {
        return nultitudeTypeCode;
    }
    public void setNultitudeTypeName(String nultitudeTypeName)
    {
        this.nultitudeTypeName = nultitudeTypeName;
    }

    public String getNultitudeTypeName()
    {
        return nultitudeTypeName;
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
    public void setNultitudeTypeOther(String nultitudeTypeOther)
    {
        this.nultitudeTypeOther = nultitudeTypeOther;
    }

    public String getNultitudeTypeOther()
    {
        return nultitudeTypeOther;
    }
    public void setQzrjDataType(String qzrjDataType)
    {
        this.qzrjDataType = qzrjDataType;
    }

    public String getQzrjDataType()
    {
        return qzrjDataType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("patientName", getPatientName())
                .append("idCardTypeCode", getIdCardTypeCode())
                .append("idCardTypeName", getIdCardTypeName())
                .append("idCard", getIdCard())
                .append("genderCode", getGenderCode())
                .append("genderName", getGenderName())
                .append("birthDate", getBirthDate())
                .append("nationalityCode", getNationalityCode())
                .append("nationalityName", getNationalityName())
                .append("nationCode", getNationCode())
                .append("nationName", getNationName())
                .append("permanentAddrCode", getPermanentAddrCode())
                .append("permanentAddrName", getPermanentAddrName())
                .append("permanentAddrDetail", getPermanentAddrDetail())
                .append("currentAddrCode", getCurrentAddrCode())
                .append("currentAddrName", getCurrentAddrName())
                .append("currentAddrDetail", getCurrentAddrDetail())
                .append("workunit", getWorkunit())
                .append("maritalStatusCode", getMaritalStatusCode())
                .append("maritalStatusName", getMaritalStatusName())
                .append("tel", getTel())
                .append("contacts", getContacts())
                .append("contactsTel", getContactsTel())
                .append("orgCode", getOrgCode())
                .append("orgName", getOrgName())
                .append("operatorId", getOperatorId())
                .append("operationTime", getOperationTime())
                .append("invalidFlag", getInvalidFlag())
                .append("educationCode", getEducationCode())
                .append("educationName", getEducationName())
                .append("nultitudeTypeCode", getNultitudeTypeCode())
                .append("nultitudeTypeName", getNultitudeTypeName())
                .append("dataStatus", getDataStatus())
                .append("createDate", getCreateDate())
                .append("nultitudeTypeOther", getNultitudeTypeOther())
                .append("qzrjDataType", getQzrjDataType())
                .toString();
    }
}
