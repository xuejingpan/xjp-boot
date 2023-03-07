package com.xuejingpan.xjpboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
     * 分页查询用户
     * @param userPageDTO 分页查询用户对象
     * @return 分页后的用户
     */
    Page<UserVO> getUserPage(UserPageDTO userPageDTO);
}
