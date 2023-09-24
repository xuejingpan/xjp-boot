package com.xuejingpan.xjpboot.web.controller;

import com.xuejingpan.xjpboot.common.result.ResponseResult;
import com.xuejingpan.xjpboot.service.LoginService;
import com.xuejingpan.xjpboot.web.dto.LoginDTO;
import com.xuejingpan.xjpboot.web.vo.LoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author xuejingpan
 */
@Api(tags = "登录")
@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @ApiOperation("登录")
    @PostMapping("login")
    public ResponseResult<LoginVO> login(@Validated @RequestBody LoginDTO loginDTO) {
        return ResponseResult.success(loginService.login(loginDTO));
    }

    @ApiOperation("登出")
    @DeleteMapping("logout")
    public ResponseResult<?> logout() {
        return ResponseResult.success();
    }

    @ApiOperation("注册")
    @PostMapping("register")
    public ResponseResult<?> register() {
        return ResponseResult.success();
    }
}
