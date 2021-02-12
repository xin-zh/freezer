package cn.xhu.common.utils;

/**
 * @author:zx
 * @create time:2021/2/12 21:29
 * @desciption:
 */


public class StringUtils {
    public static boolean isNotEmpty(String str){
        return (str==null||str=="")?false:true;
    }

    public static boolean isEmpty(String str){
        return (str==null||str=="")?true:false;
    }


}
