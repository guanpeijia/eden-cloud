package com.peijia.common.exception;

/**
 * @author Peijia
 * @className BusinessException
 * @desc 业务异常类
 * @create 2021/3/6 15:11
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -1320072239109107944L;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
