package cn.xa.eyre.hub.domain.base;

import cn.xa.eyre.common.core.domain.BaseEntity;
import cn.xa.eyre.common.utils.DateUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 【科室信息】对象 base_dept
 *
 * @author ruoyi
 * @date 2025-06-11
 */
public class BaseDept extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 院方科室code */
    private String deptCode;

    /** 院方科室名称 */
    private String deptName;

    /** 前置软件科室code */
    private String targetDeptCode;

    /** 前置软件科室名称 */
    private String targetDeptName;

    private String createTime;

    public void setDeptCode(String deptCode)
    {
        this.deptCode = deptCode;
    }

    public String getDeptCode()
    {
        return deptCode;
    }
    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    public String getDeptName()
    {
        return deptName;
    }
    public void setTargetDeptCode(String targetDeptCode)
    {
        this.targetDeptCode = targetDeptCode;
    }

    public String getTargetDeptCode()
    {
        return targetDeptCode;
    }
    public void setTargetDeptName(String targetDeptName)
    {
        this.targetDeptName = targetDeptName;
    }

    public String getTargetDeptName()
    {
        return targetDeptName;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, createTime);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("deptCode", getDeptCode())
                .append("deptName", getDeptName())
                .append("targetDeptCode", getTargetDeptCode())
                .append("targetDeptName", getTargetDeptName())
                .append("createTime", getCreateTime())
                .toString();
    }
}
