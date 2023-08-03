package com.xuejingpan.xjpboot.common.config;

import com.xuejingpan.xjpboot.common.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @ClassName WebMvcConfig
 * @Description WebMvc配置
 * @Author xuejingpan
 * @Date 2023/4/8 13:15
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                // 拦截的请求
                //.addPathPatterns("/web/**")
                // 放行的请求
                .excludePathPatterns("/login", "/register");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 允许访问的域名
                .allowedOriginPatterns("*")
                // 允许携带证书
                .allowCredentials(true)
                // 允许通过的方法
                .allowedMethods("*")
                // 允许的请求头
                .allowedHeaders("*")
                // 设置预请求的生效时间
                .maxAge(3600);
    }
}
