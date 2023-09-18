package com.xuejingpan.xjpboot.web.dto;

import com.xuejingpan.xjpboot.common.constant.Password;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @ClassName LoginDTO
 * @Description TODO
 * @Author xuejingpan
 */
@Data
public class LoginDTO {

    /**
     * 账号
     */
    @NotBlank(message = "账号不能为空")
    private String account;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @Size(min = Password.MIN_LENGTH, max = Password.MAX_LENGTH, message = "密码长度必须在" + Password.MIN_LENGTH + "位到" + Password.MAX_LENGTH + "位之间")
    private String password;
}
