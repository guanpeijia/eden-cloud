package com.peijia.common.annotation;

import com.peijia.common.EdenAuthExceptionConfigure;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;

/**
 * @author Peijia
 * @className EnableEdenAuthExceptionHandler
 * @desc
 * @create 2020/9/8 9:56
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EdenAuthExceptionConfigure.class)
public @interface EnableEdenAuthExceptionHandler {

}
