package com.xuejingpan.xjpboot.common.handler;

import com.xuejingpan.xjpboot.common.exception.AuthenticationException;
import com.xuejingpan.xjpboot.common.exception.AuthorizationException;
import com.xuejingpan.xjpboot.common.exception.ExceptionData;
import com.xuejingpan.xjpboot.common.exception.GlobalException;
import com.xuejingpan.xjpboot.common.result.ResponseResult;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
     * 知乎：账号不存在：401，密码错误：400
     */

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthenticationException.class)
    public ResponseResult<?> handleAuthenticationException(AuthenticationException e) {
        log.warn("认证异常: {}", e.getMessage());
        return ResponseResult.fail(e.getMessage());
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AuthorizationException.class)
    public ResponseResult<?> handleAuthorizationException(AuthorizationException e) {
        log.warn("授权异常: {}", e.getMessage());
        return ResponseResult.fail(e.getMessage());
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(GlobalException.class)
    public ResponseResult<?> handleGlobalException(GlobalException e) {
        log.warn("全局异常: {}", e.getMessage());
        return ResponseResult.fail(e.getMessage());
    }

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
        ExceptionData.ExceptionDataBuilder exceptionDataBuilder = ExceptionData.builder();
        if (e instanceof BindException) {
            BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
            bindingResult.getAllErrors()
                    .forEach(a -> exceptionDataBuilder.data(((FieldError) a).getField() + ": " + a.getDefaultMessage()));
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
