package cn.xa.eyre.common.constant;

/**
 * 通用常量信息
 * 
 * @author zm
 */
public class Constants
{
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * www主域
     */
    public static final String WWW = "www.";

    /**
     * http请求
     */
    public static final String HTTP = "http://";

    /**
     * https请求
     */
    public static final String HTTPS = "https://";

    /**
     * 成功标记
     */
    public static final Integer SUCCESS = 0;

    /**
     * 失败标记
     */
    public static final Integer FAIL = 500;

    /**
     * 定时任务白名单配置（仅允许访问的包名，如其他需要可以自行添加）
     */
    public static final String[] JOB_WHITELIST_STR = { "cn.xa.eyre" };

    /**
     * 定时任务违规的字符
     */
    public static final String[] JOB_ERROR_STR = { "java.net.URL", "javax.naming.InitialContext", "org.yaml.snakeyaml",
            "org.springframework", "org.apache", "cn.xa.eyre.common.utils.file" };

    public static final String HIS_URL = "http://127.0.0.1:8091";

    public static final String CONVERT_URL = "http://127.0.0.1:8090";


    public static final String CONFIG_XA_ERYE_HUB_SERVICE_URL = "xa.erye.hub.service.url";
    public static final String CONFIG_XA_ERYE_SAVE_API_LOG = "xa.erye.hub.save.api.log";

    /**
     * HTTP请求类型
     */
    public static final String HTTP_METHOD_POST = "POST";
    public static final String HTTP_METHOD_DELETE = "DELETE";

    /**
     * 调用结果 0:失败,1:成功
     */
    public static final Integer API_STATUS_SUCCESS = 1;
    public static final Integer API_STATUS_FAIL = 0;

    /**
     * 是否记录接口调用日志 1：记录，2：不记录
     */
    public static final Integer SAVE_API_LOG_YES = 1;
    public static final Integer SAVE_API_LOG_NO = 2;

    /**
     * 是否缺省值 0:是,1:不是
     */
    public static final Integer IS_NOT_DEFAULT = 1;
    public static final Integer IS_DEFAULT = 0;

    /**
     * 通用状态 0:正常,1:停用
     */
    public static final Integer STATUS_STOP = 1;
    public static final Integer STATUS_NORMAL = 0;

    /**
     * 诊断类别 1:门诊诊断，2:入院初诊，3：主要诊断
     */
    public static final String DIAGNOSIS_TYPE_CODE_MZZD = "1";
    public static final String DIAGNOSIS_TYPE_CODE_RYCZ = "2";
    public static final String DIAGNOSIS_TYPE_CODE_ZYZD = "3";
    public static final String DIAGNOSIS_TYPE_CODE_QT = "A";

    public static final String CHARGE_TYPE_JDYG = "军队医改";

}
