package com.xuejingpan.xjpboot.common.result;

/**
 * @EnumName ResultEnum
 * @Description 结果枚举
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
     * 请求失败
     */
    FAIL(-1, "fail");

    private Integer code;

    private String message;

    ResultEnum() {
    }

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
