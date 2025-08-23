package cn.xa.eyre.lab.domain;

import java.math.BigDecimal;
import java.util.Date;

public class LabTestMaster {
    private String testNo;

    private Short priorityIndicator;

    private String patientId;

    private Integer visitId;

    private String workingId;

    private Date executeDate;

    private String name;

    private String namePhonetic;

    private String chargeType;

    private String sex;

    private Short age;

    private String testCause;

    private String relevantClinicDiag;

    private String specimen;

    private String notesForSpcm;

    private Date spcmReceivedDateTime;

    private Date spcmSampleDateTime;

    private Date requestedDateTime;

    private String orderingDept;

    private String orderingProvider;

    private String performedBy;

    private String resultStatus;

    private Date resultsRptDateTime;

    private String transcriptionist;

    private String verifiedBy;

    private BigDecimal costs;

    private BigDecimal charges;

    private Short billingIndicator;

    private Short printIndicator;

    private String subject;

    private String alarmflag;

    private String rejectStatus;

    private Date rejectDate;

    private String rejectReason;

    private String bgddh;

    private Integer visitNo;

    private Date visitDate;

    private String patientSource;

    private Date dateOfBirth;

    public String getTestNo() {
        return testNo;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo == null ? null : testNo.trim();
    }

    public Short getPriorityIndicator() {
        return priorityIndicator;
    }

    public void setPriorityIndicator(Short priorityIndicator) {
        this.priorityIndicator = priorityIndicator;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public Integer getVisitId() {
        return visitId;
    }

    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }

    public String getWorkingId() {
        return workingId;
    }

    public void setWorkingId(String workingId) {
        this.workingId = workingId == null ? null : workingId.trim();
    }

    public Date getExecuteDate() {
        return executeDate;
    }

    public void setExecuteDate(Date executeDate) {
        this.executeDate = executeDate;
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

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getTestCause() {
        return testCause;
    }

    public void setTestCause(String testCause) {
        this.testCause = testCause == null ? null : testCause.trim();
    }

    public String getRelevantClinicDiag() {
        return relevantClinicDiag;
    }

    public void setRelevantClinicDiag(String relevantClinicDiag) {
        this.relevantClinicDiag = relevantClinicDiag == null ? null : relevantClinicDiag.trim();
    }

    public String getSpecimen() {
        return specimen;
    }

    public void setSpecimen(String specimen) {
        this.specimen = specimen == null ? null : specimen.trim();
    }

    public String getNotesForSpcm() {
        return notesForSpcm;
    }

    public void setNotesForSpcm(String notesForSpcm) {
        this.notesForSpcm = notesForSpcm == null ? null : notesForSpcm.trim();
    }

    public Date getSpcmReceivedDateTime() {
        return spcmReceivedDateTime;
    }

    public void setSpcmReceivedDateTime(Date spcmReceivedDateTime) {
        this.spcmReceivedDateTime = spcmReceivedDateTime;
    }

    public Date getSpcmSampleDateTime() {
        return spcmSampleDateTime;
    }

    public void setSpcmSampleDateTime(Date spcmSampleDateTime) {
        this.spcmSampleDateTime = spcmSampleDateTime;
    }

    public Date getRequestedDateTime() {
        return requestedDateTime;
    }

    public void setRequestedDateTime(Date requestedDateTime) {
        this.requestedDateTime = requestedDateTime;
    }

    public String getOrderingDept() {
        return orderingDept;
    }

    public void setOrderingDept(String orderingDept) {
        this.orderingDept = orderingDept == null ? null : orderingDept.trim();
    }

    public String getOrderingProvider() {
        return orderingProvider;
    }

    public void setOrderingProvider(String orderingProvider) {
        this.orderingProvider = orderingProvider == null ? null : orderingProvider.trim();
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy == null ? null : performedBy.trim();
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus == null ? null : resultStatus.trim();
    }

    public Date getResultsRptDateTime() {
        return resultsRptDateTime;
    }

    public void setResultsRptDateTime(Date resultsRptDateTime) {
        this.resultsRptDateTime = resultsRptDateTime;
    }

    public String getTranscriptionist() {
        return transcriptionist;
    }

    public void setTranscriptionist(String transcriptionist) {
        this.transcriptionist = transcriptionist == null ? null : transcriptionist.trim();
    }

    public String getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(String verifiedBy) {
        this.verifiedBy = verifiedBy == null ? null : verifiedBy.trim();
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

    public Short getBillingIndicator() {
        return billingIndicator;
    }

    public void setBillingIndicator(Short billingIndicator) {
        this.billingIndicator = billingIndicator;
    }

    public Short getPrintIndicator() {
        return printIndicator;
    }

    public void setPrintIndicator(Short printIndicator) {
        this.printIndicator = printIndicator;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getAlarmflag() {
        return alarmflag;
    }

    public void setAlarmflag(String alarmflag) {
        this.alarmflag = alarmflag == null ? null : alarmflag.trim();
    }

    public String getRejectStatus() {
        return rejectStatus;
    }

    public void setRejectStatus(String rejectStatus) {
        this.rejectStatus = rejectStatus == null ? null : rejectStatus.trim();
    }

    public Date getRejectDate() {
        return rejectDate;
    }

    public void setRejectDate(Date rejectDate) {
        this.rejectDate = rejectDate;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason == null ? null : rejectReason.trim();
    }

    public String getBgddh() {
        return bgddh;
    }

    public void setBgddh(String bgddh) {
        this.bgddh = bgddh == null ? null : bgddh.trim();
    }

    public Integer getVisitNo() {
        return visitNo;
    }

    public void setVisitNo(Integer visitNo) {
        this.visitNo = visitNo;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getPatientSource() {
        return patientSource;
    }

    public void setPatientSource(String patientSource) {
        this.patientSource = patientSource == null ? null : patientSource.trim();
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}