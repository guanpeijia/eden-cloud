package com.peijia.common.base;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Peijia
 * @className BaseResponse
 * @desc 通用返回对象
 * @create 2020/8/15 20:22
 */
@Data
@NoArgsConstructor
@SuppressWarnings("all")
public class BaseResponse<T> {

    /**
     * 成功返回码
     */
    public static final String CODE_SUCCESS = "0";

    /**
     * 失败返回码
     */
    public static final String CODE_ERROR = "-1";

    private String code;

    private T data;

    private String message;

    public BaseResponse message(String message){
        this.code = CODE_ERROR;
        this.message = message;
        return this;
    }
}
