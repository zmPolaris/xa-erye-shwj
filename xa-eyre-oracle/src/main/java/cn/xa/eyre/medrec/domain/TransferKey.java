package cn.xa.eyre.medrec.domain;

import java.util.Date;

public class TransferKey {

    /**
     * 病人标识
     */
    private String patientId;

    /**
     * 病人本次住院标识
     */
    private Short visitId;

    /**
     * 入科日期及时间
     */
    private Date admissionDateTime;

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

    public Date getAdmissionDateTime() {
        return admissionDateTime;
    }

    public void setAdmissionDateTime(Date admissionDateTime) {
        this.admissionDateTime = admissionDateTime;
    }
}