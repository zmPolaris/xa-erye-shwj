package cn.xa.eyre.common.constant;

/**
 * 缓存的key 常量
 * 
 * @author zm
 */
public class CacheConstants
{
    /**
     * 登录用户 redis key
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 参数管理 cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 科室管理 cache key
     */
    public static final String SYS_DICT_DEPT_KEY = "sys_dict_dept:";

    /**
     * 医生 cache key
     */
    public static final String SYS_COMM_USER_KEY = "sys_comm_user:";

    /**
     * 参数管理 cache key
     */
    public static final String SYS_CA_CHANNEL_CONFIG_KEY = "sys_ca_chanel:";

    /**
     * 字典管理 cache key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * 防重提交 redis key
     */
    public static final String REPEAT_SUBMIT_KEY = "repeat_submit:";

    /**
     * 限流 redis key
     */
    public static final String RATE_LIMIT_KEY = "rate_limit:";

    /**
     * 登录账户密码错误次数 redis key
     */
    public static final String PWD_ERR_CNT_KEY = "pwd_err_cnt:";

    /**
     * 字典管理 cache key
     */
    public static final String ORDADM_ICU_CPAP_PATIENT_KEY = "ordadm:icu_cpap:";

    /**
     * 字典管理 cache key
     */
    public static final String ORDADM_PATIENT_DEATH_INFO_KEY = "ordadm:death_info:";
}
