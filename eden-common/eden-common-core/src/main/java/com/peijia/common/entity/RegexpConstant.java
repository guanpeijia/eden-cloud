package com.peijia.common.entity;

/**
 * @author Peijia
 * @className RegexpConstant
 * @desc 正则表达式常量
 * @create 2021/3/10 10:33
 */
public class RegexpConstant {

    /**
     * 简单手机号正则（这里只是简单校验是否为 11位，实际规则更复杂）
     */
    public static final String MOBILE_REG = "[1]\\d{10}";
}
