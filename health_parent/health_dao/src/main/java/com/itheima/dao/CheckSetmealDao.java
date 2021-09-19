package com.itheima.dao;

import com.itheima.pojo.Setmeal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckSetmealDao {
    /**
     * 添加套餐数据
     * @param setmeal
     */
    void add(Setmeal setmeal);

    /**
     * 添加setmeal和checkgroup的关系表
     * @param setmealId
     * @param checkgroupId
     * 两个参数为integer类型需要取别名
     */
    void setmealBycheckgroupId(@Param("setmealId") Integer setmealId, @Param("checkgroupId")Integer checkgroupId);

    List<String> selectImgs();

}
