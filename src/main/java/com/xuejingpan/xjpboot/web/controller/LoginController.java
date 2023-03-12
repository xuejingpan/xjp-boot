package com.xuejingpan.xjpboot.web.controller;

import com.xuejingpan.xjpboot.common.result.Result;
import com.xuejingpan.xjpboot.web.vo.LoginVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author xuejingpan
 * @Date 2023/3/12 23:42
 * @Version 1.0
 */
@RestController
public class LoginController {

    @PostMapping("login")
    public Result<LoginVO> login() {
        return Result.success();
    }

    @PostMapping("logout")
    public Result<?> logout() {
        return Result.success();
    }

    @PostMapping("register")
    public Result<?> register() {
        return Result.success();
    }
}
