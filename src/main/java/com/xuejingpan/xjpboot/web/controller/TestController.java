package com.xuejingpan.xjpboot.web.controller;

import com.xuejingpan.xjpboot.common.result.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description 测试
 * @Author xuejingpan
 * @Date 2023/3/2 23:34
 * @Version 1.0
 */
@RestController
public class TestController {

    @GetMapping
    public ResponseResult<?> test() {
        return ResponseResult.success("Test success !");
    }
}
