package com.xuejingpan.xjpboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xuejingpan.xjpboot.service.bo.OperationLogBO;
import com.xuejingpan.xjpboot.web.dto.OperationLogPageDTO;
import com.xuejingpan.xjpboot.web.vo.OperationLogVO;

/**
 * @InterfaceName LogService
 * @Description TODO
 * @Author xuejingpan
 * @Date 2023/4/9 0:18
 * @Version 1.0
 */
public interface LogService {

    /**
     * 保存操作日志（异步）
     * @param operationLogBO 操作日志对象
     */
    void saveOperationLog(OperationLogBO operationLogBO);

    /**
     * 查询操作日志（分页）
     * @param operationLogPageDTO 分页模糊查询对象
     * @return 操作日志
     */
    IPage<OperationLogVO> getOperationLog(OperationLogPageDTO operationLogPageDTO);
}
