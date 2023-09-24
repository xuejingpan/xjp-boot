package com.xuejingpan.xjpboot.service.bo;

import lombok.Data;

/**
 * @ClassName OperationLogBO
 * @Description TODO
 * @Author xuejingpan
 */
@Data
public class OperationLogBO {

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
}
