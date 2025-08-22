package cn.xa.eyre.hub.domain.emrmonitor;

import java.util.Date;

import cn.xa.eyre.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 医嘱信息细对象 emr_order_item
 *
 * @author ruoyi
 * @date 2025-06-11
 */
public class EmrOrderItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 医嘱处方ID */
    private String orderId;

    /** 药物代码 */
    private String drugCode;

    /** 药物名称 */
    private String drugName;

    /** 药物规格 */
    private String drugSpecifications;

    /** 单次用药剂量代码 */
    private String drugDosageCode;

    /** 药物使用剂量单位代码 */
    private String drugDosageUnitCode;

    /** 药物使用剂量单位名称 */
    private String drugDosageUnitName;

    /** 药物使用总剂量 */
    private String drugDosageTotal;

    /** 中药饮片处方 */
    private String tcmPrescription;

    /** 中药饮片剂数(剂) */
    private String tcmNumber;

    /** 中药饮片煎煮法 */
    private String tcmDecoctionMethod;

    /** 中药用药方法 */
    private String tcmUseMethod;

    /** 操作人ID */
    private String operatorId;

    /** 操作时间 */
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private String operationTime;

    /** 作废标志 */
    private String invalidFlag;

    /** 数据状态 0 未传输 1已传输 */
    private String dataStatus;

    /** 入库日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public String getOrderId()
    {
        return orderId;
    }
    public void setDrugCode(String drugCode)
    {
        this.drugCode = drugCode;
    }

    public String getDrugCode()
    {
        return drugCode;
    }
    public void setDrugName(String drugName)
    {
        this.drugName = drugName;
    }

    public String getDrugName()
    {
        return drugName;
    }
    public void setDrugSpecifications(String drugSpecifications)
    {
        this.drugSpecifications = drugSpecifications;
    }

    public String getDrugSpecifications()
    {
        return drugSpecifications;
    }
    public void setDrugDosageCode(String drugDosageCode)
    {
        this.drugDosageCode = drugDosageCode;
    }

    public String getDrugDosageCode()
    {
        return drugDosageCode;
    }
    public void setDrugDosageUnitCode(String drugDosageUnitCode)
    {
        this.drugDosageUnitCode = drugDosageUnitCode;
    }

    public String getDrugDosageUnitCode()
    {
        return drugDosageUnitCode;
    }
    public void setDrugDosageUnitName(String drugDosageUnitName)
    {
        this.drugDosageUnitName = drugDosageUnitName;
    }

    public String getDrugDosageUnitName()
    {
        return drugDosageUnitName;
    }
    public void setDrugDosageTotal(String drugDosageTotal)
    {
        this.drugDosageTotal = drugDosageTotal;
    }

    public String getDrugDosageTotal()
    {
        return drugDosageTotal;
    }
    public void setTcmPrescription(String tcmPrescription)
    {
        this.tcmPrescription = tcmPrescription;
    }

    public String getTcmPrescription()
    {
        return tcmPrescription;
    }
    public void setTcmNumber(String tcmNumber)
    {
        this.tcmNumber = tcmNumber;
    }

    public String getTcmNumber()
    {
        return tcmNumber;
    }
    public void setTcmDecoctionMethod(String tcmDecoctionMethod)
    {
        this.tcmDecoctionMethod = tcmDecoctionMethod;
    }

    public String getTcmDecoctionMethod()
    {
        return tcmDecoctionMethod;
    }
    public void setTcmUseMethod(String tcmUseMethod)
    {
        this.tcmUseMethod = tcmUseMethod;
    }

    public String getTcmUseMethod()
    {
        return tcmUseMethod;
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
    public void setDataStatus(String dataStatus)
    {
        this.dataStatus = dataStatus;
    }

    public String getDataStatus()
    {
        return dataStatus;
    }
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public Date getCreateDate()
    {
        return createDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("orderId", getOrderId())
                .append("drugCode", getDrugCode())
                .append("drugName", getDrugName())
                .append("drugSpecifications", getDrugSpecifications())
                .append("drugDosageCode", getDrugDosageCode())
                .append("drugDosageUnitCode", getDrugDosageUnitCode())
                .append("drugDosageUnitName", getDrugDosageUnitName())
                .append("drugDosageTotal", getDrugDosageTotal())
                .append("tcmPrescription", getTcmPrescription())
                .append("tcmNumber", getTcmNumber())
                .append("tcmDecoctionMethod", getTcmDecoctionMethod())
                .append("tcmUseMethod", getTcmUseMethod())
                .append("operatorId", getOperatorId())
                .append("operationTime", getOperationTime())
                .append("invalidFlag", getInvalidFlag())
                .append("dataStatus", getDataStatus())
                .append("createDate", getCreateDate())
                .toString();
    }
}
