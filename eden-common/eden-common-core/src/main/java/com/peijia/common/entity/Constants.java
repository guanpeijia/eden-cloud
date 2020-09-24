package com.peijia.common.entity;

/**
 * @author Peijia
 * @className Constants
 * @desc 静态常量类
 * @create 2020/9/18 10:19
 */
public class Constants {

    private Constants(){}
    /**
     * Zuul请求头TOKEN名称（不要有空格）
     */
    public static final String ZUUL_TOKEN_HEADER = "ZuulToken";
    /**
     * Zuul请求头TOKEN值
     */
    public static final String ZUUL_TOKEN_VALUE = "eden:zuul:123456";
}
