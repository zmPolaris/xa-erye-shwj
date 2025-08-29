package cn.xa.eyre.medrec.domain;

import java.util.Objects;

public class DiagnosticDescCode {

    private String patientId;

    private Short visitId;

    private String diagnosisType;

    private Short diagnosisNo;

    private String diagnosisDesc;

    private String treatResult;

    private String diagnosisCode;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Short getVisitId() {
        return visitId;
    }

    public void setVisitId(Short visitId) {
        this.visitId = visitId;
    }

    public String getDiagnosisType() {
        return diagnosisType;
    }

    public void setDiagnosisType(String diagnosisType) {
        this.diagnosisType = diagnosisType;
    }

    public Short getDiagnosisNo() {
        return diagnosisNo;
    }

    public void setDiagnosisNo(Short diagnosisNo) {
        this.diagnosisNo = diagnosisNo;
    }

    public String getDiagnosisDesc() {
        return diagnosisDesc;
    }

    public void setDiagnosisDesc(String diagnosisDesc) {
        this.diagnosisDesc = diagnosisDesc;
    }

    public String getTreatResult() {
        return treatResult;
    }

    public void setTreatResult(String treatResult) {
        this.treatResult = treatResult;
    }

    public String getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DiagnosticDescCode)) return false;
        DiagnosticDescCode that = (DiagnosticDescCode) o;
        return Objects.equals(getPatientId(), that.getPatientId()) && Objects.equals(getVisitId(), that.getVisitId()) && Objects.equals(getDiagnosisType(), that.getDiagnosisType()) && Objects.equals(getDiagnosisNo(), that.getDiagnosisNo()) && Objects.equals(getDiagnosisDesc(), that.getDiagnosisDesc()) && Objects.equals(getTreatResult(), that.getTreatResult()) && Objects.equals(getDiagnosisCode(), that.getDiagnosisCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPatientId(), getVisitId(), getDiagnosisType(), getDiagnosisNo(), getDiagnosisDesc(), getTreatResult(), getDiagnosisCode());
    }
}
