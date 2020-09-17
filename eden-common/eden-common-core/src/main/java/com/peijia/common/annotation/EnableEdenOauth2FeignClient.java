package com.peijia.common.annotation;

import com.peijia.common.configure.EdenOAuth2FeignConfigure;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;

/**
 * @author Peijia
 * @className EnableEdenOauth2FeignClient
 * @desc @Enable类型注解，让该配置类EdenOAuth2FeignConfigure生效
 * @create 2020/9/17 22:17
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EdenOAuth2FeignConfigure.class)
public @interface EnableEdenOauth2FeignClient {

}
