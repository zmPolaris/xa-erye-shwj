package cn.xa.eyre.inpbill.domain;

import java.math.BigDecimal;
import java.util.Date;

public class InpBillDetail extends InpBillDetailKey {

    private String patientId;

    private Short visitId;

    private Integer itemNo;

    @Override
    public String getPatientId() {
        return patientId;
    }

    @Override
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    @Override
    public Short getVisitId() {
        return visitId;
    }

    @Override
    public void setVisitId(Short visitId) {
        this.visitId = visitId;
    }

    @Override
    public Integer getItemNo() {
        return itemNo;
    }

    @Override
    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }

    private String itemClass;

    private String itemName;

    private String itemCode;

    private String itemSpec;

    private BigDecimal amount;

    private String units;

    private String orderedBy;

    private String performedBy;

    private BigDecimal costs;

    private BigDecimal charges;

    private Date billingDateTime;

    private String operatorNo;

    private String rcptNo;

    private BigDecimal freeCosts;

    private BigDecimal unitPrice;

    private BigDecimal flItemCosts;

    private BigDecimal jyItemCosts;

    private String classOnInpRcpt;

    private BigDecimal specialCharges;

    private Short costburdensFlag;

    private Long subItemNo;

    private BigDecimal zfItemCosts;

    private String freeLimit;

    private Short gjyFlag;

    private String insuranceCode;

    private BigDecimal childrenJyItemCosts;

    private String examLabReqno;

    private String mxzdh;

    private Integer orderNo;

    private Integer orderSubNo;

    private String specialInfo;

    private Short recipetype;

    private Short packNo;

    private String transFlag;

    private String feedetlSn;

    private String combNo;

    private String nationCode;

    private String initFeedetlSn;

    private Integer refundItemNo;

    private Integer minpacuntDrugTracCnt;

    private Integer mcsTracCnt;

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass == null ? null : itemClass.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getItemSpec() {
        return itemSpec;
    }

    public void setItemSpec(String itemSpec) {
        this.itemSpec = itemSpec == null ? null : itemSpec.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units == null ? null : units.trim();
    }

    public String getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(String orderedBy) {
        this.orderedBy = orderedBy == null ? null : orderedBy.trim();
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy == null ? null : performedBy.trim();
    }

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }

    public BigDecimal getCharges() {
        return charges;
    }

    public void setCharges(BigDecimal charges) {
        this.charges = charges;
    }

    public Date getBillingDateTime() {
        return billingDateTime;
    }

    public void setBillingDateTime(Date billingDateTime) {
        this.billingDateTime = billingDateTime;
    }

    public String getOperatorNo() {
        return operatorNo;
    }

    public void setOperatorNo(String operatorNo) {
        this.operatorNo = operatorNo == null ? null : operatorNo.trim();
    }

    public String getRcptNo() {
        return rcptNo;
    }

    public void setRcptNo(String rcptNo) {
        this.rcptNo = rcptNo == null ? null : rcptNo.trim();
    }

    public BigDecimal getFreeCosts() {
        return freeCosts;
    }

    public void setFreeCosts(BigDecimal freeCosts) {
        this.freeCosts = freeCosts;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getFlItemCosts() {
        return flItemCosts;
    }

    public void setFlItemCosts(BigDecimal flItemCosts) {
        this.flItemCosts = flItemCosts;
    }

    public BigDecimal getJyItemCosts() {
        return jyItemCosts;
    }

    public void setJyItemCosts(BigDecimal jyItemCosts) {
        this.jyItemCosts = jyItemCosts;
    }

    public String getClassOnInpRcpt() {
        return classOnInpRcpt;
    }

    public void setClassOnInpRcpt(String classOnInpRcpt) {
        this.classOnInpRcpt = classOnInpRcpt == null ? null : classOnInpRcpt.trim();
    }

    public BigDecimal getSpecialCharges() {
        return specialCharges;
    }

    public void setSpecialCharges(BigDecimal specialCharges) {
        this.specialCharges = specialCharges;
    }

    public Short getCostburdensFlag() {
        return costburdensFlag;
    }

    public void setCostburdensFlag(Short costburdensFlag) {
        this.costburdensFlag = costburdensFlag;
    }

    public Long getSubItemNo() {
        return subItemNo;
    }

    public void setSubItemNo(Long subItemNo) {
        this.subItemNo = subItemNo;
    }

    public BigDecimal getZfItemCosts() {
        return zfItemCosts;
    }

    public void setZfItemCosts(BigDecimal zfItemCosts) {
        this.zfItemCosts = zfItemCosts;
    }

    public String getFreeLimit() {
        return freeLimit;
    }

    public void setFreeLimit(String freeLimit) {
        this.freeLimit = freeLimit == null ? null : freeLimit.trim();
    }

    public Short getGjyFlag() {
        return gjyFlag;
    }

    public void setGjyFlag(Short gjyFlag) {
        this.gjyFlag = gjyFlag;
    }

    public String getInsuranceCode() {
        return insuranceCode;
    }

    public void setInsuranceCode(String insuranceCode) {
        this.insuranceCode = insuranceCode == null ? null : insuranceCode.trim();
    }

    public BigDecimal getChildrenJyItemCosts() {
        return childrenJyItemCosts;
    }

    public void setChildrenJyItemCosts(BigDecimal childrenJyItemCosts) {
        this.childrenJyItemCosts = childrenJyItemCosts;
    }

    public String getExamLabReqno() {
        return examLabReqno;
    }

    public void setExamLabReqno(String examLabReqno) {
        this.examLabReqno = examLabReqno == null ? null : examLabReqno.trim();
    }

    public String getMxzdh() {
        return mxzdh;
    }

    public void setMxzdh(String mxzdh) {
        this.mxzdh = mxzdh == null ? null : mxzdh.trim();
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getOrderSubNo() {
        return orderSubNo;
    }

    public void setOrderSubNo(Integer orderSubNo) {
        this.orderSubNo = orderSubNo;
    }

    public String getSpecialInfo() {
        return specialInfo;
    }

    public void setSpecialInfo(String specialInfo) {
        this.specialInfo = specialInfo == null ? null : specialInfo.trim();
    }

    public Short getRecipetype() {
        return recipetype;
    }

    public void setRecipetype(Short recipetype) {
        this.recipetype = recipetype;
    }

    public Short getPackNo() {
        return packNo;
    }

    public void setPackNo(Short packNo) {
        this.packNo = packNo;
    }

    public String getTransFlag() {
        return transFlag;
    }

    public void setTransFlag(String transFlag) {
        this.transFlag = transFlag == null ? null : transFlag.trim();
    }

    public String getFeedetlSn() {
        return feedetlSn;
    }

    public void setFeedetlSn(String feedetlSn) {
        this.feedetlSn = feedetlSn == null ? null : feedetlSn.trim();
    }

    public String getCombNo() {
        return combNo;
    }

    public void setCombNo(String combNo) {
        this.combNo = combNo == null ? null : combNo.trim();
    }

    public String getNationCode() {
        return nationCode;
    }

    public void setNationCode(String nationCode) {
        this.nationCode = nationCode == null ? null : nationCode.trim();
    }

    public String getInitFeedetlSn() {
        return initFeedetlSn;
    }

    public void setInitFeedetlSn(String initFeedetlSn) {
        this.initFeedetlSn = initFeedetlSn == null ? null : initFeedetlSn.trim();
    }

    public Integer getRefundItemNo() {
        return refundItemNo;
    }

    public void setRefundItemNo(Integer refundItemNo) {
        this.refundItemNo = refundItemNo;
    }

    public Integer getMinpacuntDrugTracCnt() {
        return minpacuntDrugTracCnt;
    }

    public void setMinpacuntDrugTracCnt(Integer minpacuntDrugTracCnt) {
        this.minpacuntDrugTracCnt = minpacuntDrugTracCnt;
    }

    public Integer getMcsTracCnt() {
        return mcsTracCnt;
    }

    public void setMcsTracCnt(Integer mcsTracCnt) {
        this.mcsTracCnt = mcsTracCnt;
    }
}