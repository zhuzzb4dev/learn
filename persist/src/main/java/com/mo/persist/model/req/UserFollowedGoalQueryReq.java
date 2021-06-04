package com.mo.persist.model.req;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

/**
 * 用户跟踪目标表(UserFollowedGoal)查询请求类
 *
 * @author 朱志斌
 * @since 2021-05-23 00:32:26
 */
@Getter
@Setter
public class UserFollowedGoalQueryReq implements Serializable {
    private static final long serialVersionUID = -47214368116188119L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 目标id
    */
    private Long goalId;

}