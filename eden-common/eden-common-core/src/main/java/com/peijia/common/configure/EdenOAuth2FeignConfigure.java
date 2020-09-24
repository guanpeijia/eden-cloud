package com.peijia.common.configure;

import com.peijia.common.entity.Constants;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.util.Base64Utils;

/**
 * @author Peijia
 * @className EdenOAuth2FeignConfigure
 * @desc 为Feign在调用远程服务的时候，并不会帮我们把原HTTP请求头部的内容也携带上，请求头部没有访问令牌，于是抛出了401异常。
 *      要解决上面的问题也很简单，只需要拦截Feign请求，手动往请求头上加入令牌即可
 * @create 2020/9/17 22:11
 */
public class EdenOAuth2FeignConfigure {

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return requestTemplate -> {
            // 添加 Zuul Token
            String zuulToken = new String(Base64Utils.encode(Constants.ZUUL_TOKEN_VALUE.getBytes()));
            requestTemplate.header(Constants.ZUUL_TOKEN_HEADER, zuulToken);

            Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
            if (details instanceof OAuth2AuthenticationDetails) {
                String authorizationToken = ((OAuth2AuthenticationDetails) details).getTokenValue();
                requestTemplate.header(HttpHeaders.AUTHORIZATION, "bearer " + authorizationToken);
            }
        };
    }
}
