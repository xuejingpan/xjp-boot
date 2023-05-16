package com.xuejingpan.xjpboot.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuejingpan.xjpboot.common.util.BeanUtil;
import com.xuejingpan.xjpboot.dao.entity.OperationLogDO;
import com.xuejingpan.xjpboot.dao.mapper.OperationLogMapper;
import com.xuejingpan.xjpboot.service.LogService;
import com.xuejingpan.xjpboot.service.bo.OperationLogBO;
import com.xuejingpan.xjpboot.web.dto.OperationLogPageDTO;
import com.xuejingpan.xjpboot.web.vo.OperationLogVO;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName LogServiceImpl
 * @Description TODO
 * @Author xuejingpan
 * @Date 2023/4/9 0:22
 * @Version 1.0
 */
@Service
public class LogServiceImpl implements LogService {

    @Resource
    private OperationLogMapper operationLogMapper;

    @Async
    @Override
    public void saveOperationLog(OperationLogBO operationLogBO) {
        OperationLogDO operationLogDO = BeanUtil.copyFrom(operationLogBO, OperationLogDO::new);
        operationLogMapper.insert(operationLogDO);
    }

    @Override
    public IPage<OperationLogVO> getOperationLog(OperationLogPageDTO operationLogPageDTO) {
        Page<OperationLogDO> operationLogPage = new Page<>(operationLogPageDTO.getCurrent(), operationLogPageDTO.getSize());
        List<OperationLogDO> operationLogDOList = operationLogMapper.getOperationLog(operationLogPage, operationLogPageDTO);
        operationLogPage.setRecords(operationLogDOList);
        return operationLogPage.convert(operationLogDO -> BeanUtil.copyFrom(operationLogDO, OperationLogVO::new));
    }
}
