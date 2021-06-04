package com.mo.persist.service.impl;

import com.mo.persist.dao.GoalDao;
import com.mo.persist.entity.Goal;
import com.mo.persist.service.GoalService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Goal)表服务实现类
 *
 * @author 朱志斌
 * @since 2021-05-21 00:32:16
 */
@Service("goalService")
public class GoalServiceImpl extends BaseService implements GoalService {

    @Resource
    private GoalDao goalDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Goal queryById(Long id) {
        return this.goalDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Goal> queryAllByLimit(int offset, int limit) {
        return this.goalDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param goal 实例对象
     * @return 实例对象
     */
    @Override
    public Goal insert(Goal goal) {
        this.goalDao.insert(goal);
        return goal;
    }

    /**
     * 修改数据
     *
     * @param goal 实例对象
     * @return 实例对象
     */
    @Override
    public Goal update(Goal goal) {
        this.goalDao.update(goal);
        return this.queryById(goal.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.goalDao.deleteById(id) > 0;
    }

    @Override
    public List<Goal> queryByUserId() {
        return goalDao.queryByUserId(this.getLoginUser().getId());
    }

    @Override
    public List<Goal> queryByIds(@Param("goalIds") List<Long> goalIds) {
        return goalDao.queryByIds(goalIds);
    }

    @Override
    public List<Goal> queryAll() {
        return goalDao.queryAll(null);
    }
}