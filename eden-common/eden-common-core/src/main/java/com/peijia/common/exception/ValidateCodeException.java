package com.peijia.common.exception;

/**
 * @author Peijia
 * @className ValidateCodeException
 * @desc ValidateCodeException
 * @create 2021/3/1 15:06
 */
public class ValidateCodeException extends Exception {

    private static final long serialVersionUID = -2123209228637240299L;

    public ValidateCodeException(String message){
        super(message);
    }
}
