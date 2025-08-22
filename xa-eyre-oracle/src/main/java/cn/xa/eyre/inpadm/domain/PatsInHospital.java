package cn.xa.eyre.inpadm.domain;

import java.math.BigDecimal;
import java.util.Date;

public class PatsInHospital {
    private String patientId;

    private Short visitId;

    private String wardCode;

    private String deptCode;

    private Short bedNo;

    private Date admissionDateTime;

    private Date admWardDateTime;

    private String diagnosis;

    private String patientCondition;

    private String nursingClass;

    private String doctorInCharge;

    private Date operatingDate;

    private Date billingDateTime;

    private BigDecimal prepayments;

    private BigDecimal totalCosts;

    private BigDecimal totalCharges;

    private String guarantor;

    private String guarantorOrg;

    private String guarantorPhoneNum;

    private Date billCheckedDateTime;

    private Short settledIndicator;

    private Short lendBedNo;

    private String bedDeptCode;

    private String bedWardCode;

    private String deptCodeLend;

    private Short lendIndicator;

    private Short isNewborn;

    private BigDecimal payFromAccount;

    private BigDecimal payFromFund;

    private BigDecimal payFromInsured;

    private BigDecimal payWay;

    private String deptInCharge;

    private Date startDateTime;

    private Integer frequencyNurse;

    private String bedLabel;

    private String nurseInCharge;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public Short getVisitId() {
        return visitId;
    }

    public void setVisitId(Short visitId) {
        this.visitId = visitId;
    }

    public String getWardCode() {
        return wardCode;
    }

    public void setWardCode(String wardCode) {
        this.wardCode = wardCode == null ? null : wardCode.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public Short getBedNo() {
        return bedNo;
    }

    public void setBedNo(Short bedNo) {
        this.bedNo = bedNo;
    }

    public Date getAdmissionDateTime() {
        return admissionDateTime;
    }

    public void setAdmissionDateTime(Date admissionDateTime) {
        this.admissionDateTime = admissionDateTime;
    }

    public Date getAdmWardDateTime() {
        return admWardDateTime;
    }

    public void setAdmWardDateTime(Date admWardDateTime) {
        this.admWardDateTime = admWardDateTime;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis == null ? null : diagnosis.trim();
    }

    public String getPatientCondition() {
        return patientCondition;
    }

    public void setPatientCondition(String patientCondition) {
        this.patientCondition = patientCondition == null ? null : patientCondition.trim();
    }

    public String getNursingClass() {
        return nursingClass;
    }

    public void setNursingClass(String nursingClass) {
        this.nursingClass = nursingClass == null ? null : nursingClass.trim();
    }

    public String getDoctorInCharge() {
        return doctorInCharge;
    }

    public void setDoctorInCharge(String doctorInCharge) {
        this.doctorInCharge = doctorInCharge == null ? null : doctorInCharge.trim();
    }

    public Date getOperatingDate() {
        return operatingDate;
    }

    public void setOperatingDate(Date operatingDate) {
        this.operatingDate = operatingDate;
    }

    public Date getBillingDateTime() {
        return billingDateTime;
    }

    public void setBillingDateTime(Date billingDateTime) {
        this.billingDateTime = billingDateTime;
    }

    public BigDecimal getPrepayments() {
        return prepayments;
    }

    public void setPrepayments(BigDecimal prepayments) {
        this.prepayments = prepayments;
    }

    public BigDecimal getTotalCosts() {
        return totalCosts;
    }

    public void setTotalCosts(BigDecimal totalCosts) {
        this.totalCosts = totalCosts;
    }

    public BigDecimal getTotalCharges() {
        return totalCharges;
    }

    public void setTotalCharges(BigDecimal totalCharges) {
        this.totalCharges = totalCharges;
    }

    public String getGuarantor() {
        return guarantor;
    }

    public void setGuarantor(String guarantor) {
        this.guarantor = guarantor == null ? null : guarantor.trim();
    }

    public String getGuarantorOrg() {
        return guarantorOrg;
    }

    public void setGuarantorOrg(String guarantorOrg) {
        this.guarantorOrg = guarantorOrg == null ? null : guarantorOrg.trim();
    }

    public String getGuarantorPhoneNum() {
        return guarantorPhoneNum;
    }

    public void setGuarantorPhoneNum(String guarantorPhoneNum) {
        this.guarantorPhoneNum = guarantorPhoneNum == null ? null : guarantorPhoneNum.trim();
    }

    public Date getBillCheckedDateTime() {
        return billCheckedDateTime;
    }

    public void setBillCheckedDateTime(Date billCheckedDateTime) {
        this.billCheckedDateTime = billCheckedDateTime;
    }

    public Short getSettledIndicator() {
        return settledIndicator;
    }

    public void setSettledIndicator(Short settledIndicator) {
        this.settledIndicator = settledIndicator;
    }

    public Short getLendBedNo() {
        return lendBedNo;
    }

    public void setLendBedNo(Short lendBedNo) {
        this.lendBedNo = lendBedNo;
    }

    public String getBedDeptCode() {
        return bedDeptCode;
    }

    public void setBedDeptCode(String bedDeptCode) {
        this.bedDeptCode = bedDeptCode == null ? null : bedDeptCode.trim();
    }

    public String getBedWardCode() {
        return bedWardCode;
    }

    public void setBedWardCode(String bedWardCode) {
        this.bedWardCode = bedWardCode == null ? null : bedWardCode.trim();
    }

    public String getDeptCodeLend() {
        return deptCodeLend;
    }

    public void setDeptCodeLend(String deptCodeLend) {
        this.deptCodeLend = deptCodeLend == null ? null : deptCodeLend.trim();
    }

    public Short getLendIndicator() {
        return lendIndicator;
    }

    public void setLendIndicator(Short lendIndicator) {
        this.lendIndicator = lendIndicator;
    }

    public Short getIsNewborn() {
        return isNewborn;
    }

    public void setIsNewborn(Short isNewborn) {
        this.isNewborn = isNewborn;
    }

    public BigDecimal getPayFromAccount() {
        return payFromAccount;
    }

    public void setPayFromAccount(BigDecimal payFromAccount) {
        this.payFromAccount = payFromAccount;
    }

    public BigDecimal getPayFromFund() {
        return payFromFund;
    }

    public void setPayFromFund(BigDecimal payFromFund) {
        this.payFromFund = payFromFund;
    }

    public BigDecimal getPayFromInsured() {
        return payFromInsured;
    }

    public void setPayFromInsured(BigDecimal payFromInsured) {
        this.payFromInsured = payFromInsured;
    }

    public BigDecimal getPayWay() {
        return payWay;
    }

    public void setPayWay(BigDecimal payWay) {
        this.payWay = payWay;
    }

    public String getDeptInCharge() {
        return deptInCharge;
    }

    public void setDeptInCharge(String deptInCharge) {
        this.deptInCharge = deptInCharge == null ? null : deptInCharge.trim();
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Integer getFrequencyNurse() {
        return frequencyNurse;
    }

    public void setFrequencyNurse(Integer frequencyNurse) {
        this.frequencyNurse = frequencyNurse;
    }

    public String getBedLabel() {
        return bedLabel;
    }

    public void setBedLabel(String bedLabel) {
        this.bedLabel = bedLabel == null ? null : bedLabel.trim();
    }

    public String getNurseInCharge() {
        return nurseInCharge;
    }

    public void setNurseInCharge(String nurseInCharge) {
        this.nurseInCharge = nurseInCharge == null ? null : nurseInCharge.trim();
    }
}