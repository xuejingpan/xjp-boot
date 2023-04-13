package com.xuejingpan.xjpboot.common.annotation;

import com.xuejingpan.xjpboot.common.enums.LogType;

import java.lang.annotation.*;

/**
 * @AnnotationName OperationLog
 * @Description 操作日志注解
 * @Author xuejingpan
 * @Date 2023/3/30 22:27
 * @Version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLog {

    /**
     * 内容
     * 当日志类型为系统日志时此字段无效
     */
    String content() default "";
}
