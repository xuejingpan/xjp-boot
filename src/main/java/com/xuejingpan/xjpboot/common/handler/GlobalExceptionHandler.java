package com.xuejingpan.xjpboot.common.handler;

import com.xuejingpan.xjpboot.common.result.ResponseResult;
import com.xuejingpan.xjpboot.common.result.ResultCode;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.login.LoginException;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常处理
 * @Author xuejingpan
 * @Date 2023/6/12 23:15
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * org.springframework.web.HttpRequestMethodNotSupportedException: Request method 'GET' not supported
     */

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(LoginException.class)
    public ResponseResult<?> handleLoginException(LoginException e) {
        log.warn("登录异常: {}", e.getMessage());
        return ResponseResult.fail(e.getMessage());
    }
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

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler({BindException.class,
//            ConstraintViolationException.class,
//            MissingServletRequestParameterException.class})
//    public Result<?> handleParamVerificationException(Exception e) {
//        StringBuilder errorMessage = new StringBuilder();
//        if (e instanceof BindException) {
//            BindingResult result = ((BindException) e).getBindingResult();
//            result.getAllErrors().forEach(error -> errorMessage.append(error.getDefaultMessage()).append("、"));
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

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = { BindException.class, ValidationException.class, MethodArgumentNotValidException.class })
    public ResponseResult<?> handleParameterVerificationException(@NonNull Exception e) {
        log.warn("Exception: {}", e.getMessage());
        if (e instanceof BindException) {
            BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
            bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .forEach(ResponseResult::fail);
        } else if (e instanceof ConstraintViolationException) {
            if (e.getMessage() != null) {
                ResponseResult.fail(e.getMessage());
            }
        } else {
            ResponseResult.fail("invalid parameter");
        }
        return ResponseResult.fail("invalid parameter");
    }
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ResponseResult<?> handleThrowable(Throwable e) {
        log.error("{}: {}", e.toString(), e.getStackTrace());
        return ResponseResult.fail();
    }
}
