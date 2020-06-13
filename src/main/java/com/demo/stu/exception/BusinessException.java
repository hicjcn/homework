package com.demo.stu.exception;

public class BusinessException extends CommonException{

    private String bizLogicMsg;

    public BusinessException(Object data, String bizLogicMsg) {
        super(data);
        this.bizLogicMsg = bizLogicMsg;
    }

}
