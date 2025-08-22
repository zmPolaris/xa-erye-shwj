package cn.xa.eyre.comm.domain;

public class DeptDict {
    private String deptCode;

    private Short serialNo;

    private String deptName;

    private String deptAlias;

    private Short clinicAttr;

    private Short outpOrInp;

    private Short internalOrSergery;

    private String inputCode;

    private String sign;

    private String position;

    private String inputCodeWb;

    private Short dispensingCumulate;

    private Short virtualCabinet;

    private Short orderCode;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getDeptAlias() {
        return deptAlias;
    }

    public void setDeptAlias(String deptAlias) {
        this.deptAlias = deptAlias == null ? null : deptAlias.trim();
    }

    public Short getClinicAttr() {
        return clinicAttr;
    }

    public void setClinicAttr(Short clinicAttr) {
        this.clinicAttr = clinicAttr;
    }

    public Short getOutpOrInp() {
        return outpOrInp;
    }

    public void setOutpOrInp(Short outpOrInp) {
        this.outpOrInp = outpOrInp;
    }

    public Short getInternalOrSergery() {
        return internalOrSergery;
    }

    public void setInternalOrSergery(Short internalOrSergery) {
        this.internalOrSergery = internalOrSergery;
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getInputCodeWb() {
        return inputCodeWb;
    }

    public void setInputCodeWb(String inputCodeWb) {
        this.inputCodeWb = inputCodeWb == null ? null : inputCodeWb.trim();
    }

    public Short getDispensingCumulate() {
        return dispensingCumulate;
    }

    public void setDispensingCumulate(Short dispensingCumulate) {
        this.dispensingCumulate = dispensingCumulate;
    }

    public Short getVirtualCabinet() {
        return virtualCabinet;
    }

    public void setVirtualCabinet(Short virtualCabinet) {
        this.virtualCabinet = virtualCabinet;
    }

    public Short getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Short orderCode) {
        this.orderCode = orderCode;
    }
}