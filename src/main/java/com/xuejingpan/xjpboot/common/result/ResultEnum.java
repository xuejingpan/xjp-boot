package com.xuejingpan.xjpboot.common.result;

/**
 * @EnumName ResultEnum
 * @Description 返回结果枚举
 * @Author xuejingpan
 * @Date 2023/3/1 22:55
 * @Version 1.0
 */
public enum ResultEnum {

    /**
     * 请求成功
     */
    SUCCESS(0, "success"),

    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(-1, "Internal Server Error"),

    BAD_REQUEST(10001, "参数校验异常：%");

    private final Integer code;

    private final String message;

    ResultEnum(Integer code, String message) {
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
