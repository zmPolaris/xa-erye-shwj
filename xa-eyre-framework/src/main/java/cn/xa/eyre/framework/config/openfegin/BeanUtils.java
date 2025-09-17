package cn.xa.eyre.framework.config.openfegin;

import java.lang.reflect.Field;
import java.util.*;

public class BeanUtils {
    public static Map<String, Object> deepConvertToMap(Object obj) throws IllegalAccessException {
        if (obj == null) return null;
        Map<String, Object> map = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(obj);
            if (value != null) {
                if (isPrimitiveOrWrapper(value.getClass())) {
                    map.put(field.getName(), value);
                } else if (value instanceof Collection) {
                    map.put(field.getName(), convertCollection((Collection<?>) value));
                } else {
                    map.put(field.getName(), deepConvertToMap(value));
                }
            }
        }
        return map;
    }

    private static boolean isPrimitiveOrWrapper(Class<?> clazz) {
        return clazz.isPrimitive() ||
                clazz == String.class ||
                Number.class.isAssignableFrom(clazz) ||
                clazz == Boolean.class ||
                clazz == Character.class ||
                clazz == Date.class;
    }

    private static List<Object> convertCollection(Collection<?> collection) throws IllegalAccessException {
        List<Object> list = new ArrayList<>();
        for (Object item : collection) {
            if (isPrimitiveOrWrapper(item.getClass())) {
                list.add(item);
            } else {
                list.add(deepConvertToMap(item));
            }
        }
        return list;
    }

}
