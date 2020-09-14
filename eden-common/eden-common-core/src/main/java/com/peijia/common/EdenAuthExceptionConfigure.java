package com.peijia.common;

import com.peijia.common.handler.EdenAccessDeniedHandler;
import com.peijia.common.handler.EdenAuthExceptionEntryPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @author Peijia
 * @className EdenAuthExceptionConfigure
 * @desc
 * @create 2020/9/8 9:40
 */
public class EdenAuthExceptionConfigure {

    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public EdenAccessDeniedHandler accessDeniedHandler() {
        return new EdenAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public EdenAuthExceptionEntryPoint authenticationEntryPoint() {
        return new EdenAuthExceptionEntryPoint();
    }
}
