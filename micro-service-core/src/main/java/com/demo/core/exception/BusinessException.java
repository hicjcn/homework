package com.demo.core.exception;

public class BusinessException extends CommonException {

    private String message;

    public BusinessException(Object data, String bizLogicMsg) {
        super(data);
        this.message = bizLogicMsg;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
