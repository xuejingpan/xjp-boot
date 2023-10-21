package com.xuejingpan.xjpboot.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuejingpan.xjpboot.common.constant.Mdc;
import com.xuejingpan.xjpboot.common.util.BeanUtil;
import com.xuejingpan.xjpboot.dao.entity.UserDO;
import com.xuejingpan.xjpboot.dao.mapper.UserMapper;
import com.xuejingpan.xjpboot.service.UserService;
import com.xuejingpan.xjpboot.web.dto.UserDTO;
import com.xuejingpan.xjpboot.web.dto.UserPageDTO;
import com.xuejingpan.xjpboot.web.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author xuejingpan
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserVO getUser(Integer id) {
        UserDO userDO = userMapper.selectById(id);
        return BeanUtil.copyFrom(userDO, UserVO::new);
    }

    @Override
    public void addUser(UserDTO userDTO) {
        UserDO userDO = BeanUtil.copyFrom(userDTO, UserDO::new);
        userMapper.insert(userDO);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        UserDO userDO = BeanUtil.copyFrom(userDTO, UserDO::new);
        userMapper.updateById(userDO);
    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public IPage<UserVO> getUserPage(UserPageDTO userPageDTO) {
        log.info("当前用户：{}", MDC.get(Mdc.ACCOUNT));
        Page<UserDO> userPage = new Page<>(userPageDTO.getCurrent(), userPageDTO.getSize());
        List<UserDO> userDOList = userMapper.getUserPage(userPage, userPageDTO);
        userPage.setRecords(userDOList);
        return userPage.convert(userDO -> BeanUtil.copyFrom(userDO, UserVO::new));
    }
}
