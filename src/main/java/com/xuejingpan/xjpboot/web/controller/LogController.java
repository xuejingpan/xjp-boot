package com.xuejingpan.xjpboot.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xuejingpan.xjpboot.common.result.Result;
import com.xuejingpan.xjpboot.service.LogService;
import com.xuejingpan.xjpboot.web.dto.OperationLogPageDTO;
import com.xuejingpan.xjpboot.web.vo.OperationLogVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName LogController
 * @Description TODO
 * @Author xuejingpan
 * @Date 2023/4/19 23:45
 * @Version 1.0
 */
@RestController
@RequestMapping("log")
public class LogController {

    @Resource
    private LogService logService;

    @GetMapping("operationLog")
    public Result<IPage<OperationLogVO>> getOperationLogPage(OperationLogPageDTO operationLogPageDTO) {
        return Result.success(logService.getOperationLog(operationLogPageDTO));
    }
}
