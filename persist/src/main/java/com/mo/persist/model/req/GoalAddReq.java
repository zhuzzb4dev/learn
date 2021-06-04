package com.mo.persist.model.req;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * (Goal)新增请求类
 *
 * @author 朱志斌
 * @since 2021-05-21 00:32:16
 */
@Getter
@Setter
public class GoalAddReq implements Serializable {
    private static final long serialVersionUID = -57717307067003780L;

    /**
    * 目标名称
    */
    private String name;
    /**
    * 详细描述
    */
    private String comment;
    /**
    * 用户id
    */
    private Long userId;

}