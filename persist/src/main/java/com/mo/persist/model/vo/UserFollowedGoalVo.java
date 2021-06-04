package com.mo.persist.model.vo;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

/**
 * 用户跟踪目标表(UserFollowedGoal)请求返回对象
 *
 * @author 朱志斌
 * @since 2021-05-23 00:32:26
 */
@Getter
@Setter
public class UserFollowedGoalVo implements Serializable {
    private static final long serialVersionUID = 134729374091549572L;
    /**
    * 主键
    */
    private Long id;

    /**
    * 目标id
    */
    private Long goalId;

    /**
     * 目标名称
     */
    private String name;
    /**
     * 详细描述
     */
    private String comment;

}