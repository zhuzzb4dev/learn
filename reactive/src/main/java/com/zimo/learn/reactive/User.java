package com.zimo.learn.reactive;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;

/**
 * (User)实体类
 *
 * @author 朱志斌
 * @since 2021-05-22 16:33:28
 */
@Getter
@Setter
@Table("user")
public class User implements Serializable {
    private static final long serialVersionUID = -86145911318791579L;
    /**
    * 主键
    */
    @Id
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