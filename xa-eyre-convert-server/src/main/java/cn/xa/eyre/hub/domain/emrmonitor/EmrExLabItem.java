package cn.xa.eyre.hub.domain.emrmonitor;

import java.util.Date;

import cn.xa.eyre.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 检验报告明细对象 emr_ex_lab_item
 *
 * @author ruoyi
 * @date 2025-06-11
 */
public class EmrExLabItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 检验报告ID */
    private String exLabId;

    /** 检验项目代码 */
    private String itemCode;

    /** 检验项目名称 */
    private String itemName;

    /** 检验定性结果代码 */
    private String examinationResultCode;

    /** 检验定性结果名称 */
    private String examinationResultName;

    /** 检验定量结果 */
    private String examinationQuantification;

    /** 检验定量结果计量单位 */
    private String examinationQuantificationUnit;

    /** 操作时间 */
    private String operationTime;

    /** 操作人ID */
    private String operatorId;

    /** 作废标志 */
    private String invalidFlag;

    /** 数据状态 0 未传输 1已传输 */
    private String dataStatus;

    /** 入库日期 */
    private String createDate;

    /** 检验定量结果参考区间-下限 */
    private String examinationQuantificationLower;

    /** 检验定量结果参考区间-上限 */
    private String examinationQuantificationUpper;

    /** 检验定量结果超出或低于参考值 */
    private String examinationQuantificationRi;

    /** 患者检验结果在医院信息系统编码体系中的分类代码 */
    private String sourceExaminationResultCode;

    /** 患者检验结果名称 */
    private String sourceExaminationResultName;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setExLabId(String exLabId)
    {
        this.exLabId = exLabId;
    }

    public String getExLabId()
    {
        return exLabId;
    }
    public void setItemCode(String itemCode)
    {
        this.itemCode = itemCode;
    }

    public String getItemCode()
    {
        return itemCode;
    }
    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }

    public String getItemName()
    {
        return itemName;
    }
    public void setExaminationResultCode(String examinationResultCode)
    {
        this.examinationResultCode = examinationResultCode;
    }

    public String getExaminationResultCode()
    {
        return examinationResultCode;
    }
    public void setExaminationResultName(String examinationResultName)
    {
        this.examinationResultName = examinationResultName;
    }

    public String getExaminationResultName()
    {
        return examinationResultName;
    }
    public void setExaminationQuantification(String examinationQuantification)
    {
        this.examinationQuantification = examinationQuantification;
    }

    public String getExaminationQuantification()
    {
        return examinationQuantification;
    }
    public void setExaminationQuantificationUnit(String examinationQuantificationUnit)
    {
        this.examinationQuantificationUnit = examinationQuantificationUnit;
    }

    public String getExaminationQuantificationUnit()
    {
        return examinationQuantificationUnit;
    }
    public void setOperationTime(String operationTime)
    {
        this.operationTime = operationTime;
    }

    public String getOperationTime()
    {
        return operationTime;
    }
    public void setOperatorId(String operatorId)
    {
        this.operatorId = operatorId;
    }

    public String getOperatorId()
    {
        return operatorId;
    }
    public void setInvalidFlag(String invalidFlag)
    {
        this.invalidFlag = invalidFlag;
    }

    public String getInvalidFlag()
    {
        return invalidFlag;
    }
    public void setDataStatus(String dataStatus)
    {
        this.dataStatus = dataStatus;
    }

    public String getDataStatus()
    {
        return dataStatus;
    }
    public void setCreateDate(String createDate)
    {
        this.createDate = createDate;
    }

    public String getCreateDate()
    {
        return createDate;
    }
    public void setExaminationQuantificationLower(String examinationQuantificationLower)
    {
        this.examinationQuantificationLower = examinationQuantificationLower;
    }

    public String getExaminationQuantificationLower()
    {
        return examinationQuantificationLower;
    }
    public void setExaminationQuantificationUpper(String examinationQuantificationUpper)
    {
        this.examinationQuantificationUpper = examinationQuantificationUpper;
    }

    public String getExaminationQuantificationUpper()
    {
        return examinationQuantificationUpper;
    }
    public void setExaminationQuantificationRi(String examinationQuantificationRi)
    {
        this.examinationQuantificationRi = examinationQuantificationRi;
    }

    public String getExaminationQuantificationRi()
    {
        return examinationQuantificationRi;
    }
    public void setSourceExaminationResultCode(String sourceExaminationResultCode)
    {
        this.sourceExaminationResultCode = sourceExaminationResultCode;
    }

    public String getSourceExaminationResultCode()
    {
        return sourceExaminationResultCode;
    }
    public void setSourceExaminationResultName(String sourceExaminationResultName)
    {
        this.sourceExaminationResultName = sourceExaminationResultName;
    }

    public String getSourceExaminationResultName()
    {
        return sourceExaminationResultName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("exLabId", getExLabId())
                .append("itemCode", getItemCode())
                .append("itemName", getItemName())
                .append("examinationResultCode", getExaminationResultCode())
                .append("examinationResultName", getExaminationResultName())
                .append("examinationQuantification", getExaminationQuantification())
                .append("examinationQuantificationUnit", getExaminationQuantificationUnit())
                .append("operationTime", getOperationTime())
                .append("operatorId", getOperatorId())
                .append("invalidFlag", getInvalidFlag())
                .append("dataStatus", getDataStatus())
                .append("createDate", getCreateDate())
                .append("examinationQuantificationLower", getExaminationQuantificationLower())
                .append("examinationQuantificationUpper", getExaminationQuantificationUpper())
                .append("examinationQuantificationRi", getExaminationQuantificationRi())
                .append("sourceExaminationResultCode", getSourceExaminationResultCode())
                .append("sourceExaminationResultName", getSourceExaminationResultName())
                .toString();
    }
}
