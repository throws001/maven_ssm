package com.itheima.controller;

import com.itheima.constant.MessageConstant;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.service.CheckItemService;
import com.itheima.pojo.CheckItem;
import org.springframework.beans.factory.annotation.Autowired;
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
    //不加.dodispachersevlet已经做过处理了
    @PostMapping("/findPage")
    public Result findPage(@RequestBody QueryPageBean queryPageBean) {
             //pageresult来 装数据
          PageResult<CheckItem> result =checkItemService.findPage(queryPageBean);
        return new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS,result);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable int id) {
        //必须一样的名字   id  id
        //调用service
            checkItemService.deleteById(id);
         //删除成功  响应前端数据
         return new Result(true,MessageConstant.DELETE_CHECKITEM_SUCCESS);
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable int id) {
        //必须一样的名字   id  id
        //调用service
       CheckItem checkItem =checkItemService.findById(id);
        //删除成功  响应前端数据
        return new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS,checkItem);

    }



    @PutMapping("/{id}")
    public Result update(@PathVariable int id,@RequestBody CheckItem checkItem) {
        //按restful 规范，设置id以路径上id为准
        checkItem.setId(id);
         checkItemService.update(checkItem);
        //删除成功  响应前端数据
        return new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS);

    }



}
