package com.mo.persist.controller;

import com.mo.persist.entity.UserGoal;
import com.mo.persist.model.CommonResponse;
import com.mo.persist.model.req.UserGoalReachReq;
import com.mo.persist.service.UserGoalService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * (UserGoal)表控制层
 *
 * @author 朱志斌
 * @since 2021-05-22 23:36:35
 */
@RestController
@RequestMapping("userGoal")
public class UserGoalController{
    /**
     * 服务对象
     */
    @Resource
    private UserGoalService userGoalService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserGoal selectOne(Long id) {
        return this.userGoalService.queryById(id);
    }

    @RequestMapping("reachGoal")
    public CommonResponse<Long> reachGoal(@RequestBody @Validated UserGoalReachReq req, HttpServletRequest request) {
        return userGoalService.reachGoal(req);
    }
}