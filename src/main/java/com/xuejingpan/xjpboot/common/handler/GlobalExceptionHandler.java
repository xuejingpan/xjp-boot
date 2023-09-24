package com.xuejingpan.xjpboot.common.handler;

import com.xuejingpan.xjpboot.common.exception.AuthenticationException;
import com.xuejingpan.xjpboot.common.exception.AuthorizationException;
import com.xuejingpan.xjpboot.common.exception.GlobalException;
import com.xuejingpan.xjpboot.common.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常处理
 * @Author xuejingpan
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


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseResult<?> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.warn("参数校验异常: {}", e.toString());
        return ResponseResult.fail(e.getParameterName() + "不能为空");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BindException.class, ConstraintViolationException.class})
    public ResponseResult<?> handleParamVerification(Exception e) {
        List<String> errorMessage = new ArrayList<>();
        if (e instanceof BindException) {
            BindingResult result = ((BindException) e).getBindingResult();
            result.getAllErrors().forEach(error -> errorMessage.add(error.getDefaultMessage()));
        } else if (e instanceof ConstraintViolationException) {
            Set<ConstraintViolation<?>> result = ((ConstraintViolationException) e).getConstraintViolations();
            result.forEach(error -> errorMessage.add(error.getMessage()));
        }
        log.warn("参数校验异常: {}", e.toString());
        return ResponseResult.fail(errorMessage.toString());
    }

//    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(value = { BindException.class, ValidationException.class, MethodArgumentNotValidException.class })
//    public ResponseResult<?> handleParameterVerificationException(@NonNull Exception e) {
//        ExceptionData.ExceptionDataBuilder exceptionDataBuilder = ExceptionData.builder();
//        if (e instanceof BindException) {
//            BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
//            bindingResult.getAllErrors()
//                    .forEach(a -> exceptionDataBuilder.data(((FieldError) a).getField() + ": " + a.getDefaultMessage()));
//        } else if (e instanceof ConstraintViolationException) {
//            if (e.getMessage() != null) {
//                ResponseResult.fail(e.getMessage());
//            }
//        } else {
//            ResponseResult.fail("invalid parameter");
//        }
//        return ResponseResult.fail("invalid parameter");
//    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseResult<?> handleMaxUploadSizeExceededException(SizeLimitExceededException e) {
        log.warn("文件过大异常: {}", e.getMessage());
        return ResponseResult.fail(e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(GlobalException.class)
    public ResponseResult<?> handleGlobalException(GlobalException e) {
        log.warn("全局异常: {}", e.getMessage());
        return ResponseResult.fail(e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ResponseResult<?> handleThrowable(Throwable throwable) {
        log.error("内部错误: {}", throwable.toString());
        return ResponseResult.fail(throwable.getMessage());
    }
}
