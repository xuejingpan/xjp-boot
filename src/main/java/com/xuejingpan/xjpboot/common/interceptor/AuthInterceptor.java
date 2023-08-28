package com.xuejingpan.xjpboot.common.interceptor;

import com.xuejingpan.xjpboot.common.constant.Mdc;
import com.xuejingpan.xjpboot.common.util.UUIDUtil;
import org.slf4j.MDC;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName AuthInterceptor
 * @Description TODO
 * @Author xuejingpan
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果是OPTIONS请求，则放行
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }
        MDC.put(Mdc.TRACE_ID, UUIDUtil.getUUID());
        MDC.put(Mdc.USER_ID, "111");
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 清除MDC中的数据
        MDC.clear();
    }
}
