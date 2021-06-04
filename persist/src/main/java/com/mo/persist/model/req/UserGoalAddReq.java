package com.mo.persist.model.req;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

/**
 * (UserGoal)新增请求类
 *
 * @author 朱志斌
 * @since 2021-05-22 23:46:43
 */
@Getter
@Setter
public class UserGoalAddReq implements Serializable {
    private static final long serialVersionUID = 477076561206177737L;
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
    /**
    * 达成时间-时间点
    */
    private Date reachTime;
    /**
    * 达成时间-天
    */
    private String reachDay;
    /**
    * 达成时间-月
    */
    private String reachMonth;
    /**
    * 达成时间-年
    */
    private String reachYear;
    /**
    * 达成时间-日期
    */
    private String reachDate;

}