package cn.xa.eyre.medrec.domain;

import java.util.Date;

public class Transfer extends TransferKey {

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
}