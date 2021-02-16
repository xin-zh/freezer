package cn.xhu.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author:zx
 * @create time:2021/2/12 21:32
 * @desciption:
 */


public class BeanUtils {
    public static boolean isNotEmpty(Object obj){
        return obj==null?false:true;
    }

    public static boolean isEmpty(Object obj){
        return obj==null?true:false;
    }

    public static void copyProperties(Object source,Object target){
        Class<? extends Object> aClass = source.getClass();
        Field[] sourceFields = aClass.getDeclaredFields();
        Field[] targetFields = target.getClass().getDeclaredFields();
        try {
            for (Field sourceField : sourceFields){
                sourceField.setAccessible(true);
                for (Field targetField : targetFields) {
                    if(targetField.getName().equals(sourceField.getName()) && targetField.getType() == sourceField.getType()) {
                        int mod = targetField.getModifiers();
                        if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                            continue;
                        }
                        targetField.setAccessible(true);
                        targetField.set(target, sourceField.get(source));
                        break;
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
