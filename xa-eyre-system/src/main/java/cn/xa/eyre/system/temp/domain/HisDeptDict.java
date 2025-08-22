package cn.xa.eyre.system.temp.domain;

public class HisDeptDict {
    private Integer id;

    private Integer serialNo;

    private String deptCode;

    private String deptName;

    private String deptAlias;

    private Integer clinicAttr;

    private Integer outpOrInp;

    private Integer internalOrSergery;

    private String inputCode;

    private String sign;

    private String position;

    private String inputCodeWb;

    private Integer dispensingCumulate;

    private Integer virtualCabinet;

    private Integer orderCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
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

    public Integer getClinicAttr() {
        return clinicAttr;
    }

    public void setClinicAttr(Integer clinicAttr) {
        this.clinicAttr = clinicAttr;
    }

    public Integer getOutpOrInp() {
        return outpOrInp;
    }

    public void setOutpOrInp(Integer outpOrInp) {
        this.outpOrInp = outpOrInp;
    }

    public Integer getInternalOrSergery() {
        return internalOrSergery;
    }

    public void setInternalOrSergery(Integer internalOrSergery) {
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

    public Integer getDispensingCumulate() {
        return dispensingCumulate;
    }

    public void setDispensingCumulate(Integer dispensingCumulate) {
        this.dispensingCumulate = dispensingCumulate;
    }

    public Integer getVirtualCabinet() {
        return virtualCabinet;
    }

    public void setVirtualCabinet(Integer virtualCabinet) {
        this.virtualCabinet = virtualCabinet;
    }

    public Integer getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Integer orderCode) {
        this.orderCode = orderCode;
    }
}