package com.ys.service_base.exceptionhandler;

import com.ys.commonUtils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        log.error(e.getMessage());

        e.printStackTrace();
        return Result.error().message("执行了全局异常处理");
    }


    @ExceptionHandler(YsException.class)
    @ResponseBody
    public Result err(YsException e){
        log.error(e.getMessage());

        e.printStackTrace();
        return Result.error().message(e.getMessage());
    }
}
