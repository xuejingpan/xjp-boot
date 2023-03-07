package com.xuejingpan.xjpboot.web.dto;

import lombok.Data;

/**
 * @ClassName PageDTO
 * @Description 分页查询基础参数
 * @Author xuejingpan
 * @Date 2023/3/7 23:52
 * @Version 1.0
 */
@Data
public class PageDTO {

    /**
     * 当前页
     */
    private Long current;

    /**
     * 每页显示条数
     */
    private Long size;
}
