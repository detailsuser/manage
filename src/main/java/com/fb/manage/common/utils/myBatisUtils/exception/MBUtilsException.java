package com.fb.manage.common.utils.myBatisUtils.exception;

/**
 * 数据库操作异常
 * @createDate : 2017/11/30 11:23
 * @ceeateName : MEINANZI
 */
public class MBUtilsException extends Exception {
    public MBUtilsException(String msg){ super(msg); }
    public MBUtilsException(String msg, Exception e){ super(msg,e); }
}
