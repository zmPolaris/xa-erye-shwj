package cn.xa.eyre.outpadm.domain;

import java.math.BigDecimal;
import java.util.Date;

public class ClinicMaster extends ClinicMasterKey {
    private Date visitDate;

    private Integer visitNo;


    private String clinicLabel;

    private String visitTimeDesc;

    private Short serialNo;

    private String patientId;

    private String name;

    private String namePhonetic;

    private String sex;

    private Short age;

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

    private Short mrProvidedIndicator;

    private Short registrationStatus;

    private Date registeringDate;

    private String symptom;

    private String clinicClass;

    private BigDecimal registFee;

    private BigDecimal clinicFee;

    private BigDecimal otherFee;

    private String operator;

    private Date returnedDate;

    private String returnedOperator;

    private String diagnosisCode;

    private Short mrProvideIndicator;

    private String rcptNo;

    private Short printFlag;

    private Short acctFlag;

    private String internalNo;

    private String identityClass;

    private BigDecimal clinicCharge;

    private String returnedAcctNo;

    private String acctNo;

    private String payWay;

    private String gsid;

    private Date visitTime;

    private String serviceClass;

    private String armedServices;

    private Short serviceSystemIndicator;

    private String jzdyh;

    private BigDecimal ydReturnedFee;

    private BigDecimal ygfundPaySumamt;

    private String securityTypeCode;

    private String powerpaychannel;

    private String powertranid;

    private String setlId;

    private String medType;

    private String checkupid;

    private String powertranidRefund;

    private BigDecimal totalRegist;

    private BigDecimal totalClinic;

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

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
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

    @Override
    public Date getVisitDate() {
        return visitDate;
    }

    @Override
    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public Integer getVisitNo() {
        return visitNo;
    }

    @Override
    public void setVisitNo(Integer visitNo) {
        this.visitNo = visitNo;
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

    public Short getMrProvidedIndicator() {
        return mrProvidedIndicator;
    }

    public void setMrProvidedIndicator(Short mrProvidedIndicator) {
        this.mrProvidedIndicator = mrProvidedIndicator;
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

    public String getClinicClass() {
        return clinicClass;
    }

    public void setClinicClass(String clinicClass) {
        this.clinicClass = clinicClass == null ? null : clinicClass.trim();
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

    public String getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode == null ? null : diagnosisCode.trim();
    }

    public Short getMrProvideIndicator() {
        return mrProvideIndicator;
    }

    public void setMrProvideIndicator(Short mrProvideIndicator) {
        this.mrProvideIndicator = mrProvideIndicator;
    }

    public String getRcptNo() {
        return rcptNo;
    }

    public void setRcptNo(String rcptNo) {
        this.rcptNo = rcptNo == null ? null : rcptNo.trim();
    }

    public Short getPrintFlag() {
        return printFlag;
    }

    public void setPrintFlag(Short printFlag) {
        this.printFlag = printFlag;
    }

    public Short getAcctFlag() {
        return acctFlag;
    }

    public void setAcctFlag(Short acctFlag) {
        this.acctFlag = acctFlag;
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

    public BigDecimal getClinicCharge() {
        return clinicCharge;
    }

    public void setClinicCharge(BigDecimal clinicCharge) {
        this.clinicCharge = clinicCharge;
    }

    public String getReturnedAcctNo() {
        return returnedAcctNo;
    }

    public void setReturnedAcctNo(String returnedAcctNo) {
        this.returnedAcctNo = returnedAcctNo == null ? null : returnedAcctNo.trim();
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

    public String getGsid() {
        return gsid;
    }

    public void setGsid(String gsid) {
        this.gsid = gsid == null ? null : gsid.trim();
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
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

    public String getJzdyh() {
        return jzdyh;
    }

    public void setJzdyh(String jzdyh) {
        this.jzdyh = jzdyh == null ? null : jzdyh.trim();
    }

    public BigDecimal getYdReturnedFee() {
        return ydReturnedFee;
    }

    public void setYdReturnedFee(BigDecimal ydReturnedFee) {
        this.ydReturnedFee = ydReturnedFee;
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

    public String getPowerpaychannel() {
        return powerpaychannel;
    }

    public void setPowerpaychannel(String powerpaychannel) {
        this.powerpaychannel = powerpaychannel == null ? null : powerpaychannel.trim();
    }

    public String getPowertranid() {
        return powertranid;
    }

    public void setPowertranid(String powertranid) {
        this.powertranid = powertranid == null ? null : powertranid.trim();
    }

    public String getSetlId() {
        return setlId;
    }

    public void setSetlId(String setlId) {
        this.setlId = setlId == null ? null : setlId.trim();
    }

    public String getMedType() {
        return medType;
    }

    public void setMedType(String medType) {
        this.medType = medType == null ? null : medType.trim();
    }

    public String getCheckupid() {
        return checkupid;
    }

    public void setCheckupid(String checkupid) {
        this.checkupid = checkupid == null ? null : checkupid.trim();
    }

    public String getPowertranidRefund() {
        return powertranidRefund;
    }

    public void setPowertranidRefund(String powertranidRefund) {
        this.powertranidRefund = powertranidRefund == null ? null : powertranidRefund.trim();
    }

    public BigDecimal getTotalRegist() {
        return totalRegist;
    }

    public void setTotalRegist(BigDecimal totalRegist) {
        this.totalRegist = totalRegist;
    }

    public BigDecimal getTotalClinic() {
        return totalClinic;
    }

    public void setTotalClinic(BigDecimal totalClinic) {
        this.totalClinic = totalClinic;
    }
}