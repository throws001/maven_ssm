package com.itheima.service;

import com.itheima.pojo.OrderSetting;

import java.util.List;

public interface OrderSettingService {

    void doImport(List<OrderSetting> orderSettings);
}
