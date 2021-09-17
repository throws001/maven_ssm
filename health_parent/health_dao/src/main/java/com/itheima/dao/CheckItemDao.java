package com.itheima.dao;


import com.itheima.pojo.CheckItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckItemDao {
    //操作数据库
    List<CheckItem> findAll() ;

    int add(CheckItem checkItem);
}
