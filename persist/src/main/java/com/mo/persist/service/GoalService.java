package com.mo.persist.service;

import com.mo.persist.entity.Goal;

import java.util.List;

/**
 * (Goal)表服务接口
 *
 * @author 朱志斌
 * @since 2021-05-21 00:32:16
 */
public interface GoalService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Goal queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Goal> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param goal 实例对象
     * @return 实例对象
     */
    Goal insert(Goal goal);

    /**
     * 修改数据
     *
     * @param goal 实例对象
     * @return 实例对象
     */
    Goal update(Goal goal);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    List<Goal> queryByUserId();

    List<Goal> queryByIds(List<Long> goalIds);

    List<Goal> queryAll();
}