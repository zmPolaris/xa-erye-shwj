package cn.xa.eyre.lab.domain;

public class LabTestItems extends LabTestItemsKey {
    private String itemName;

    private String itemCode;

    private String labSheetId;

    private String className;

    private String labSubject;

    private Short reportPrintIndicator;

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

    public String getLabSheetId() {
        return labSheetId;
    }

    public void setLabSheetId(String labSheetId) {
        this.labSheetId = labSheetId == null ? null : labSheetId.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getLabSubject() {
        return labSubject;
    }

    public void setLabSubject(String labSubject) {
        this.labSubject = labSubject == null ? null : labSubject.trim();
    }

    public Short getReportPrintIndicator() {
        return reportPrintIndicator;
    }

    public void setReportPrintIndicator(Short reportPrintIndicator) {
        this.reportPrintIndicator = reportPrintIndicator;
    }
}