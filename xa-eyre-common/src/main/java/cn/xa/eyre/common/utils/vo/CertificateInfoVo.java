package cn.xa.eyre.common.utils.vo;

/**
 * @author qiaoyu
 * @version 1.0.0
 * @project zm
 * @datetime 2024/8/20 10:15
 * @description []
 */
public class CertificateInfoVo {

    private String cn; // 证书主体的cn项
    private String o; // 证书主体的组织项
    private String ou; // 证书主体的名称项
    private String c; // 证书主体的国家项
    private String startTime; // 证书开始时间 yyyyMMddHHmmss
    private String endTime; // 证书结束时间 yyyyMMddHHmmss
    private String certId; // 证书ID
    private String trustStr; // 客服信任号
    private String signCert; // 签名证书
    private String publicKeyAlgorithm; // 签名证书公钥算法（00：SM2，01：RSA）
    private String start; // 证书开始时间 yyyy-MM-dd HH:mm:ss
    private String end; // 证书结束时间 yyyy-MM-dd HH:mm:ss

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getO() {
        return o;
    }

    public void setO(String o) {
        this.o = o;
    }

    public String getOu() {
        return ou;
    }

    public void setOu(String ou) {
        this.ou = ou;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCertId() {
        return certId;
    }

    public void setCertId(String certId) {
        this.certId = certId;
    }

    public String getTrustStr() {
        return trustStr;
    }

    public void setTrustStr(String trustStr) {
        this.trustStr = trustStr;
    }

    public String getSignCert() {
        return signCert;
    }

    public void setSignCert(String signCert) {
        this.signCert = signCert;
    }

    public String getPublicKeyAlgorithm() {
        return publicKeyAlgorithm;
    }

    public void setPublicKeyAlgorithm(String publicKeyAlgorithm) {
        this.publicKeyAlgorithm = publicKeyAlgorithm;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
