package com.itheima.service;

import com.itheima.pojo.Setmeal;

import java.util.List;

public interface CheckSetmealService {

    void add(Setmeal setmeal, List<Integer> checkgroupIds);
}
