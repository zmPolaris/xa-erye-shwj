package cn.xa.eyre.ordadm.domain;

public class OrdersKey {
    private String patientId;

    private Short visitId;

    private Short orderNo;

    private Short orderSubNo;

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
}