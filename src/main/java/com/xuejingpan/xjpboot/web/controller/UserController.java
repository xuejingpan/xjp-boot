package com.xuejingpan.xjpboot.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xuejingpan.xjpboot.common.annotation.OperationLog;
import com.xuejingpan.xjpboot.common.result.ResponseResult;
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
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    public ResponseResult<UserVO> getUser() {
        return ResponseResult.success(userService.getUser());
    }

    @PostMapping
    public ResponseResult<?> addUser(UserDTO userDTO) {
        userService.addUser(userDTO);
        return ResponseResult.success();
    }

    @PutMapping
    public ResponseResult<?> updateUser(UserDTO userDTO) {
        userService.updateUser(userDTO);
        return ResponseResult.success();
    }

    @OperationLog(content = "注销用户")
    @DeleteMapping("admin/{id}")
    public ResponseResult<?> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return ResponseResult.success();
    }

    @OperationLog(content = "分页查询用户")
    @GetMapping("admin/user")
    public ResponseResult<IPage<UserVO>> getUserPage(UserPageDTO userPageDTO) {
        return ResponseResult.success(userService.getUserPage(userPageDTO));
    }
}
