package com.mo.persist.model.req;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户跟踪目标表(UserFollowedGoal)新增请求类
 *
 * @author 朱志斌
 * @since 2021-05-23 00:32:26
 */
@Getter
@Setter
public class UserFollowedGoalAddReq implements Serializable {

    /**
    * 目标id
    */
    @NotNull
    private Long goalId;

}