package com.xuejingpan.xjpboot.common.result;

import lombok.Data;

/**
 * @ClassName Result
 * @Description 结果
 * @Author xuejingpan
 * @Date 2023/3/1 22:51
 * @Version 1.0
 */
@Data
public class Result<T> {

    private Integer code;

    private String message;

    private T data;
}
