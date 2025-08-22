package cn.xa.eyre.outpdoct.domain;

import java.math.BigDecimal;
import java.util.Date;

public class OutpTreatRec extends OutpTreatRecKey {
    private Date visitDate;

    private Short visitNo;

    private String itemClass;

    private String itemCode;

    private String itemName;

    private String itemSpec;

    private String units;

    private Short amount;

    private String frequency;

    private String performedBy;

    private BigDecimal costs;

    private BigDecimal charges;

    private Short chargeIndicator;

    private String appointNo;

    private Short appointItemNo;

    private Short recipetype;

    private BigDecimal costsPrice;

    private BigDecimal costsReal;

    private String meno;

    private String treatMethod;

    private String getdrugFlag;

    private String freqDetail;

    private String performedLocation;

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Short getVisitNo() {
        return visitNo;
    }

    public void setVisitNo(Short visitNo) {
        this.visitNo = visitNo;
    }

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass == null ? null : itemClass.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemSpec() {
        return itemSpec;
    }

    public void setItemSpec(String itemSpec) {
        this.itemSpec = itemSpec == null ? null : itemSpec.trim();
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units == null ? null : units.trim();
    }

    public Short getAmount() {
        return amount;
    }

    public void setAmount(Short amount) {
        this.amount = amount;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency == null ? null : frequency.trim();
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

    public Short getChargeIndicator() {
        return chargeIndicator;
    }

    public void setChargeIndicator(Short chargeIndicator) {
        this.chargeIndicator = chargeIndicator;
    }

    public String getAppointNo() {
        return appointNo;
    }

    public void setAppointNo(String appointNo) {
        this.appointNo = appointNo == null ? null : appointNo.trim();
    }

    public Short getAppointItemNo() {
        return appointItemNo;
    }

    public void setAppointItemNo(Short appointItemNo) {
        this.appointItemNo = appointItemNo;
    }

    public Short getRecipetype() {
        return recipetype;
    }

    public void setRecipetype(Short recipetype) {
        this.recipetype = recipetype;
    }

    public BigDecimal getCostsPrice() {
        return costsPrice;
    }

    public void setCostsPrice(BigDecimal costsPrice) {
        this.costsPrice = costsPrice;
    }

    public BigDecimal getCostsReal() {
        return costsReal;
    }

    public void setCostsReal(BigDecimal costsReal) {
        this.costsReal = costsReal;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno == null ? null : meno.trim();
    }

    public String getTreatMethod() {
        return treatMethod;
    }

    public void setTreatMethod(String treatMethod) {
        this.treatMethod = treatMethod == null ? null : treatMethod.trim();
    }

    public String getGetdrugFlag() {
        return getdrugFlag;
    }

    public void setGetdrugFlag(String getdrugFlag) {
        this.getdrugFlag = getdrugFlag == null ? null : getdrugFlag.trim();
    }

    public String getFreqDetail() {
        return freqDetail;
    }

    public void setFreqDetail(String freqDetail) {
        this.freqDetail = freqDetail == null ? null : freqDetail.trim();
    }

    public String getPerformedLocation() {
        return performedLocation;
    }

    public void setPerformedLocation(String performedLocation) {
        this.performedLocation = performedLocation == null ? null : performedLocation.trim();
    }
}