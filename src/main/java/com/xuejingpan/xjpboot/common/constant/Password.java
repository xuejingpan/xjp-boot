package com.xuejingpan.xjpboot.common.constant;

/**
 * @InterfaceName Password
 * @Description TODO
 * @Author xuejingpan
 */
public interface Password {

    String SALT = "xuejingpan";

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
