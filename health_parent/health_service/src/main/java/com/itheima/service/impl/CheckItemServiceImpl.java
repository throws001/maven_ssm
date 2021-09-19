package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckItemDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.exception.MyException;
import com.itheima.service.CheckItemService;
import com.itheima.pojo.CheckItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
//注入到spring容器中
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    private CheckItemDao checkItemDao;

    @Override
    public List<CheckItem> findAll() {
       List<CheckItem> list=checkItemDao.findAll();

        return list;
    }

    @Override
    public int add(CheckItem checkItem) {
       int row =checkItemDao.add(checkItem);
        return row;
    }
    @Override
    public PageResult<CheckItem> findPage(QueryPageBean queryPageBean) {
        //需要的数据有那些  ？
        //0.总条数
        //2分页查询的数据 单个线程中共享数据
        Page<CheckItem> threadLocalPage=
      PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
        //判断是否有条件【注意】非空要加
        //import com.alibaba.druid.util.StringUtils;判断拿来的数据不为空
        if(!StringUtils.isEmpty(queryPageBean.getQueryString())){
            //如果不为空，有条件所有要进行模糊查询  拼接数据
            queryPageBean.setQueryString('%'+queryPageBean.getQueryString()+'%');
        }
        //查询page<E>extends arraylist<E> implement list    查询数据存入到page中
        Page<CheckItem> pageinfo=checkItemDao.findByCondition(queryPageBean.getQueryString());
        //总记录数
        long total = pageinfo.getTotal();
        //分页结果集
        List<CheckItem> list = pageinfo.getResult();
        //构造pageResult
        PageResult<CheckItem> pageResult = new PageResult<>(total, list);
        return pageResult;

    }

    @Override
    public void deleteById(int id) {
        //检查id查询这个id是否呗检查组使用了
        int cnt= checkItemDao.findCountByCheckItemId(id);
        //统计这个检查项id被检查组使用的次数
        if (cnt>0){
            //计数>0被使用，报错 该检查项检查组 使用了，不能删除
            throw  new MyException("不能删除该id，该项目被项目组使用了");
        }else {
            //计数=0 没被使用可以删除
            checkItemDao.deleteById(id);
        }


    }

    @Override
    public CheckItem findById(int id) {
        CheckItem  checkItem =checkItemDao.findById(id);
        return checkItem;
    }

    @Override
    public void update(CheckItem checkItem) {
        checkItemDao.update(checkItem);

    }


}
