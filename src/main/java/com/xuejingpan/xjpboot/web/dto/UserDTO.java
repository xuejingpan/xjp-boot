package com.xuejingpan.xjpboot.web.dto;

import com.xuejingpan.xjpboot.common.validation.Insert;
import com.xuejingpan.xjpboot.common.validation.Update;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @ClassName UserDTO
 * @Description TODO
 * @Author xuejingpan
 */
@Data
public class UserDTO {

    /**
     * id
     */
    @Null(message = "id必须为空", groups = Insert.class)
    @NotNull(message = "id不能为空", groups = Update.class)
    private Integer id;

    /**
     * 账号
     */
    @NotBlank(message = "账号不能为空")
    private String account;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    @Email(message = "邮箱格式不正确")
    private String email;
}
