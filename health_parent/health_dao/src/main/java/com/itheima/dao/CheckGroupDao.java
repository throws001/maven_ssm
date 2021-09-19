package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 根据id查询，CheckGroup——CheckItem是否有关系
     * @param id
     * @return
     */
    List<Integer> findCheCheckItemIdsByCheckGroupId(int id);

    /**
     * 修改检查项数据
     * @param checkGroup
     */
    void update(CheckGroup checkGroup);

    /**
     *
     * @param checkGroupId
     */
    void deleteCheckGroupCheckItem(Integer checkGroupId);

    /**
     * 删除关系
     * @param id
     */
    void daleteById(int id);

    /**
     * 根据id查询，CheckGroup——Steameal是否有关系
     * @param id
     * @return
     */
    int findCheCheckItemIdSteameal(int id);

    /**
     * 根据id删除检查项
      * @param id
     */
    void deleteBycheckitem(int id);

    /**
     * 查询所有的项目组
     * @return
     */
    List<CheckGroup> findAll();



}
