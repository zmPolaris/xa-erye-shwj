package cn.xa.eyre.outpadm.domain;

import java.util.Date;

public class ClinicMasterKey {
    private Date visitDate;

    private Integer visitNo;

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
}