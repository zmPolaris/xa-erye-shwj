package cn.xa.eyre.system.dict.domain;

import java.util.Date;

public class DictExamType {
    private Integer id;

    private String emrCode;

    private String emrName;

    private String hubCode;

    private String hubName;

    private String remark;

    private Integer isDefault;

    private Integer codeStatus;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmrCode() {
        return emrCode;
    }

    public void setEmrCode(String emrCode) {
        this.emrCode = emrCode == null ? null : emrCode.trim();
    }

    public String getEmrName() {
        return emrName;
    }

    public void setEmrName(String emrName) {
        this.emrName = emrName == null ? null : emrName.trim();
    }

    public String getHubCode() {
        return hubCode;
    }

    public void setHubCode(String hubCode) {
        this.hubCode = hubCode == null ? null : hubCode.trim();
    }

    public String getHubName() {
        return hubName;
    }

    public void setHubName(String hubName) {
        this.hubName = hubName == null ? null : hubName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(Integer codeStatus) {
        this.codeStatus = codeStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}