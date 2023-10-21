package com.xuejingpan.xjpboot.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xuejingpan.xjpboot.common.annotation.OperationLog;
import com.xuejingpan.xjpboot.common.result.ResponseResult;
import com.xuejingpan.xjpboot.common.validation.Insert;
import com.xuejingpan.xjpboot.common.validation.Update;
import com.xuejingpan.xjpboot.service.UserService;
import com.xuejingpan.xjpboot.web.dto.UserDTO;
import com.xuejingpan.xjpboot.web.dto.UserPageDTO;
import com.xuejingpan.xjpboot.web.vo.UserVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author xuejingpan
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    @Resource
    private UserService userService;

    @OperationLog(content = "分页查询用户")
    @GetMapping("user")
    public ResponseResult<IPage<UserVO>> getUserPage(UserPageDTO userPageDTO) {
        return ResponseResult.success(userService.getUserPage(userPageDTO));
    }

    @OperationLog(content = "添加用户")
    @PostMapping("user")
    public ResponseResult<?> addUser(@Validated(Insert.class) @RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
        return ResponseResult.success();
    }

    @OperationLog(content = "更新用户信息")
    @PutMapping("user")
    public ResponseResult<?> updateUser(@Validated(Update.class) @RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
        return ResponseResult.success();
    }

    @OperationLog(content = "删除用户")
    @DeleteMapping("user/{id}")
    public ResponseResult<?> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return ResponseResult.success();
    }
}
