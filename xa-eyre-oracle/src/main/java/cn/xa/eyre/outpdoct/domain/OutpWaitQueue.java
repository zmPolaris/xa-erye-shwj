package cn.xa.eyre.outpdoct.domain;

import java.util.Date;

public class OutpWaitQueue extends OutpWaitQueueKey {
    private Date visitDate;

    private Integer visitNo;

    private Short workedIndicator;

    private String doctor;

    private String visitDateStr;

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Integer getVisitNo() {
        return visitNo;
    }

    public void setVisitNo(Integer visitNo) {
        this.visitNo = visitNo;
    }

    public Short getWorkedIndicator() {
        return workedIndicator;
    }

    public void setWorkedIndicator(Short workedIndicator) {
        this.workedIndicator = workedIndicator;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor == null ? null : doctor.trim();
    }

    public String getVisitDateStr() {
        return visitDateStr;
    }

    public void setVisitDateStr(String visitDateStr) {
        this.visitDateStr = visitDateStr;
    }
}