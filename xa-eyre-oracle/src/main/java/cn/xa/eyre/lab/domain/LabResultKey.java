package cn.xa.eyre.lab.domain;

public class LabResultKey {
    private String testNo;

    private Short itemNo;

    private Short printOrder;

    public String getTestNo() {
        return testNo;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo == null ? null : testNo.trim();
    }

    public Short getItemNo() {
        return itemNo;
    }

    public void setItemNo(Short itemNo) {
        this.itemNo = itemNo;
    }

    public Short getPrintOrder() {
        return printOrder;
    }

    public void setPrintOrder(Short printOrder) {
        this.printOrder = printOrder;
    }
}