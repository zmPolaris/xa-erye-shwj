package cn.xa.eyre.medrec.domain;

public class DiagnosticCategory extends DiagnosticCategoryKey {
    private Short codeNo;

    private String insuranceIcd10Code;

    private String insuranceIcd10CodePlus;

    private String shIcd10Code;

    private String shIcd10CodePlus;

    private String clinicIcd10Code;

    private String clinicIcd10CodePlus;

    private String icd10Code;

    private String icd10CodePlus;

    public Short getCodeNo() {
        return codeNo;
    }

    public void setCodeNo(Short codeNo) {
        this.codeNo = codeNo;
    }

    public String getInsuranceIcd10Code() {
        return insuranceIcd10Code;
    }

    public void setInsuranceIcd10Code(String insuranceIcd10Code) {
        this.insuranceIcd10Code = insuranceIcd10Code == null ? null : insuranceIcd10Code.trim();
    }

    public String getInsuranceIcd10CodePlus() {
        return insuranceIcd10CodePlus;
    }

    public void setInsuranceIcd10CodePlus(String insuranceIcd10CodePlus) {
        this.insuranceIcd10CodePlus = insuranceIcd10CodePlus == null ? null : insuranceIcd10CodePlus.trim();
    }

    public String getShIcd10Code() {
        return shIcd10Code;
    }

    public void setShIcd10Code(String shIcd10Code) {
        this.shIcd10Code = shIcd10Code == null ? null : shIcd10Code.trim();
    }

    public String getShIcd10CodePlus() {
        return shIcd10CodePlus;
    }

    public void setShIcd10CodePlus(String shIcd10CodePlus) {
        this.shIcd10CodePlus = shIcd10CodePlus == null ? null : shIcd10CodePlus.trim();
    }

    public String getClinicIcd10Code() {
        return clinicIcd10Code;
    }

    public void setClinicIcd10Code(String clinicIcd10Code) {
        this.clinicIcd10Code = clinicIcd10Code == null ? null : clinicIcd10Code.trim();
    }

    public String getClinicIcd10CodePlus() {
        return clinicIcd10CodePlus;
    }

    public void setClinicIcd10CodePlus(String clinicIcd10CodePlus) {
        this.clinicIcd10CodePlus = clinicIcd10CodePlus == null ? null : clinicIcd10CodePlus.trim();
    }

    public String getIcd10Code() {
        return icd10Code;
    }

    public void setIcd10Code(String icd10Code) {
        this.icd10Code = icd10Code == null ? null : icd10Code.trim();
    }

    public String getIcd10CodePlus() {
        return icd10CodePlus;
    }

    public void setIcd10CodePlus(String icd10CodePlus) {
        this.icd10CodePlus = icd10CodePlus == null ? null : icd10CodePlus.trim();
    }
}