package com.xuejingpan.xjpboot.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName Knife4jConfig
 * @Description TODO
 * @Author xuejingpan
 * @Date 2023/3/16 23:26
 * @Version 1.0
 */
@Configuration
@EnableSwagger2
public class Knife4jConfig {

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(new ApiInfoBuilder()
                    .title("xjp-boot")
                    .description("基于Spring Boot的模板项目")
                    .license("MIT license")
                    .termsOfServiceUrl("https://github.com/xuejingpan/xjp-boot")
                    .contact(new Contact("xuejingpan", "https://github.com/xuejingpan", "xuejingpan@qq.com"))
                    .version("1.0.0")
                    .build())
                .groupName("1.0.0版本")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xuejingpan.xjpboot.web.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
