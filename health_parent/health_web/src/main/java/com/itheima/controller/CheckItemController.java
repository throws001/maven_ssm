package com.itheima.controller;

import com.itheima.constant.MessageConstant;
import com.itheima.entity.Result;
import com.itheima.service.CheckItemService;
import com.itheima.pojo.CheckItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller+@ResponseBody=@RestController
@RequestMapping("/checkitem")
public class CheckItemController {
    //调用service执行业务操作
    @Autowired
    private CheckItemService checkItemService;

    //配置文件
    @GetMapping("/findAll")
    public Result findAll() {
        List<CheckItem> list = checkItemService.findAll();

        return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS, list);

    }
    //配置文件
    @PostMapping("/add")
    //带数据到前端需要注解
    public Result add(@RequestBody CheckItem checkItem ) {
            int row= checkItemService.add(checkItem);
            if (row>0){
                return new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS);
            }

        return new Result(false,MessageConstant.ADD_CHECKITEM_FAIL);
    }



}
