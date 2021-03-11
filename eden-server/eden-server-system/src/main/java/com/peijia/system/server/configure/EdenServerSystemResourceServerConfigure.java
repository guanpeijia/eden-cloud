package com.peijia.system.server.configure;

import com.peijia.system.server.properties.EdenServerSystemProperties;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author Peijia
 * @className EdenServerSystemResourceServerConfigure
 * @desc
 * @create 2020/9/6 19:32
 */
@Configuration
@EnableResourceServer
public class EdenServerSystemResourceServerConfigure extends ResourceServerConfigurerAdapter {

    @Autowired
    private EdenServerSystemProperties edenServerSystemProperties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(
            edenServerSystemProperties.getAnonUrl(), ",");

        http.csrf().disable()
            .requestMatchers().antMatchers("/**")
            .and()
            .authorizeRequests()
            .antMatchers(anonUrls).permitAll()
            .antMatchers("/**").authenticated();
    }
}
