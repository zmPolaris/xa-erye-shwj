package cn.xa.eyre.outpadm.domain;

import java.math.BigDecimal;
import java.util.Date;

public class ClinicMaster extends ClinicMasterKey {
    private String clinicLabel;

    private String visitTimeDesc;

    private Short serialNo;

    private String patientId;

    private String name;

    private String namePhonetic;

    private String sex;

    private BigDecimal age;

    private String identity;

    private String chargeType;

    private String insuranceType;

    private String insuranceNo;

    private String unitInContract;

    private String clinicType;

    private Short firstVisitIndicator;

    private String visitDept;

    private String visitSpecialClinic;

    private String doctor;

    private Short mrProvideIndicator;

    private Short registrationStatus;

    private Date registeringDate;

    private String symptom;

    private BigDecimal registFee;

    private BigDecimal clinicFee;

    private BigDecimal otherFee;

    private String operator;

    private Date returnedDate;

    private String returnedOperator;

    private BigDecimal clinicCharge;

    private String internalNo;

    private String identityClass;

    private String invoiceNo;

    private String modeCode;

    private String cardName;

    private String cardNo;

    private Date acctDateTime;

    private String acctNo;

    private String payWay;

    private Short mrProvidedIndicator;

    private Date tallyDate;

    private String tallyUser;

    private String clinicNo;

    private String realSort;

    private String idNo;

    private String ghlsh;

    private Short outpId;

    private String diagcode;

    private String rcptNo;

    private String returnedAcctNo;

    private String serviceClass;

    private String armedServices;

    private Short serviceSystemIndicator;

    private BigDecimal ygfundPaySumamt;

    private String securityTypeCode;

    private String calWay;

    private String postradeno;

    private String eciRegId;

    private String diagnoseRoomId;

    private String doctorId;

    private Date visitTime;

    private String registrationTypeId;

    private String regDoctorId;

    private String regDeptId;

    private String regClinicDeptId;

    private String waitingAreaId;

    private String dutySettingId;

    private String dutyTimeRangeId;

    private String diagnosisDesc;

    private String ygfundPayWay;

    private String patientLabel;

    private String lastLabelStaffId;

    private Date lastLabelTime;

    private String arrangeDetailId;

    private Short rVisitNo;

    private Date rVisitDate;

    private String verifyCode;

    private String patientClass;

    private String transferMark;

    public String getClinicLabel() {
        return clinicLabel;
    }

    public void setClinicLabel(String clinicLabel) {
        this.clinicLabel = clinicLabel == null ? null : clinicLabel.trim();
    }

    public String getVisitTimeDesc() {
        return visitTimeDesc;
    }

    public void setVisitTimeDesc(String visitTimeDesc) {
        this.visitTimeDesc = visitTimeDesc == null ? null : visitTimeDesc.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNamePhonetic() {
        return namePhonetic;
    }

    public void setNamePhonetic(String namePhonetic) {
        this.namePhonetic = namePhonetic == null ? null : namePhonetic.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType == null ? null : insuranceType.trim();
    }

    public String getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo == null ? null : insuranceNo.trim();
    }

    public String getUnitInContract() {
        return unitInContract;
    }

    public void setUnitInContract(String unitInContract) {
        this.unitInContract = unitInContract == null ? null : unitInContract.trim();
    }

    public String getClinicType() {
        return clinicType;
    }

    public void setClinicType(String clinicType) {
        this.clinicType = clinicType == null ? null : clinicType.trim();
    }

    public Short getFirstVisitIndicator() {
        return firstVisitIndicator;
    }

    public void setFirstVisitIndicator(Short firstVisitIndicator) {
        this.firstVisitIndicator = firstVisitIndicator;
    }

    public String getVisitDept() {
        return visitDept;
    }

    public void setVisitDept(String visitDept) {
        this.visitDept = visitDept == null ? null : visitDept.trim();
    }

    public String getVisitSpecialClinic() {
        return visitSpecialClinic;
    }

    public void setVisitSpecialClinic(String visitSpecialClinic) {
        this.visitSpecialClinic = visitSpecialClinic == null ? null : visitSpecialClinic.trim();
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor == null ? null : doctor.trim();
    }

    public Short getMrProvideIndicator() {
        return mrProvideIndicator;
    }

    public void setMrProvideIndicator(Short mrProvideIndicator) {
        this.mrProvideIndicator = mrProvideIndicator;
    }

    public Short getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(Short registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public Date getRegisteringDate() {
        return registeringDate;
    }

    public void setRegisteringDate(Date registeringDate) {
        this.registeringDate = registeringDate;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom == null ? null : symptom.trim();
    }

    public BigDecimal getRegistFee() {
        return registFee;
    }

    public void setRegistFee(BigDecimal registFee) {
        this.registFee = registFee;
    }

    public BigDecimal getClinicFee() {
        return clinicFee;
    }

    public void setClinicFee(BigDecimal clinicFee) {
        this.clinicFee = clinicFee;
    }

    public BigDecimal getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(BigDecimal otherFee) {
        this.otherFee = otherFee;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public String getReturnedOperator() {
        return returnedOperator;
    }

    public void setReturnedOperator(String returnedOperator) {
        this.returnedOperator = returnedOperator == null ? null : returnedOperator.trim();
    }

    public BigDecimal getClinicCharge() {
        return clinicCharge;
    }

    public void setClinicCharge(BigDecimal clinicCharge) {
        this.clinicCharge = clinicCharge;
    }

    public String getInternalNo() {
        return internalNo;
    }

    public void setInternalNo(String internalNo) {
        this.internalNo = internalNo == null ? null : internalNo.trim();
    }

    public String getIdentityClass() {
        return identityClass;
    }

    public void setIdentityClass(String identityClass) {
        this.identityClass = identityClass == null ? null : identityClass.trim();
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo == null ? null : invoiceNo.trim();
    }

    public String getModeCode() {
        return modeCode;
    }

    public void setModeCode(String modeCode) {
        this.modeCode = modeCode == null ? null : modeCode.trim();
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName == null ? null : cardName.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public Date getAcctDateTime() {
        return acctDateTime;
    }

    public void setAcctDateTime(Date acctDateTime) {
        this.acctDateTime = acctDateTime;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo == null ? null : acctNo.trim();
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
    }

    public Short getMrProvidedIndicator() {
        return mrProvidedIndicator;
    }

    public void setMrProvidedIndicator(Short mrProvidedIndicator) {
        this.mrProvidedIndicator = mrProvidedIndicator;
    }

    public Date getTallyDate() {
        return tallyDate;
    }

    public void setTallyDate(Date tallyDate) {
        this.tallyDate = tallyDate;
    }

    public String getTallyUser() {
        return tallyUser;
    }

    public void setTallyUser(String tallyUser) {
        this.tallyUser = tallyUser == null ? null : tallyUser.trim();
    }

    public String getClinicNo() {
        return clinicNo;
    }

    public void setClinicNo(String clinicNo) {
        this.clinicNo = clinicNo == null ? null : clinicNo.trim();
    }

    public String getRealSort() {
        return realSort;
    }

    public void setRealSort(String realSort) {
        this.realSort = realSort == null ? null : realSort.trim();
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public String getGhlsh() {
        return ghlsh;
    }

    public void setGhlsh(String ghlsh) {
        this.ghlsh = ghlsh == null ? null : ghlsh.trim();
    }

    public Short getOutpId() {
        return outpId;
    }

    public void setOutpId(Short outpId) {
        this.outpId = outpId;
    }

    public String getDiagcode() {
        return diagcode;
    }

    public void setDiagcode(String diagcode) {
        this.diagcode = diagcode == null ? null : diagcode.trim();
    }

    public String getRcptNo() {
        return rcptNo;
    }

    public void setRcptNo(String rcptNo) {
        this.rcptNo = rcptNo == null ? null : rcptNo.trim();
    }

    public String getReturnedAcctNo() {
        return returnedAcctNo;
    }

    public void setReturnedAcctNo(String returnedAcctNo) {
        this.returnedAcctNo = returnedAcctNo == null ? null : returnedAcctNo.trim();
    }

    public String getServiceClass() {
        return serviceClass;
    }

    public void setServiceClass(String serviceClass) {
        this.serviceClass = serviceClass == null ? null : serviceClass.trim();
    }

    public String getArmedServices() {
        return armedServices;
    }

    public void setArmedServices(String armedServices) {
        this.armedServices = armedServices == null ? null : armedServices.trim();
    }

    public Short getServiceSystemIndicator() {
        return serviceSystemIndicator;
    }

    public void setServiceSystemIndicator(Short serviceSystemIndicator) {
        this.serviceSystemIndicator = serviceSystemIndicator;
    }

    public BigDecimal getYgfundPaySumamt() {
        return ygfundPaySumamt;
    }

    public void setYgfundPaySumamt(BigDecimal ygfundPaySumamt) {
        this.ygfundPaySumamt = ygfundPaySumamt;
    }

    public String getSecurityTypeCode() {
        return securityTypeCode;
    }

    public void setSecurityTypeCode(String securityTypeCode) {
        this.securityTypeCode = securityTypeCode == null ? null : securityTypeCode.trim();
    }

    public String getCalWay() {
        return calWay;
    }

    public void setCalWay(String calWay) {
        this.calWay = calWay == null ? null : calWay.trim();
    }

    public String getPostradeno() {
        return postradeno;
    }

    public void setPostradeno(String postradeno) {
        this.postradeno = postradeno == null ? null : postradeno.trim();
    }

    public String getEciRegId() {
        return eciRegId;
    }

    public void setEciRegId(String eciRegId) {
        this.eciRegId = eciRegId == null ? null : eciRegId.trim();
    }

    public String getDiagnoseRoomId() {
        return diagnoseRoomId;
    }

    public void setDiagnoseRoomId(String diagnoseRoomId) {
        this.diagnoseRoomId = diagnoseRoomId == null ? null : diagnoseRoomId.trim();
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId == null ? null : doctorId.trim();
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getRegistrationTypeId() {
        return registrationTypeId;
    }

    public void setRegistrationTypeId(String registrationTypeId) {
        this.registrationTypeId = registrationTypeId == null ? null : registrationTypeId.trim();
    }

    public String getRegDoctorId() {
        return regDoctorId;
    }

    public void setRegDoctorId(String regDoctorId) {
        this.regDoctorId = regDoctorId == null ? null : regDoctorId.trim();
    }

    public String getRegDeptId() {
        return regDeptId;
    }

    public void setRegDeptId(String regDeptId) {
        this.regDeptId = regDeptId == null ? null : regDeptId.trim();
    }

    public String getRegClinicDeptId() {
        return regClinicDeptId;
    }

    public void setRegClinicDeptId(String regClinicDeptId) {
        this.regClinicDeptId = regClinicDeptId == null ? null : regClinicDeptId.trim();
    }

    public String getWaitingAreaId() {
        return waitingAreaId;
    }

    public void setWaitingAreaId(String waitingAreaId) {
        this.waitingAreaId = waitingAreaId == null ? null : waitingAreaId.trim();
    }

    public String getDutySettingId() {
        return dutySettingId;
    }

    public void setDutySettingId(String dutySettingId) {
        this.dutySettingId = dutySettingId == null ? null : dutySettingId.trim();
    }

    public String getDutyTimeRangeId() {
        return dutyTimeRangeId;
    }

    public void setDutyTimeRangeId(String dutyTimeRangeId) {
        this.dutyTimeRangeId = dutyTimeRangeId == null ? null : dutyTimeRangeId.trim();
    }

    public String getDiagnosisDesc() {
        return diagnosisDesc;
    }

    public void setDiagnosisDesc(String diagnosisDesc) {
        this.diagnosisDesc = diagnosisDesc == null ? null : diagnosisDesc.trim();
    }

    public String getYgfundPayWay() {
        return ygfundPayWay;
    }

    public void setYgfundPayWay(String ygfundPayWay) {
        this.ygfundPayWay = ygfundPayWay == null ? null : ygfundPayWay.trim();
    }

    public String getPatientLabel() {
        return patientLabel;
    }

    public void setPatientLabel(String patientLabel) {
        this.patientLabel = patientLabel == null ? null : patientLabel.trim();
    }

    public String getLastLabelStaffId() {
        return lastLabelStaffId;
    }

    public void setLastLabelStaffId(String lastLabelStaffId) {
        this.lastLabelStaffId = lastLabelStaffId == null ? null : lastLabelStaffId.trim();
    }

    public Date getLastLabelTime() {
        return lastLabelTime;
    }

    public void setLastLabelTime(Date lastLabelTime) {
        this.lastLabelTime = lastLabelTime;
    }

    public String getArrangeDetailId() {
        return arrangeDetailId;
    }

    public void setArrangeDetailId(String arrangeDetailId) {
        this.arrangeDetailId = arrangeDetailId == null ? null : arrangeDetailId.trim();
    }

    public Short getrVisitNo() {
        return rVisitNo;
    }

    public void setrVisitNo(Short rVisitNo) {
        this.rVisitNo = rVisitNo;
    }

    public Date getrVisitDate() {
        return rVisitDate;
    }

    public void setrVisitDate(Date rVisitDate) {
        this.rVisitDate = rVisitDate;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode == null ? null : verifyCode.trim();
    }

    public String getPatientClass() {
        return patientClass;
    }

    public void setPatientClass(String patientClass) {
        this.patientClass = patientClass == null ? null : patientClass.trim();
    }

    public String getTransferMark() {
        return transferMark;
    }

    public void setTransferMark(String transferMark) {
        this.transferMark = transferMark == null ? null : transferMark.trim();
    }
}