package com.mo.persist.dao;

import com.mo.persist.entity.UserGoal;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (UserGoal)表数据库访问层
 *
 * @author 朱志斌
 * @since 2021-05-22 23:46:40
 */
public interface UserGoalDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserGoal queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserGoal> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userGoal 实例对象
     * @return 对象列表
     */
    List<UserGoal> queryAll(UserGoal userGoal);

    /**
     * 新增数据
     *
     * @param userGoal 实例对象
     * @return 影响行数
     */
    int insert(UserGoal userGoal);

    /**
     * 修改数据
     *
     * @param userGoal 实例对象
     * @return 影响行数
     */
    int update(UserGoal userGoal);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}