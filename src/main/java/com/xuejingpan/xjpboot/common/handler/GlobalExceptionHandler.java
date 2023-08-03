package com.xuejingpan.xjpboot.common.handler;

import com.xuejingpan.xjpboot.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常处理
 * @Author xuejingpan
 * @Date 2023/6/12 23:15
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
//
//    @ResponseStatus(HttpStatus.OK)
//    @ExceptionHandler(LoginException.class)
//    public Result<?> handleLoginException(LoginException e) {
//        log.warn("登录异常: [code:{}, message:{}]", e.getCode(), e.getMessage());
//        return Result.error(e.getCode());
//    }
//
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    @ExceptionHandler(TokenAuthenticationException.class)
//    public Result<Object> handleTokenAuthenticationException(TokenAuthenticationException e) {
//        log.warn("token认证异常: [code:{}, message:{}]", e.getCode(), e.getMessage());
//        return Result.error(e.getCode());
//    }
//
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(SsoAuthException.class)
//    public Result<?> handleSsoAuthException(SsoAuthException e) {
//        log.warn("自定义异常: [code:{}, message:{}]", e.getCode(), e.getMessage());
//        return Result.error(e.getCode());
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler({BindException.class,
//            ConstraintViolationException.class,
//            MissingServletRequestParameterException.class})
//    public Result<?> handleParamVerificationException(Exception e) {
//        StringBuilder errorMessage = new StringBuilder();
//        if (e instanceof BindException) {
//            BindingResult result = ((BindException) e).getBindingResult();
//            result.getAllErrors().forEach(error -> errorMessage.append("[").append(error.getDefaultMessage()).append("]"));
//        } else if (e instanceof ConstraintViolationException) {
//            Set<ConstraintViolation<?>> result = ((ConstraintViolationException) e).getConstraintViolations();
//            result.forEach(error -> errorMessage.append("[").append(error.getMessage()).append("]"));
//        } else if (e instanceof MissingServletRequestParameterException) {
//            MissingServletRequestParameterException exception = (MissingServletRequestParameterException) e;
//            errorMessage.append(exception.getParameterName()).append("不能为空");
//        }
//        log.warn("参数校验异常: {}", e.toString());
//        return Result.error(errorMessage.toString());
//    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public Result<?> handleThrowable(Throwable e) {
        log.error("{}: {}", e.toString(), e.getStackTrace());
        return Result.error();
    }
}
