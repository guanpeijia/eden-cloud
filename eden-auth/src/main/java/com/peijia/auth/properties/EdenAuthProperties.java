package com.peijia.auth.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Peijia
 * @className EdenAuthProperties
 * @desc @PropertySource(value = {"classpath:eden-auth.properties"})用于指定读取的配置文件路径；
*  @desc @ConfigurationProperties(prefix = "eden.auth")指定了要读取的属性的统一前缀名称为eden.auth；@SpringBootConfiguration实质上为
 * @desc @Component的派生注解，用于将EdenAuthProperties纳入到IOC容器中。
 * @create 2020/9/7 16:29
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:eden-auth.properties"})
@ConfigurationProperties(prefix = "eden.auth")
public class EdenAuthProperties {

    /**
     * 个认证服务器可以根据多种Client来发放对应的令牌，所以这个属性使用的是数组形式
     */
    private EdenClientsProperties[] clients = {};

    /**
     * accessTokenValiditySeconds用于指定access_token的有效时间，默认值为60 * 60 * 24秒
     */
    private int accessTokenValiditySeconds = 60 * 60 * 24;

    /**
     * refreshTokenValiditySeconds用于指定refresh_token的有效时间，默认值为60 * 60 * 24 * 7秒
     */
    private int refreshTokenValiditySeconds = 60 * 60 * 24 * 7;

    /**
     * 验证码配置类
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();

    /**
     * 免认证路径
     */
    private String anonUrl;
}
