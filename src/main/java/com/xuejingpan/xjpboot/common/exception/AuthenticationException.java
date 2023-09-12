package com.xuejingpan.xjpboot.common.exception;

/**
 * @ClassName AuthenticationException
 * @Description 认证异常（认证：你是谁）
 * @Author xuejingpan
 */
public class AuthenticationException extends RuntimeException {

    public AuthenticationException(String message) {
        super(message);
    }
}
