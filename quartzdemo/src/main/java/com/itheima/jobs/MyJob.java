package com.itheima.jobs;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public void abc(){
        System.out.println(sdf.format(new Date()));
    }

}
