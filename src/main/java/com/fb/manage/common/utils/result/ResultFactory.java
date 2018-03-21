package com.fb.manage.common.utils.result;

public class ResultFactory {
    /**
     * 获取一个成功的实例
     * @param obj 返回数据
     * @return
     */
    public static Result getSuccessResult(Object obj) {
        Result result = new Result();
        result.setMessage("success");
        result.setCode(ResultCode.SUCCESS);
        result.setT(obj);
        return result;
    }

    /**
     * 获得一个参数错误的实例
     * @param message 错误消息
     * @param ErrorCode 错误代码
     * @return
     */
    public static Result getParameterErrorResult(String message, String ErrorCode) {
        Result result = new Result();
        result.setMessage(message);
        result.setCode(ResultCode.PARAMS_ERROR);
        result.setErrorCode(ErrorCode);
        return result;
    }

    /**
     * 获得一个系统错误的实例
     * @param message 错误消息
     * @param ErrorCode 错误代码
     * @return
     */
    public static Result getSystemErrorResult(String message, String ErrorCode) {
        Result result = new Result();
        result.setMessage(message);
        result.setCode(ResultCode.SYSTEM_ERROR);
        result.setErrorCode(ErrorCode);
        return result;
    }
}

