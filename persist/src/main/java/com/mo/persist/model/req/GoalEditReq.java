package com.mo.persist.model.req;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * (Goal)编辑请求类
 *
 * @author 朱志斌
 * @since 2021-05-21 00:32:16
 */
@Getter
@Setter
public class GoalEditReq implements Serializable {
    private static final long serialVersionUID = 999003896512174742L;
    /**
    * 主键
    */
    private Long id;
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
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;

}