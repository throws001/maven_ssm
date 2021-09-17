package com.itheima.service;

import com.itheima.pojo.CheckItem;

import java.util.List;

public interface CheckItemService {
    /**
     * 查询所有检查项
     * @return
     */
    List<CheckItem> findAll();


    int add(CheckItem checkItem);
}
