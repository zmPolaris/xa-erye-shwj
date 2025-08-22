package cn.xa.eyre.hub.domain.base;

import cn.xa.eyre.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【用户信息】对象 base_user
 *
 * @author ruoyi
 * @date 2025-06-11
 */
public class BaseUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private String id;

    /** 用户真实姓名 */
    private String userName;

    /** 用户身份证件所属类别代码 */
    private String idCardTypeCode;

    /** 用户的身份证号，尚未获得身份证号码的人员使用护照号等特定编码标识 */
    private String idCard;

    /** 用户本人的电话号码 */
    private String tel;

    /** 用户取得的医师执业资格证号 */
    private String physicianNo;

    /** 用户所属医疗机构在机构代码表中的代码 */
    private String orgCode;

    /** 用户所属科室在代码表中的代码 */
    private String deptCode;

    /** 1=作废，0=有效 */
    private String invalidFlag;

    /** 登录名 */
    private String loginName;

    /** 用户类型，dd_user_type，（1公卫2临床3管理员） */
    private String userTypeCode;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setIdCardTypeCode(String idCardTypeCode)
    {
        this.idCardTypeCode = idCardTypeCode;
    }

    public String getIdCardTypeCode()
    {
        return idCardTypeCode;
    }
    public void setIdCard(String idCard)
    {
        this.idCard = idCard;
    }

    public String getIdCard()
    {
        return idCard;
    }
    public void setTel(String tel)
    {
        this.tel = tel;
    }

    public String getTel()
    {
        return tel;
    }
    public void setPhysicianNo(String physicianNo)
    {
        this.physicianNo = physicianNo;
    }

    public String getPhysicianNo()
    {
        return physicianNo;
    }
    public void setOrgCode(String orgCode)
    {
        this.orgCode = orgCode;
    }

    public String getOrgCode()
    {
        return orgCode;
    }
    public void setDeptCode(String deptCode)
    {
        this.deptCode = deptCode;
    }

    public String getDeptCode()
    {
        return deptCode;
    }
    public void setInvalidFlag(String invalidFlag)
    {
        this.invalidFlag = invalidFlag;
    }

    public String getInvalidFlag()
    {
        return invalidFlag;
    }
    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    public String getLoginName()
    {
        return loginName;
    }
    public void setUserTypeCode(String userTypeCode)
    {
        this.userTypeCode = userTypeCode;
    }

    public String getUserTypeCode()
    {
        return userTypeCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userName", getUserName())
                .append("idCardTypeCode", getIdCardTypeCode())
                .append("idCard", getIdCard())
                .append("tel", getTel())
                .append("physicianNo", getPhysicianNo())
                .append("orgCode", getOrgCode())
                .append("deptCode", getDeptCode())
                .append("createTime", getCreateTime())
                .append("invalidFlag", getInvalidFlag())
                .append("loginName", getLoginName())
                .append("userTypeCode", getUserTypeCode())
                .toString();
    }
}
