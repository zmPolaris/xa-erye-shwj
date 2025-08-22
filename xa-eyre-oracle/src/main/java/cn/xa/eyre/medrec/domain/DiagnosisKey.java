package cn.xa.eyre.medrec.domain;

public class DiagnosisKey {
    private String patientId;

    private Short visitId;

    private String diagnosisType;

    private Short diagnosisNo;

    public DiagnosisKey() {
    }

    public DiagnosisKey(String patientId, Short visitId, String diagnosisType) {
        this.patientId = patientId;
        this.visitId = visitId;
        this.diagnosisType = diagnosisType;
    }

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

    public String getDiagnosisType() {
        return diagnosisType;
    }

    public void setDiagnosisType(String diagnosisType) {
        this.diagnosisType = diagnosisType == null ? null : diagnosisType.trim();
    }

    public Short getDiagnosisNo() {
        return diagnosisNo;
    }

    public void setDiagnosisNo(Short diagnosisNo) {
        this.diagnosisNo = diagnosisNo;
    }
}