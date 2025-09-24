package cn.xa.eyre.medrec.domain;

import java.util.Date;

public class Transfer extends TransferKey {

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
    /**
     * 所在科室
     */
    private String deptStayed;

    /**
     * 出科日期及时间
     */
    private Date dischargeDateTime;

    /**
     * 转向科室
     */
    private String deptTransferedTo;

    /**
     * 经治医师
     */
    private String doctorInCharge;

    public String getDeptStayed() {
        return deptStayed;
    }

    public void setDeptStayed(String deptStayed) {
        this.deptStayed = deptStayed == null ? null : deptStayed.trim();
    }

    public Date getDischargeDateTime() {
        return dischargeDateTime;
    }

    public void setDischargeDateTime(Date dischargeDateTime) {
        this.dischargeDateTime = dischargeDateTime;
    }

    public String getDeptTransferedTo() {
        return deptTransferedTo;
    }

    public void setDeptTransferedTo(String deptTransferedTo) {
        this.deptTransferedTo = deptTransferedTo == null ? null : deptTransferedTo.trim();
    }

    public String getDoctorInCharge() {
        return doctorInCharge;
    }

    public void setDoctorInCharge(String doctorInCharge) {
        this.doctorInCharge = doctorInCharge == null ? null : doctorInCharge.trim();
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
    public Date getAdmissionDateTime() {
        return admissionDateTime;
    }

    @Override
    public void setAdmissionDateTime(Date admissionDateTime) {
        this.admissionDateTime = admissionDateTime;
    }
}