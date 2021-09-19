package com.itheima.dao;


import com.github.pagehelper.Page;
import com.itheima.pojo.CheckItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
