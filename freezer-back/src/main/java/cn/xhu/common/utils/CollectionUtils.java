package cn.xhu.common.utils;


import java.util.Collection;

/**
 * @author:zx
 * @create time:2021/2/12 21:30
 * @desciption:
 */


public class CollectionUtils {
    public static boolean isNotEmpty(Collection col){
        return (col.size()<=0||col==null)?false:true;
    }

    public static boolean isEmpty(Collection col){
        return (col.size()<=0||col==null)?true:false;
    }
}
