package com.peijia.getaway.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Peijia
 * @className GatewayProperties
 * @desc GatewayProperties
 * @create 2021/3/18 11:10
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:eden-gateway.properties"})
@ConfigurationProperties(prefix = "eden.gateway")
public class GatewayProperties {

    /**
     * 禁止外部访问的 URI，多个值的话以逗号分隔
     */
    private String forbidRequestUri;
}
