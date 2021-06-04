package com.mo.persist.service.impl;

import cn.hutool.core.date.DateUtil;
import com.mo.persist.dao.UserGoalDao;
import com.mo.persist.entity.User;
import com.mo.persist.entity.UserGoal;
import com.mo.persist.model.CommonResponse;
import com.mo.persist.model.req.UserGoalReachReq;
import com.mo.persist.service.UserGoalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (UserGoal)表服务实现类
 *
 * @author 朱志斌
 * @since 2021-05-22 23:46:41
 */
@Service("userGoalService")
public class UserGoalServiceImpl extends BaseService implements UserGoalService {
    @Resource
    private UserGoalDao userGoalDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserGoal queryById(Long id) {
        return this.userGoalDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UserGoal> queryAllByLimit(int offset, int limit) {
        return this.userGoalDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userGoal 实例对象
     * @return 实例对象
     */
    @Override
    public UserGoal insert(UserGoal userGoal) {
        this.userGoalDao.insert(userGoal);
        return userGoal;
    }

    /**
     * 修改数据
     *
     * @param userGoal 实例对象
     * @return 实例对象
     */
    @Override
    public UserGoal update(UserGoal userGoal) {
        this.userGoalDao.update(userGoal);
        return this.queryById(userGoal.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userGoalDao.deleteById(id) > 0;
    }

    @Override
    public CommonResponse<Long> reachGoal(UserGoalReachReq req) {
        User loginUser = this.getLoginUser();
        Long userId = loginUser.getId();
        UserGoal userGoal = new UserGoal();
        userGoal.setUserId(userId);
        userGoal.setGoalId(req.getGoalId());


        //TODO 目标是自己定制的，或者收藏的
        Date reachTime = new Date();
        userGoal.setReachTime(reachTime);
        userGoal.setReachDay(DateUtil.format(reachTime,"dd"));
        userGoal.setReachMonth(DateUtil.format(reachTime,"MM"));
        userGoal.setReachYear(DateUtil.format(reachTime,"yyyy"));
        userGoal.setReachDate(DateUtil.format(reachTime,"yyyy-MM-dd"));
        userGoalDao.insert(userGoal);
        return CommonResponse.createSuccess(userGoal.getId());
    }
}