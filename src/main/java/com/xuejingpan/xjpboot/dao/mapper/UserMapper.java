package com.xuejingpan.xjpboot.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xuejingpan.xjpboot.dao.entity.UserDO;
import com.xuejingpan.xjpboot.web.dto.UserPageDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @InterfaceName UserMapper
 * @Description TODO
 * @Author xuejingpan
 */
@Repository
public interface UserMapper extends BaseMapper<UserDO> {

    List<UserDO> getUserPage(IPage<UserDO> page, @Param("user") UserPageDTO user);
}
