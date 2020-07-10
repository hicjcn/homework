package cn.jcera.core.exception;

import cn.jcera.core.entity.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ResultBean<Exception> exceptionHandler(Exception e){
        logger.error("未知异常", e);
        return new ResultBean<>(e);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultBean<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        return new ResultBean<>(ExceptionEnum.PARAM_ERROR, e.getMessage());
    }
}
