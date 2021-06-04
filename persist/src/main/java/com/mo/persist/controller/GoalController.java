package com.mo.persist.controller;

import com.mo.persist.entity.Goal;
import com.mo.persist.model.CommonResponse;
import com.mo.persist.model.req.GoalAddReq;
import com.mo.persist.model.vo.HotGoalVo;
import com.mo.persist.service.GoalService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (Goal)表控制层
 *
 * @author 朱志斌
 * @since 2021-05-21 00:32:16
 */
@RestController
@RequestMapping("goal")
public class GoalController {
    /**
     * 服务对象
     */
    @Resource
    private GoalService goalService;

    @PostMapping("add")
    public CommonResponse<Long> add(@RequestBody GoalAddReq req) {
        Goal goal = new Goal();
        BeanUtils.copyProperties(req,goal);
        goalService.insert(goal);
        return CommonResponse.createSuccess(goal.getId());
    }

    @PostMapping("myGoal")
    public CommonResponse<List<Goal>> myGoal() {
        List<Goal> list = goalService.queryByUserId();
        return CommonResponse.createSuccess(list);
    }

    @PostMapping("hotGoal")
    public CommonResponse<List<HotGoalVo>> hotGoal() {
        List<Goal> list = goalService.queryAll();
        List<HotGoalVo> collect = list.stream().map(o -> {
            HotGoalVo vo = new HotGoalVo();
            BeanUtils.copyProperties(o, vo);
            return vo;
        }).collect(Collectors.toList());
        return CommonResponse.createSuccess(collect);
    }


}