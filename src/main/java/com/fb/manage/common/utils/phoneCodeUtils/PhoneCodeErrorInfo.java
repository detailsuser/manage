package com.fb.manage.common.utils.phoneCodeUtils;

/**
 * 错误信息枚举
 * @createDate : 2018/1/3 14:44
 * @ceeateName : MEINANZI
 */
public enum PhoneCodeErrorInfo {
    ERROR_PHONECODE_TYPE_NOT("类型不存在"),
    ERROR_PHONECODE_SEND_INTERVAL_SHORT("请求验证码的间隔太短");

    private String errorInfo;

    PhoneCodeErrorInfo(String s) {
        errorInfo = s;
    }
}
