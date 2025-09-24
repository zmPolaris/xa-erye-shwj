package cn.xa.eyre.ordadm.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Orders extends OrdersKey {

    private String patientId;

    private Short visitId;

    private Short orderNo;

    private Short orderSubNo;


    private Short repeatIndicator;

    private String orderClass;

    private String orderText;

    private String orderCode;

    private BigDecimal dosage;

    private String dosageUnits;

    private String administration;

    private Short duration;

    private String durationUnits;

    private Date startDateTime;

    private Date stopDateTime;

    private String frequency;

    private Short freqCounter;

    private Short freqInterval;

    private String freqIntervalUnit;

    private String freqDetail;

    private String performSchedule;

    private String performResult;

    private String orderingDept;

    private String doctor;

    private String stopDoctor;

    private String nurse;

    private Date enterDateTime;

    private String orderStatus;

    private Short billingAttr;

    private Date lastPerformDateTime;

    private Date lastAcctingDateTime;

    private String currentPrescNo;

    private String checkOperator;

    private Date checkDatetime;

    private Short drugBillingAttr;

    private String stopNurse;

    private Date stopOrderDateTime;

    private String isprint;

    public Short getRepeatIndicator() {
        return repeatIndicator;
    }

    public void setRepeatIndicator(Short repeatIndicator) {
        this.repeatIndicator = repeatIndicator;
    }

    public String getOrderClass() {
        return orderClass;
    }

    public void setOrderClass(String orderClass) {
        this.orderClass = orderClass == null ? null : orderClass.trim();
    }

    public String getOrderText() {
        return orderText;
    }

    public void setOrderText(String orderText) {
        this.orderText = orderText == null ? null : orderText.trim();
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public BigDecimal getDosage() {
        return dosage;
    }

    public void setDosage(BigDecimal dosage) {
        this.dosage = dosage;
    }

    public String getDosageUnits() {
        return dosageUnits;
    }

    public void setDosageUnits(String dosageUnits) {
        this.dosageUnits = dosageUnits == null ? null : dosageUnits.trim();
    }

    public String getAdministration() {
        return administration;
    }

    public void setAdministration(String administration) {
        this.administration = administration == null ? null : administration.trim();
    }

    public Short getDuration() {
        return duration;
    }

    public void setDuration(Short duration) {
        this.duration = duration;
    }

    public String getDurationUnits() {
        return durationUnits;
    }

    public void setDurationUnits(String durationUnits) {
        this.durationUnits = durationUnits == null ? null : durationUnits.trim();
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getStopDateTime() {
        return stopDateTime;
    }

    public void setStopDateTime(Date stopDateTime) {
        this.stopDateTime = stopDateTime;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency == null ? null : frequency.trim();
    }

    public Short getFreqCounter() {
        return freqCounter;
    }

    public void setFreqCounter(Short freqCounter) {
        this.freqCounter = freqCounter;
    }

    public Short getFreqInterval() {
        return freqInterval;
    }

    public void setFreqInterval(Short freqInterval) {
        this.freqInterval = freqInterval;
    }

    public String getFreqIntervalUnit() {
        return freqIntervalUnit;
    }

    public void setFreqIntervalUnit(String freqIntervalUnit) {
        this.freqIntervalUnit = freqIntervalUnit == null ? null : freqIntervalUnit.trim();
    }

    public String getFreqDetail() {
        return freqDetail;
    }

    public void setFreqDetail(String freqDetail) {
        this.freqDetail = freqDetail == null ? null : freqDetail.trim();
    }

    public String getPerformSchedule() {
        return performSchedule;
    }

    public void setPerformSchedule(String performSchedule) {
        this.performSchedule = performSchedule == null ? null : performSchedule.trim();
    }

    public String getPerformResult() {
        return performResult;
    }

    public void setPerformResult(String performResult) {
        this.performResult = performResult == null ? null : performResult.trim();
    }

    public String getOrderingDept() {
        return orderingDept;
    }

    public void setOrderingDept(String orderingDept) {
        this.orderingDept = orderingDept == null ? null : orderingDept.trim();
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor == null ? null : doctor.trim();
    }

    public String getStopDoctor() {
        return stopDoctor;
    }

    public void setStopDoctor(String stopDoctor) {
        this.stopDoctor = stopDoctor == null ? null : stopDoctor.trim();
    }

    public String getNurse() {
        return nurse;
    }

    public void setNurse(String nurse) {
        this.nurse = nurse == null ? null : nurse.trim();
    }

    public Date getEnterDateTime() {
        return enterDateTime;
    }

    public void setEnterDateTime(Date enterDateTime) {
        this.enterDateTime = enterDateTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public Short getBillingAttr() {
        return billingAttr;
    }

    public void setBillingAttr(Short billingAttr) {
        this.billingAttr = billingAttr;
    }

    public Date getLastPerformDateTime() {
        return lastPerformDateTime;
    }

    public void setLastPerformDateTime(Date lastPerformDateTime) {
        this.lastPerformDateTime = lastPerformDateTime;
    }

    public Date getLastAcctingDateTime() {
        return lastAcctingDateTime;
    }

    public void setLastAcctingDateTime(Date lastAcctingDateTime) {
        this.lastAcctingDateTime = lastAcctingDateTime;
    }

    public String getCurrentPrescNo() {
        return currentPrescNo;
    }

    public void setCurrentPrescNo(String currentPrescNo) {
        this.currentPrescNo = currentPrescNo == null ? null : currentPrescNo.trim();
    }

    public String getCheckOperator() {
        return checkOperator;
    }

    public void setCheckOperator(String checkOperator) {
        this.checkOperator = checkOperator == null ? null : checkOperator.trim();
    }

    public Date getCheckDatetime() {
        return checkDatetime;
    }

    public void setCheckDatetime(Date checkDatetime) {
        this.checkDatetime = checkDatetime;
    }

    public Short getDrugBillingAttr() {
        return drugBillingAttr;
    }

    public void setDrugBillingAttr(Short drugBillingAttr) {
        this.drugBillingAttr = drugBillingAttr;
    }

    public String getStopNurse() {
        return stopNurse;
    }

    public void setStopNurse(String stopNurse) {
        this.stopNurse = stopNurse == null ? null : stopNurse.trim();
    }

    public Date getStopOrderDateTime() {
        return stopOrderDateTime;
    }

    public void setStopOrderDateTime(Date stopOrderDateTime) {
        this.stopOrderDateTime = stopOrderDateTime;
    }

    public String getIsprint() {
        return isprint;
    }

    public void setIsprint(String isprint) {
        this.isprint = isprint == null ? null : isprint.trim();
    }

    @Override
    public String getPatientId() {
        return patientId;
    }

    @Override
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    @Override
    public Short getVisitId() {
        return visitId;
    }

    @Override
    public void setVisitId(Short visitId) {
        this.visitId = visitId;
    }

    @Override
    public Short getOrderNo() {
        return orderNo;
    }

    @Override
    public void setOrderNo(Short orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public Short getOrderSubNo() {
        return orderSubNo;
    }

    @Override
    public void setOrderSubNo(Short orderSubNo) {
        this.orderSubNo = orderSubNo;
    }
}