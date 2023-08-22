package com.xuejingpan.xjpboot.service;

import com.xuejingpan.xjpboot.web.dto.LoginDTO;
import com.xuejingpan.xjpboot.web.vo.LoginVO;

/**
 * @Interface LoginService
 * @Description TODO
 * @Author 80010745
 * @Date 2023/8/22 17:48
 */
public interface LoginService {

    /**
     * 登录
     * @param loginDTO 账号、密码
     * @return 姓名、token...
     */
    LoginVO login(LoginDTO loginDTO);
}
