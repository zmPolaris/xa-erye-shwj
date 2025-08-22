package cn.xa.eyre.common.enums;

public enum ExceptionEnum {
    CERT_PARAMS_ERROR(1000001,"参数错误，原因：%s"),

    CERT_TYPE_ERROR(1000101,"证书类型错误"),
    CERT_ERROR(1000102,"证书申请失败"),
    CERT_NOT_EXISTS_ERROR(1000103,"证书信息不存在"),
    CERT_NOT_ALGORITHM_ERROR(1000104,"算法不支持"),
    CERT_SIGN_ERROR(1000105,"签名失败"),
    CERT_SIGN_TYPE_ERROR(1000106,"不支持p1签名"),
    CERT_PUBLICKKEY_TYPE_ERROR(1000107,"请填写正确的公钥算法类型"),
    CERT_PUBLICKKEY_LEN_ERROR(1000108,"请填写正确的对应算法长度"),

    NOT_ORDER_ERROR(1000201,"没有找到对应的订单信息"),
    NOT_ORDER_NOAVAIL_ERROR(1000202,"订单已完成"),
    NOT_ORDER_BUS_TYOPE_ERROR(1000202,"订单业务类型不匹配"),
    CERT_ORDER_NOT_PAY_ERROR(1000203,"订单未支付"),
    CERT_ORDER_CENCEL_ERROR(1000204,"订单已取消"),
    ORDER_CERTTYPE_ERROR(1000205,"订单证书类型不匹配"),
    ORDER_NOAVAIL_COMPANY_ERROR(1000206,"企业证书已签发"),
    ORDER_NOAVAIL_CEO_ERROR(1000207,"法人证书已签发"),

    DATE_ENCRYPT_ERROR(1000301,"数据加密失败"),


    SOCIAL_CREDIT_CODE_ERROR(1000401,"企业社会统一信用代码不匹配"),
    IDENTITY_NUMBER_ERROR(1000402,"个人身份证号不匹配"),
    ;


    private final int code;
    private final String msg;

    ExceptionEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg == null ? "" : msg;
    }
}
