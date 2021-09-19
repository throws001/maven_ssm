package com.itheima.controller;


import com.itheima.constant.MessageConstant;
import com.itheima.entity.Result;
import com.itheima.pojo.OrderSetting;
import com.itheima.service.OrderSettingService;
import com.itheima.utils.POIUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

//加注解
@RestController
@RequestMapping("/ordersetting")
public class OrderSettingController {

    private static final Logger log = LoggerFactory.getLogger(OrderSettingController.class);
    @Autowired
    private OrderSettingService orderSettingService;

    @PostMapping("/upload")
    public Result upload(MultipartFile excelFile){
        //读取excel内容List<String[]>
        try{
            // List<String[]> 转成 list<OrderSetting> 取反
            List<String[]> strings = POIUtils.readExcel(excelFile);
            if (!CollectionUtils.isEmpty(strings)){
                //日期转换 读取使用Poutils.data_FORMAT格式化日期，现在反解析为日期，必须使用相同的格式
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(POIUtils.DATE_FORMAT);
                //list<string>转成list<ordersetting>
               List<OrderSetting> orderSettings= new ArrayList<>();
                for (String[] string : strings) {
                    //string[0]
                    //string[1]
                    OrderSetting os = new OrderSetting(simpleDateFormat.parse(string[0]), Integer.parseInt(string[1]));
                    orderSettings.add(os);
                }
                orderSettingService.doImport(orderSettings);
            }
            return new Result(true, MessageConstant.IMPORT_ORDERSETTING_SUCCESS);
        }catch (Exception e){
                log.error("导入数据失败" ,e);
        }
        return new Result(true, MessageConstant.IMPORT_ORDERSETTING_FAIL);

    }


}
