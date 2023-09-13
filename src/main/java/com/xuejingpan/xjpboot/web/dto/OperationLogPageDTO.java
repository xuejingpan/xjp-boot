package com.xuejingpan.xjpboot.web.dto;

import com.xuejingpan.xjpboot.common.page.BasePage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @ClassName OperationLogPageDTO
 * @Description TODO
 * @Author xuejingpan
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OperationLogPageDTO extends BasePage {

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
     * 是否执行成功
     */
    private Boolean success;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;
}
