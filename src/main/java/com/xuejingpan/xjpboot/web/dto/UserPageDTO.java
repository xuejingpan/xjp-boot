package com.xuejingpan.xjpboot.web.dto;

import com.xuejingpan.xjpboot.common.page.BasePage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName UserPageDTO
 * @Description TODO
 * @Author xuejingpan
 * @Date 2023/3/7 23:59
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserPageDTO extends BasePage {

    /**
     * 账号
     */
    private String account;

    /**
     * 用户名
     */
    private String username;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态：0-已删除，1-正常
     */
    private Integer state;
}
