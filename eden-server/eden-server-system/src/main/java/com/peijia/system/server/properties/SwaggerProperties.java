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
    /**
     * 是否开启swagger，生产环境一般关闭，所以这里定义一个变量
     */
    private Boolean enable;

    private String basePackage;
    private String title;
    private String description;
    private String version;
    private String author;
    private String url;
    private String email;
    private String license;
    private String licenseUrl;
    /**
     * 接口调试地址
     */
    private String tryHost;

    private String grantUrl;

    private String name;

    private String scope;

}
