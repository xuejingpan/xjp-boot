package com.xuejingpan.xjpboot.common.result;

/**
 * @EnumName ResultCode
 * @Description 返回码
 * @Author xuejingpan
 */
public enum ResultCode {

    /**
     * 请求成功
     */
    SUCCESS(0, "success"),

    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(-1, "Internal Server Error"),

    NOT_LOGIN(10001, "未登录"),
    TOKEN_EMPTY(9001, "token为空"),
    TOKEN_ERROR(9002, "token无效"),
    TOKEN_EXPIRED(9003, "token已过期"),

    USER_NOT_EXIST(10002, "用户不存在"),
    PASSWORD_ERROR(10002, "密码错误"),

    BAD_REQUEST(40001, "参数校验异常：%s");

    private final Integer code;

    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
