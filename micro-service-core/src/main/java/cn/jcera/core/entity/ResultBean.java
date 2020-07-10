package cn.jcera.core.entity;

import cn.jcera.core.exception.ExceptionEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResultBean<T> implements Serializable {
    /**
     * Code
     */
    private String code = ExceptionEnum.SUCCESS.getErrorCode();
    /**
     * 编号
     */
    private String errStr = ExceptionEnum.SUCCESS.toString();

    /**
     * 消息内容

     */
    private String message = "success";

    /**
     数据内容
     */
    private  T data;

    public ResultBean(ExceptionEnum exceptionEnum, String message, T data) {
        this.code = exceptionEnum.getErrorCode();
        this.errStr = exceptionEnum.toString();
        this.message = message;
        this.data = data;
    }

    public ResultBean(ExceptionEnum exceptionEnum, String message) {
        this.code = exceptionEnum.getErrorCode();
        this.errStr = exceptionEnum.toString();
        this.message = message;
    }

    public ResultBean(){}

    public ResultBean(T data){
        this.data = data;
    }

    public ResultBean(Throwable e){
        this.code = ExceptionEnum.SERVER_ERROR.getErrorCode();
        this.errStr = ExceptionEnum.SERVER_ERROR.getErrorStr();
        this.message = e.getMessage();
    }

    public static <T> ResultBean<T> success(T data) {
        return new ResultBean<>(data);
    }
}
