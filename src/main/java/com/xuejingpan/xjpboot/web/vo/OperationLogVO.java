package com.xuejingpan.xjpboot.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName OperationLogVO
 * @Description TODO
 * @Author xuejingpan
 */
@Data
public class OperationLogVO {

    /**
     * 账号
     */
    private String account;

    /**
     * 用户名
     */
    private String username;

    /**
     * 操作内容
     */
    private String content;

    /**
     * 请求方法
     */
    private String methodName;

    /**
     * 请求数据
     */
    private String requestData;

    /**
     * 返回数据
     */
    private String responseData;

    /**
     * 执行时间
     */
    private Long executionTime;

    /**
     * 是否执行成功
     */
    private Boolean success;

    /**
     * 操作时间
     */
    private LocalDateTime operationTime;
}
