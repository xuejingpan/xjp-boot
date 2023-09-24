package com.xuejingpan.xjpboot.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xuejingpan.xjpboot.dao.entity.OperationLogDO;
import com.xuejingpan.xjpboot.web.dto.OperationLogPageDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName OperationLogMapper
 * @Description TODO
 * @Author xuejingpan
 */
public interface OperationLogMapper extends BaseMapper<OperationLogDO> {

    /**
     * 分页查询操作日志
     * @param page 分页对象
     * @param operationLog 操作日志入参
     * @return 操作日志集合
     */
    List<OperationLogDO> getOperationLog(IPage<OperationLogDO> page, @Param("operationLog") OperationLogPageDTO operationLog);
}
