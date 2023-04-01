package com.xuejingpan.xjpboot.common.annotation;

import com.xuejingpan.xjpboot.common.enums.LogType;

import java.lang.annotation.*;

/**
 * @AnnotationName Log
 * @Description 日志注解
 * @Author xuejingpan
 * @Date 2023/3/30 22:27
 * @Version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * 标题
     */
    String title() default "";

    /**
     * 日志类型
     */
    LogType type() default LogType.OTHER;

    /**
     * 是否保存到数据库
     */
    boolean isSaveToDb() default false;
}
