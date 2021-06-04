package com.mo.persist.dao;

import com.mo.persist.entity.UserFollowedGoal;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户跟踪目标表(UserFollowedGoal)表数据库访问层
 *
 * @author 朱志斌
 * @since 2021-05-23 00:32:18
 */
public interface UserFollowedGoalDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserFollowedGoal queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserFollowedGoal> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userFollowedGoal 实例对象
     * @return 对象列表
     */
    List<UserFollowedGoal> queryAll(UserFollowedGoal userFollowedGoal);

    /**
     * 新增数据
     *
     * @param userFollowedGoal 实例对象
     * @return 影响行数
     */
    int insert(UserFollowedGoal userFollowedGoal);

    /**
     * 修改数据
     *
     * @param userFollowedGoal 实例对象
     * @return 影响行数
     */
    int update(UserFollowedGoal userFollowedGoal);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    List<UserFollowedGoal> queryByUserId(Long id);
}