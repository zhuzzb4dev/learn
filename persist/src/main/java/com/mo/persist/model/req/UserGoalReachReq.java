package com.mo.persist.model.req;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;

/**
 * (UserGoal)新增请求类
 *
 * @author 朱志斌
 * @since 2021-05-22 23:36:35
 */
@Getter
@Setter
public class UserGoalReachReq implements Serializable {

    /**
    * 详细描述
    */
    @NonNull
    private Long goalId;

}