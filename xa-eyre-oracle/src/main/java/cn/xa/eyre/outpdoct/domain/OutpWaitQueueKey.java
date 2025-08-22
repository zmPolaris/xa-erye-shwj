package cn.xa.eyre.outpdoct.domain;

import java.util.Date;

public class OutpWaitQueueKey {
    private String counselNo;

    private String queueName;

    private Date registerDate;

    private String registerDept;

    private Short queueSequence;

    public String getCounselNo() {
        return counselNo;
    }

    public void setCounselNo(String counselNo) {
        this.counselNo = counselNo == null ? null : counselNo.trim();
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName == null ? null : queueName.trim();
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getRegisterDept() {
        return registerDept;
    }

    public void setRegisterDept(String registerDept) {
        this.registerDept = registerDept == null ? null : registerDept.trim();
    }

    public Short getQueueSequence() {
        return queueSequence;
    }

    public void setQueueSequence(Short queueSequence) {
        this.queueSequence = queueSequence;
    }
}