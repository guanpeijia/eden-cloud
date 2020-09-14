package com.peijia.auth.handler;

import com.peijia.common.handler.BaseExceptionHandler;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Peijia
 * @className GlobalExceptionHandler
 * @desc 全局异常处理器
 * @create 2020/9/14 20:43
 */
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler extends BaseExceptionHandler {

}
