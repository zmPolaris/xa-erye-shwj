package cn.xa.eyre.common.exception;

import java.util.HashMap;
import java.util.Map;


public enum ExceptionStaticAPIEnum {
    
	ERROR_API_EXCEPTION(500, "接口应用内部错误"),
    ERROR_CERT_EXPIRED(-126,"证书已过期"),
    ERROR_HEADER_NULL(10,"权限不足：请求头信息{}不能为空"),
    ERROR_APP_NULL(11,"权限不足：当前应用未接入"),
    ERROR_SIGN_VERIFY(12,"权限不足：签名值校验失败"),
    ERROR_CSSP_SERVICE(13,"调用密码服务平台接口失败：{}"),
    ERROR_ORG_INFO(14,"企业信息与证书序列号不匹配"),
    ERROR_ORG_NULL(15,"企业信息不能为空"),
    ERROR_OPERATOR_NULL(16,"授权人信息不存在"),
    ERROR_MESSAGE_CAPTCHA(17,"短信验证码错误"),
    ERROR_TOKEN_EXPIRE(18,"token已失效，请重新获取"),
    ;

    private final Integer                            code;

    private final String                            message;

    private static Map<Integer, ExceptionStaticAPIEnum> codeLookup = new HashMap<Integer, ExceptionStaticAPIEnum>();

    static {
        for (ExceptionStaticAPIEnum type : ExceptionStaticAPIEnum.values()) {
            codeLookup.put(type.code, type);
        }
    }

    ExceptionStaticAPIEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public static ExceptionStaticAPIEnum getByCode(Integer code) {
        return codeLookup.get(code);
    }
    
    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return this.code + "-" + this.message;
    }
    public String getMessageByCode(String code){
        return  codeLookup.get(code).getMessage();
    }

    public boolean equals(String code){
        return  this.code.equals(code);
    }
    
    
    public static void main(String[] args) {
    	int a =0x00000010;
		System.out.println(a);
	}
}
