package com.mo.persist.controller;

import com.mo.persist.entity.User;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    public User getLoginUser(HttpServletRequest request) {
        return (User) request.getAttribute("LoginUserInfo");
    }
}
