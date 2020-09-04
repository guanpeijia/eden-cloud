package com.peijia.auth.domain;

/**
 * @author Peijia
 * @className AuthException
 * @desc 鉴权异常类
 * @create 2020/8/15 20:35
 */
public class AuthException extends Exception {

    private static final long serialVersionUID = 2036426077595181748L;

    public AuthException(String message){
        super(message);
    }
}
