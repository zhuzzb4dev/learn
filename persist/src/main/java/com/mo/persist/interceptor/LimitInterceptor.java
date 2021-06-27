package com.mo.persist.interceptor;

import com.mo.persist.exception.BizException;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LimitInterceptor implements HandlerInterceptor {


    private Long lastTime = System.currentTimeMillis();

    private long interval = 1000;

    private int count = 0;

    private int max = 10;

    @Resource
    private RedissonClient redissonClient;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Thread.sleep(5000);
        long now = System.currentTimeMillis();
        System.out.println(now);
        System.out.println(count);
        if (now < lastTime + interval) {
            if(++count < max) return true;
            throw new BizException("request too many");
        } else {
            lastTime = now;
            count = 0;
        }
        return true;

//        return ++count < 10;

    }
}
