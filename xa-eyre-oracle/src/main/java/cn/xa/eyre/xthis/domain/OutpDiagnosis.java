package cn.xa.eyre.xthis.domain;

import java.math.BigDecimal;
import java.util.Date;

public class OutpDiagnosis extends OutpDiagnosisKey {
    private String diagnosisType;

    private String diagnosisDesc;

    private Date diagnosisDate;

    private Date diagStartDate;

    private String resultType;

    private Short firstVisitIndicator;

    private String diagnosisCode;

    private String diagnosisNote;

    private String mainFlag;

    private String diagnosisName;

    private String diagnosisDoctorId;

    private BigDecimal sortOrder;

    private String id;

    private String iCDType;

    public String getDiagnosisType() {
        return diagnosisType;
    }

    public void setDiagnosisType(String diagnosisType) {
        this.diagnosisType = diagnosisType == null ? null : diagnosisType.trim();
    }

    public String getDiagnosisDesc() {
        return diagnosisDesc;
    }

    public void setDiagnosisDesc(String diagnosisDesc) {
        this.diagnosisDesc = diagnosisDesc == null ? null : diagnosisDesc.trim();
    }

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public Date getDiagStartDate() {
        return diagStartDate;
    }

    public void setDiagStartDate(Date diagStartDate) {
        this.diagStartDate = diagStartDate;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType == null ? null : resultType.trim();
    }

    public Short getFirstVisitIndicator() {
        return firstVisitIndicator;
    }

    public void setFirstVisitIndicator(Short firstVisitIndicator) {
        this.firstVisitIndicator = firstVisitIndicator;
    }

    public String getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode == null ? null : diagnosisCode.trim();
    }

    public String getDiagnosisNote() {
        return diagnosisNote;
    }

    public void setDiagnosisNote(String diagnosisNote) {
        this.diagnosisNote = diagnosisNote == null ? null : diagnosisNote.trim();
    }

    public String getMainFlag() {
        return mainFlag;
    }

    public void setMainFlag(String mainFlag) {
        this.mainFlag = mainFlag == null ? null : mainFlag.trim();
    }

    public String getDiagnosisName() {
        return diagnosisName;
    }

    public void setDiagnosisName(String diagnosisName) {
        this.diagnosisName = diagnosisName == null ? null : diagnosisName.trim();
    }

    public String getDiagnosisDoctorId() {
        return diagnosisDoctorId;
    }

    public void setDiagnosisDoctorId(String diagnosisDoctorId) {
        this.diagnosisDoctorId = diagnosisDoctorId == null ? null : diagnosisDoctorId.trim();
    }

    public BigDecimal getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(BigDecimal sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getiCDType() {
        return iCDType;
    }

    public void setiCDType(String iCDType) {
        this.iCDType = iCDType == null ? null : iCDType.trim();
    }
}