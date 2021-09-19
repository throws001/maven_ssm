package com.itheima.service.impl;

import com.itheima.dao.OrderSettingDao;
import com.itheima.exception.MyException;
import com.itheima.pojo.OrderSetting;
import com.itheima.service.OrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderSettingServiceImpl implements OrderSettingService {
    @Autowired
    private OrderSettingDao orderSettingDao;
    @Override
    public void doImport(List<OrderSetting> orderSettingsList) {
        //遍历导入的数据
        for (OrderSetting orderSetting : orderSettingsList) {
            //由于用户重复导入，先判断，通过日期查询，看记录是否存在
        OrderSetting osinob  =  orderSettingDao.findByorderDate(orderSetting.getOrderDate());
                 //存在，则需要更新数据
            if (null!=osinob){
                //拿到已经预约的人数
                int reservations = osinob.getReservations();
                //要更新的人数
                int number = orderSetting.getNumber();
                if (reservations>number){
                    //已经预约的人数大于要更新的人数 则报错
                    throw new MyException("最大预约数不能小于已预约人数");
                }else {
                    //否则，可以更新最大的预约数
                    orderSettingDao.updateNumber(orderSetting);
                }
            }else {
                //不存在，则要添加新纪录
                orderSettingDao.add(orderSetting);
            }
        }

    }
}
