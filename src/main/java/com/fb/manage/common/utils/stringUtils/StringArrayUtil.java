package com.fb.manage.common.utils.stringUtils;

import java.util.ArrayList;
import java.util.List;

public class StringArrayUtil {


    /**
     * 两个字符串数组两两比较    返回不相同部分   返回多余部分   返回值中s1 在 s2前
     *s1{"abc","def","ghi"}
     *s2{"abc","bbb","ghi","ccc"}
     *return {"def","bbb","ccc"}
     * @return
     */
    public static String[] CompareStringArray(String[] s1, String[] s2){

        List<String> relustlist = new ArrayList<String>();
        int i;
        for (i = 0; i < (s1.length<s2.length?s1.length:s2.length); i++){
            if(!s1[i].equals(s2[i])){
                relustlist.add(s1[i]);
                relustlist.add(s2[i]);
            }
        }
        if(s1.length == s2.length)
            return relustlist.toArray(new String[1]);


        String[] s3 = s1.length > s2.length ? s1 : s2;

        try{
            for(; ;i++){
                relustlist.add(s3[i]);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            return  relustlist.toArray(new String[1]);
        }


    }


}
