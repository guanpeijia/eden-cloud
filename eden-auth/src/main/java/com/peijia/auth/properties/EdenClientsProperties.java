package com.peijia.auth.properties;

import lombok.Data;

/**
 * @author Peijia
 * @className EdenClientsProperties
 * @desc
 * @create 2020/9/7 16:23
 */
@Data
public class EdenClientsProperties {

    /**
     * client_id
     */
    private String client;

    /**
     * client_secret
     */
    private String secret;

    /**
     * grantType 认证类型
     */
    private String grantType = "password,authorization_code,refresh_token";

    /**
     * scope对应认证范围
     */
    private String scope = "all";
}
