package com.xuejingpan.xjpboot.common.exception;

import com.xuejingpan.xjpboot.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalException
 * @Description 全局异常
 * @Author xuejingpan
 * @Date 2023/3/1 23:14
 * @Version 1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalException extends RuntimeException {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public Result<?> handleThrowable(Throwable e) {
        log.error("{}, 堆栈追踪信息: {}", e.toString(), e.getStackTrace());
        return Result.error();
    }
}
