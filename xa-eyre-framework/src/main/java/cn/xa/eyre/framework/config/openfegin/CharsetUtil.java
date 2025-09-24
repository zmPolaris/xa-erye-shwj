package cn.xa.eyre.framework.config.openfegin;

import cn.hutool.core.util.ObjectUtil;
import cn.xa.eyre.common.core.domain.R;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CharsetUtil {

    public static List<Object> convertObjectList(Object object){
        if (ObjectUtil.isEmpty(object)){
            return null;
        }
        List<Object> list = (List<Object>) object;
        list.replaceAll(item -> convertObject(item));
        return list;
    }

    public static Object convertObject(Object obj){
        if (ObjectUtil.isEmpty(obj)){
            return null;
        }
        try {
            Map<String, Object> objectMap = BeanUtils.deepConvertToMap(obj);
            objectMap.forEach((key, value) -> {
                if (value instanceof String) {
                    objectMap.put(key, convertToChinese((String) value));
                } else if (value instanceof Map) {
                    convertObject(value);
                }
            });
            return objectMap;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return obj;
        }
    }
    public static String convertToChinese(String garbledText) {
        try {
            if (!containsGarbledChars(garbledText)){
                return garbledText;
            }
            byte[] isoBytes = garbledText.getBytes("ISO-8859-1");
            // 尝试常见中文编码
            for (String encoding : new String[]{"GBK", "UTF-8", "GB2312"}) {
                try {
                    String converted = new String(isoBytes, encoding);
                    if (!containsGarbledChars(converted)) {
                        return converted;
                    }
                } catch (UnsupportedEncodingException ignored) {}
            }
            return garbledText; // 无法解码时返回原值
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
