package com.james.demo.common.handler;

import com.james.demo.common.exception.BusinessException;
import com.james.demo.common.resp.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by James_hu on 2018/6/5
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理所有不可知的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    private AppResponse handleException(Exception e){
        LOGGER.error("======="+e.getMessage(), e);

        AppResponse response = new AppResponse();
        response.setFail("操作失败！");
        return response;
    }

    /**
     * 处理所有业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    private AppResponse handleBusinessException(BusinessException e){
        LOGGER.error("======="+e.getMessage(), e);

        AppResponse response = new AppResponse();
        response.setFail(e.getMessage());
        return response;
    }
}
