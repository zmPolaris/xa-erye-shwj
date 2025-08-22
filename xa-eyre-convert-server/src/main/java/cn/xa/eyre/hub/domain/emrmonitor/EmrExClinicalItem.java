package cn.xa.eyre.hub.domain.emrmonitor;


import cn.xa.eyre.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 检查报告细对象 emr_ex_clinical_item
 *
 * @author ruoyi
 * @date 2025-06-11
 */
public class EmrExClinicalItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 检查报告ID */
    private String exClinicalId;

    /** 检查项目 */
    private String itemName;

    /** 检查结果代码 */
    private String examinationResultCode;

    /** 检查结果名称 */
    private String examinationResultName;

    /** 检查定量结果 */
    private String examinationQuantification;

    /** 检查定量结果计量单位 */
    private String examinationQuantificationUnit;

    /** 操作人ID */
    private String operatorId;

    /** 操作时间 */
    private String operationTime;

    /** 作废标志 */
    private String invalidFlag;

    /** 检查项目代码 */
    private String itemCode;

    /** 数据状态 0 未传输 1已传输 */
    private String dataStatus;

    /** 入库日期 */
    private String createDate;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setExClinicalId(String exClinicalId)
    {
        this.exClinicalId = exClinicalId;
    }

    public String getExClinicalId()
    {
        return exClinicalId;
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
    public void setOperatorId(String operatorId)
    {
        this.operatorId = operatorId;
    }

    public String getOperatorId()
    {
        return operatorId;
    }
    public void setOperationTime(String operationTime)
    {
        this.operationTime = operationTime;
    }

    public String getOperationTime()
    {
        return operationTime;
    }
    public void setInvalidFlag(String invalidFlag)
    {
        this.invalidFlag = invalidFlag;
    }

    public String getInvalidFlag()
    {
        return invalidFlag;
    }
    public void setItemCode(String itemCode)
    {
        this.itemCode = itemCode;
    }

    public String getItemCode()
    {
        return itemCode;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("exClinicalId", getExClinicalId())
                .append("itemName", getItemName())
                .append("examinationResultCode", getExaminationResultCode())
                .append("examinationResultName", getExaminationResultName())
                .append("examinationQuantification", getExaminationQuantification())
                .append("examinationQuantificationUnit", getExaminationQuantificationUnit())
                .append("operatorId", getOperatorId())
                .append("operationTime", getOperationTime())
                .append("invalidFlag", getInvalidFlag())
                .append("itemCode", getItemCode())
                .append("dataStatus", getDataStatus())
                .append("createDate", getCreateDate())
                .toString();
    }
}
