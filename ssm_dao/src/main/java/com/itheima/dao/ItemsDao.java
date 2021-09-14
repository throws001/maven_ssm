package com.itheima.dao;


import com.itheima.poji.Items;

import java.util.List;

public interface ItemsDao {
    /**
     * 查看所用用户
     * @return
     */
    List<Items> findAll();

    /**
     * 添加用户
     * @param items
     * @return
     */
    int save(Items items);
}
