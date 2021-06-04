package com.mo.persist.service;

import com.mo.persist.entity.UserFollowedGoal;
import com.mo.persist.model.CommonResponse;
import com.mo.persist.model.req.UserFollowedGoalAddReq;
import com.mo.persist.model.vo.UserFollowedGoalVo;

import java.util.List;

/**
 * 用户跟踪目标表(UserFollowedGoal)表服务接口
 *
 * @author 朱志斌
 * @since 2021-05-23 00:32:18
 */
public interface UserFollowedGoalService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserFollowedGoal queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserFollowedGoal> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userFollowedGoal 实例对象
     * @return 实例对象
     */
    UserFollowedGoal insert(UserFollowedGoal userFollowedGoal);

    /**
     * 修改数据
     *
     * @param userFollowedGoal 实例对象
     * @return 实例对象
     */
    UserFollowedGoal update(UserFollowedGoal userFollowedGoal);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    CommonResponse<Long> follow(UserFollowedGoalAddReq req);

    CommonResponse<List<UserFollowedGoalVo>> queryByUserId();
}