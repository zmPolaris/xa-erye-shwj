package cn.xa.eyre.medrec.domain;

import java.util.Date;

public class Diagnosis extends DiagnosisKey {

    private String patientId;

    private Short visitId;

    private String diagnosisType;

    private Short diagnosisNo;

    private String diagnosisDesc;

    private Date diagnosisDate;

    private Short treatDays;

    private String treatResult;

    private Short operTreatIndicator;

    public String getDiagnosisDesc() {
        return diagnosisDesc;
    }

    public void setDiagnosisDesc(String diagnosisDesc) {
        this.diagnosisDesc = diagnosisDesc == null ? null : diagnosisDesc.trim();
    }

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public Short getTreatDays() {
        return treatDays;
    }

    public void setTreatDays(Short treatDays) {
        this.treatDays = treatDays;
    }

    public String getTreatResult() {
        return treatResult;
    }

    public void setTreatResult(String treatResult) {
        this.treatResult = treatResult == null ? null : treatResult.trim();
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
    public String getDiagnosisType() {
        return diagnosisType;
    }

    @Override
    public void setDiagnosisType(String diagnosisType) {
        this.diagnosisType = diagnosisType;
    }

    @Override
    public Short getDiagnosisNo() {
        return diagnosisNo;
    }

    @Override
    public void setDiagnosisNo(Short diagnosisNo) {
        this.diagnosisNo = diagnosisNo;
    }

    public Short getOperTreatIndicator() {
        return operTreatIndicator;
    }

    public void setOperTreatIndicator(Short operTreatIndicator) {
        this.operTreatIndicator = operTreatIndicator;
    }
}