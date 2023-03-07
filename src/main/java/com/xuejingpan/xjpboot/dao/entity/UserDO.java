package com.xuejingpan.xjpboot.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName UserDO
 * @Description 用户
 * @Author xuejingpan
 * @Date 2023/3/7 23:38
 * @Version 1.0
 */
@Data
@TableName(value = "user", autoResultMap = true)
public class UserDO {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 账号
     */
    private String account;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

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
