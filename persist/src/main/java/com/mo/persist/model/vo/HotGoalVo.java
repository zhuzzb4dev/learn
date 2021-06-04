package com.mo.persist.model.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * (Goal)请求返回对象
 *
 * @author 朱志斌
 * @since 2021-05-21 00:32:16
 */
@Getter
@Setter
public class HotGoalVo{
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

}