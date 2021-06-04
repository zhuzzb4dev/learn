package com.mo.persist.model.req;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

/**
 * 用户跟踪目标表(UserFollowedGoal)编辑请求类
 *
 * @author 朱志斌
 * @since 2021-05-23 00:32:26
 */
@Getter
@Setter
public class UserFollowedGoalEditReq implements Serializable {
    private static final long serialVersionUID = 600066550516763320L;
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