package com.fb.manage.common.utils.myBatisUtils;

import java.util.Date;

/**
 * 数据类型转换   db类型与java数类型
 */
public class DBandJAVADataTypeConversion {

    //java数据类型
    private static final String JINT = Integer.class.getName();
    private static final String JSTRING = String.class.getName();
    private static final String JBOOLEAN = Boolean.class.getName();
    private static final String JDATE = Date.class.getName();
    private static final String JDOUBLE = Double.class.getName();
    //数据库数据类型
    private static final String DINT = "int";
    private static final String DSTRING = "varchar";
    private static final String DBOOLEAN = "boolean";
    private static final String DDATE = "date";
    private static final String DDOUBLE = "double";


    /**
     * 根据java数据类型获取数据库数据类型
     * @param jType  java数据类型
     * @return
     */
    public static String getDTypeByJType(String jType){
        if ( jType.equals(JINT) || jType.equals(DINT))
            return DINT;
        else if (jType.equals(JSTRING) || jType.equals(DSTRING))
            return DSTRING;
        else if (jType.equals(JBOOLEAN) || jType.equals(DBOOLEAN))
            return DBOOLEAN;
        else if (jType.equals(JDATE) || jType.equals(DDATE))
            return DDATE;
        else if (jType.equals(JDOUBLE) || jType.equals(DDOUBLE))
            return DDOUBLE;
        else
            return null;
    }


    public static String getJTypeByDType(String dType){
        if (dType.equals(DINT) || dType.equals(JINT))
            return JINT;
        else if (dType.equals(DSTRING) || dType.equals(JSTRING))
            return JSTRING;
        else if (dType.equals(DBOOLEAN) || dType.equals(JBOOLEAN))
            return JBOOLEAN;
        else if (dType.equals(DDATE) || dType.equals(JDATE))
            return JDATE;
        else if (dType.equals(DDOUBLE) || dType.equals(JDOUBLE))
            return JDOUBLE;
        else
            return null;
    }
}
