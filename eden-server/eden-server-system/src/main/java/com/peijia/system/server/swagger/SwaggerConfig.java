package com.peijia.system.server.swagger;

import com.peijia.system.server.properties.EdenServerSystemProperties;
import com.peijia.system.server.properties.SwaggerProperties;
import java.util.Arrays;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Peijia
 * @className SwaggerConfig
 * @desc
 * @create 2021/3/11 9:35
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    private EdenServerSystemProperties edenServerSystemProperties;

    @Bean
    public Docket swaggerApi() {
        SwaggerProperties swagger = edenServerSystemProperties.getSwagger();
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage(swagger.getBasePackage()))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo(swagger))
            .securitySchemes(Collections.singletonList(securityScheme(swagger)))
            .securityContexts(Collections.singletonList(securityContext(swagger)));
    }

    private ApiInfo apiInfo(SwaggerProperties swagger) {
        return new ApiInfo(
            swagger.getTitle(),
            swagger.getDescription(),
            swagger.getVersion(),
            null,
            new Contact(swagger.getAuthor(), swagger.getUrl(), swagger.getEmail()),
            swagger.getLicense(), swagger.getLicenseUrl(), Collections.emptyList());
    }

    private SecurityScheme securityScheme(SwaggerProperties swagger) {
        GrantType grantType = new ResourceOwnerPasswordCredentialsGrant(swagger.getGrantUrl());

        return new OAuthBuilder()
            .name(swagger.getName())
            .grantTypes(Collections.singletonList(grantType))
            .scopes(Arrays.asList(scopes(swagger)))
            .build();
    }

    private SecurityContext securityContext(SwaggerProperties swagger) {
        return SecurityContext.builder()
            .securityReferences(Collections.singletonList(new SecurityReference(swagger.getName(), scopes(swagger))))
            .forPaths(PathSelectors.any())
            .build();
    }

    private AuthorizationScope[] scopes(SwaggerProperties swagger) {
        return new AuthorizationScope[]{
            new AuthorizationScope(swagger.getScope(), "")
        };
    }
}

