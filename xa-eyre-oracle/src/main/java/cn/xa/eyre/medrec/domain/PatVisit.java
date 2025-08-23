package cn.xa.eyre.medrec.domain;

import java.math.BigDecimal;
import java.util.Date;

public class PatVisit extends PatVisitKey {
    private String deptAdmissionTo;

    private Date admissionDateTime;

    private String deptDischargeFrom;

    private Date dischargeDateTime;

    private String occupation;

    private String maritalStatus;

    private String identity;

    private String armedServices;

    private String duty;

    private String unitInContract;

    private String chargeType;

    private Short workingStatus;

    private String insuranceType;

    private String insuranceNo;

    private String serviceAgency;

    private String mailingAddress;

    private String zipCode;

    private String nextOfKin;

    private String relationship;

    private String nextOfKinAddr;

    private String nextOfKinZipcode;

    private String nextOfKinPhone;

    private String patientClass;

    private String admissionCause;

    private Date consultingDate;

    private String patAdmCondition;

    private String consultingDoctor;

    private String admittedBy;

    private Short emerTreatTimes;

    private Short escEmerTimes;

    private Short seriousCondDays;

    private Short criticalCondDays;

    private Short icuDays;

    private Short ccuDays;

    private Short specLevelNursDays;

    private Short firstLevelNursDays;

    private Short secondLevelNursDays;

    private Short autopsyIndicator;

    private String bloodType;

    private String bloodTypeRh;

    private Short infusionReactTimes;

    private Short bloodTranTimes;

    private Integer bloodTranVol;

    private Short bloodTranReactTimes;

    private Short decubitalUlcerTimes;

    private String alergyDrugs;

    private String adverseReactionDrugs;

    private String mrValue;

    private String mrQuality;

    private Short followIndicator;

    private Short followInterval;

    private String followIntervalUnits;

    private String director;

    private String attendingDoctor;

    private String doctorInCharge;

    private String dischargeDisposition;

    private BigDecimal totalCosts;

    private BigDecimal totalPayments;

    private Date catalogDate;

    private String cataloger;

    private String topUnit;

    private Short serviceSystemIndicator;

    private String directorDbuser;

    private String attendingDoctorDbuser;

    private String doctorInChargeDbuser;

    private String insuranceDiagnosisCode;

    private String internalNo;

    private String identityClass;

    private Short hbsagIndicator;

    private Short hcvAbIndicator;

    private Short hivAbIndicator;

    private String chiefDoctor;

    private String advancedStudiesDoctor;

    private String practiceDoctorOfGraduate;

    private String practiceDoctor;

    private String doctorOfControlQuality;

    private String nurseOfControlQuality;

    private Date dateOfControlQuality;

    private Short firstCaseIndicator;

    private Short thirdLevelNursDays;

    private String xExamNo;

    private String medicalPayWay;

    private Short trainingInjuryIndicator;

    private String insuranceDiagnosisName;

    private String insuranceAdmissionType;

    private BigDecimal bodyWeight;

    private BigDecimal bodyHeight;

    private String infectIndicator;

    private String mrInfectReport;

    private String healthLevel;

    private String jzdyh;

    private String securityTypeCode;

    private String mdtrtId;

    private Short childFundTrtFlag;

    private Short bedNo;

    public String getDeptAdmissionTo() {
        return deptAdmissionTo;
    }

    public void setDeptAdmissionTo(String deptAdmissionTo) {
        this.deptAdmissionTo = deptAdmissionTo == null ? null : deptAdmissionTo.trim();
    }

    public Date getAdmissionDateTime() {
        return admissionDateTime;
    }

    public void setAdmissionDateTime(Date admissionDateTime) {
        this.admissionDateTime = admissionDateTime;
    }

    public String getDeptDischargeFrom() {
        return deptDischargeFrom;
    }

    public void setDeptDischargeFrom(String deptDischargeFrom) {
        this.deptDischargeFrom = deptDischargeFrom == null ? null : deptDischargeFrom.trim();
    }

    public Date getDischargeDateTime() {
        return dischargeDateTime;
    }

    public void setDischargeDateTime(Date dischargeDateTime) {
        this.dischargeDateTime = dischargeDateTime;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation == null ? null : occupation.trim();
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus == null ? null : maritalStatus.trim();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getArmedServices() {
        return armedServices;
    }

    public void setArmedServices(String armedServices) {
        this.armedServices = armedServices == null ? null : armedServices.trim();
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public String getUnitInContract() {
        return unitInContract;
    }

    public void setUnitInContract(String unitInContract) {
        this.unitInContract = unitInContract == null ? null : unitInContract.trim();
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    public Short getWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(Short workingStatus) {
        this.workingStatus = workingStatus;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType == null ? null : insuranceType.trim();
    }

    public String getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo == null ? null : insuranceNo.trim();
    }

    public String getServiceAgency() {
        return serviceAgency;
    }

    public void setServiceAgency(String serviceAgency) {
        this.serviceAgency = serviceAgency == null ? null : serviceAgency.trim();
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress == null ? null : mailingAddress.trim();
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    public String getNextOfKin() {
        return nextOfKin;
    }

    public void setNextOfKin(String nextOfKin) {
        this.nextOfKin = nextOfKin == null ? null : nextOfKin.trim();
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship == null ? null : relationship.trim();
    }

    public String getNextOfKinAddr() {
        return nextOfKinAddr;
    }

    public void setNextOfKinAddr(String nextOfKinAddr) {
        this.nextOfKinAddr = nextOfKinAddr == null ? null : nextOfKinAddr.trim();
    }

    public String getNextOfKinZipcode() {
        return nextOfKinZipcode;
    }

    public void setNextOfKinZipcode(String nextOfKinZipcode) {
        this.nextOfKinZipcode = nextOfKinZipcode == null ? null : nextOfKinZipcode.trim();
    }

    public String getNextOfKinPhone() {
        return nextOfKinPhone;
    }

    public void setNextOfKinPhone(String nextOfKinPhone) {
        this.nextOfKinPhone = nextOfKinPhone == null ? null : nextOfKinPhone.trim();
    }

    public String getPatientClass() {
        return patientClass;
    }

    public void setPatientClass(String patientClass) {
        this.patientClass = patientClass == null ? null : patientClass.trim();
    }

    public String getAdmissionCause() {
        return admissionCause;
    }

    public void setAdmissionCause(String admissionCause) {
        this.admissionCause = admissionCause == null ? null : admissionCause.trim();
    }

    public Date getConsultingDate() {
        return consultingDate;
    }

    public void setConsultingDate(Date consultingDate) {
        this.consultingDate = consultingDate;
    }

    public String getPatAdmCondition() {
        return patAdmCondition;
    }

    public void setPatAdmCondition(String patAdmCondition) {
        this.patAdmCondition = patAdmCondition == null ? null : patAdmCondition.trim();
    }

    public String getConsultingDoctor() {
        return consultingDoctor;
    }

    public void setConsultingDoctor(String consultingDoctor) {
        this.consultingDoctor = consultingDoctor == null ? null : consultingDoctor.trim();
    }

    public String getAdmittedBy() {
        return admittedBy;
    }

    public void setAdmittedBy(String admittedBy) {
        this.admittedBy = admittedBy == null ? null : admittedBy.trim();
    }

    public Short getEmerTreatTimes() {
        return emerTreatTimes;
    }

    public void setEmerTreatTimes(Short emerTreatTimes) {
        this.emerTreatTimes = emerTreatTimes;
    }

    public Short getEscEmerTimes() {
        return escEmerTimes;
    }

    public void setEscEmerTimes(Short escEmerTimes) {
        this.escEmerTimes = escEmerTimes;
    }

    public Short getSeriousCondDays() {
        return seriousCondDays;
    }

    public void setSeriousCondDays(Short seriousCondDays) {
        this.seriousCondDays = seriousCondDays;
    }

    public Short getCriticalCondDays() {
        return criticalCondDays;
    }

    public void setCriticalCondDays(Short criticalCondDays) {
        this.criticalCondDays = criticalCondDays;
    }

    public Short getIcuDays() {
        return icuDays;
    }

    public void setIcuDays(Short icuDays) {
        this.icuDays = icuDays;
    }

    public Short getCcuDays() {
        return ccuDays;
    }

    public void setCcuDays(Short ccuDays) {
        this.ccuDays = ccuDays;
    }

    public Short getSpecLevelNursDays() {
        return specLevelNursDays;
    }

    public void setSpecLevelNursDays(Short specLevelNursDays) {
        this.specLevelNursDays = specLevelNursDays;
    }

    public Short getFirstLevelNursDays() {
        return firstLevelNursDays;
    }

    public void setFirstLevelNursDays(Short firstLevelNursDays) {
        this.firstLevelNursDays = firstLevelNursDays;
    }

    public Short getSecondLevelNursDays() {
        return secondLevelNursDays;
    }

    public void setSecondLevelNursDays(Short secondLevelNursDays) {
        this.secondLevelNursDays = secondLevelNursDays;
    }

    public Short getAutopsyIndicator() {
        return autopsyIndicator;
    }

    public void setAutopsyIndicator(Short autopsyIndicator) {
        this.autopsyIndicator = autopsyIndicator;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType == null ? null : bloodType.trim();
    }

    public String getBloodTypeRh() {
        return bloodTypeRh;
    }

    public void setBloodTypeRh(String bloodTypeRh) {
        this.bloodTypeRh = bloodTypeRh == null ? null : bloodTypeRh.trim();
    }

    public Short getInfusionReactTimes() {
        return infusionReactTimes;
    }

    public void setInfusionReactTimes(Short infusionReactTimes) {
        this.infusionReactTimes = infusionReactTimes;
    }

    public Short getBloodTranTimes() {
        return bloodTranTimes;
    }

    public void setBloodTranTimes(Short bloodTranTimes) {
        this.bloodTranTimes = bloodTranTimes;
    }

    public Integer getBloodTranVol() {
        return bloodTranVol;
    }

    public void setBloodTranVol(Integer bloodTranVol) {
        this.bloodTranVol = bloodTranVol;
    }

    public Short getBloodTranReactTimes() {
        return bloodTranReactTimes;
    }

    public void setBloodTranReactTimes(Short bloodTranReactTimes) {
        this.bloodTranReactTimes = bloodTranReactTimes;
    }

    public Short getDecubitalUlcerTimes() {
        return decubitalUlcerTimes;
    }

    public void setDecubitalUlcerTimes(Short decubitalUlcerTimes) {
        this.decubitalUlcerTimes = decubitalUlcerTimes;
    }

    public String getAlergyDrugs() {
        return alergyDrugs;
    }

    public void setAlergyDrugs(String alergyDrugs) {
        this.alergyDrugs = alergyDrugs == null ? null : alergyDrugs.trim();
    }

    public String getAdverseReactionDrugs() {
        return adverseReactionDrugs;
    }

    public void setAdverseReactionDrugs(String adverseReactionDrugs) {
        this.adverseReactionDrugs = adverseReactionDrugs == null ? null : adverseReactionDrugs.trim();
    }

    public String getMrValue() {
        return mrValue;
    }

    public void setMrValue(String mrValue) {
        this.mrValue = mrValue == null ? null : mrValue.trim();
    }

    public String getMrQuality() {
        return mrQuality;
    }

    public void setMrQuality(String mrQuality) {
        this.mrQuality = mrQuality == null ? null : mrQuality.trim();
    }

    public Short getFollowIndicator() {
        return followIndicator;
    }

    public void setFollowIndicator(Short followIndicator) {
        this.followIndicator = followIndicator;
    }

    public Short getFollowInterval() {
        return followInterval;
    }

    public void setFollowInterval(Short followInterval) {
        this.followInterval = followInterval;
    }

    public String getFollowIntervalUnits() {
        return followIntervalUnits;
    }

    public void setFollowIntervalUnits(String followIntervalUnits) {
        this.followIntervalUnits = followIntervalUnits == null ? null : followIntervalUnits.trim();
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    public String getAttendingDoctor() {
        return attendingDoctor;
    }

    public void setAttendingDoctor(String attendingDoctor) {
        this.attendingDoctor = attendingDoctor == null ? null : attendingDoctor.trim();
    }

    public String getDoctorInCharge() {
        return doctorInCharge;
    }

    public void setDoctorInCharge(String doctorInCharge) {
        this.doctorInCharge = doctorInCharge == null ? null : doctorInCharge.trim();
    }

    public String getDischargeDisposition() {
        return dischargeDisposition;
    }

    public void setDischargeDisposition(String dischargeDisposition) {
        this.dischargeDisposition = dischargeDisposition == null ? null : dischargeDisposition.trim();
    }

    public BigDecimal getTotalCosts() {
        return totalCosts;
    }

    public void setTotalCosts(BigDecimal totalCosts) {
        this.totalCosts = totalCosts;
    }

    public BigDecimal getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(BigDecimal totalPayments) {
        this.totalPayments = totalPayments;
    }

    public Date getCatalogDate() {
        return catalogDate;
    }

    public void setCatalogDate(Date catalogDate) {
        this.catalogDate = catalogDate;
    }

    public String getCataloger() {
        return cataloger;
    }

    public void setCataloger(String cataloger) {
        this.cataloger = cataloger == null ? null : cataloger.trim();
    }

    public String getTopUnit() {
        return topUnit;
    }

    public void setTopUnit(String topUnit) {
        this.topUnit = topUnit == null ? null : topUnit.trim();
    }

    public Short getServiceSystemIndicator() {
        return serviceSystemIndicator;
    }

    public void setServiceSystemIndicator(Short serviceSystemIndicator) {
        this.serviceSystemIndicator = serviceSystemIndicator;
    }

    public String getDirectorDbuser() {
        return directorDbuser;
    }

    public void setDirectorDbuser(String directorDbuser) {
        this.directorDbuser = directorDbuser == null ? null : directorDbuser.trim();
    }

    public String getAttendingDoctorDbuser() {
        return attendingDoctorDbuser;
    }

    public void setAttendingDoctorDbuser(String attendingDoctorDbuser) {
        this.attendingDoctorDbuser = attendingDoctorDbuser == null ? null : attendingDoctorDbuser.trim();
    }

    public String getDoctorInChargeDbuser() {
        return doctorInChargeDbuser;
    }

    public void setDoctorInChargeDbuser(String doctorInChargeDbuser) {
        this.doctorInChargeDbuser = doctorInChargeDbuser == null ? null : doctorInChargeDbuser.trim();
    }

    public String getInsuranceDiagnosisCode() {
        return insuranceDiagnosisCode;
    }

    public void setInsuranceDiagnosisCode(String insuranceDiagnosisCode) {
        this.insuranceDiagnosisCode = insuranceDiagnosisCode == null ? null : insuranceDiagnosisCode.trim();
    }

    public String getInternalNo() {
        return internalNo;
    }

    public void setInternalNo(String internalNo) {
        this.internalNo = internalNo == null ? null : internalNo.trim();
    }

    public String getIdentityClass() {
        return identityClass;
    }

    public void setIdentityClass(String identityClass) {
        this.identityClass = identityClass == null ? null : identityClass.trim();
    }

    public Short getHbsagIndicator() {
        return hbsagIndicator;
    }

    public void setHbsagIndicator(Short hbsagIndicator) {
        this.hbsagIndicator = hbsagIndicator;
    }

    public Short getHcvAbIndicator() {
        return hcvAbIndicator;
    }

    public void setHcvAbIndicator(Short hcvAbIndicator) {
        this.hcvAbIndicator = hcvAbIndicator;
    }

    public Short getHivAbIndicator() {
        return hivAbIndicator;
    }

    public void setHivAbIndicator(Short hivAbIndicator) {
        this.hivAbIndicator = hivAbIndicator;
    }

    public String getChiefDoctor() {
        return chiefDoctor;
    }

    public void setChiefDoctor(String chiefDoctor) {
        this.chiefDoctor = chiefDoctor == null ? null : chiefDoctor.trim();
    }

    public String getAdvancedStudiesDoctor() {
        return advancedStudiesDoctor;
    }

    public void setAdvancedStudiesDoctor(String advancedStudiesDoctor) {
        this.advancedStudiesDoctor = advancedStudiesDoctor == null ? null : advancedStudiesDoctor.trim();
    }

    public String getPracticeDoctorOfGraduate() {
        return practiceDoctorOfGraduate;
    }

    public void setPracticeDoctorOfGraduate(String practiceDoctorOfGraduate) {
        this.practiceDoctorOfGraduate = practiceDoctorOfGraduate == null ? null : practiceDoctorOfGraduate.trim();
    }

    public String getPracticeDoctor() {
        return practiceDoctor;
    }

    public void setPracticeDoctor(String practiceDoctor) {
        this.practiceDoctor = practiceDoctor == null ? null : practiceDoctor.trim();
    }

    public String getDoctorOfControlQuality() {
        return doctorOfControlQuality;
    }

    public void setDoctorOfControlQuality(String doctorOfControlQuality) {
        this.doctorOfControlQuality = doctorOfControlQuality == null ? null : doctorOfControlQuality.trim();
    }

    public String getNurseOfControlQuality() {
        return nurseOfControlQuality;
    }

    public void setNurseOfControlQuality(String nurseOfControlQuality) {
        this.nurseOfControlQuality = nurseOfControlQuality == null ? null : nurseOfControlQuality.trim();
    }

    public Date getDateOfControlQuality() {
        return dateOfControlQuality;
    }

    public void setDateOfControlQuality(Date dateOfControlQuality) {
        this.dateOfControlQuality = dateOfControlQuality;
    }

    public Short getFirstCaseIndicator() {
        return firstCaseIndicator;
    }

    public void setFirstCaseIndicator(Short firstCaseIndicator) {
        this.firstCaseIndicator = firstCaseIndicator;
    }

    public Short getThirdLevelNursDays() {
        return thirdLevelNursDays;
    }

    public void setThirdLevelNursDays(Short thirdLevelNursDays) {
        this.thirdLevelNursDays = thirdLevelNursDays;
    }

    public String getxExamNo() {
        return xExamNo;
    }

    public void setxExamNo(String xExamNo) {
        this.xExamNo = xExamNo == null ? null : xExamNo.trim();
    }

    public String getMedicalPayWay() {
        return medicalPayWay;
    }

    public void setMedicalPayWay(String medicalPayWay) {
        this.medicalPayWay = medicalPayWay == null ? null : medicalPayWay.trim();
    }

    public Short getTrainingInjuryIndicator() {
        return trainingInjuryIndicator;
    }

    public void setTrainingInjuryIndicator(Short trainingInjuryIndicator) {
        this.trainingInjuryIndicator = trainingInjuryIndicator;
    }

    public String getInsuranceDiagnosisName() {
        return insuranceDiagnosisName;
    }

    public void setInsuranceDiagnosisName(String insuranceDiagnosisName) {
        this.insuranceDiagnosisName = insuranceDiagnosisName == null ? null : insuranceDiagnosisName.trim();
    }

    public String getInsuranceAdmissionType() {
        return insuranceAdmissionType;
    }

    public void setInsuranceAdmissionType(String insuranceAdmissionType) {
        this.insuranceAdmissionType = insuranceAdmissionType == null ? null : insuranceAdmissionType.trim();
    }

    public BigDecimal getBodyWeight() {
        return bodyWeight;
    }

    public void setBodyWeight(BigDecimal bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public BigDecimal getBodyHeight() {
        return bodyHeight;
    }

    public void setBodyHeight(BigDecimal bodyHeight) {
        this.bodyHeight = bodyHeight;
    }

    public String getInfectIndicator() {
        return infectIndicator;
    }

    public void setInfectIndicator(String infectIndicator) {
        this.infectIndicator = infectIndicator == null ? null : infectIndicator.trim();
    }

    public String getMrInfectReport() {
        return mrInfectReport;
    }

    public void setMrInfectReport(String mrInfectReport) {
        this.mrInfectReport = mrInfectReport == null ? null : mrInfectReport.trim();
    }

    public String getHealthLevel() {
        return healthLevel;
    }

    public void setHealthLevel(String healthLevel) {
        this.healthLevel = healthLevel == null ? null : healthLevel.trim();
    }

    public String getJzdyh() {
        return jzdyh;
    }

    public void setJzdyh(String jzdyh) {
        this.jzdyh = jzdyh == null ? null : jzdyh.trim();
    }

    public String getSecurityTypeCode() {
        return securityTypeCode;
    }

    public void setSecurityTypeCode(String securityTypeCode) {
        this.securityTypeCode = securityTypeCode == null ? null : securityTypeCode.trim();
    }

    public String getMdtrtId() {
        return mdtrtId;
    }

    public void setMdtrtId(String mdtrtId) {
        this.mdtrtId = mdtrtId == null ? null : mdtrtId.trim();
    }

    public Short getChildFundTrtFlag() {
        return childFundTrtFlag;
    }

    public void setChildFundTrtFlag(Short childFundTrtFlag) {
        this.childFundTrtFlag = childFundTrtFlag;
    }

    public Short getBedNo() {
        return bedNo;
    }

    public void setBedNo(Short bedNo) {
        this.bedNo = bedNo;
    }
}