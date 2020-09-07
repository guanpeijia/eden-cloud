package com.peijia.server.test.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author Peijia
 * @className EdenServerTestResourceServerConfigure
 * @desc
 * @create 2020/9/7 10:51
 */
@Configuration
@EnableResourceServer
public class EdenServerTestResourceServerConfigure extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .requestMatchers().antMatchers("/**")
            .and()
            .authorizeRequests()
            .antMatchers("/**").authenticated();
    }

}
