package com.peijia.common.configure;

import com.peijia.common.interceptor.EdenServerProtectInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Peijia
 * @className EdenServerProtectConfigure
 * @desc
 * @create 2020/9/18 16:48
 */
public class EdenServerProtectConfigure implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor edenServerProtectInterceptor() {
        return new EdenServerProtectInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(edenServerProtectInterceptor());
    }
}
