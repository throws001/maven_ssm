package com.itheima.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
//对conteoller方法的增强advice
public class MyException extends RuntimeException {
    /**
     * 构建就要闯入提示的信息
     * @param messaeg
     */
    public MyException(String messaeg){
        super(messaeg);
    }
}
