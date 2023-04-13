package com.xuejingpan.xjpboot.service;

/**
 * @InterfaceName HttpServletRequestService
 * @Description TODO
 * @Author xuejingpan
 * @Date 2023/4/9 22:26
 * @Version 1.0
 */
public interface HttpServletRequestService {

    /**
     * 从HttpServletRequest获取token
     * @return token
     */
    String getToken();

    /**
     * 从HttpServletRequest获取账号
     * @return 账号
     */
    String getAccount();

    /**
     * 从HttpServletRequest获取用户名
     * @return 用户名
     */
    String getUsername();
}
