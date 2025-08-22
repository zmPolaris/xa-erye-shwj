package cn.xa.eyre.comm.domain;

import java.util.Date;

public class DiagnosisDict extends DiagnosisDictKey {
    private Short stdIndicator;

    private Short approvedIndicator;

    private Date createDate;

    private String inputCode;

    private String healthLevel;

    private String infectIndicator;

    private String inputCodeWb;

    private String diseaseSort;

    private String contagioncode;

    private Short diagIndicator;

    private String nm1;

    private String nm2;

    private String codeVersion;

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

    public String getHealthLevel() {
        return healthLevel;
    }

    public void setHealthLevel(String healthLevel) {
        this.healthLevel = healthLevel == null ? null : healthLevel.trim();
    }

    public String getInfectIndicator() {
        return infectIndicator;
    }

    public void setInfectIndicator(String infectIndicator) {
        this.infectIndicator = infectIndicator == null ? null : infectIndicator.trim();
    }

    public String getInputCodeWb() {
        return inputCodeWb;
    }

    public void setInputCodeWb(String inputCodeWb) {
        this.inputCodeWb = inputCodeWb == null ? null : inputCodeWb.trim();
    }

    public String getDiseaseSort() {
        return diseaseSort;
    }

    public void setDiseaseSort(String diseaseSort) {
        this.diseaseSort = diseaseSort == null ? null : diseaseSort.trim();
    }

    public String getContagioncode() {
        return contagioncode;
    }

    public void setContagioncode(String contagioncode) {
        this.contagioncode = contagioncode == null ? null : contagioncode.trim();
    }

    public Short getDiagIndicator() {
        return diagIndicator;
    }

    public void setDiagIndicator(Short diagIndicator) {
        this.diagIndicator = diagIndicator;
    }

    public String getNm1() {
        return nm1;
    }

    public void setNm1(String nm1) {
        this.nm1 = nm1 == null ? null : nm1.trim();
    }

    public String getNm2() {
        return nm2;
    }

    public void setNm2(String nm2) {
        this.nm2 = nm2 == null ? null : nm2.trim();
    }

    public String getCodeVersion() {
        return codeVersion;
    }

    public void setCodeVersion(String codeVersion) {
        this.codeVersion = codeVersion == null ? null : codeVersion.trim();
    }
}