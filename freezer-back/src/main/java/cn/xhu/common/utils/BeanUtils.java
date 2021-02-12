package cn.xhu.common.utils;

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
}
