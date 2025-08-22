package cn.xa.eyre.lqt2024.domain;

import java.util.Date;

public class LqtCrbZd extends LqtCrbZdKey {
    private String inpNo;

    private String icd10;

    private String icd10name;

    private Date activityTime;

    private String fillDoctor;

    private String deptCode;

    private Date createTime;

    public String getInpNo() {
        return inpNo;
    }

    public void setInpNo(String inpNo) {
        this.inpNo = inpNo == null ? null : inpNo.trim();
    }

    public String getIcd10() {
        return icd10;
    }

    public void setIcd10(String icd10) {
        this.icd10 = icd10 == null ? null : icd10.trim();
    }

    public String getIcd10name() {
        return icd10name;
    }

    public void setIcd10name(String icd10name) {
        this.icd10name = icd10name == null ? null : icd10name.trim();
    }

    public Date getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public String getFillDoctor() {
        return fillDoctor;
    }

    public void setFillDoctor(String fillDoctor) {
        this.fillDoctor = fillDoctor == null ? null : fillDoctor.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}