package com.zimo.learn.reactive;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@RestController
@RequestMapping("reactive/user")
public class ReactiveUserController {

    @Resource
    private UserRepository userDao;

    @RequestMapping("add")
    public Mono<User> add(@RequestBody User user){
        return userDao.save(user);
    }
}
