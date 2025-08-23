package cn.xa.eyre.outpdoct.domain;

import java.util.Date;

public class OutpMrKey {
    private Date visitDate;

    private Short visitNo;

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
}