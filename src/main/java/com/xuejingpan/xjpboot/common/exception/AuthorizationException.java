package com.xuejingpan.xjpboot.common.exception;

/**
 * @ClassName AuthorizationException
 * @Description 授权异常（授权：你能干什么）
 * @Author xuejingpan
 */
public class AuthorizationException extends RuntimeException {

    public AuthorizationException(String message) {
        super(message);
    }
}
