package com.mo.persist.service.impl;

import com.mo.persist.entity.User;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class BaseService {

    public User getLoginUser(){
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        RequestContextHolder.getRequestAttributes();
        //从session里面获取对应的值
//        String str = (String) requestAttributes.getAttribute("name",RequestAttributes.SCOPE_SESSION);
//        return (User) requestAttributes.getAttribute("LoginUserInfo",RequestAttributes.SCOPE_SESSION);
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        return (User) request.getAttribute("LoginUserInfo");
//        HttpServletResponse response = ((ServletRequestAttributes)requestAttributes).getResponse();
    }
}
