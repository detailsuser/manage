package com.fb.manage.common.utils.result;

import lombok.Data;

import java.io.Serializable;


@Data
public class Result<T> implements Serializable {
    private int code;           //返回类型   0成功  -1系统错误   1参数错误
    private String errorCode;   //错误代码
    private String message;     //消息    成功不返回    错误返回提示
    private T t;                //返回内容
}
