package com.mo.persist.config;

import com.mo.persist.interceptor.LimitInterceptor;
import com.mo.persist.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    private static final String[] excludePathPatterns = {
            "/user/login",
            "/user/register",
            "/test/**"
    };

    @Resource
    private LoginInterceptor loginInterceptor;

    @Resource
    private LimitInterceptor limitInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePathPatterns)
                .order(0);

//        registry.addInterceptor(limitInterceptor)
//                .addPathPatterns("/**")
//                .order(1);
    }


}
