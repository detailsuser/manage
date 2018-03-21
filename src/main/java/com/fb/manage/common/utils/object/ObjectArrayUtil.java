package com.fb.manage.common.utils.object;

/**
 * 对象数组工具
 * @createDate : 2017/12/22 10:44
 * @ceeateName : MEINANZI
 */
public class ObjectArrayUtil {
    /**
     * 检查对象数组是否为空
     * @param objects
     * @return  true  没有对象为空 <br/>
     *           false  有一个以上对象为空
     */
    public static boolean objectsNotNull(Object[] objects){
        for (Object obj : objects){
            if (obj == null){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param objects
     * @return
     */
    public static boolean OneObjectNotNull(Object[] objects){
        for (Object obj : objects){
            if (obj == null){
                return false;
            }
        }
        return true;
    }

}
