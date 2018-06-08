package com.james.demo.common.exception;

/**
 * 封装的业务异常类
 **/
public class BusinessException extends RuntimeException {
    public BusinessException(String message){
        super(message);
    }
}
