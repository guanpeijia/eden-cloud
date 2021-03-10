package com.peijia.system.server.handler;

import com.peijia.common.handler.BaseExceptionHandler;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Peijia
 * @className GlobalExceptionHandler
 * @desc 全局异常处理器 ：对于通用的异常类型捕获可以在BaseExceptionHandler中定义，而当前微服务系统独有的异常类型捕获可以在GlobalExceptionHandler中定义。
 * @create 2020/9/14 20:43
 */
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler extends BaseExceptionHandler {

}
