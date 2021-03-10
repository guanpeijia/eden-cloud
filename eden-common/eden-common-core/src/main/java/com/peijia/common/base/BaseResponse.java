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

    public static <T> BaseResponse<T> success(T data) {
        BaseResponse<T> basicResponseVo = new BaseResponse<>();
        basicResponseVo.setCode(CODE_SUCCESS);
        basicResponseVo.setData(data);
        return basicResponseVo;
    }

    public static <T> BaseResponse<T> success() {
        return success(null);
    }

    public static <T> BaseResponse<T> error(String message) {
        BaseResponse<T> basicResponseVo = new BaseResponse<>();
        basicResponseVo.setCode(CODE_ERROR);
        basicResponseVo.setMessage(message);
        return basicResponseVo;
    }

    public static <T> BaseResponse<T> error(T context) {
        BaseResponse<T> basicResponseVo = new BaseResponse<>();
        basicResponseVo.setCode(CODE_ERROR);
        basicResponseVo.setData(context);
        return basicResponseVo;
    }

    public static <T> BaseResponse<T> error(T context,Integer code) {
        BaseResponse<T> basicResponseVo = new BaseResponse<>();
        basicResponseVo.setCode(CODE_ERROR);
        basicResponseVo.setData(context);
        return basicResponseVo;
    }

}
