package com.fb.manage.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @createDate : 2017/11/30 16:12
 * @ceeateName : MEINANZI
 */
public class DateUtil {
    /**
     * 一天的时间数
     */
    public static final long DATE_DAY = 1000 * 60 * 60 * 24;
    /**
     * 一周的时间数
     */
    public static final long DATE_WEEKS = DATE_DAY * 7;
    /**
     * 一月的时间数
     */
    public static final long DATE_MONTH = DATE_DAY * 30;
    /**
     * 一年时间数
     */
    public static final long DATE_YEARS = DATE_MONTH * 12;

    /**
     * 六位值时间格式
     */
    private final static SimpleDateFormat hexSimp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat getHexSimp(){return hexSimp;}
    /**
     * 三位值时间格式
     */
    private final static SimpleDateFormat sexSimp = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat getSexSimp(){return sexSimp;}
    /**
     * 获取 当前时间 yyyy-MM-dd 的时间格式
     * @return
     */
    public static String getDateStringOnYyyy_MM_dd(){
        return getDateStringOnYyyy_MM_dd(new Date());
    }

    /**
     * 格式化时间
     * @param date
     * @return
     */
    public static String getDateStringOnYyyy_MM_dd(Date date){
        return sexSimp.format(date);
    }

/**
 * 获取改时间的开始值  默认为8:00为一天的开始和结束
 * @param date  需要获取开始时间的日期
 */
    public static Date getStartDate(Date date){
        long time = date.getTime();
        return new Date(time - (time % DATE_DAY));
    }
    /**
     * 获取改时间的结束值  默认为8:00为一天的开始和结束
     * @param date  需要获取结束时间的日期
     */
    public static Date getEndDate(Date date) {
        long time = date.getTime();
        return new Date(time - (time % DATE_DAY) + DATE_DAY);
    }



}
