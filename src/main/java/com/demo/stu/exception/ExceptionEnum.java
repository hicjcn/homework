package com.demo.stu.exception;

public enum ExceptionEnum {
    SUCCESS("200", "响应正常"),
    PARAM_ERROR("201", "参数错误"),
    REQUEST_ERROR("300", "请求异常"),
    BUSINESS_ERROR("400", "业务异常"),
    SERVER_ERROR("500", "服务异常"),
    ;

    private String errorCode;
    private String errorStr;

    ExceptionEnum(String errorCode, String errorStr) {
        this.errorCode = errorCode;
        this.errorStr = errorStr;
    }

    public String getErrorStr() {
        return errorStr;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
