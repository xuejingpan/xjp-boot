package com.xuejingpan.xjpboot.common.result;

/**
 * @EnumName ResultCode
 * @Description 返回码
 * @Author xuejingpan
 * @Date 2023/3/1 22:55
 * @Version 1.0
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
