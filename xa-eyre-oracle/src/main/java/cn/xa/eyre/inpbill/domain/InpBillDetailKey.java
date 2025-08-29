package cn.xa.eyre.inpbill.domain;

public class InpBillDetailKey {
    private String patientId;

    private Short visitId;

    private Integer itemNo;

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

    public Integer getItemNo() {
        return itemNo;
    }

    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }
}