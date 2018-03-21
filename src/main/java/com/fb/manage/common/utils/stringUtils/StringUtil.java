package com.fb.manage.common.utils.stringUtils;



public class StringUtil {
    /**
     * 比较两个字符串  返回不同的部分  返回内容中s1 在 s2前面
     * @param s1
     * @param s2
     * @return
     */
    public static String compareString(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        StringBuilder SB = new StringBuilder();
        int i;
        for (i = 0; i < (c1.length<c2.length?c1.length:c2.length); i++){
            if(c1[i] != c2[i]){
                SB.append(c1[i]).append(c2[i]);
            }
        }
        if(c1.length == c2.length)
            return SB.toString();
        char[] c3 = c1.length > c2.length ? c1 : c2;
        try{
            for(; ;i++){
                SB.append(c3[i]);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            return  SB.toString();
        }
    }

    /**
     * 设置首字母小写
     * @param str
     * @return
     */
    public static String toLowerCase(String str){
        char[] chars = str.toCharArray();
        char c = chars[0];
        if (c > 'A' && c < 'Z')
            chars[0] += 32;
        return String.copyValueOf(chars);
    }

    /**
     * 设置首字母大写
     * @param str
     * @return
     */
    public static String toUpperCase(String str){
        char[] chars = str.toCharArray();
        char c = chars[0];
        if (c > 'a' && c < 'z')
        chars[0] -=32;
        return String.copyValueOf(chars);
    }

    /**
     * 将一段字符加到每个大写字母前
     * @param str 原始字符串
     * @param addstr 需要追加的字符串
     * @return
     */
    public static String UpperCaseAsCutting(String str, String addstr){
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char c : chars){
            if (c > 'A' && c< 'Z'){
                sb.append(addstr);
            }
            sb.append(c);
        }
        return sb.toString();
    }




//    public static String getLastStringByS(String ){
//
//    }






}
