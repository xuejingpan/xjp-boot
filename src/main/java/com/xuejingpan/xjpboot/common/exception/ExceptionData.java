package com.xuejingpan.xjpboot.common.exception;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

/**
 * @ClassName ExceptionData
 * @Description TODO
 * @Author xuejingpan
 */
@Data
@Builder
public class ExceptionData {

    private final List<String> data;
}
