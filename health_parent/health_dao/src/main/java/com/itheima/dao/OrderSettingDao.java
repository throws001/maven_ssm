package com.itheima.dao;

import com.itheima.pojo.OrderSetting;

import java.util.Date;

public interface OrderSettingDao {
    /**
     * 通过日期擦查询
     * @param orderDate
     * @return
     */
    OrderSetting findByorderDate(Date orderDate);

    /**
     * 修改最大预约数
     */
    void updateNumber(OrderSetting orderSetting);

    /**
     * 添加预约设置
     * @param orderSetting
     */
    void add(OrderSetting orderSetting);

}
