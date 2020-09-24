package com.peijia.common.annotation;

import com.peijia.common.configure.EdenServerProtectConfigure;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;

/**
 * @author Peijia
 * @className EnableEdenServerProtect
 * @desc
 * @create 2020/9/18 16:54
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EdenServerProtectConfigure.class)
public @interface EnableEdenServerProtect {

}
