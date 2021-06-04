package com.mo.persist.service;

import com.mo.persist.entity.UserGoal;
import com.mo.persist.model.CommonResponse;
import com.mo.persist.model.req.UserGoalReachReq;

import java.util.List;

/**
 * (UserGoal)表服务接口
 *
 * @author 朱志斌
 * @since 2021-05-22 23:46:40
 */
public interface UserGoalService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserGoal queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserGoal> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userGoal 实例对象
     * @return 实例对象
     */
    UserGoal insert(UserGoal userGoal);

    /**
     * 修改数据
     *
     * @param userGoal 实例对象
     * @return 实例对象
     */
    UserGoal update(UserGoal userGoal);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    CommonResponse<Long> reachGoal(UserGoalReachReq req);
}