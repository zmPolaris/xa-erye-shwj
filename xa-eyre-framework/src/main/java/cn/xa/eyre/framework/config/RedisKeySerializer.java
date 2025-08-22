package cn.xa.eyre.framework.config;

import cn.xa.eyre.common.utils.StringUtils;
import cn.xa.eyre.common.config.EyreConfig;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.nio.charset.Charset;

/**
 * @author liuxin
 * @date 2022/9/6
 */
@Component
public class RedisKeySerializer implements RedisSerializer<String> {

    @Resource
    private EyreConfig config;

    private final Charset charset;

    public RedisKeySerializer()
    {
        this(Charset.forName("UTF8"));
    }

    public RedisKeySerializer(Charset charset)
    {

        assert charset == null;
        this.charset = charset;
    }

    @Override
    public byte[] serialize(String string) throws SerializationException
    {
        // 通过项目名称ruoyi.name来定义Redis前缀，用于区分项目缓存
        if (StringUtils.isNotEmpty(config.getName()) && !string.contains(config.getName()))
        {
            return new StringBuilder(config.getName()).append(":").append(string).toString().getBytes(charset);
        }
        return string.getBytes(charset);
    }

    @Override
    public String deserialize(byte[] bytes) throws SerializationException
    {
        return (bytes == null ? null : new String(bytes, charset));
    }
}
