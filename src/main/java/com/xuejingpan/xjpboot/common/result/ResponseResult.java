package com.xuejingpan.xjpboot.common.result;

import lombok.Data;

/**
 * @ClassName ResponseResult
 * @Description 统一返回结果
 * @Author xuejingpan
 */
@Data
public class ResponseResult<T> {

    private Integer code;

    private String message;

    private T data;

    public ResponseResult() {
    }

    public ResponseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseResult<T> success() {
        return new ResponseResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage());
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static ResponseResult<?> fail() {
        return new ResponseResult<>(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage(), null);
    }

    public static ResponseResult<?> fail(String message) {
        return new ResponseResult<>(ResultCode.FAIL.getCode(), message, null);
    }

    public static <T> ResponseResult<T> instance(Integer code, String message, T data) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(code);
        responseResult.setMessage(message);
        responseResult.setData(data);
        return responseResult;
    }
}
