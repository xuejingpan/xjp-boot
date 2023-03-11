package com.xuejingpan.xjpboot.service;

import cn.hutool.http.server.HttpServerRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuejingpan.xjpboot.web.dto.UserDTO;
import com.xuejingpan.xjpboot.web.dto.UserPageDTO;
import com.xuejingpan.xjpboot.web.vo.UserVO;

/**
 * @InterfaceName UserService
 * @Description TODO
 * @Author xuejingpan
 * @Date 2023/3/7 23:45
 * @Version 1.0
 */
public interface UserService {

    /**
     * 查询当前用户
     * @param request http请求
     * @return 当前用户信息
     */
    UserVO getUser(HttpServerRequest request);

    /**
     * 添加用户
     * @param userDTO 用户信息
     */
    void addUser(UserDTO userDTO);

    /**
     * 更新用户信息
     * @param userDTO 用户信息
     */
    void updateUser(UserDTO userDTO);

    /**
     * 删除用户
     * @param id 用户id
     */
    void deleteUser(Integer id);

    /**
     * 分页查询用户
     * @param userPageDTO 分页查询用户对象
     * @return 分页后的用户
     */
    IPage<UserVO> getUserPage(UserPageDTO userPageDTO);
}
