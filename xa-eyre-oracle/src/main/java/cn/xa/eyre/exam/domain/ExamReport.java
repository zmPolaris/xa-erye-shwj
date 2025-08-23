package cn.xa.eyre.exam.domain;

public class ExamReport {
    private String examNo;

    private String examPara;

    private String description;

    private String impression;

    private String recommendation;

    private String isAbnormal;

    private String useImage;

    private String memo;

    public String getExamNo() {
        return examNo;
    }

    public void setExamNo(String examNo) {
        this.examNo = examNo == null ? null : examNo.trim();
    }

    public String getExamPara() {
        return examPara;
    }

    public void setExamPara(String examPara) {
        this.examPara = examPara == null ? null : examPara.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getImpression() {
        return impression;
    }

    public void setImpression(String impression) {
        this.impression = impression == null ? null : impression.trim();
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation == null ? null : recommendation.trim();
    }

    public String getIsAbnormal() {
        return isAbnormal;
    }

    public void setIsAbnormal(String isAbnormal) {
        this.isAbnormal = isAbnormal == null ? null : isAbnormal.trim();
    }

    public String getUseImage() {
        return useImage;
    }

    public void setUseImage(String useImage) {
        this.useImage = useImage == null ? null : useImage.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}