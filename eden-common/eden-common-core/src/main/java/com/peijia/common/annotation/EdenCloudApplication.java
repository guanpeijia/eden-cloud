package com.peijia.common.annotation;

/**
 * @author Peijia
 * @className EdenCloudApplication
 * @desc
 * @create 2020/9/24 23:17
 */

import com.peijia.common.selector.EdenCloudApplicationSelector;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EdenCloudApplicationSelector.class)
public @interface EdenCloudApplication {

}
