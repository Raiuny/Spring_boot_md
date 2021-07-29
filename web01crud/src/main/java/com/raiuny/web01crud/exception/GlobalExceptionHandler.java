package com.raiuny.web01crud.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})//处理异常
    public String handlerArithmeticException(Exception e) {
        log.error("异常是：{}", e);
        return "login"; //返回视图地址
    }
}
