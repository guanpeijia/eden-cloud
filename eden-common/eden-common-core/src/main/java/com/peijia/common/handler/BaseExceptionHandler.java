package com.peijia.common.handler;

import com.peijia.common.base.BaseResponse;
import javax.security.auth.message.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Peijia
 * @className BaseExceptionHandler
 * @desc 全局异常处理器
 * @create 2020/9/14 20:23
 */
@Slf4j
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse handleException(Exception e) {
        log.error("系统内部异常，异常信息", e);
        return new BaseResponse().message("系统内部异常");
    }

    @ExceptionHandler(value = AuthException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse handleAuthException(AuthException e) {
        log.error("系统错误", e);
        return new BaseResponse().message(e.getMessage());
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public BaseResponse handleAccessDeniedException(){
        return new BaseResponse().message("没有权限访问该资源");
    }
}
