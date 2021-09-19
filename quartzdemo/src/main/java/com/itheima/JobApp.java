package com.itheima;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class JobApp {
    public static void main(String[] args) throws IOException {
        new ClassPathXmlApplicationContext("classpath:application-jobs.xml");
        // 阻塞当线程，不让程序退出
        System.in.read();
    }
}
