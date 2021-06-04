package com.mo.persist.controller;

import cn.hutool.core.util.IdUtil;
import com.mo.persist.entity.User;
import com.mo.persist.model.CommonResponse;
import com.mo.persist.model.req.UserLoginReq;
import com.mo.persist.model.req.UserRegisterReq;
import com.mo.persist.service.UserService;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

/**
 * (User)表控制层
 *
 * @author 朱志斌
 * @since 2021-05-22 16:33:28
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @Resource
    private RedissonClient redissonClient;

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Long id) {
        return this.userService.queryById(id);
    }

    @PostMapping("register")
    public CommonResponse<Long> register(@RequestBody @Validated UserRegisterReq req) {
        User userEntity = new User();
        userEntity.setUuid(IdUtil.randomUUID());
        userEntity.setEmail(req.getEmail());
        userEntity.setPassword(req.getPassword());
        userEntity.setCreateTime(new Date());
        userEntity.setToken(IdUtil.randomUUID());


        Long id = userService.register(userEntity);
        return CommonResponse.createSuccess(id);
    }

    @PostMapping("login")
    public CommonResponse<String> login(@RequestBody @Validated UserLoginReq req) {

        User userEntity = userService.queryByEmail(req.getEmail());
        if (Objects.isNull(userEntity)) {
            return CommonResponse.createError("user not exists");
        }

        if (!userEntity.getPassword().equals(req.getPassword())) {
            return CommonResponse.createError("wrong password");
        }

        String token = IdUtil.randomUUID();
        userEntity.setToken(token);
        userService.updateOnLogin(userEntity);
//        redisTemplate.opsForValue().set(token,userEntity);
        Config config = redissonClient.getConfig();
        System.out.println(config.getCodec());
        RBucket<User> bucket = redissonClient.getBucket("token-"+token);
        bucket.set(userEntity);
        return CommonResponse.createSuccess(token);
    }
}