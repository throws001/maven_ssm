package com.itheima.controller;

import com.itheima.entity.Result;
import com.itheima.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
//对我们controller方法进行增强advice
//5种通知方法增强
//前置  后置  环绕 异常
//返回给页面
//try  整个controller
public class MyExceptionAdvice {
    private static final Logger log = LoggerFactory.getLogger(MyExceptionAdvice.class);
    /**
     * 处理业务异常
     * @param e
     * @return
     */
        @ExceptionHandler(value = MyException.class)
        //catch
    public Result handleMyException(MyException e){
           return new Result(false,e.getMessage());
        }

    /**
     * 处理系统异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    //catch
    public Result handleException(Exception e){
        log.error("出异常了",e);//sout.out 不能出现在代码里，
        //e.printStackTrace();
        return new Result(false,"系统繁忙，请稍后重试");

    }
}
