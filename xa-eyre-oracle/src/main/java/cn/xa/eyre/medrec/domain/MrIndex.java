package cn.xa.eyre.medrec.domain;

import java.math.BigDecimal;
import java.util.Date;

public class MrIndex extends MrIndexKey {
    private String mrStatus;

    private String storageVolumeLabel;

    private String accessPath;

    private Date lastAccessDateTime;

    private String submitDoctorId;

    private String selfComment;

    private String deptComment;

    private String hosComment;

    private BigDecimal selfAssess;

    private Date selfDate;

    private BigDecimal deptAssess;

    private Date deptDate;

    private String deptDirector;

    private BigDecimal hosAssess;

    private Date hosDate;

    private String hosQcman;

    public String getMrStatus() {
        return mrStatus;
    }

    public void setMrStatus(String mrStatus) {
        this.mrStatus = mrStatus == null ? null : mrStatus.trim();
    }

    public String getStorageVolumeLabel() {
        return storageVolumeLabel;
    }

    public void setStorageVolumeLabel(String storageVolumeLabel) {
        this.storageVolumeLabel = storageVolumeLabel == null ? null : storageVolumeLabel.trim();
    }

    public String getAccessPath() {
        return accessPath;
    }

    public void setAccessPath(String accessPath) {
        this.accessPath = accessPath == null ? null : accessPath.trim();
    }

    public Date getLastAccessDateTime() {
        return lastAccessDateTime;
    }

    public void setLastAccessDateTime(Date lastAccessDateTime) {
        this.lastAccessDateTime = lastAccessDateTime;
    }

    public String getSubmitDoctorId() {
        return submitDoctorId;
    }

    public void setSubmitDoctorId(String submitDoctorId) {
        this.submitDoctorId = submitDoctorId == null ? null : submitDoctorId.trim();
    }

    public String getSelfComment() {
        return selfComment;
    }

    public void setSelfComment(String selfComment) {
        this.selfComment = selfComment == null ? null : selfComment.trim();
    }

    public String getDeptComment() {
        return deptComment;
    }

    public void setDeptComment(String deptComment) {
        this.deptComment = deptComment == null ? null : deptComment.trim();
    }

    public String getHosComment() {
        return hosComment;
    }

    public void setHosComment(String hosComment) {
        this.hosComment = hosComment == null ? null : hosComment.trim();
    }

    public BigDecimal getSelfAssess() {
        return selfAssess;
    }

    public void setSelfAssess(BigDecimal selfAssess) {
        this.selfAssess = selfAssess;
    }

    public Date getSelfDate() {
        return selfDate;
    }

    public void setSelfDate(Date selfDate) {
        this.selfDate = selfDate;
    }

    public BigDecimal getDeptAssess() {
        return deptAssess;
    }

    public void setDeptAssess(BigDecimal deptAssess) {
        this.deptAssess = deptAssess;
    }

    public Date getDeptDate() {
        return deptDate;
    }

    public void setDeptDate(Date deptDate) {
        this.deptDate = deptDate;
    }

    public String getDeptDirector() {
        return deptDirector;
    }

    public void setDeptDirector(String deptDirector) {
        this.deptDirector = deptDirector == null ? null : deptDirector.trim();
    }

    public BigDecimal getHosAssess() {
        return hosAssess;
    }

    public void setHosAssess(BigDecimal hosAssess) {
        this.hosAssess = hosAssess;
    }

    public Date getHosDate() {
        return hosDate;
    }

    public void setHosDate(Date hosDate) {
        this.hosDate = hosDate;
    }

    public String getHosQcman() {
        return hosQcman;
    }

    public void setHosQcman(String hosQcman) {
        this.hosQcman = hosQcman == null ? null : hosQcman.trim();
    }
}