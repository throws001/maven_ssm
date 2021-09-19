package com.itheima.controller;

import com.itheima.constant.MessageConstant;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.pojo.CheckGroup;
import com.itheima.service.CheckGroupSevcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/checkgroup")
public class CheckGroupController {

    @Autowired
    private CheckGroupSevcie checkGroupSevcie;

    @PostMapping("/add")
        //包装数据的一致性
    public Result add(@RequestBody CheckGroup checkGroup ,@RequestParam List<Integer> checkitemIds){
        //调用servcie增加组
        checkGroupSevcie.add(checkGroup,checkitemIds);
        return  new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS);
    }

    @PostMapping("/findPage")
    public Result findpage(@RequestBody QueryPageBean queryPageBean){
        //调用servcie增加组
        PageResult<CheckGroup> checkGroups=checkGroupSevcie.findpage(queryPageBean);
        return  new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS,checkGroups);
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable int id){
        //调用servcie增加组
        CheckGroup checkGroup=checkGroupSevcie.findById(id);
        return  new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS,checkGroup);
    }

    @GetMapping("/findCheCheckItemIdsByCheckGroupId/{id}")
    public Result findCheCheckItemIdsByCheckGroupId(@PathVariable int id){
        //调用servcie增加组
        List<Integer> checkGroups=checkGroupSevcie.findCheCheckItemIdsByCheckGroupId(id);
        return  new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS,checkGroups);
    }


    @PostMapping("/update")
    //包装数据的一致性
    public Result update(@RequestBody CheckGroup checkGroup ,@RequestParam List<Integer> checkitemIds){
        //调用servcie增加组
        checkGroupSevcie.update(checkGroup,checkitemIds);
        return  new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS);
    }

    @DeleteMapping("/{id}")
    //包装数据的一致性
    /**
     * 删除项目组
     */
    public Result delete(@PathVariable int id){
        //根据id删除，调用service
        checkGroupSevcie.delete(id);
        return  new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS);
    }

    @GetMapping("/findAll")
    public Result findAlll(){
         List<CheckGroup> checkGroups=  checkGroupSevcie.findAlll();
        return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS,checkGroups);
    }



}
