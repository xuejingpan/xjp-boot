package com.xuejingpan.xjpboot.web.controller;

import com.xuejingpan.xjpboot.common.result.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description 测试
 * @Author xuejingpan
 */
@RestController
public class TestController {

    @GetMapping
    public ResponseResult<?> test() {
        return ResponseResult.success("Test success !");
    }
}
