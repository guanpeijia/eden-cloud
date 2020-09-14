package com.peijia.auth.configure;

import com.peijia.common.handler.EdenAccessDeniedHandler;
import com.peijia.common.handler.EdenAuthExceptionEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author Peijia
 * @className ResourceServerConfigure
 * @desc 虽然我们现在正在搭建的是一个认证服务器，但是认证服务器本身也可以对外提供REST服务，
 * @desc 比如通过Token获取当前登录用户信息，注销当前Token等，所以它也是一台资源服务器。于是我们需要定义一个资源服务器的配置类
 * @desc 用于处理非/oauth/开头的请求，其主要用于资源的保护，客户端只能通过OAuth2协议发放的令牌来从资源服务器中获取受保护的资源。
 * @create 2020/8/15 20:04
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfigure extends ResourceServerConfigurerAdapter {

    @Autowired
    private EdenAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private EdenAuthExceptionEntryPoint exceptionEntryPoint;
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .requestMatchers().antMatchers("/**")
            .and()
            .authorizeRequests()
            .antMatchers("/**").authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(exceptionEntryPoint)
            .accessDeniedHandler(accessDeniedHandler);
    }
}
