package com.peijia.system.server.properties;

import lombok.Data;

/**
 * @author Peijia
 * @className SwaggerProperties
 * @desc
 * @create 2021/3/11 9:54
 */
@Data
public class SwaggerProperties {
    private String basePackage;
    private String title;
    private String description;
    private String version;
    private String author;
    private String url;
    private String email;
    private String license;
    private String licenseUrl;
}
