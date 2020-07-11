package com.demo.core.exception;

import lombok.Data;

/**
 * 通用异常:当异常找不到细分项的时候，使用这个异常
 */
@Data
public class CommonException extends RuntimeException {

    /**
     * 错误数据：eg.一般为null
     */
    private Object data;

    public CommonException(Object data) {
        this.data = data;
    }

}
