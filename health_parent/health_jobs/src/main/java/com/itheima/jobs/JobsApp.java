package com.itheima.jobs;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JobsApp {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("classpath:application-jobs.xml");

    }

}
