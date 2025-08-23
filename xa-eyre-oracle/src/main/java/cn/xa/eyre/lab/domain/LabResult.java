package cn.xa.eyre.lab.domain;

import java.util.Date;

public class LabResult extends LabResultKey {
    private String reportItemName;

    private String reportItemCode;

    private String result;

    private String units;

    private String abnormalIndicator;

    private String instrumentId;

    private Date resultDateTime;

    private String recheck;

    private Date recheckdate;

    private String printContext;

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

    public String getRecheck() {
        return recheck;
    }

    public void setRecheck(String recheck) {
        this.recheck = recheck == null ? null : recheck.trim();
    }

    public Date getRecheckdate() {
        return recheckdate;
    }

    public void setRecheckdate(Date recheckdate) {
        this.recheckdate = recheckdate;
    }

    public String getPrintContext() {
        return printContext;
    }

    public void setPrintContext(String printContext) {
        this.printContext = printContext == null ? null : printContext.trim();
    }
}