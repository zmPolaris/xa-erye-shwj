package cn.xa.eyre.system.dict.domain;

public class DatasetDiseaseData {
    private Integer id;

    private String diseaseName;

    private String diseaseType;

    private String icd10;

    private String simpleDiseaseName;

    private String availableCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName == null ? null : diseaseName.trim();
    }

    public String getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType == null ? null : diseaseType.trim();
    }

    public String getIcd10() {
        return icd10;
    }

    public void setIcd10(String icd10) {
        this.icd10 = icd10 == null ? null : icd10.trim();
    }

    public String getSimpleDiseaseName() {
        return simpleDiseaseName;
    }

    public void setSimpleDiseaseName(String simpleDiseaseName) {
        this.simpleDiseaseName = simpleDiseaseName == null ? null : simpleDiseaseName.trim();
    }

    public String getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(String availableCount) {
        this.availableCount = availableCount == null ? null : availableCount.trim();
    }
}