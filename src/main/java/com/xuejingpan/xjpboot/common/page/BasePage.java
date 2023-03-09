package com.xuejingpan.xjpboot.common.page;

import lombok.Data;

/**
 * @ClassName BasePage
 * @Description TODO
 * @Author xuejingpan
 * @Date 2023/3/10 0:23
 * @Version 1.0
 */
@Data
public class BasePage {

    /**
     * 当前页
     */
    private Long current;

    /**
     * 每页显示条数
     */
    private Long size;
}
