package com.itheima.dao;


import com.github.pagehelper.Page;
import com.itheima.pojo.CheckItem;

import java.util.List;

public interface CheckItemDao {
    //操作数据库
    List<CheckItem> findAll() ;

    int add(CheckItem checkItem);

    Page<CheckItem> findByCondition(String queryString);

    void deleteById(int id);

    int findCountByCheckItemId(int id);

    CheckItem findById(int id);

    void update(CheckItem checkItem);
}
