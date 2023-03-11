package com.xuejingpan.xjpboot.service.Impl;

import cn.hutool.http.server.HttpServerRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuejingpan.xjpboot.common.util.BeanUtil;
import com.xuejingpan.xjpboot.dao.entity.UserDO;
import com.xuejingpan.xjpboot.dao.mapper.UserMapper;
import com.xuejingpan.xjpboot.service.UserService;
import com.xuejingpan.xjpboot.web.dto.UserDTO;
import com.xuejingpan.xjpboot.web.dto.UserPageDTO;
import com.xuejingpan.xjpboot.web.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author xuejingpan
 * @Date 2023/3/8 0:02
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserVO getUser(HttpServerRequest request) {
        return null;
    }

    @Override
    public void addUser(UserDTO userDTO) {

    }

    @Override
    public void updateUser(UserDTO userDTO) {

    }

    @Override
    public void deleteUser(Integer id) {

    }

    @Override
    public IPage<UserVO> getUserPage(UserPageDTO userPageDTO) {
        Long current = userPageDTO.getCurrent();
        Long size = userPageDTO.getSize();
        Page<UserDO> userPage = new Page<>(current == null ? 1L : current, size == null ? 10L : size);
        List<UserDO> userDOList = userMapper.getUserPage(userPage, userPageDTO);
        userPage.setRecords(userDOList);
        return userPage.convert(userDO -> BeanUtil.copyFrom(userDO, UserVO::new));
    }
}
