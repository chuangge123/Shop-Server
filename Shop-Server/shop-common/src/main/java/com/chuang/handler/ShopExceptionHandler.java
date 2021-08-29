package com.chuang.handler;

import com.chuang.entity.ResultEntity;
import com.chuang.entity.ShopException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: Shop-Server
 * @description: 全局异常类
 * @author: chuang
 * @create: 2021-06-10 11:11
 */
@ControllerAdvice
public class ShopExceptionHandler {
    //处理系统异常
    @ExceptionHandler (Exception.class)
    @ResponseBody
    public ResultEntity systemException(Exception e){
        System.out.println("系统异常"+e);
        return ResultEntity.error("系统走丢了-.-!请联系管理员");
    }
    @ExceptionHandler (ShopException.class)
    @ResponseBody
    public ResultEntity businessException(Exception e){
        System.out.println("业务异常"+e);
        return ResultEntity.error("系统开小差-。-l 稍后再试");
    }
}
