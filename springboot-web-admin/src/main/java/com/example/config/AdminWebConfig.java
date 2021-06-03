package com.example.config;

import com.example.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器资源拦截
 * 1、编写一个拦截器实现HandlerInterceptor接口
 * 2、拦截器注册到容器中(实现WebMvcConfigurer中的addInterceptors方法)
 * 3、指定拦截规则【如果是拦截所有，静态资源也会被拦截】
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns：拦截的url
        // excludePathPatterns：放行的url
        // 静态资源不拦截
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")      // 所有请求都被拦截，包括静态资源
                .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**", "/js/**", "/city");
    }
}
