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

    private String rptstatus;

    private String printStatus;

    private String examSubdept;

    private String confirmDoct;

    private String studyUid;

    private String verifier;

    private String examReason;

    private Date confirmDateTime;

    private String photoStatus;

    private String auditingDoct;

    private Date auditingDateTime;

    private String artificer;

    private String errorComment;

    private Short priorityIndicator;

    private String treatProcess;

    private Date visitDate;

    private Short visitNo;

    private Short bedNo;

    private String accessionNo;

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

    public String getRptstatus() {
        return rptstatus;
    }

    public void setRptstatus(String rptstatus) {
        this.rptstatus = rptstatus == null ? null : rptstatus.trim();
    }

    public String getPrintStatus() {
        return printStatus;
    }

    public void setPrintStatus(String printStatus) {
        this.printStatus = printStatus == null ? null : printStatus.trim();
    }

    public String getExamSubdept() {
        return examSubdept;
    }

    public void setExamSubdept(String examSubdept) {
        this.examSubdept = examSubdept == null ? null : examSubdept.trim();
    }

    public String getConfirmDoct() {
        return confirmDoct;
    }

    public void setConfirmDoct(String confirmDoct) {
        this.confirmDoct = confirmDoct == null ? null : confirmDoct.trim();
    }

    public String getStudyUid() {
        return studyUid;
    }

    public void setStudyUid(String studyUid) {
        this.studyUid = studyUid == null ? null : studyUid.trim();
    }

    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier == null ? null : verifier.trim();
    }

    public String getExamReason() {
        return examReason;
    }

    public void setExamReason(String examReason) {
        this.examReason = examReason == null ? null : examReason.trim();
    }

    public Date getConfirmDateTime() {
        return confirmDateTime;
    }

    public void setConfirmDateTime(Date confirmDateTime) {
        this.confirmDateTime = confirmDateTime;
    }

    public String getPhotoStatus() {
        return photoStatus;
    }

    public void setPhotoStatus(String photoStatus) {
        this.photoStatus = photoStatus == null ? null : photoStatus.trim();
    }

    public String getAuditingDoct() {
        return auditingDoct;
    }

    public void setAuditingDoct(String auditingDoct) {
        this.auditingDoct = auditingDoct == null ? null : auditingDoct.trim();
    }

    public Date getAuditingDateTime() {
        return auditingDateTime;
    }

    public void setAuditingDateTime(Date auditingDateTime) {
        this.auditingDateTime = auditingDateTime;
    }

    public String getArtificer() {
        return artificer;
    }

    public void setArtificer(String artificer) {
        this.artificer = artificer == null ? null : artificer.trim();
    }

    public String getErrorComment() {
        return errorComment;
    }

    public void setErrorComment(String errorComment) {
        this.errorComment = errorComment == null ? null : errorComment.trim();
    }

    public Short getPriorityIndicator() {
        return priorityIndicator;
    }

    public void setPriorityIndicator(Short priorityIndicator) {
        this.priorityIndicator = priorityIndicator;
    }

    public String getTreatProcess() {
        return treatProcess;
    }

    public void setTreatProcess(String treatProcess) {
        this.treatProcess = treatProcess == null ? null : treatProcess.trim();
    }

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

    public Short getBedNo() {
        return bedNo;
    }

    public void setBedNo(Short bedNo) {
        this.bedNo = bedNo;
    }

    public String getAccessionNo() {
        return accessionNo;
    }

    public void setAccessionNo(String accessionNo) {
        this.accessionNo = accessionNo == null ? null : accessionNo.trim();
    }
}