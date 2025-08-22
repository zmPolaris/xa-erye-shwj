package cn.xa.eyre.ordadm.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {
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

    private Short drugBillingAttr;

    private String stopNurse;

    private Date stopOrderDateTime;

    private Integer currentPrescNo;

    private String doctorUser;

    private Date verifyDataTime;

    private Short orderPrintIndicator;

    private Date processingDateTime;

    private String processingNurse;

    private String stopProcessingNurse;

    private Date stopProcessingDateTime;

    private Date cancelDateTime;

    private String cancelDoctor;

    private Short degree;

    private String appNo;

    private Short isAdjust;

    private Date conversionDateTime;

    private String continueOrderNo;

    private String stopFlag;

    private Short adaptSymptomIndicate;

    private String printFlag;

    private String printFlag1;

    private String printFlag3;

    private String relativeNo;

    private String orderTypeName;

    private String orderPerformStatus;

    private Short queryOrderNo;

    private Short queryOrderSubNo;

    private String exeNurse;

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

    public Short getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Short orderNo) {
        this.orderNo = orderNo;
    }

    public Short getOrderSubNo() {
        return orderSubNo;
    }

    public void setOrderSubNo(Short orderSubNo) {
        this.orderSubNo = orderSubNo;
    }

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

    public Integer getCurrentPrescNo() {
        return currentPrescNo;
    }

    public void setCurrentPrescNo(Integer currentPrescNo) {
        this.currentPrescNo = currentPrescNo;
    }

    public String getDoctorUser() {
        return doctorUser;
    }

    public void setDoctorUser(String doctorUser) {
        this.doctorUser = doctorUser == null ? null : doctorUser.trim();
    }

    public Date getVerifyDataTime() {
        return verifyDataTime;
    }

    public void setVerifyDataTime(Date verifyDataTime) {
        this.verifyDataTime = verifyDataTime;
    }

    public Short getOrderPrintIndicator() {
        return orderPrintIndicator;
    }

    public void setOrderPrintIndicator(Short orderPrintIndicator) {
        this.orderPrintIndicator = orderPrintIndicator;
    }

    public Date getProcessingDateTime() {
        return processingDateTime;
    }

    public void setProcessingDateTime(Date processingDateTime) {
        this.processingDateTime = processingDateTime;
    }

    public String getProcessingNurse() {
        return processingNurse;
    }

    public void setProcessingNurse(String processingNurse) {
        this.processingNurse = processingNurse == null ? null : processingNurse.trim();
    }

    public String getStopProcessingNurse() {
        return stopProcessingNurse;
    }

    public void setStopProcessingNurse(String stopProcessingNurse) {
        this.stopProcessingNurse = stopProcessingNurse == null ? null : stopProcessingNurse.trim();
    }

    public Date getStopProcessingDateTime() {
        return stopProcessingDateTime;
    }

    public void setStopProcessingDateTime(Date stopProcessingDateTime) {
        this.stopProcessingDateTime = stopProcessingDateTime;
    }

    public Date getCancelDateTime() {
        return cancelDateTime;
    }

    public void setCancelDateTime(Date cancelDateTime) {
        this.cancelDateTime = cancelDateTime;
    }

    public String getCancelDoctor() {
        return cancelDoctor;
    }

    public void setCancelDoctor(String cancelDoctor) {
        this.cancelDoctor = cancelDoctor == null ? null : cancelDoctor.trim();
    }

    public Short getDegree() {
        return degree;
    }

    public void setDegree(Short degree) {
        this.degree = degree;
    }

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo == null ? null : appNo.trim();
    }

    public Short getIsAdjust() {
        return isAdjust;
    }

    public void setIsAdjust(Short isAdjust) {
        this.isAdjust = isAdjust;
    }

    public Date getConversionDateTime() {
        return conversionDateTime;
    }

    public void setConversionDateTime(Date conversionDateTime) {
        this.conversionDateTime = conversionDateTime;
    }

    public String getContinueOrderNo() {
        return continueOrderNo;
    }

    public void setContinueOrderNo(String continueOrderNo) {
        this.continueOrderNo = continueOrderNo == null ? null : continueOrderNo.trim();
    }

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag == null ? null : stopFlag.trim();
    }

    public Short getAdaptSymptomIndicate() {
        return adaptSymptomIndicate;
    }

    public void setAdaptSymptomIndicate(Short adaptSymptomIndicate) {
        this.adaptSymptomIndicate = adaptSymptomIndicate;
    }

    public String getPrintFlag() {
        return printFlag;
    }

    public void setPrintFlag(String printFlag) {
        this.printFlag = printFlag == null ? null : printFlag.trim();
    }

    public String getPrintFlag1() {
        return printFlag1;
    }

    public void setPrintFlag1(String printFlag1) {
        this.printFlag1 = printFlag1 == null ? null : printFlag1.trim();
    }

    public String getPrintFlag3() {
        return printFlag3;
    }

    public void setPrintFlag3(String printFlag3) {
        this.printFlag3 = printFlag3 == null ? null : printFlag3.trim();
    }

    public String getRelativeNo() {
        return relativeNo;
    }

    public void setRelativeNo(String relativeNo) {
        this.relativeNo = relativeNo == null ? null : relativeNo.trim();
    }

    public String getOrderTypeName() {
        return orderTypeName;
    }

    public void setOrderTypeName(String orderTypeName) {
        this.orderTypeName = orderTypeName == null ? null : orderTypeName.trim();
    }

    public String getOrderPerformStatus() {
        return orderPerformStatus;
    }

    public void setOrderPerformStatus(String orderPerformStatus) {
        this.orderPerformStatus = orderPerformStatus == null ? null : orderPerformStatus.trim();
    }

    public Short getQueryOrderNo() {
        return queryOrderNo;
    }

    public void setQueryOrderNo(Short queryOrderNo) {
        this.queryOrderNo = queryOrderNo;
    }

    public Short getQueryOrderSubNo() {
        return queryOrderSubNo;
    }

    public void setQueryOrderSubNo(Short queryOrderSubNo) {
        this.queryOrderSubNo = queryOrderSubNo;
    }

    public String getExeNurse() {
        return exeNurse;
    }

    public void setExeNurse(String exeNurse) {
        this.exeNurse = exeNurse == null ? null : exeNurse.trim();
    }
}