package cn.xa.eyre.pharmacy.domain;

import java.math.BigDecimal;
import java.util.Date;

public class    DrugPrescMaster {
    private Date prescDate;

    private Short prescNo;

    private String dispensary;

    private String patientId;

    private String name;

    private String namePhonetic;

    private String identity;

    private String chargeType;

    private String unitInContract;

    private Short prescType;

    private String prescAttr;

    private Short prescSource;

    private Short repetition;

    private BigDecimal costs;

    private BigDecimal payments;

    private String orderedBy;

    private String prescribedBy;

    private String enteredBy;

    private String dispensingProvider;

    private Short countPerRepetition;

    private Date enteredDatetime;

    private Date dispensingDatetime;

    private String memo;

    private String subStorage;

    private Short flag;

    private String doctorUser;

    private String verifyBy;

    private Short dischargeTakingIndicator;

    private String clinicNo;

    private Short visitId;

    private Short decoction;

    private Date verifiedDatetime;

    private String rcptNo;

    private Date originalPrescDate;

    private Integer originalPrescNo;

    private Integer returnVisitNo;

    private Date returnVisitDate;

    private String batchProvideNo;

    private Date dispenseDateTime;

    public String prescDateStr;

    public String prescDateShortStr;

    public Date getPrescDate() {
        return prescDate;
    }

    public void setPrescDate(Date prescDate) {
        this.prescDate = prescDate;
    }

    public Short getPrescNo() {
        return prescNo;
    }

    public void setPrescNo(Short prescNo) {
        this.prescNo = prescNo;
    }

    public String getDispensary() {
        return dispensary;
    }

    public void setDispensary(String dispensary) {
        this.dispensary = dispensary == null ? null : dispensary.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNamePhonetic() {
        return namePhonetic;
    }

    public void setNamePhonetic(String namePhonetic) {
        this.namePhonetic = namePhonetic == null ? null : namePhonetic.trim();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    public String getUnitInContract() {
        return unitInContract;
    }

    public void setUnitInContract(String unitInContract) {
        this.unitInContract = unitInContract == null ? null : unitInContract.trim();
    }

    public Short getPrescType() {
        return prescType;
    }

    public void setPrescType(Short prescType) {
        this.prescType = prescType;
    }

    public String getPrescAttr() {
        return prescAttr;
    }

    public void setPrescAttr(String prescAttr) {
        this.prescAttr = prescAttr == null ? null : prescAttr.trim();
    }

    public Short getPrescSource() {
        return prescSource;
    }

    public void setPrescSource(Short prescSource) {
        this.prescSource = prescSource;
    }

    public Short getRepetition() {
        return repetition;
    }

    public void setRepetition(Short repetition) {
        this.repetition = repetition;
    }

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }

    public BigDecimal getPayments() {
        return payments;
    }

    public void setPayments(BigDecimal payments) {
        this.payments = payments;
    }

    public String getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(String orderedBy) {
        this.orderedBy = orderedBy == null ? null : orderedBy.trim();
    }

    public String getPrescribedBy() {
        return prescribedBy;
    }

    public void setPrescribedBy(String prescribedBy) {
        this.prescribedBy = prescribedBy == null ? null : prescribedBy.trim();
    }

    public String getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(String enteredBy) {
        this.enteredBy = enteredBy == null ? null : enteredBy.trim();
    }

    public String getDispensingProvider() {
        return dispensingProvider;
    }

    public void setDispensingProvider(String dispensingProvider) {
        this.dispensingProvider = dispensingProvider == null ? null : dispensingProvider.trim();
    }

    public Short getCountPerRepetition() {
        return countPerRepetition;
    }

    public void setCountPerRepetition(Short countPerRepetition) {
        this.countPerRepetition = countPerRepetition;
    }

    public Date getEnteredDatetime() {
        return enteredDatetime;
    }

    public void setEnteredDatetime(Date enteredDatetime) {
        this.enteredDatetime = enteredDatetime;
    }

    public Date getDispensingDatetime() {
        return dispensingDatetime;
    }

    public void setDispensingDatetime(Date dispensingDatetime) {
        this.dispensingDatetime = dispensingDatetime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getSubStorage() {
        return subStorage;
    }

    public void setSubStorage(String subStorage) {
        this.subStorage = subStorage == null ? null : subStorage.trim();
    }

    public Short getFlag() {
        return flag;
    }

    public void setFlag(Short flag) {
        this.flag = flag;
    }

    public String getDoctorUser() {
        return doctorUser;
    }

    public void setDoctorUser(String doctorUser) {
        this.doctorUser = doctorUser == null ? null : doctorUser.trim();
    }

    public String getVerifyBy() {
        return verifyBy;
    }

    public void setVerifyBy(String verifyBy) {
        this.verifyBy = verifyBy == null ? null : verifyBy.trim();
    }

    public Short getDischargeTakingIndicator() {
        return dischargeTakingIndicator;
    }

    public void setDischargeTakingIndicator(Short dischargeTakingIndicator) {
        this.dischargeTakingIndicator = dischargeTakingIndicator;
    }

    public String getClinicNo() {
        return clinicNo;
    }

    public void setClinicNo(String clinicNo) {
        this.clinicNo = clinicNo == null ? null : clinicNo.trim();
    }

    public Short getVisitId() {
        return visitId;
    }

    public void setVisitId(Short visitId) {
        this.visitId = visitId;
    }

    public Short getDecoction() {
        return decoction;
    }

    public void setDecoction(Short decoction) {
        this.decoction = decoction;
    }

    public Date getVerifiedDatetime() {
        return verifiedDatetime;
    }

    public void setVerifiedDatetime(Date verifiedDatetime) {
        this.verifiedDatetime = verifiedDatetime;
    }

    public String getRcptNo() {
        return rcptNo;
    }

    public void setRcptNo(String rcptNo) {
        this.rcptNo = rcptNo == null ? null : rcptNo.trim();
    }

    public Date getOriginalPrescDate() {
        return originalPrescDate;
    }

    public void setOriginalPrescDate(Date originalPrescDate) {
        this.originalPrescDate = originalPrescDate;
    }

    public Integer getOriginalPrescNo() {
        return originalPrescNo;
    }

    public void setOriginalPrescNo(Integer originalPrescNo) {
        this.originalPrescNo = originalPrescNo;
    }

    public Integer getReturnVisitNo() {
        return returnVisitNo;
    }

    public void setReturnVisitNo(Integer returnVisitNo) {
        this.returnVisitNo = returnVisitNo;
    }

    public Date getReturnVisitDate() {
        return returnVisitDate;
    }

    public void setReturnVisitDate(Date returnVisitDate) {
        this.returnVisitDate = returnVisitDate;
    }

    public String getBatchProvideNo() {
        return batchProvideNo;
    }

    public void setBatchProvideNo(String batchProvideNo) {
        this.batchProvideNo = batchProvideNo == null ? null : batchProvideNo.trim();
    }

    public Date getDispenseDateTime() {
        return dispenseDateTime;
    }

    public void setDispenseDateTime(Date dispenseDateTime) {
        this.dispenseDateTime = dispenseDateTime;
    }

    public String getPrescDateStr() {
        return prescDateStr;
    }

    public void setPrescDateStr(String prescDateStr) {
        this.prescDateStr = prescDateStr;
    }

    public String getPrescDateShortStr() {
        return prescDateShortStr;
    }

    public void setPrescDateShortStr(String prescDateShortStr) {
        this.prescDateShortStr = prescDateShortStr;
    }
}