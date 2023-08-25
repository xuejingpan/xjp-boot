package com.xuejingpan.xjpboot.common.constant;

/**
 * @InterfaceName Password
 * @Description TODO
 * @Author xuejingpan
 */
public interface Password {

    /**
     * 盐
     */
    String SALT = "xuejingpan";

    /**
     * 默认密码
     */
    String DEFAULT_PASSWORD = "123456";

    /**
     * 密码最小长度
     */
    int MIN_LENGTH = 6;

    /**
     * 密码最大长度
     */
    int MAX_LENGTH = 18;
}
