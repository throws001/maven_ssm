package com.itheima.service.Impl;

import com.itheima.dao.ItemsDao;
import com.itheima.poji.Items;
import com.itheima.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//事务处理类
@Transactional
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsDao dao;
    /**
     * 查询所有用户
      * @return
     */
    public List<Items> findAll(){
        List<Items> itemsList = dao.findAll();
        return itemsList;
    }
    /**
     * 添加用户
     * @return
     */
    public int save(Items items){
        int rows = dao.save(items);
        return rows;
    }

}
