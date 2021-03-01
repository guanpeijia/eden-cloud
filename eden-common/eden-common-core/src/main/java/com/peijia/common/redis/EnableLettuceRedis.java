package com.peijia.common.redis;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;

/**
 * @author Peijia
 * @className EnableLettuceRedis
 * @desc EnableLettuceRedis
 * @create 2021/3/1 11:36
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LettuceRedisConfigure.class)
public @interface EnableLettuceRedis {

}
