package com.xuejingpan.xjpboot.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName LogAspect
 * @Description TODO
 * @Author xuejingpan
 * @Date 2023/3/30 22:28
 * @Version 1.0
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("@annotation(com.xuejingpan.xjpboot.common.annotation.Log)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        boolean isSuccess = false;
        startTime.set(System.currentTimeMillis());
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        }
        isSuccess = true;
        log.info("执行耗时：{}毫秒", System.currentTimeMillis() - startTime.get());
        log.info("执行{}", isSuccess ? "成功" : "失败");
        startTime.remove();
        return result;
    }
}
