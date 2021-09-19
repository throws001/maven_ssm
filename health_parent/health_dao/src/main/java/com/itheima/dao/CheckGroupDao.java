package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckGroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckGroupDao {
    /**
     * 增加项目组的数据
     */
    void add(CheckGroup checkGroup);
    //mybatis 对于两个相同类型的数据类型，需要取别名区分
    void addCheckGroupByCheckItem(@Param("checkGroupId") Integer checkGroupid,@Param("checkitemId") Integer checkitemId);
    //进行模糊查询
    Page<CheckGroup> findByCondition(String queryString);
    CheckGroup findById(int id);

    List<Integer> findCheCheckItemIdsByCheckGroupId(int id);

    void update(CheckGroup checkGroup);

    void deleteCheckGroupCheckItem(Integer checkGroupId);

    void daleteById(int id);


    int findCheCheckItemIdSteameal(int id);

    void deleteBycheckitem(int id);

    List<CheckGroup> findAll();

}
