package com.mo.persist.controller;

import com.mo.persist.entity.UserFollowedGoal;
import com.mo.persist.model.CommonResponse;
import com.mo.persist.model.req.UserFollowedGoalAddReq;
import com.mo.persist.model.vo.UserFollowedGoalVo;
import com.mo.persist.service.UserFollowedGoalService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户跟踪目标表(UserFollowedGoal)表控制层
 *
 * @author 朱志斌
 * @since 2021-05-23 00:32:18
 */
@RestController
@RequestMapping("userFollowedGoal")
public class UserFollowedGoalController {
    /**
     * 服务对象
     */
    @Resource
    private UserFollowedGoalService userFollowedGoalService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserFollowedGoal selectOne(Long id) {
        return this.userFollowedGoalService.queryById(id);
    }

    @PostMapping("follow")
    public CommonResponse<Long> follow(@RequestBody @Validated UserFollowedGoalAddReq req) {
        return userFollowedGoalService.follow(req);
    }

    @PostMapping("myFollowed")
    public CommonResponse<List<UserFollowedGoalVo>> myFollowed() {
        return userFollowedGoalService.queryByUserId();
    }
}