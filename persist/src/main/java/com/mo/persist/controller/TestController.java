package com.mo.persist.controller;

import com.mo.persist.model.CommonResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("test")
@RestController
public class TestController {

    @RequestMapping("empty")
    public CommonResponse test(HttpServletRequest request) {
        return CommonResponse.createSuccess("999");
    }
}
