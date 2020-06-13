package com.demo.stu.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 通用异常:当异常找不到细分项的时候，使用这个异常
 */
@EqualsAndHashCode(callSuper = true)
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
