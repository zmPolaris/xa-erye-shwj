package cn.xa.eyre.insurance.domain;

public class GysybIcd10 {
    private String icdCode;

    private String icdCode2;

    private String icdName;

    public String getIcdCode() {
        return icdCode;
    }

    public void setIcdCode(String icdCode) {
        this.icdCode = icdCode == null ? null : icdCode.trim();
    }

    public String getIcdCode2() {
        return icdCode2;
    }

    public void setIcdCode2(String icdCode2) {
        this.icdCode2 = icdCode2 == null ? null : icdCode2.trim();
    }

    public String getIcdName() {
        return icdName;
    }

    public void setIcdName(String icdName) {
        this.icdName = icdName == null ? null : icdName.trim();
    }
}