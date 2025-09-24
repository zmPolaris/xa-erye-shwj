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

    private String operatorNo;

    private Short isoveruse;

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

    public String getOperatorNo() {
        return operatorNo;
    }

    public void setOperatorNo(String operatorNo) {
        this.operatorNo = operatorNo == null ? null : operatorNo.trim();
    }

    public Short getIsoveruse() {
        return isoveruse;
    }

    public void setIsoveruse(Short isoveruse) {
        this.isoveruse = isoveruse;
    }
}