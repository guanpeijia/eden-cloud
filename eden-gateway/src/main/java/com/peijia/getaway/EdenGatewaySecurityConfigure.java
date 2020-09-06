package com.peijia.getaway;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Peijia
 * @className EdenGatewaySecurityConfigure
 * @desc 安全配置类
 * 因为eden-gateway引入了eden-common模块，eden-common模块包含了Spring Cloud Security依赖，所以我们需要定义一个自己的WebSecurity配置类，来覆盖默认的。这里主要是关闭了csrf功能，否则会报csrf相关异常。
 * @create 2020/9/6 18:02
 */
@EnableWebSecurity
public class EdenGatewaySecurityConfigure extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }
}
