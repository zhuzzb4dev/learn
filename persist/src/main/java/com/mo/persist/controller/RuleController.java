package com.mo.persist.controller;

import com.mo.persist.group.CommonGroupSequence;
import com.mo.persist.model.CommonResponse;
import com.mo.persist.model.req.RuleAddReq;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test/rule")
@RestController
public class RuleController {

    @PostMapping("add")
    public CommonResponse addRule(@RequestBody @Validated(CommonGroupSequence.class) RuleAddReq req) {
        //业务处理代码
        return CommonResponse.createSuccess("666");
    }
}
