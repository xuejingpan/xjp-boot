package com.xuejingpan.xjpboot.web.controller;

import com.xuejingpan.xjpboot.common.result.Result;
import com.xuejingpan.xjpboot.web.vo.LoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author xuejingpan
 * @Date 2023/3/12 23:42
 * @Version 1.0
 */
@Api(tags = "登录")
@RestController
public class LoginController {

    @ApiOperation("登录")
    @PostMapping("login")
    public Result<LoginVO> login() {
        return Result.success();
    }

    @ApiOperation("登出")
    @PostMapping("logout")
    public Result<?> logout() {
        return Result.success();
    }

    @ApiOperation("注册")
    @PostMapping("register")
    public Result<?> register() {
        return Result.success();
    }
}
