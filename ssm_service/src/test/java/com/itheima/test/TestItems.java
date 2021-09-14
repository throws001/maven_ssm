package com.itheima.test;


import com.itheima.poji.Items;
import com.itheima.service.ItemsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestItems {
    @Test
    public  void  test01(){
        ApplicationContext app=new ClassPathXmlApplicationContext("spring-service.xml");
        ItemsService its =  app.getBean(ItemsService.class);
        List<Items> all = its.findAll();
        System.out.println("all = " + all);
        ArrayList<String> list = new ArrayList<String>();
    }
}
