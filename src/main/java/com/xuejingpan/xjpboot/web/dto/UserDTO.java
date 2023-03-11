package com.xuejingpan.xjpboot.web.dto;

import lombok.Data;

/**
 * @ClassName UserDTO
 * @Description TODO
 * @Author xuejingpan
 * @Date 2023/3/11 23:16
 * @Version 1.0
 */
@Data
public class UserDTO {

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
}
