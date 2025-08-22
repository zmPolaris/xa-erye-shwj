package cn.xa.eyre.hub.domain.emrreal;

import java.util.Date;

import cn.xa.eyre.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 传报卡信息对象 emr_inf_report
 *
 * @author ruoyi
 * @date 2025-06-11
 */
public class EmrInfReport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 患者基本信息ID */
    private String patientId;

    /** 就诊流水号 */
    private String serialNumber;

    /** 活动类型代码 */
    private String activityTypeCode;

    /** 活动类型名称 */
    private String activityTypeName;

    /** 患者姓名 */
    private String patientName;

    /** 证件类型代码 */
    private String idCardTypeCode;

    /** 证件类型名称 */
    private String idCardTypeName;

    /** 证件号码 */
    private String idCard;

    /** 是否因此病死亡代码 */
    private String isDeadByThisCode;

    /** 是否因此病死亡名称 */
    private String isDeadByThisName;

    /** 发病日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date onsetDate;

    /** 症状代码 */
    private String symptomsCode;

    /** 症状名称 */
    private String symptomsName;

    /** 诊断时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date diagnoseTime;

    /** 疾病代码 */
    private String diseaseCode;

    /** 疾病名称 */
    private String diseaseName;

    /** 其他疾病说明 */
    private String diseaseOther;

    /** 诊断状态代码 */
    private String diagnoseStateCode;

    /** 诊断状态名称 */
    private String diagnoseStateName;

    /** 病例类型代码 */
    private String caseTypeCode;

    /** 病例类型名称 */
    private String caseTypeName;

    /** 死亡日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deadDate;

    /** 实验室检测判定代码 */
    private String laboratoryDetectionVerdictCode;

    /** 实验室检测判定名称 */
    private String laboratoryDetectionVerdictName;

    /** 检测阳性日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date detectionPositiveDate;

    /** 检测机构代码 */
    private String detectionOrgCode;

    /** 确诊日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dtDiagnose;

    /** AFP地区类型1代码 */
    private String afpAreatype1Code;

    /** AFP地区类型1名称 */
    private String afpAreatype1Name;

    /** AFP麻痹日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date afpPalsyDate;

    /** AFP医生报告日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date afpDoctorDate;

    /** AFP地区类型2代码 */
    private String afpAreatype2Code;

    /** AFP地区类型2名称 */
    private String afpAreatype2Name;

    /** AFP地址代码 */
    private String afpAddrcodeCode;

    /** AFP地址名称 */
    private String afpAddrcodeName;

    /** AFP详细地址 */
    private String afpAddr;

    /** AFP麻痹症状 */
    private String afpPalsySymptom;

    /** 报告日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date reportDate;

    /** 发现方式代码 */
    private String discoveryModeCode;

    /** 发现方式名称 */
    private String discoveryModeName;

    /** 其他发现方式 */
    private String discoveryModeOther;

    /** 性病代码 */
    private String venerealDisCode;

    /** 性病名称 */
    private String venerealDisName;

    /** 传播途径代码 */
    private String bsTransmissionCode;

    /** 传播途径名称 */
    private String bsTransmissionName;

    /** 其他传播途径 */
    private String bsTransmissionOther;

    /** 接触类型代码 */
    private String contactTypeCode;

    /** 接触类型名称 */
    private String contactTypeName;

    /** 注射次数 */
    private String injectCount;

    /** 非网络报告次数 */
    private String nonwebCount;

    /** 短信报告次数 */
    private String smCount;

    /** 其他接触信息 */
    private String contactOther;

    /** 继发感染代码 */
    private String sinfectCode;

    /** 继发感染名称 */
    private String sinfectName;

    /** 严重程度代码 */
    private String serverityCode;

    /** 严重程度名称 */
    private String serverityName;

    /** 实验室结果代码 */
    private String labResultCode;

    /** 实验室结果名称 */
    private String labResultName;

    /** HBsAg代码 */
    private String hbsagCode;

    /** HBsAg名称 */
    private String hbsagName;

    /** 首次HBsAg检测日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date hbsagFirst;

    /** HBsAg不详标识 */
    private String hbsagBuxiang;

    /** HBsAg ALT值 */
    private String hbsagAlt;

    /** HBcIg结果代码 */
    private String hbcigResultCode;

    /** HBcIg结果名称 */
    private String hbcigResultName;

    /** 肝穿刺代码 */
    private String hbliverPunctureCode;

    /** 肝穿刺名称 */
    private String hbliverPunctureName;

    /** HBsAg变化代码 */
    private String hbsagChangeCode;

    /** HBsAg变化名称 */
    private String hbsagChangeName;

    /** 接触标识代码 */
    private String contactflagCode;

    /** 接触标识名称 */
    private String contactflagName;

    /** 填报医生 */
    private String fillDoctor;

    /** 备注 */
    private String notes;

    /** NCV严重程度代码 */
    private String ncvSeverityCode;

    /** NCV严重程度名称 */
    private String ncvSeverityName;

    /** 外籍类型代码 */
    private String foreignTypeCode;

    /** 外籍类型名称 */
    private String foreignTypeName;

    /** 地点代码 */
    private String placeCode;

    /** 地点名称 */
    private String placeName;

    /** 报告地区代码 */
    private String reportZoneCode;

    /** 报告地区名称 */
    private String reportZoneName;

    /** 报告机构代码 */
    private String reportOrgCode;

    /** 报告机构名称 */
    private String reportOrgName;

    /** 操作员ID */
    private String operatorId;

    /** 操作时间 */
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private String operationTime;

    /** 作废标志 */
    private String invalidFlag;

    /** 数据状态 */
    private String dataStatus;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /** 性别代码 */
    private String genderCode;

    /** 性别名称 */
    private String genderName;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    /** 国籍代码 */
    private String nationalityCode;

    /** 国籍名称 */
    private String nationalityName;

    /** 民族代码 */
    private String nationCode;

    /** 民族名称 */
    private String nationName;

    /** 常住地址代码 */
    private String permanentAddrCode;

    /** 常住地址名称 */
    private String permanentAddrName;

    /** 常住地址详情 */
    private String permanentAddrDetail;

    /** 现住址代码 */
    private String currentAddrCode;

    /** 现住址名称 */
    private String currentAddrName;

    /** 现住址详情 */
    private String currentAddrDetail;

    /** 工作单位 */
    private String workunit;

    /** 婚姻状况代码 */
    private String maritalStatusCode;

    /** 婚姻状况名称 */
    private String maritalStatusName;

    /** 联系电话 */
    private String tel;

    /** 联系人 */
    private String contacts;

    /** 联系人电话 */
    private String contactsTel;

    /** 教育程度代码 */
    private String educationCode;

    /** 教育程度名称 */
    private String educationName;

    /** 人群类型代码 */
    private String nultitudeTypeCode;

    /** 人群类型名称 */
    private String nultitudeTypeName;

    /** 其他人群类型 */
    private String nultitudeTypeOther;

    /** 科室代码 */
    private String deptCode;

    /** 科室名称 */
    private String deptName;

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
    public void setIsDeadByThisCode(String isDeadByThisCode)
    {
        this.isDeadByThisCode = isDeadByThisCode;
    }

    public String getIsDeadByThisCode()
    {
        return isDeadByThisCode;
    }
    public void setIsDeadByThisName(String isDeadByThisName)
    {
        this.isDeadByThisName = isDeadByThisName;
    }

    public String getIsDeadByThisName()
    {
        return isDeadByThisName;
    }
    public void setOnsetDate(Date onsetDate)
    {
        this.onsetDate = onsetDate;
    }

    public Date getOnsetDate()
    {
        return onsetDate;
    }
    public void setSymptomsCode(String symptomsCode)
    {
        this.symptomsCode = symptomsCode;
    }

    public String getSymptomsCode()
    {
        return symptomsCode;
    }
    public void setSymptomsName(String symptomsName)
    {
        this.symptomsName = symptomsName;
    }

    public String getSymptomsName()
    {
        return symptomsName;
    }
    public void setDiagnoseTime(Date diagnoseTime)
    {
        this.diagnoseTime = diagnoseTime;
    }

    public Date getDiagnoseTime()
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
    public void setDiseaseOther(String diseaseOther)
    {
        this.diseaseOther = diseaseOther;
    }

    public String getDiseaseOther()
    {
        return diseaseOther;
    }
    public void setDiagnoseStateCode(String diagnoseStateCode)
    {
        this.diagnoseStateCode = diagnoseStateCode;
    }

    public String getDiagnoseStateCode()
    {
        return diagnoseStateCode;
    }
    public void setDiagnoseStateName(String diagnoseStateName)
    {
        this.diagnoseStateName = diagnoseStateName;
    }

    public String getDiagnoseStateName()
    {
        return diagnoseStateName;
    }
    public void setCaseTypeCode(String caseTypeCode)
    {
        this.caseTypeCode = caseTypeCode;
    }

    public String getCaseTypeCode()
    {
        return caseTypeCode;
    }
    public void setCaseTypeName(String caseTypeName)
    {
        this.caseTypeName = caseTypeName;
    }

    public String getCaseTypeName()
    {
        return caseTypeName;
    }
    public void setDeadDate(Date deadDate)
    {
        this.deadDate = deadDate;
    }

    public Date getDeadDate()
    {
        return deadDate;
    }
    public void setLaboratoryDetectionVerdictCode(String laboratoryDetectionVerdictCode)
    {
        this.laboratoryDetectionVerdictCode = laboratoryDetectionVerdictCode;
    }

    public String getLaboratoryDetectionVerdictCode()
    {
        return laboratoryDetectionVerdictCode;
    }
    public void setLaboratoryDetectionVerdictName(String laboratoryDetectionVerdictName)
    {
        this.laboratoryDetectionVerdictName = laboratoryDetectionVerdictName;
    }

    public String getLaboratoryDetectionVerdictName()
    {
        return laboratoryDetectionVerdictName;
    }
    public void setDetectionPositiveDate(Date detectionPositiveDate)
    {
        this.detectionPositiveDate = detectionPositiveDate;
    }

    public Date getDetectionPositiveDate()
    {
        return detectionPositiveDate;
    }
    public void setDetectionOrgCode(String detectionOrgCode)
    {
        this.detectionOrgCode = detectionOrgCode;
    }

    public String getDetectionOrgCode()
    {
        return detectionOrgCode;
    }
    public void setDtDiagnose(Date dtDiagnose)
    {
        this.dtDiagnose = dtDiagnose;
    }

    public Date getDtDiagnose()
    {
        return dtDiagnose;
    }
    public void setAfpAreatype1Code(String afpAreatype1Code)
    {
        this.afpAreatype1Code = afpAreatype1Code;
    }

    public String getAfpAreatype1Code()
    {
        return afpAreatype1Code;
    }
    public void setAfpAreatype1Name(String afpAreatype1Name)
    {
        this.afpAreatype1Name = afpAreatype1Name;
    }

    public String getAfpAreatype1Name()
    {
        return afpAreatype1Name;
    }
    public void setAfpPalsyDate(Date afpPalsyDate)
    {
        this.afpPalsyDate = afpPalsyDate;
    }

    public Date getAfpPalsyDate()
    {
        return afpPalsyDate;
    }
    public void setAfpDoctorDate(Date afpDoctorDate)
    {
        this.afpDoctorDate = afpDoctorDate;
    }

    public Date getAfpDoctorDate()
    {
        return afpDoctorDate;
    }
    public void setAfpAreatype2Code(String afpAreatype2Code)
    {
        this.afpAreatype2Code = afpAreatype2Code;
    }

    public String getAfpAreatype2Code()
    {
        return afpAreatype2Code;
    }
    public void setAfpAreatype2Name(String afpAreatype2Name)
    {
        this.afpAreatype2Name = afpAreatype2Name;
    }

    public String getAfpAreatype2Name()
    {
        return afpAreatype2Name;
    }
    public void setAfpAddrcodeCode(String afpAddrcodeCode)
    {
        this.afpAddrcodeCode = afpAddrcodeCode;
    }

    public String getAfpAddrcodeCode()
    {
        return afpAddrcodeCode;
    }
    public void setAfpAddrcodeName(String afpAddrcodeName)
    {
        this.afpAddrcodeName = afpAddrcodeName;
    }

    public String getAfpAddrcodeName()
    {
        return afpAddrcodeName;
    }
    public void setAfpAddr(String afpAddr)
    {
        this.afpAddr = afpAddr;
    }

    public String getAfpAddr()
    {
        return afpAddr;
    }
    public void setAfpPalsySymptom(String afpPalsySymptom)
    {
        this.afpPalsySymptom = afpPalsySymptom;
    }

    public String getAfpPalsySymptom()
    {
        return afpPalsySymptom;
    }
    public void setReportDate(Date reportDate)
    {
        this.reportDate = reportDate;
    }

    public Date getReportDate()
    {
        return reportDate;
    }
    public void setDiscoveryModeCode(String discoveryModeCode)
    {
        this.discoveryModeCode = discoveryModeCode;
    }

    public String getDiscoveryModeCode()
    {
        return discoveryModeCode;
    }
    public void setDiscoveryModeName(String discoveryModeName)
    {
        this.discoveryModeName = discoveryModeName;
    }

    public String getDiscoveryModeName()
    {
        return discoveryModeName;
    }
    public void setDiscoveryModeOther(String discoveryModeOther)
    {
        this.discoveryModeOther = discoveryModeOther;
    }

    public String getDiscoveryModeOther()
    {
        return discoveryModeOther;
    }
    public void setVenerealDisCode(String venerealDisCode)
    {
        this.venerealDisCode = venerealDisCode;
    }

    public String getVenerealDisCode()
    {
        return venerealDisCode;
    }
    public void setVenerealDisName(String venerealDisName)
    {
        this.venerealDisName = venerealDisName;
    }

    public String getVenerealDisName()
    {
        return venerealDisName;
    }
    public void setBsTransmissionCode(String bsTransmissionCode)
    {
        this.bsTransmissionCode = bsTransmissionCode;
    }

    public String getBsTransmissionCode()
    {
        return bsTransmissionCode;
    }
    public void setBsTransmissionName(String bsTransmissionName)
    {
        this.bsTransmissionName = bsTransmissionName;
    }

    public String getBsTransmissionName()
    {
        return bsTransmissionName;
    }
    public void setBsTransmissionOther(String bsTransmissionOther)
    {
        this.bsTransmissionOther = bsTransmissionOther;
    }

    public String getBsTransmissionOther()
    {
        return bsTransmissionOther;
    }
    public void setContactTypeCode(String contactTypeCode)
    {
        this.contactTypeCode = contactTypeCode;
    }

    public String getContactTypeCode()
    {
        return contactTypeCode;
    }
    public void setContactTypeName(String contactTypeName)
    {
        this.contactTypeName = contactTypeName;
    }

    public String getContactTypeName()
    {
        return contactTypeName;
    }
    public void setInjectCount(String injectCount)
    {
        this.injectCount = injectCount;
    }

    public String getInjectCount()
    {
        return injectCount;
    }
    public void setNonwebCount(String nonwebCount)
    {
        this.nonwebCount = nonwebCount;
    }

    public String getNonwebCount()
    {
        return nonwebCount;
    }
    public void setSmCount(String smCount)
    {
        this.smCount = smCount;
    }

    public String getSmCount()
    {
        return smCount;
    }
    public void setContactOther(String contactOther)
    {
        this.contactOther = contactOther;
    }

    public String getContactOther()
    {
        return contactOther;
    }
    public void setSinfectCode(String sinfectCode)
    {
        this.sinfectCode = sinfectCode;
    }

    public String getSinfectCode()
    {
        return sinfectCode;
    }
    public void setSinfectName(String sinfectName)
    {
        this.sinfectName = sinfectName;
    }

    public String getSinfectName()
    {
        return sinfectName;
    }
    public void setServerityCode(String serverityCode)
    {
        this.serverityCode = serverityCode;
    }

    public String getServerityCode()
    {
        return serverityCode;
    }
    public void setServerityName(String serverityName)
    {
        this.serverityName = serverityName;
    }

    public String getServerityName()
    {
        return serverityName;
    }
    public void setLabResultCode(String labResultCode)
    {
        this.labResultCode = labResultCode;
    }

    public String getLabResultCode()
    {
        return labResultCode;
    }
    public void setLabResultName(String labResultName)
    {
        this.labResultName = labResultName;
    }

    public String getLabResultName()
    {
        return labResultName;
    }
    public void setHbsagCode(String hbsagCode)
    {
        this.hbsagCode = hbsagCode;
    }

    public String getHbsagCode()
    {
        return hbsagCode;
    }
    public void setHbsagName(String hbsagName)
    {
        this.hbsagName = hbsagName;
    }

    public String getHbsagName()
    {
        return hbsagName;
    }
    public void setHbsagFirst(Date hbsagFirst)
    {
        this.hbsagFirst = hbsagFirst;
    }

    public Date getHbsagFirst()
    {
        return hbsagFirst;
    }
    public void setHbsagBuxiang(String hbsagBuxiang)
    {
        this.hbsagBuxiang = hbsagBuxiang;
    }

    public String getHbsagBuxiang()
    {
        return hbsagBuxiang;
    }
    public void setHbsagAlt(String hbsagAlt)
    {
        this.hbsagAlt = hbsagAlt;
    }

    public String getHbsagAlt()
    {
        return hbsagAlt;
    }
    public void setHbcigResultCode(String hbcigResultCode)
    {
        this.hbcigResultCode = hbcigResultCode;
    }

    public String getHbcigResultCode()
    {
        return hbcigResultCode;
    }
    public void setHbcigResultName(String hbcigResultName)
    {
        this.hbcigResultName = hbcigResultName;
    }

    public String getHbcigResultName()
    {
        return hbcigResultName;
    }
    public void setHbliverPunctureCode(String hbliverPunctureCode)
    {
        this.hbliverPunctureCode = hbliverPunctureCode;
    }

    public String getHbliverPunctureCode()
    {
        return hbliverPunctureCode;
    }
    public void setHbliverPunctureName(String hbliverPunctureName)
    {
        this.hbliverPunctureName = hbliverPunctureName;
    }

    public String getHbliverPunctureName()
    {
        return hbliverPunctureName;
    }
    public void setHbsagChangeCode(String hbsagChangeCode)
    {
        this.hbsagChangeCode = hbsagChangeCode;
    }

    public String getHbsagChangeCode()
    {
        return hbsagChangeCode;
    }
    public void setHbsagChangeName(String hbsagChangeName)
    {
        this.hbsagChangeName = hbsagChangeName;
    }

    public String getHbsagChangeName()
    {
        return hbsagChangeName;
    }
    public void setContactflagCode(String contactflagCode)
    {
        this.contactflagCode = contactflagCode;
    }

    public String getContactflagCode()
    {
        return contactflagCode;
    }
    public void setContactflagName(String contactflagName)
    {
        this.contactflagName = contactflagName;
    }

    public String getContactflagName()
    {
        return contactflagName;
    }
    public void setFillDoctor(String fillDoctor)
    {
        this.fillDoctor = fillDoctor;
    }

    public String getFillDoctor()
    {
        return fillDoctor;
    }
    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public String getNotes()
    {
        return notes;
    }
    public void setNcvSeverityCode(String ncvSeverityCode)
    {
        this.ncvSeverityCode = ncvSeverityCode;
    }

    public String getNcvSeverityCode()
    {
        return ncvSeverityCode;
    }
    public void setNcvSeverityName(String ncvSeverityName)
    {
        this.ncvSeverityName = ncvSeverityName;
    }

    public String getNcvSeverityName()
    {
        return ncvSeverityName;
    }
    public void setForeignTypeCode(String foreignTypeCode)
    {
        this.foreignTypeCode = foreignTypeCode;
    }

    public String getForeignTypeCode()
    {
        return foreignTypeCode;
    }
    public void setForeignTypeName(String foreignTypeName)
    {
        this.foreignTypeName = foreignTypeName;
    }

    public String getForeignTypeName()
    {
        return foreignTypeName;
    }
    public void setPlaceCode(String placeCode)
    {
        this.placeCode = placeCode;
    }

    public String getPlaceCode()
    {
        return placeCode;
    }
    public void setPlaceName(String placeName)
    {
        this.placeName = placeName;
    }

    public String getPlaceName()
    {
        return placeName;
    }
    public void setReportZoneCode(String reportZoneCode)
    {
        this.reportZoneCode = reportZoneCode;
    }

    public String getReportZoneCode()
    {
        return reportZoneCode;
    }
    public void setReportZoneName(String reportZoneName)
    {
        this.reportZoneName = reportZoneName;
    }

    public String getReportZoneName()
    {
        return reportZoneName;
    }
    public void setReportOrgCode(String reportOrgCode)
    {
        this.reportOrgCode = reportOrgCode;
    }

    public String getReportOrgCode()
    {
        return reportOrgCode;
    }
    public void setReportOrgName(String reportOrgName)
    {
        this.reportOrgName = reportOrgName;
    }

    public String getReportOrgName()
    {
        return reportOrgName;
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
    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    public Date getBirthDate()
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
    public void setNultitudeTypeOther(String nultitudeTypeOther)
    {
        this.nultitudeTypeOther = nultitudeTypeOther;
    }

    public String getNultitudeTypeOther()
    {
        return nultitudeTypeOther;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("patientId", getPatientId())
                .append("serialNumber", getSerialNumber())
                .append("activityTypeCode", getActivityTypeCode())
                .append("activityTypeName", getActivityTypeName())
                .append("patientName", getPatientName())
                .append("idCardTypeCode", getIdCardTypeCode())
                .append("idCardTypeName", getIdCardTypeName())
                .append("idCard", getIdCard())
                .append("isDeadByThisCode", getIsDeadByThisCode())
                .append("isDeadByThisName", getIsDeadByThisName())
                .append("onsetDate", getOnsetDate())
                .append("symptomsCode", getSymptomsCode())
                .append("symptomsName", getSymptomsName())
                .append("diagnoseTime", getDiagnoseTime())
                .append("diseaseCode", getDiseaseCode())
                .append("diseaseName", getDiseaseName())
                .append("diseaseOther", getDiseaseOther())
                .append("diagnoseStateCode", getDiagnoseStateCode())
                .append("diagnoseStateName", getDiagnoseStateName())
                .append("caseTypeCode", getCaseTypeCode())
                .append("caseTypeName", getCaseTypeName())
                .append("deadDate", getDeadDate())
                .append("laboratoryDetectionVerdictCode", getLaboratoryDetectionVerdictCode())
                .append("laboratoryDetectionVerdictName", getLaboratoryDetectionVerdictName())
                .append("detectionPositiveDate", getDetectionPositiveDate())
                .append("detectionOrgCode", getDetectionOrgCode())
                .append("dtDiagnose", getDtDiagnose())
                .append("afpAreatype1Code", getAfpAreatype1Code())
                .append("afpAreatype1Name", getAfpAreatype1Name())
                .append("afpPalsyDate", getAfpPalsyDate())
                .append("afpDoctorDate", getAfpDoctorDate())
                .append("afpAreatype2Code", getAfpAreatype2Code())
                .append("afpAreatype2Name", getAfpAreatype2Name())
                .append("afpAddrcodeCode", getAfpAddrcodeCode())
                .append("afpAddrcodeName", getAfpAddrcodeName())
                .append("afpAddr", getAfpAddr())
                .append("afpPalsySymptom", getAfpPalsySymptom())
                .append("reportDate", getReportDate())
                .append("discoveryModeCode", getDiscoveryModeCode())
                .append("discoveryModeName", getDiscoveryModeName())
                .append("discoveryModeOther", getDiscoveryModeOther())
                .append("venerealDisCode", getVenerealDisCode())
                .append("venerealDisName", getVenerealDisName())
                .append("bsTransmissionCode", getBsTransmissionCode())
                .append("bsTransmissionName", getBsTransmissionName())
                .append("bsTransmissionOther", getBsTransmissionOther())
                .append("contactTypeCode", getContactTypeCode())
                .append("contactTypeName", getContactTypeName())
                .append("injectCount", getInjectCount())
                .append("nonwebCount", getNonwebCount())
                .append("smCount", getSmCount())
                .append("contactOther", getContactOther())
                .append("sinfectCode", getSinfectCode())
                .append("sinfectName", getSinfectName())
                .append("serverityCode", getServerityCode())
                .append("serverityName", getServerityName())
                .append("labResultCode", getLabResultCode())
                .append("labResultName", getLabResultName())
                .append("hbsagCode", getHbsagCode())
                .append("hbsagName", getHbsagName())
                .append("hbsagFirst", getHbsagFirst())
                .append("hbsagBuxiang", getHbsagBuxiang())
                .append("hbsagAlt", getHbsagAlt())
                .append("hbcigResultCode", getHbcigResultCode())
                .append("hbcigResultName", getHbcigResultName())
                .append("hbliverPunctureCode", getHbliverPunctureCode())
                .append("hbliverPunctureName", getHbliverPunctureName())
                .append("hbsagChangeCode", getHbsagChangeCode())
                .append("hbsagChangeName", getHbsagChangeName())
                .append("contactflagCode", getContactflagCode())
                .append("contactflagName", getContactflagName())
                .append("fillDoctor", getFillDoctor())
                .append("notes", getNotes())
                .append("ncvSeverityCode", getNcvSeverityCode())
                .append("ncvSeverityName", getNcvSeverityName())
                .append("foreignTypeCode", getForeignTypeCode())
                .append("foreignTypeName", getForeignTypeName())
                .append("placeCode", getPlaceCode())
                .append("placeName", getPlaceName())
                .append("reportZoneCode", getReportZoneCode())
                .append("reportZoneName", getReportZoneName())
                .append("reportOrgCode", getReportOrgCode())
                .append("reportOrgName", getReportOrgName())
                .append("operatorId", getOperatorId())
                .append("operationTime", getOperationTime())
                .append("invalidFlag", getInvalidFlag())
                .append("dataStatus", getDataStatus())
                .append("createDate", getCreateDate())
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
                .append("educationCode", getEducationCode())
                .append("educationName", getEducationName())
                .append("nultitudeTypeCode", getNultitudeTypeCode())
                .append("nultitudeTypeName", getNultitudeTypeName())
                .append("nultitudeTypeOther", getNultitudeTypeOther())
                .append("deptCode", getDeptCode())
                .append("deptName", getDeptName())
                .toString();
    }
}
