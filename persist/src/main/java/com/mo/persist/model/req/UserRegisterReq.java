package com.mo.persist.model.req;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * (User)新增请求类
 *
 * @author 朱志斌
 * @since 2021-05-22 16:33:28
 */
@Getter
@Setter
public class UserRegisterReq implements Serializable {
    private static final long serialVersionUID = 207662927171575485L;

    /**
    * 用户名
    */
    @Email
    @Length(max = 32)
    private String email;
    /**
    * 密码
    */
    @NotBlank
    @Length(min = 6, max = 32)
    private String password;

}