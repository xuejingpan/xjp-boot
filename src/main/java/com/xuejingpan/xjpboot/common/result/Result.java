package com.xuejingpan.xjpboot.common.result;

import lombok.Data;

/**
 * @ClassName Result
 * @Description 统一返回结果
 * @Author xuejingpan
 * @Date 2023/3/1 22:51
 * @Version 1.0
 */
@Data
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public Result() {
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success() {
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage());
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static Result<?> error() {
        return new Result<>(ResultCode.INTERNAL_SERVER_ERROR.getCode(), ResultCode.INTERNAL_SERVER_ERROR.getMessage(), null);
    }

    public static <T> Result<T> instance(Integer code, String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}
