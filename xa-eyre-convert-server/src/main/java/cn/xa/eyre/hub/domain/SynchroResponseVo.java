package cn.xa.eyre.hub.domain;

public class SynchroResponseVo {

    /** 请求结果 **/
    private boolean result;

    /** 消息描述 **/
    private String desc;

    /** 操作表ID **/
    private String id;

    /** 请求失败返回码 **/
    private String errorCode;

    /** 请求失败返回消息 **/
    private String errorName;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }
}
