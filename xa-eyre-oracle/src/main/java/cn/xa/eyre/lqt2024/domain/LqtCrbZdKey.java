package cn.xa.eyre.lqt2024.domain;

public class LqtCrbZdKey {
    private String patientId;

    private String visitId;

    private String diagnosisNo;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId == null ? null : visitId.trim();
    }

    public String getDiagnosisNo() {
        return diagnosisNo;
    }

    public void setDiagnosisNo(String diagnosisNo) {
        this.diagnosisNo = diagnosisNo == null ? null : diagnosisNo.trim();
    }
}