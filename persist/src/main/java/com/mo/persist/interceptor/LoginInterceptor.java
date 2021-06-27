package com.mo.persist.interceptor;

import cn.hutool.core.util.StrUtil;
import com.mo.persist.entity.User;
import com.mo.persist.exception.BizException;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private RedissonClient redissonClient;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (StrUtil.isBlank(token)) {
            throw new BizException("not login");
        }
        RBucket<User> bucket = redissonClient.getBucket("token-" + token);
        User user = bucket.get();
        if (Objects.isNull(user)) {
            throw new BizException("login state not valid");
        }
        request.setAttribute("LoginUserInfo",user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
