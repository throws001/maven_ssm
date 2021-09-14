package com.itheima;


import com.itheima.dao.ItemsDao;
import com.itheima.poji.Items;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test01 {

    @Test
    public void show(){
        //读取配置文件
        ApplicationContext app=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        //Items加载这个类的代理对象
               ItemsDao itemsDao = app.getBean(ItemsDao.class);
        List<Items> all = itemsDao.findAll();
        System.out.println("all = " + all);

    }

}
