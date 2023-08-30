package com.xuejingpan.xjpboot.service.Impl;

import com.xuejingpan.xjpboot.common.util.JwtUtil;
import com.xuejingpan.xjpboot.service.LoginService;
import com.xuejingpan.xjpboot.web.dto.LoginDTO;
import com.xuejingpan.xjpboot.web.vo.LoginVO;
import org.springframework.stereotype.Service;

/**
 * @ClassName LoginServiceImpl
 * @Description TODO
 * @Author xuejingpan
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public LoginVO login(LoginDTO loginDTO) {
        String token = JwtUtil.createToken(loginDTO.getAccount());
        LoginVO loginVO = new LoginVO();
        loginVO.setAccount(loginDTO.getAccount());
        loginVO.setToken(token);
        return loginVO;
    }
}
