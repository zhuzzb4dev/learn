package com.mo.persist.service.impl;

import com.mo.persist.dao.UserFollowedGoalDao;
import com.mo.persist.entity.Goal;
import com.mo.persist.entity.UserFollowedGoal;
import com.mo.persist.model.CommonResponse;
import com.mo.persist.model.req.UserFollowedGoalAddReq;
import com.mo.persist.model.vo.UserFollowedGoalVo;
import com.mo.persist.service.GoalService;
import com.mo.persist.service.UserFollowedGoalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 用户跟踪目标表(UserFollowedGoal)表服务实现类
 *
 * @author 朱志斌
 * @since 2021-05-23 00:32:18
 */
@Service("userFollowedGoalService")
public class UserFollowedGoalServiceImpl extends BaseService implements UserFollowedGoalService {
    @Resource
    private UserFollowedGoalDao userFollowedGoalDao;

    @Resource
    private GoalService goalService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserFollowedGoal queryById(Long id) {
        return this.userFollowedGoalDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UserFollowedGoal> queryAllByLimit(int offset, int limit) {
        return this.userFollowedGoalDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userFollowedGoal 实例对象
     * @return 实例对象
     */
    @Override
    public UserFollowedGoal insert(UserFollowedGoal userFollowedGoal) {
        this.userFollowedGoalDao.insert(userFollowedGoal);
        return userFollowedGoal;
    }

    /**
     * 修改数据
     *
     * @param userFollowedGoal 实例对象
     * @return 实例对象
     */
    @Override
    public UserFollowedGoal update(UserFollowedGoal userFollowedGoal) {
        this.userFollowedGoalDao.update(userFollowedGoal);
        return this.queryById(userFollowedGoal.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userFollowedGoalDao.deleteById(id) > 0;
    }

    @Override
    public CommonResponse<Long> follow(UserFollowedGoalAddReq req) {
        UserFollowedGoal entity = new UserFollowedGoal();
        entity.setUserId(this.getLoginUser().getId());
        entity.setGoalId(req.getGoalId());
        userFollowedGoalDao.insert(entity);
        return CommonResponse.createSuccess(entity.getId());
    }

    @Override
    public CommonResponse<List<UserFollowedGoalVo>> queryByUserId() {

        List<UserFollowedGoal> list = userFollowedGoalDao.queryByUserId(this.getLoginUser().getId());
        List<Long> goalIds = list.stream()
                .map(o->o.getGoalId())
                .collect(Collectors.toList());


        List<Goal> goalList = goalService.queryByIds(goalIds);
        Map<Long, Goal> goalMap = goalList.stream().collect(Collectors.toMap(Goal::getId, o -> o));
        List<UserFollowedGoalVo> voList = list.stream().map(o -> {
            UserFollowedGoalVo vo = new UserFollowedGoalVo();
            vo.setId(o.getId());
            Long goalId = o.getGoalId();
            vo.setGoalId(goalId);
            vo.setName(goalMap.get(goalId).getName());
            vo.setComment(goalMap.get(goalId).getComment());
            return vo;
        }).collect(Collectors.toList());
        return CommonResponse.createSuccess(voList);
    }
}