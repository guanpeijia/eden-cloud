package com.peijia.getaway.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
/**
 * @author Peijia
 * @className EdenGateWayCorsConfigure
 * @desc 跨域处理
 * @create 2020/9/27 23:13
 */
public class EdenGateWayCorsConfigure {

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        //setAllowCredentials(true)表示允许cookie跨域；
        corsConfiguration.setAllowCredentials(true);
        // addAllowedHeader(CorsConfiguration.ALL)表示请求头部允许携带任何内容；
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
        // addAllowedOrigin(CorsConfiguration.ALL)表示允许任何来源；
        corsConfiguration.addAllowedOrigin(CorsConfiguration.ALL);
        // addAllowedMethod(CorsConfiguration.ALL)表示允许任何HTTP方法
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }
}