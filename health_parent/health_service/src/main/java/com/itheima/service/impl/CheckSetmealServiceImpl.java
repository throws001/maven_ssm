package com.itheima.service.impl;

import com.itheima.dao.CheckSetmealDao;
import com.itheima.pojo.Setmeal;
import com.itheima.service.CheckSetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CheckSetmealServiceImpl implements CheckSetmealService {
    //注入dao
    @Autowired
    private CheckSetmealDao checkSetmealDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(Setmeal setmeal, List<Integer> checkgroupIds) {
        //添加套餐数据
        checkSetmealDao.add(setmeal);
        //添加数据后返回添加的套餐的id值
        Integer setmealId = setmeal.getId();
        //非空判断
        if(null!=checkgroupIds){
            //遍历集合添加套餐表和项目表的数据
            for (Integer checkgroupId : checkgroupIds) {
                checkSetmealDao.setmealBycheckgroupId(setmealId,checkgroupId);
            }
        }
    }
}
