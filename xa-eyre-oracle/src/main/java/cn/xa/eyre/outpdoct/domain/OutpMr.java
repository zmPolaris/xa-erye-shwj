package cn.xa.eyre.outpdoct.domain;

import java.util.Date;

public class OutpMr extends OutpMrKey {
    private String patientId;

    private String illnessDesc;

    private String anamnesis;

    private String familyIll;

    private String marrital;

    private String individual;

    private String menses;

    private String medHistory;

    private String bodyExam;

    private String diagDesc;

    private String advice;

    private String doctor;

    private String operationRecord;

    private String medicalRecord;

    private String assistExam;

    private String specialty;

    private String diagnosisMz1;

    private String diagnosisCodeMz1;

    private String diagnosisMz2;

    private String diagnosisCodeMz2;

    private Date beginVisitDate; // 补充参数

    private Date endVisitDate;

    private String visitDateStr;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getIllnessDesc() {
        return illnessDesc;
    }

    public void setIllnessDesc(String illnessDesc) {
        this.illnessDesc = illnessDesc == null ? null : illnessDesc.trim();
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis == null ? null : anamnesis.trim();
    }

    public String getFamilyIll() {
        return familyIll;
    }

    public void setFamilyIll(String familyIll) {
        this.familyIll = familyIll == null ? null : familyIll.trim();
    }

    public String getMarrital() {
        return marrital;
    }

    public void setMarrital(String marrital) {
        this.marrital = marrital == null ? null : marrital.trim();
    }

    public String getIndividual() {
        return individual;
    }

    public void setIndividual(String individual) {
        this.individual = individual == null ? null : individual.trim();
    }

    public String getMenses() {
        return menses;
    }

    public void setMenses(String menses) {
        this.menses = menses == null ? null : menses.trim();
    }

    public String getMedHistory() {
        return medHistory;
    }

    public void setMedHistory(String medHistory) {
        this.medHistory = medHistory == null ? null : medHistory.trim();
    }

    public String getBodyExam() {
        return bodyExam;
    }

    public void setBodyExam(String bodyExam) {
        this.bodyExam = bodyExam == null ? null : bodyExam.trim();
    }

    public String getDiagDesc() {
        return diagDesc;
    }

    public void setDiagDesc(String diagDesc) {
        this.diagDesc = diagDesc == null ? null : diagDesc.trim();
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice == null ? null : advice.trim();
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor == null ? null : doctor.trim();
    }

    public String getOperationRecord() {
        return operationRecord;
    }

    public void setOperationRecord(String operationRecord) {
        this.operationRecord = operationRecord == null ? null : operationRecord.trim();
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord == null ? null : medicalRecord.trim();
    }

    public String getAssistExam() {
        return assistExam;
    }

    public void setAssistExam(String assistExam) {
        this.assistExam = assistExam == null ? null : assistExam.trim();
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty == null ? null : specialty.trim();
    }

    public String getDiagnosisMz1() {
        return diagnosisMz1;
    }

    public void setDiagnosisMz1(String diagnosisMz1) {
        this.diagnosisMz1 = diagnosisMz1 == null ? null : diagnosisMz1.trim();
    }

    public String getDiagnosisCodeMz1() {
        return diagnosisCodeMz1;
    }

    public void setDiagnosisCodeMz1(String diagnosisCodeMz1) {
        this.diagnosisCodeMz1 = diagnosisCodeMz1 == null ? null : diagnosisCodeMz1.trim();
    }

    public String getDiagnosisMz2() {
        return diagnosisMz2;
    }

    public void setDiagnosisMz2(String diagnosisMz2) {
        this.diagnosisMz2 = diagnosisMz2 == null ? null : diagnosisMz2.trim();
    }

    public String getDiagnosisCodeMz2() {
        return diagnosisCodeMz2;
    }

    public void setDiagnosisCodeMz2(String diagnosisCodeMz2) {
        this.diagnosisCodeMz2 = diagnosisCodeMz2 == null ? null : diagnosisCodeMz2.trim();
    }

    public Date getBeginVisitDate() {
        return beginVisitDate;
    }

    public void setBeginVisitDate(Date beginVisitDate) {
        this.beginVisitDate = beginVisitDate;
    }

    public Date getEndVisitDate() {
        return endVisitDate;
    }

    public void setEndVisitDate(Date endVisitDate) {
        this.endVisitDate = endVisitDate;
    }

    public String getVisitDateStr() {
        return visitDateStr;
    }

    public void setVisitDateStr(String visitDateStr) {
        this.visitDateStr = visitDateStr;
    }
}