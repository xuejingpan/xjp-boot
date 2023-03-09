package com.xuejingpan.xjpboot.web.dto;

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
public class UserPageDTO extends PageDTO {

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
     * 状态：0无效，1有效
     */
    private Integer state;
}
