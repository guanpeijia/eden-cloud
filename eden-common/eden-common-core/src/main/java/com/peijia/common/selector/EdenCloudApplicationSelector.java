package com.peijia.common.selector;

import com.peijia.common.EdenAuthExceptionConfigure;
import com.peijia.common.configure.EdenOAuth2FeignConfigure;
import com.peijia.common.interceptor.EdenServerProtectInterceptor;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Peijia
 * @className EdenCloudApplicationSelector
 * @desc 整合edenCloud通用注解
 * @create 2020/9/24 23:12
 */
public class EdenCloudApplicationSelector implements ImportSelector {

    /**
     * Select and return the names of which class(es) should be imported based on the {@link
     * AnnotationMetadata} of the importing @{@link Configuration} class.
     *
     * @return the class names, or an empty array if none
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
            EdenAuthExceptionConfigure.class.getName(),
            EdenServerProtectInterceptor.class.getName(),
            EdenOAuth2FeignConfigure.class.getName()
        };
    }
}
