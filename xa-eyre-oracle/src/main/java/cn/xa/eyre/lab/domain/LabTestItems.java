package cn.xa.eyre.lab.domain;

public class LabTestItems extends LabTestItemsKey {
    private String itemName;

    private String itemCode;

    private String testNo;

    private Short itemNo;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    @Override
    public String getTestNo() {
        return testNo;
    }

    @Override
    public void setTestNo(String testNo) {
        this.testNo = testNo;
    }

    @Override
    public Short getItemNo() {
        return itemNo;
    }

    @Override
    public void setItemNo(Short itemNo) {
        this.itemNo = itemNo;
    }
}