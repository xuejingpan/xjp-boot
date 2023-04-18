package com.xuejingpan.xjpboot.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuejingpan.xjpboot.dao.entity.OperationLogDO;

import java.util.List;

/**
 * @InterfaceName OperationLogMapper
 * @Description TODO
 * @Author xuejingpan
 * @Date 2023/4/9 0:15
 * @Version 1.0
 */
public interface OperationLogMapper extends BaseMapper<OperationLogDO> {

    List<OperationLogDO> getOperationLog();
}
