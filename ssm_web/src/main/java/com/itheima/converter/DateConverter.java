package com.itheima.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateConverter implements Converter<String, Date> {
    /**
     * 转化数据
     * @param s
     * @return
     */
    public Date convert(String s) {
        try {
            //定义simpledateformat
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = simpleDateFormat.parse(s);
            return parse;
        } catch (ParseException e) {
            System.out.println("服务器异常");
        }
        return null;

    }
}
