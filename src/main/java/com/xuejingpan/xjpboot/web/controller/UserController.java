package com.xuejingpan.xjpboot.web.controller;

import cn.hutool.http.server.HttpServerRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xuejingpan.xjpboot.common.annotation.Log;
import com.xuejingpan.xjpboot.common.result.Result;
import com.xuejingpan.xjpboot.service.UserService;
import com.xuejingpan.xjpboot.web.dto.UserDTO;
import com.xuejingpan.xjpboot.web.dto.UserPageDTO;
import com.xuejingpan.xjpboot.web.vo.UserVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author xuejingpan
 * @Date 2023/3/9 0:26
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    public Result<UserVO> getUser(HttpServerRequest request) {
        return Result.success(userService.getUser(request));
    }

    @PostMapping
    public Result<?> addUser(UserDTO userDTO) {
        userService.addUser(userDTO);
        return Result.success();
    }

    @PutMapping
    public Result<?> updateUser(UserDTO userDTO) {
        userService.updateUser(userDTO);
        return Result.success();
    }

    @DeleteMapping
    public Result<?> deleteUser(Integer id) {
        userService.deleteUser(id);
        return Result.success();
    }

    //@Log
    @GetMapping("/admin")
    public Result<IPage<UserVO>> getUserPage(UserPageDTO userPageDTO) {
        return Result.success(userService.getUserPage(userPageDTO));
    }
}
