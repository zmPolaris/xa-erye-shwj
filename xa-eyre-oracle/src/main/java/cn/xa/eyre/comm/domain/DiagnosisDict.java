package cn.xa.eyre.comm.domain;

import java.util.Date;

public class DiagnosisDict {
    private String diagnosisCode;

    private String diagnosisName;

    private Short stdIndicator;

    private Short approvedIndicator;

    private Date createDate;

    private String inputCode;

    private Short gjysign;

    public String getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode == null ? null : diagnosisCode.trim();
    }

    public String getDiagnosisName() {
        return diagnosisName;
    }

    public void setDiagnosisName(String diagnosisName) {
        this.diagnosisName = diagnosisName == null ? null : diagnosisName.trim();
    }

    public Short getStdIndicator() {
        return stdIndicator;
    }

    public void setStdIndicator(Short stdIndicator) {
        this.stdIndicator = stdIndicator;
    }

    public Short getApprovedIndicator() {
        return approvedIndicator;
    }

    public void setApprovedIndicator(Short approvedIndicator) {
        this.approvedIndicator = approvedIndicator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }

    public Short getGjysign() {
        return gjysign;
    }

    public void setGjysign(Short gjysign) {
        this.gjysign = gjysign;
    }
}