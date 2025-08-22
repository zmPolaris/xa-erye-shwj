package cn.xa.eyre.common.exception;

/**
 * 业务异常
 * 
 * @author zm
 */
public final class ServiceException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误提示
     */
    private String msg;

    /**
     * 错误明细，内部调试错误
     *
     * 和 {@link CommonResult#getDetailMessage()} 一致的设计
     */
    private String detailMessage;

    /**
     * 空构造方法，避免反序列化问题
     */
    public ServiceException()
    {
    }

    public ServiceException(String msg)
    {
        this.msg = msg;
    }

    public ServiceException(String msg, Integer code)
    {
        this.msg = msg;
        this.code = code;
    }

    public ServiceException(Integer code,String msg)
    {
        this.msg = msg;
        this.code = code;
    }

    public String getDetailMessage()
    {
        return detailMessage;
    }

    @Override
    public String getMessage()
    {
        return msg;
    }

    public Integer getCode()
    {
        return code;
    }

    public ServiceException setMsg(String msg)
    {
        this.msg = msg;
        return this;
    }

    public ServiceException setDetailMessage(String detailMessage)
    {
        this.detailMessage = detailMessage;
        return this;
    }
}
