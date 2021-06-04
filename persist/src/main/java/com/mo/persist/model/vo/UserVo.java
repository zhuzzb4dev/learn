package com.mo.persist.model.vo;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

/**
 * (User)请求返回对象
 *
 * @author 朱志斌
 * @since 2021-05-22 16:33:28
 */
@Getter
@Setter
public class UserVo implements Serializable {
    private static final long serialVersionUID = -46595990233774029L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 随机标识
    */
    private String uuid;
    /**
    * 用户名
    */
    private String email;
    /**
    * 密码
    */
    private String password;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;
    /**
    * 上次登录时间
    */
    private Date lastLoginTime;
    /**
    * 登陆token
    */
    private String token;

}