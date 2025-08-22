package cn.xa.eyre.comm.domain;

import java.util.Date;

public class StaffDict {
    private String empNo;

    private String deptCode;

    private String name;

    private String inputCode;

    private String job;

    private String title;

    private String userName;

    private String inputCodeWb;

    private String id;

    private Date createDate;

    private String password;

    private Integer sysFlag;

    private String surgeryClass;

    private String cancel;

    private Short antibioticDrugLimit;

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo == null ? null : empNo.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getInputCodeWb() {
        return inputCodeWb;
    }

    public void setInputCodeWb(String inputCodeWb) {
        this.inputCodeWb = inputCodeWb == null ? null : inputCodeWb.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getSysFlag() {
        return sysFlag;
    }

    public void setSysFlag(Integer sysFlag) {
        this.sysFlag = sysFlag;
    }

    public String getSurgeryClass() {
        return surgeryClass;
    }

    public void setSurgeryClass(String surgeryClass) {
        this.surgeryClass = surgeryClass == null ? null : surgeryClass.trim();
    }

    public String getCancel() {
        return cancel;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel == null ? null : cancel.trim();
    }

    public Short getAntibioticDrugLimit() {
        return antibioticDrugLimit;
    }

    public void setAntibioticDrugLimit(Short antibioticDrugLimit) {
        this.antibioticDrugLimit = antibioticDrugLimit;
    }
}