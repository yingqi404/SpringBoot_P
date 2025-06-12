package com.wyq.springboot_wyq.exception;

import com.wyq.springboot_wyq.pojo.ResponseMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.filters.ExpiresFilter;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.View;

@RestControllerAdvice//专们做统一处理的
//GlobalExceptionHandlerAdvice统一的异常处理器通知
public class GlobalExceptionHandlerAdvice {

    private final View error;
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandlerAdvice.class);//用日志具体记录是什么异常

    public GlobalExceptionHandlerAdvice(View error) {
        this.error = error;
    }

    @ExceptionHandler({Exception.class})//什么异常的统一处理
    public ResponseMessage handleException(Exception e, HttpServletRequest request, HttpServletResponse response) {
        logger.error("统一异常", e);
        return new ResponseMessage(500,"error",null);//后端的异常一律返回500
    }
}
