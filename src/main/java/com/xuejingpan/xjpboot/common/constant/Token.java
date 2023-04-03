package com.xuejingpan.xjpboot.common.constant;

/**
 * @InterfaceName Token
 * @Description TODO
 * @Author xuejingpan
 * @Date 2023/3/13 23:23
 * @Version 1.0
 */
public interface Token {

    /**
     * 名称
     */
    String NAME = "Authorization";

    /**
     * 前缀
     */
    String PREFIX = "Bearer ";

    /**
     * 秘钥
     */
    String SECRET = "xjpboot-secret";
}
