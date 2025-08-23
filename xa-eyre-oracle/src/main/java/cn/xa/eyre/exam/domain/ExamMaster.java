package cn.xa.eyre.exam.domain;

import java.math.BigDecimal;
import java.util.Date;

public class ExamMaster {
    private String examNo;

    private String localIdClass;

    private String patientLocalId;

    private String patientId;

    private Short visitId;

    private String name;

    private String sex;

    private Date dateOfBirth;

    private String examClass;

    private String examSubClass;

    private Date spmRecvedDate;

    private String clinSymp;

    private String physSign;

    private String relevantLabTest;

    private String relevantDiag;

    private String clinDiag;

    private String examMode;

    private String examGroup;

    private String device;

    private String performedBy;

    private String patientSource;

    private String facility;

    private Date reqDateTime;

    private String reqDept;

    private String reqPhysician;

    private String reqMemo;

    private Date scheduledDateTime;

    private String notice;

    private Date examDateTime;

    private Date reportDateTime;

    private String technician;

    private String reporter;

    private String resultStatus;

    private BigDecimal costs;

    private BigDecimal charges;

    private Short chargeIndicator;

    private String identity;

    private String chargeType;

    private String treatProcess;

    private String errorComment;

    private String visitNo;

    private Date visitDate;

    private String priorityIndicator;

    private String verifier;

    public String getExamNo() {
        return examNo;
    }

    public void setExamNo(String examNo) {
        this.examNo = examNo == null ? null : examNo.trim();
    }

    public String getLocalIdClass() {
        return localIdClass;
    }

    public void setLocalIdClass(String localIdClass) {
        this.localIdClass = localIdClass == null ? null : localIdClass.trim();
    }

    public String getPatientLocalId() {
        return patientLocalId;
    }

    public void setPatientLocalId(String patientLocalId) {
        this.patientLocalId = patientLocalId == null ? null : patientLocalId.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public Short getVisitId() {
        return visitId;
    }

    public void setVisitId(Short visitId) {
        this.visitId = visitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getExamClass() {
        return examClass;
    }

    public void setExamClass(String examClass) {
        this.examClass = examClass == null ? null : examClass.trim();
    }

    public String getExamSubClass() {
        return examSubClass;
    }

    public void setExamSubClass(String examSubClass) {
        this.examSubClass = examSubClass == null ? null : examSubClass.trim();
    }

    public Date getSpmRecvedDate() {
        return spmRecvedDate;
    }

    public void setSpmRecvedDate(Date spmRecvedDate) {
        this.spmRecvedDate = spmRecvedDate;
    }

    public String getClinSymp() {
        return clinSymp;
    }

    public void setClinSymp(String clinSymp) {
        this.clinSymp = clinSymp == null ? null : clinSymp.trim();
    }

    public String getPhysSign() {
        return physSign;
    }

    public void setPhysSign(String physSign) {
        this.physSign = physSign == null ? null : physSign.trim();
    }

    public String getRelevantLabTest() {
        return relevantLabTest;
    }

    public void setRelevantLabTest(String relevantLabTest) {
        this.relevantLabTest = relevantLabTest == null ? null : relevantLabTest.trim();
    }

    public String getRelevantDiag() {
        return relevantDiag;
    }

    public void setRelevantDiag(String relevantDiag) {
        this.relevantDiag = relevantDiag == null ? null : relevantDiag.trim();
    }

    public String getClinDiag() {
        return clinDiag;
    }

    public void setClinDiag(String clinDiag) {
        this.clinDiag = clinDiag == null ? null : clinDiag.trim();
    }

    public String getExamMode() {
        return examMode;
    }

    public void setExamMode(String examMode) {
        this.examMode = examMode == null ? null : examMode.trim();
    }

    public String getExamGroup() {
        return examGroup;
    }

    public void setExamGroup(String examGroup) {
        this.examGroup = examGroup == null ? null : examGroup.trim();
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device == null ? null : device.trim();
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy == null ? null : performedBy.trim();
    }

    public String getPatientSource() {
        return patientSource;
    }

    public void setPatientSource(String patientSource) {
        this.patientSource = patientSource == null ? null : patientSource.trim();
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility == null ? null : facility.trim();
    }

    public Date getReqDateTime() {
        return reqDateTime;
    }

    public void setReqDateTime(Date reqDateTime) {
        this.reqDateTime = reqDateTime;
    }

    public String getReqDept() {
        return reqDept;
    }

    public void setReqDept(String reqDept) {
        this.reqDept = reqDept == null ? null : reqDept.trim();
    }

    public String getReqPhysician() {
        return reqPhysician;
    }

    public void setReqPhysician(String reqPhysician) {
        this.reqPhysician = reqPhysician == null ? null : reqPhysician.trim();
    }

    public String getReqMemo() {
        return reqMemo;
    }

    public void setReqMemo(String reqMemo) {
        this.reqMemo = reqMemo == null ? null : reqMemo.trim();
    }

    public Date getScheduledDateTime() {
        return scheduledDateTime;
    }

    public void setScheduledDateTime(Date scheduledDateTime) {
        this.scheduledDateTime = scheduledDateTime;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice == null ? null : notice.trim();
    }

    public Date getExamDateTime() {
        return examDateTime;
    }

    public void setExamDateTime(Date examDateTime) {
        this.examDateTime = examDateTime;
    }

    public Date getReportDateTime() {
        return reportDateTime;
    }

    public void setReportDateTime(Date reportDateTime) {
        this.reportDateTime = reportDateTime;
    }

    public String getTechnician() {
        return technician;
    }

    public void setTechnician(String technician) {
        this.technician = technician == null ? null : technician.trim();
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter == null ? null : reporter.trim();
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus == null ? null : resultStatus.trim();
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

    public String getTreatProcess() {
        return treatProcess;
    }

    public void setTreatProcess(String treatProcess) {
        this.treatProcess = treatProcess == null ? null : treatProcess.trim();
    }

    public String getErrorComment() {
        return errorComment;
    }

    public void setErrorComment(String errorComment) {
        this.errorComment = errorComment == null ? null : errorComment.trim();
    }

    public String getVisitNo() {
        return visitNo;
    }

    public void setVisitNo(String visitNo) {
        this.visitNo = visitNo == null ? null : visitNo.trim();
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getPriorityIndicator() {
        return priorityIndicator;
    }

    public void setPriorityIndicator(String priorityIndicator) {
        this.priorityIndicator = priorityIndicator == null ? null : priorityIndicator.trim();
    }

    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier == null ? null : verifier.trim();
    }
}