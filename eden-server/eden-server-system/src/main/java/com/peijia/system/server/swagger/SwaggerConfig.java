package com.peijia.system.server.swagger;

import com.peijia.system.server.properties.EdenServerSystemProperties;
import com.peijia.system.server.properties.SwaggerProperties;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Peijia
 * @className SwaggerConfig
 * @desc
 * @create 2021/3/11 9:35
 */
@Configuration
public class SwaggerConfig {

    @Autowired
    private EdenServerSystemProperties edenServerSystemProperties;

    @Bean
    public Docket createRestApi() {
        SwaggerProperties swagger = edenServerSystemProperties.getSwagger();
        return new Docket(DocumentationType.OAS_30)
            .apiInfo(apiInfo(swagger))
            .select()
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo(SwaggerProperties swagger) {
        return new ApiInfoBuilder()
            .title(swagger.getTitle())
            .description(swagger.getDescription())
            .version(swagger.getVersion())
            .build();
    }
}

