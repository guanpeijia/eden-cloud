package com.peijia.system.server.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Peijia
 * @className EdebServerSystemProperties
 * @desc
 * @create 2021/3/11 10:01
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:swagger.properties"})
@ConfigurationProperties(prefix = "eden")
public class EdenServerSystemProperties {

    /**
     * 免认证 URI，多个值的话以逗号分隔
     */
    private String anonUrl;

    private SwaggerProperties swagger = new SwaggerProperties();
}
