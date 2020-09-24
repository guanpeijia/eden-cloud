package com.peijia.common.base;

import java.io.Serializable;
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
@SuppressWarnings({"rawtypes", "unchecked"})
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 44266938953077267L;

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

    @SuppressWarnings({"rawtypes", "unchecked"})
    public BaseResponse message(String message){
        this.code = CODE_ERROR;
        this.message = message;
        return this;
    }
}
