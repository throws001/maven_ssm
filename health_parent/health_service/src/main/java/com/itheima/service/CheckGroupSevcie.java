package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckGroup;

import java.util.List;

/**
 * CheckGroupSevcie 业务处理层
 */
public interface CheckGroupSevcie {

    void add(CheckGroup checkGroup, List<Integer> checkitemIds);

    PageResult<CheckGroup> findpage(QueryPageBean queryPageBean);

    CheckGroup findById(int id);

    List<Integer> findCheCheckItemIdsByCheckGroupId(int id);

    void update(CheckGroup checkGroup, List<Integer> checkitemIds);

    void delete(int id);

    List<CheckGroup> findAlll();

    //接口


}
