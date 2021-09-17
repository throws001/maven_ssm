package com.itheima.service.impl;

import com.itheima.dao.CheckItemDao;
import com.itheima.service.CheckItemService;
import com.itheima.pojo.CheckItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//注入到spring容器中
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    private CheckItemDao checkItemDao;

    @Override
    public List<CheckItem> findAll() {
       List<CheckItem> list=checkItemDao.findAll();

        return list;
    }

    @Override
    public int add(CheckItem checkItem) {
       int row =checkItemDao.add(checkItem);
        return row;
    }
}
