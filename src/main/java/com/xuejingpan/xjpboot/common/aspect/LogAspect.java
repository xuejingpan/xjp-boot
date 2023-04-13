package com.xuejingpan.xjpboot.common.aspect;

import cn.hutool.json.JSONUtil;
import com.xuejingpan.xjpboot.common.annotation.OperationLog;
import com.xuejingpan.xjpboot.common.enums.LogType;
import com.xuejingpan.xjpboot.service.HttpServletRequestService;
import com.xuejingpan.xjpboot.service.LogService;
import com.xuejingpan.xjpboot.service.bo.OperationLogBO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Arrays;

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

    private final ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Resource
    private LogService logService;

    @Resource
    private HttpServletRequestService httpServletRequestService;

//    @Pointcut("@annotation(com.xuejingpan.xjpboot.common.annotation.OperationLog)")
//    public void logPointCut() {
//    }

    @Pointcut("execution(public * com.xuejingpan.xjpboot.web.controller..*.*(..))")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String requestData = Arrays.toString(joinPoint.getArgs());
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        // 判断方法是否添加了@OperationLog注解
        if (method.isAnnotationPresent(OperationLog.class)) {
            log.info("方法是添加了@OperationLog注解");
        }
        OperationLogBO operationLogBO = new OperationLogBO();
        Object result = null;
        startTime.set(System.currentTimeMillis());
        try {
            result = joinPoint.proceed();
            operationLogBO.setExecutionTime(System.currentTimeMillis() - startTime.get());
            operationLogBO.setResponseData(result.toString());
            operationLogBO.setSuccess(true);
            return result;
        } catch (Throwable throwable) {
            operationLogBO.setExecutionTime((System.currentTimeMillis() - startTime.get()));
            operationLogBO.setResponseData(throwable.toString());
            operationLogBO.setSuccess(false);
            result = throwable;
            throw throwable;
        } finally {
            startTime.remove();
            log.debug("request:{}", requestData);
            assert result != null;
            log.debug("response:{}", result.toString());
            logService.saveOperationLog(operationLogBO);
        }
    }

//    private void saveSystemLog(ProceedingJoinPoint joinPoint) throws Throwable {
//        String request = Arrays.toString(joinPoint.getArgs());
//        Object response = joinPoint.proceed();
//        log.info("request:{}, response:{}", request, response);
//    }
//
//    private void setOperationLogBO(ProceedingJoinPoint joinPoint, OperationLogBO operationLogBO) {
//        String account = httpServletRequestService.getAccount();
//        operationLogBO.setAccount(account);
//        String username = httpServletRequestService.getUsername();
//        operationLogBO.setUsername(username);
//    }
}
