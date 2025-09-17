package cn.xa.eyre.framework.config.openfegin;

import cn.xa.eyre.common.core.domain.R;
import com.alibaba.fastjson.JSON;
import feign.Response;
import feign.codec.Decoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class FeignResponseDecoder implements Decoder {
    Logger logger = LoggerFactory.getLogger(getClass());
    private final Decoder delegate;

    public FeignResponseDecoder(Decoder delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object decode(Response response, Type type) {
        Object result = null;
        try {
            result = delegate.decode(response, type);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        logger.info("转换前：{}", JSON.toJSONString(result));
        Object o = convertNestedObjects(result);
//        processObject(result);
        logger.info("转换后：{}", JSON.toJSONString(o));
        return o; // 递归处理嵌套对象
    }

    public static <T> void processObject(Object obj){
        if (obj == null) return;

        if (obj instanceof R) {
            try {
                Field dataField = obj.getClass().getDeclaredField("data");
                dataField.setAccessible(true);
                Object data = dataField.get(obj);
                processNestedObject(data);
            }catch (Exception e){
                e.printStackTrace();
                return;
            }
        } else {
            throw new IllegalArgumentException("Input is not R<T> type");
        }
    }

    private static void processNestedObject(Object obj) throws Exception {
        if (obj == null) return;

        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(obj);

            if (value instanceof String) {
                field.set(obj, convertToChinese((String) value));
            } else if (!isPrimitiveOrWrapper(value)) {
                processNestedObject(value); // 递归处理嵌套对象
            }
        }
    }

    private static boolean isPrimitiveOrWrapper(Object obj) {
        return obj == null ||
                obj.getClass().isPrimitive() ||
                obj instanceof Number ||
                obj instanceof Boolean ||
                obj instanceof Character;
    }

    private Object convertNestedObjects(Object obj) {
        logger.info("进行数据转换...");
        if (obj instanceof String) {
            logger.info("String类型转换...");
            logger.info("字符串转换前：{}", (String) obj);
            String str = convertToChinese((String) obj);
            logger.info("字符串转换后：{}", str);
            return str; // 调用您的转换方法
        }  else if(obj instanceof R){
            try {
                return convertNestedObjects(BeanUtils.deepConvertToMap(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return obj;
            }
        } else if (obj instanceof Map) {
            logger.info("Map类型转换...");
            Map<?, ?> originalMap = (Map<?, ?>) obj;
            // 创建一个新的 LinkedHashMap 来保持插入顺序（如果需要）
            Map<Object, Object> newMap = new LinkedHashMap<>();
            for (Map.Entry<?, ?> entry : originalMap.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                // 递归转换 key 和 value
                Object newKey = convertNestedObjects(key);
                Object newValue = convertNestedObjects(value);
                newMap.put(newKey, newValue);
            }
            return newMap; // 返回新的 map
        } else if (obj instanceof Collection) {
            logger.info("Collection类型转换...");
            ((Collection<?>) obj).forEach(this::convertNestedObjects);
        } else {
            logger.info("对象类型：{}", obj.getClass().getName());
        }
        return obj;
    }

    public static String convertToChinese(String garbledText) {
        try {
            if (!containsGarbledChars(garbledText)){
                return garbledText;
            }
            byte[] isoBytes = garbledText.getBytes("ISO-8859-1");
            return new String(isoBytes, "GBK");
        } catch (UnsupportedEncodingException e) {
            return garbledText;
        }
    }

    // 检测是否仍包含乱码字符
    private static boolean containsGarbledChars(String str) {
        return str.chars().anyMatch(c -> c > 127 && !isChineseChar(c));
    }

    // 基本汉字Unicode范围判断
    private static boolean isChineseChar(int codePoint) {
        return (codePoint >= 0x4E00 && codePoint <= 0x9FFF) ||
                (codePoint >= 0x3400 && codePoint <= 0x4DBF);
    }
}
