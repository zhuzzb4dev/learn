package com.mo.persist.dao;

import com.mo.persist.entity.Goal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Goal)表数据库访问层
 *
 * @author 朱志斌
 * @since 2021-05-21 00:32:16
 */
public interface GoalDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Goal queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Goal> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param goal 实例对象
     * @return 对象列表
     */
    List<Goal> queryAll(Goal goal);

    /**
     * 新增数据
     *
     * @param goal 实例对象
     * @return 影响行数
     */
    int insert(Goal goal);

    /**
     * 修改数据
     *
     * @param goal 实例对象
     * @return 影响行数
     */
    int update(Goal goal);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    List<Goal> queryByUserId(Long id);

    List<Goal> queryByIds(List<Long> goalIds);
}