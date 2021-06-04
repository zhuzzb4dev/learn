package com.mo.persist.entity;


import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

/**
 * 用户跟踪目标表(UserFollowedGoal)实体类
 *
 * @author 朱志斌
 * @since 2021-05-23 00:32:18
 */
@Getter
@Setter
public class UserFollowedGoal implements Serializable {
    private static final long serialVersionUID = 785740408403389693L;
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