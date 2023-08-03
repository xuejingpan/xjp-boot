package com.xuejingpan.xjpboot.common.exception;

import com.xuejingpan.xjpboot.common.result.ResultCode;

/**
 * @ClassName GlobalException
 * @Description 全局异常
 * @Author xuejingpan
 * @Date 2023/3/1 23:14
 */
public class GlobalException extends RuntimeException {

    private Integer code;

    public GlobalException(Integer code) {
        this.code = code;
    }

    public GlobalException(String message){
        super(message);
        this.code = -1;
    }

    public GlobalException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public GlobalException(ResultCode resultCode){
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code){
        this.code = code;
    }
}
