package cn.xhu.converter.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 *@author:zx
 *@create time:2021/2/14 20:27
 *@desciption:
 *
 */

public class BaseConverter<T> {
    /**
     * 利用反射实现对象之间的转换
     * @param source
     * @return
     */
    public Object converter(Object source,Class<?> targetClass) {
        Object target = null;
        try {
            target = targetClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        }finally {
            return target;
        }
    }

}
