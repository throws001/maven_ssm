package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckGroupDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.exception.MyException;
import com.itheima.pojo.CheckGroup;
import com.itheima.service.CheckGroupSevcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 *
 */
@Service
//开启事务
public class  CheckGroupSevcieImpl implements CheckGroupSevcie {
    //自动注入doa层
    @Autowired
    private CheckGroupDao checkGroupDao;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(CheckGroup checkGroup, List<Integer> checkitemIds) {
        //添加检查组
        checkGroupDao.add(checkGroup);
        //非空判断检查组 id不能为空
            Integer checkGroupId =checkGroup.getId();
        if (checkitemIds != null) {
            //遍历
            for (Integer checkitemId : checkitemIds) {
                checkGroupDao.addCheckGroupByCheckItem(checkGroupId,checkitemId);
            }
        }

    }

    @Override
    public PageResult<CheckGroup> findpage(QueryPageBean queryPageBean) {
        //设置  查询分页数据 大小和总条数
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
        //查询条件的判断
        if (!StringUtils.isEmpty(queryPageBean.getQueryString())){
            //进行模糊查询的拼接
            //拿到前台写的文字，拼接模糊查询
            queryPageBean.setQueryString("%"+queryPageBean.getQueryString()+"%");
        }
        //构建pageResutl返回
       Page<CheckGroup> checkGroupPage= checkGroupDao.findByCondition(queryPageBean.getQueryString());

        return new PageResult<>(checkGroupPage.getTotal(),checkGroupPage.getResult());
    }

    @Override
    public CheckGroup findById(int id) {
        CheckGroup  checkGroup=  checkGroupDao.findById(id);
        return checkGroup;
    }

    @Override
    public List<Integer> findCheCheckItemIdsByCheckGroupId(int id) {
        List<Integer> ids =  checkGroupDao.findCheCheckItemIdsByCheckGroupId(id);
        return ids;
    }

    @Override
    public void update(CheckGroup checkGroup, List<Integer> checkitemIds) {
        //添加数据
        checkGroupDao.update(checkGroup);
        // 根据id删除关系数据
        Integer checkGroupId = checkGroup.getId();
        checkGroupDao.deleteCheckGroupCheckItem(checkGroupId);
        //添加新的关系数据
        if (checkitemIds!=null){
            //遍历id添加关系
            for (Integer checkitemId : checkitemIds) {
                checkGroupDao.addCheckGroupByCheckItem(checkGroupId,checkitemId);
            }
        }
    }

    @Override
    @Transactional(rollbackFor =Exception.class)
    //报错就回滚
    public void delete(int id) {
        //删除数据
        //检查项目表是否被其他表使用，如果使用，不能删除
       int row=checkGroupDao.findCheCheckItemIdSteameal(id);
        if (row>0){
           throw  new MyException("不能删除该id，该检查组被使用了");
       }else{
            //删除项目组之前先删除检查组和检查项的关系,再删除 项目组
            checkGroupDao.deleteBycheckitem(id);
           checkGroupDao.daleteById(id);
       }

    }

    @Override
    public   List<CheckGroup>  findAlll() {
        List<CheckGroup> checkGroups=checkGroupDao.findAll();
        return checkGroups;
    }
}
