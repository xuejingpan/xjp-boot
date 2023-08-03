package com.xuejingpan.xjpboot.common.aspect;

import com.xuejingpan.xjpboot.common.annotation.OperationLog;
import com.xuejingpan.xjpboot.service.HttpServletRequestService;
import com.xuejingpan.xjpboot.service.LogService;
import com.xuejingpan.xjpboot.service.bo.OperationLogBO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
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
@Aspect
@Component
public class LogAspect {

    private final ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Resource
    private LogService logService;

    @Resource
    private HttpServletRequestService httpServletRequestService;

    /**
     * 当前注解内容表示切点为添加了@OperationLog注解的方法
     * 如果想设置切点为所有controller类的public方法，则在@Pointcut中添加以下内容：
     * "execution(public * com.xuejingpan.xjpboot.web.controller..*.*(..))"
     */
    @Pointcut("@annotation(com.xuejingpan.xjpboot.common.annotation.OperationLog)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        OperationLogBO operationLogBO = initOperationLogBO(joinPoint);
        Object result;
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
            throw throwable;
        } finally {
            startTime.remove();
            logService.saveOperationLog(operationLogBO);
        }
    }

    private OperationLogBO initOperationLogBO(ProceedingJoinPoint joinPoint) {
        String requestData = Arrays.toString(joinPoint.getArgs());
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        String methodName = method.getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        OperationLog operationLog = method.getAnnotation(OperationLog.class);
        OperationLogBO operationLogBO = new OperationLogBO();
        operationLogBO.setMethodName(className + "." + methodName);
        String account = httpServletRequestService.getAccount();
        operationLogBO.setAccount(account);
        String username = httpServletRequestService.getUsername();
        operationLogBO.setUsername(username);
        operationLogBO.setRequestData(requestData);
        operationLogBO.setContent(operationLog.content());
        operationLogBO.setAccount(MDC.get("account"));
        operationLogBO.setUsername(MDC.get("username"));
        return operationLogBO;
    }
}
