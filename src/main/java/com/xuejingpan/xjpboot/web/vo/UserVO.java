package com.xuejingpan.xjpboot.web.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @ClassName UserVO
 * @Description TODO
 * @Author xuejingpan
 * @Date 2023/3/7 23:46
 * @Version 1.0
 */
@Data
public class UserVO {

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
