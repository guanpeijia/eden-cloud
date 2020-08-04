package com.peijia.configure;

import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Peijia
 * @className RegisterWebSecurityConfigure
 * @desc 注册中心 安全配置类
 * @create 2020/8/4 20:18
 */
@EnableEurekaServer
public class RegisterWebSecurityConfigure extends WebSecurityConfigurerAdapter {

    /**
     * 安全配置
     * @param http the {@link HttpSecurity} to modify
     * @throws Exception if an error occurs
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }
}
