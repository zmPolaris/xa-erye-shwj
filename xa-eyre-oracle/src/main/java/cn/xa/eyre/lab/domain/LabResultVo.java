package cn.xa.eyre.lab.domain;

import java.util.Date;

public class LabResultVo extends LabResultKey {
    private String reportItemName;

    private String reportItemCode;

    private String result;

    private String units;

    private String abnormalIndicator;

    private String instrumentId;

    private Date resultDateTime;

    private String printContext;

    private String resultRange;

    private String referContext;

    private String sampleid;

    private String reportid;

    private String microDataId2Result2;

    private String microDataId2Result1;

    private String microDataId2Name;

    private String infectHandle;

    private String infectHandleTime;

    private String infectHandleDoctorId;

    private String itemName;

    private String itemCode;

    private String labSheetId;

    private String className;

    private String labSubject;

    private Short reportPrintIndicator;

    public String getReportItemName() {
        return reportItemName;
    }

    public void setReportItemName(String reportItemName) {
        this.reportItemName = reportItemName == null ? null : reportItemName.trim();
    }

    public String getReportItemCode() {
        return reportItemCode;
    }

    public void setReportItemCode(String reportItemCode) {
        this.reportItemCode = reportItemCode == null ? null : reportItemCode.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units == null ? null : units.trim();
    }

    public String getAbnormalIndicator() {
        return abnormalIndicator;
    }

    public void setAbnormalIndicator(String abnormalIndicator) {
        this.abnormalIndicator = abnormalIndicator == null ? null : abnormalIndicator.trim();
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId == null ? null : instrumentId.trim();
    }

    public Date getResultDateTime() {
        return resultDateTime;
    }

    public void setResultDateTime(Date resultDateTime) {
        this.resultDateTime = resultDateTime;
    }

    public String getPrintContext() {
        return printContext;
    }

    public void setPrintContext(String printContext) {
        this.printContext = printContext == null ? null : printContext.trim();
    }

    public String getResultRange() {
        return resultRange;
    }

    public void setResultRange(String resultRange) {
        this.resultRange = resultRange == null ? null : resultRange.trim();
    }

    public String getReferContext() {
        return referContext;
    }

    public void setReferContext(String referContext) {
        this.referContext = referContext == null ? null : referContext.trim();
    }

    public String getSampleid() {
        return sampleid;
    }

    public void setSampleid(String sampleid) {
        this.sampleid = sampleid == null ? null : sampleid.trim();
    }

    public String getReportid() {
        return reportid;
    }

    public void setReportid(String reportid) {
        this.reportid = reportid == null ? null : reportid.trim();
    }

    public String getMicroDataId2Result2() {
        return microDataId2Result2;
    }

    public void setMicroDataId2Result2(String microDataId2Result2) {
        this.microDataId2Result2 = microDataId2Result2 == null ? null : microDataId2Result2.trim();
    }

    public String getMicroDataId2Result1() {
        return microDataId2Result1;
    }

    public void setMicroDataId2Result1(String microDataId2Result1) {
        this.microDataId2Result1 = microDataId2Result1 == null ? null : microDataId2Result1.trim();
    }

    public String getMicroDataId2Name() {
        return microDataId2Name;
    }

    public void setMicroDataId2Name(String microDataId2Name) {
        this.microDataId2Name = microDataId2Name == null ? null : microDataId2Name.trim();
    }

    public String getInfectHandle() {
        return infectHandle;
    }

    public void setInfectHandle(String infectHandle) {
        this.infectHandle = infectHandle == null ? null : infectHandle.trim();
    }

    public String getInfectHandleTime() {
        return infectHandleTime;
    }

    public void setInfectHandleTime(String infectHandleTime) {
        this.infectHandleTime = infectHandleTime == null ? null : infectHandleTime.trim();
    }

    public String getInfectHandleDoctorId() {
        return infectHandleDoctorId;
    }

    public void setInfectHandleDoctorId(String infectHandleDoctorId) {
        this.infectHandleDoctorId = infectHandleDoctorId == null ? null : infectHandleDoctorId.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getLabSheetId() {
        return labSheetId;
    }

    public void setLabSheetId(String labSheetId) {
        this.labSheetId = labSheetId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getLabSubject() {
        return labSubject;
    }

    public void setLabSubject(String labSubject) {
        this.labSubject = labSubject;
    }

    public Short getReportPrintIndicator() {
        return reportPrintIndicator;
    }

    public void setReportPrintIndicator(Short reportPrintIndicator) {
        this.reportPrintIndicator = reportPrintIndicator;
    }
}