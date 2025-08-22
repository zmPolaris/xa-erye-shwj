package cn.xa.eyre.hub.domain.emrmonitor;

import java.util.Date;

import cn.xa.eyre.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 住院病案首页——对象 emr_admission_record
 *
 * @author ruoyi
 * @date 2025-06-11
 */
public class EmrAdmissionRecord extends BaseEntity
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

    /** 医疗付费方式代码 */
    private String payMethodCode;

    /** 医疗付费方式 */
    private String payMethodName;

    /** 居民健康卡号 */
    private String healthCardNo;

    /** 住院次数 */
    private String admissionNum;

    /** 病案号 */
    private String regNo;

    /** 入院日期时间 */
    private String admissionDate;

    /** 入院科别代码 */
    private String admissionDeptCode;

    /** 入院科别名称 */
    private String admissionDeptName;

    /** 入院病房 */
    private String wardNo;

    /** 出院日期时间 */
    private String dischargeDate;

    /** 出院科别代码 */
    private String dischargeDeptCode;

    /** 出院科别名称 */
    private String dischargeDeptName;

    /** 出院病房 */
    private String dischargeWard;

    /** 实际住院天数 */
    private String admissionDays;

    /** 门（急)诊诊断 */
    private String wmOutpatientDiagnosisName;

    /** 门（急)诊诊断代码 */
    private String wmOutpatientDiagnosisCode;

    /** 出院诊断-主要西医诊断 */
    private String dischargeDiagnosisName;

    /** 出院诊断-主要西医诊断代码 */
    private String dischargeDiagnosisCode;

    /** 出院诊断-其他诊断 */
    private String wmOtherDiagnosisName;

    /** 出院诊断-其他诊断代码 */
    private String wmOtherDiagnosisCode;

    /** 损伤中毒的外部原因疾病 */
    private String externalCausesName;

    /** 损伤中毒的外部原因疾病代码 */
    private String externalCausesCode;

    /** 损伤中毒的外部原因系统疾病名称 */
    private String externalCausesSystemName;

    /** 病理诊断名称 */
    private String pathologicalDiagnosisName;

    /** 病理诊断代码 */
    private String pathologicalDiagnosisCode;

    /** 病理号 */
    private String pathologicalNo;

    /** 药物过敏标志 */
    private String allergyCode;

    /** 过敏药物 */
    private String allergyDrug;

    /** 死亡患者尸检标志 */
    private String autopsyCode;

    /** 主治医师ID */
    private String chiefPhysicianId;

    /** 住院医师ID */
    private String residentPhysicianId;

    /** 拟接收医疗机构代码 */
    private String acceptOrgCode;

    /** 拟接收医疗机构名称 */
    private String acceptOrgName;

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
    private String createDate;

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
    public void setPayMethodCode(String payMethodCode)
    {
        this.payMethodCode = payMethodCode;
    }

    public String getPayMethodCode()
    {
        return payMethodCode;
    }
    public void setPayMethodName(String payMethodName)
    {
        this.payMethodName = payMethodName;
    }

    public String getPayMethodName()
    {
        return payMethodName;
    }
    public void setHealthCardNo(String healthCardNo)
    {
        this.healthCardNo = healthCardNo;
    }

    public String getHealthCardNo()
    {
        return healthCardNo;
    }
    public void setAdmissionNum(String admissionNum)
    {
        this.admissionNum = admissionNum;
    }

    public String getAdmissionNum()
    {
        return admissionNum;
    }
    public void setRegNo(String regNo)
    {
        this.regNo = regNo;
    }

    public String getRegNo()
    {
        return regNo;
    }
    public void setAdmissionDate(String admissionDate)
    {
        this.admissionDate = admissionDate;
    }

    public String getAdmissionDate()
    {
        return admissionDate;
    }
    public void setAdmissionDeptCode(String admissionDeptCode)
    {
        this.admissionDeptCode = admissionDeptCode;
    }

    public String getAdmissionDeptCode()
    {
        return admissionDeptCode;
    }
    public void setAdmissionDeptName(String admissionDeptName)
    {
        this.admissionDeptName = admissionDeptName;
    }

    public String getAdmissionDeptName()
    {
        return admissionDeptName;
    }
    public void setWardNo(String wardNo)
    {
        this.wardNo = wardNo;
    }

    public String getWardNo()
    {
        return wardNo;
    }
    public void setDischargeDate(String dischargeDate)
    {
        this.dischargeDate = dischargeDate;
    }

    public String getDischargeDate()
    {
        return dischargeDate;
    }
    public void setDischargeDeptCode(String dischargeDeptCode)
    {
        this.dischargeDeptCode = dischargeDeptCode;
    }

    public String getDischargeDeptCode()
    {
        return dischargeDeptCode;
    }
    public void setDischargeDeptName(String dischargeDeptName)
    {
        this.dischargeDeptName = dischargeDeptName;
    }

    public String getDischargeDeptName()
    {
        return dischargeDeptName;
    }
    public void setDischargeWard(String dischargeWard)
    {
        this.dischargeWard = dischargeWard;
    }

    public String getDischargeWard()
    {
        return dischargeWard;
    }
    public void setAdmissionDays(String admissionDays)
    {
        this.admissionDays = admissionDays;
    }

    public String getAdmissionDays()
    {
        return admissionDays;
    }
    public void setWmOutpatientDiagnosisName(String wmOutpatientDiagnosisName)
    {
        this.wmOutpatientDiagnosisName = wmOutpatientDiagnosisName;
    }

    public String getWmOutpatientDiagnosisName()
    {
        return wmOutpatientDiagnosisName;
    }
    public void setWmOutpatientDiagnosisCode(String wmOutpatientDiagnosisCode)
    {
        this.wmOutpatientDiagnosisCode = wmOutpatientDiagnosisCode;
    }

    public String getWmOutpatientDiagnosisCode()
    {
        return wmOutpatientDiagnosisCode;
    }
    public void setDischargeDiagnosisName(String dischargeDiagnosisName)
    {
        this.dischargeDiagnosisName = dischargeDiagnosisName;
    }

    public String getDischargeDiagnosisName()
    {
        return dischargeDiagnosisName;
    }
    public void setDischargeDiagnosisCode(String dischargeDiagnosisCode)
    {
        this.dischargeDiagnosisCode = dischargeDiagnosisCode;
    }

    public String getDischargeDiagnosisCode()
    {
        return dischargeDiagnosisCode;
    }
    public void setWmOtherDiagnosisName(String wmOtherDiagnosisName)
    {
        this.wmOtherDiagnosisName = wmOtherDiagnosisName;
    }

    public String getWmOtherDiagnosisName()
    {
        return wmOtherDiagnosisName;
    }
    public void setWmOtherDiagnosisCode(String wmOtherDiagnosisCode)
    {
        this.wmOtherDiagnosisCode = wmOtherDiagnosisCode;
    }

    public String getWmOtherDiagnosisCode()
    {
        return wmOtherDiagnosisCode;
    }
    public void setExternalCausesName(String externalCausesName)
    {
        this.externalCausesName = externalCausesName;
    }

    public String getExternalCausesName()
    {
        return externalCausesName;
    }
    public void setExternalCausesCode(String externalCausesCode)
    {
        this.externalCausesCode = externalCausesCode;
    }

    public String getExternalCausesCode()
    {
        return externalCausesCode;
    }
    public void setExternalCausesSystemName(String externalCausesSystemName)
    {
        this.externalCausesSystemName = externalCausesSystemName;
    }

    public String getExternalCausesSystemName()
    {
        return externalCausesSystemName;
    }
    public void setPathologicalDiagnosisName(String pathologicalDiagnosisName)
    {
        this.pathologicalDiagnosisName = pathologicalDiagnosisName;
    }

    public String getPathologicalDiagnosisName()
    {
        return pathologicalDiagnosisName;
    }
    public void setPathologicalDiagnosisCode(String pathologicalDiagnosisCode)
    {
        this.pathologicalDiagnosisCode = pathologicalDiagnosisCode;
    }

    public String getPathologicalDiagnosisCode()
    {
        return pathologicalDiagnosisCode;
    }
    public void setPathologicalNo(String pathologicalNo)
    {
        this.pathologicalNo = pathologicalNo;
    }

    public String getPathologicalNo()
    {
        return pathologicalNo;
    }
    public void setAllergyCode(String allergyCode)
    {
        this.allergyCode = allergyCode;
    }

    public String getAllergyCode()
    {
        return allergyCode;
    }
    public void setAllergyDrug(String allergyDrug)
    {
        this.allergyDrug = allergyDrug;
    }

    public String getAllergyDrug()
    {
        return allergyDrug;
    }
    public void setAutopsyCode(String autopsyCode)
    {
        this.autopsyCode = autopsyCode;
    }

    public String getAutopsyCode()
    {
        return autopsyCode;
    }
    public void setChiefPhysicianId(String chiefPhysicianId)
    {
        this.chiefPhysicianId = chiefPhysicianId;
    }

    public String getChiefPhysicianId()
    {
        return chiefPhysicianId;
    }
    public void setResidentPhysicianId(String residentPhysicianId)
    {
        this.residentPhysicianId = residentPhysicianId;
    }

    public String getResidentPhysicianId()
    {
        return residentPhysicianId;
    }
    public void setAcceptOrgCode(String acceptOrgCode)
    {
        this.acceptOrgCode = acceptOrgCode;
    }

    public String getAcceptOrgCode()
    {
        return acceptOrgCode;
    }
    public void setAcceptOrgName(String acceptOrgName)
    {
        this.acceptOrgName = acceptOrgName;
    }

    public String getAcceptOrgName()
    {
        return acceptOrgName;
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
                .append("payMethodCode", getPayMethodCode())
                .append("payMethodName", getPayMethodName())
                .append("healthCardNo", getHealthCardNo())
                .append("admissionNum", getAdmissionNum())
                .append("regNo", getRegNo())
                .append("admissionDate", getAdmissionDate())
                .append("admissionDeptCode", getAdmissionDeptCode())
                .append("admissionDeptName", getAdmissionDeptName())
                .append("wardNo", getWardNo())
                .append("dischargeDate", getDischargeDate())
                .append("dischargeDeptCode", getDischargeDeptCode())
                .append("dischargeDeptName", getDischargeDeptName())
                .append("dischargeWard", getDischargeWard())
                .append("admissionDays", getAdmissionDays())
                .append("wmOutpatientDiagnosisName", getWmOutpatientDiagnosisName())
                .append("wmOutpatientDiagnosisCode", getWmOutpatientDiagnosisCode())
                .append("dischargeDiagnosisName", getDischargeDiagnosisName())
                .append("dischargeDiagnosisCode", getDischargeDiagnosisCode())
                .append("wmOtherDiagnosisName", getWmOtherDiagnosisName())
                .append("wmOtherDiagnosisCode", getWmOtherDiagnosisCode())
                .append("externalCausesName", getExternalCausesName())
                .append("externalCausesCode", getExternalCausesCode())
                .append("externalCausesSystemName", getExternalCausesSystemName())
                .append("pathologicalDiagnosisName", getPathologicalDiagnosisName())
                .append("pathologicalDiagnosisCode", getPathologicalDiagnosisCode())
                .append("pathologicalNo", getPathologicalNo())
                .append("allergyCode", getAllergyCode())
                .append("allergyDrug", getAllergyDrug())
                .append("autopsyCode", getAutopsyCode())
                .append("chiefPhysicianId", getChiefPhysicianId())
                .append("residentPhysicianId", getResidentPhysicianId())
                .append("acceptOrgCode", getAcceptOrgCode())
                .append("acceptOrgName", getAcceptOrgName())
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
