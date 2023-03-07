package com.xuejingpan.xjpboot.common.util;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @ClassName BeanUtil
 * @Description bean对象属性复制工具类
 * @Author xuejingpan
 * @Date 2023/3/7 22:26
 * @Version 1.0
 */
public class BeanUtil {

    public static <T, R> R copyFrom(T src, R supplier) {
        if (src == null || supplier == null) {
            return null;
        }
        BeanUtils.copyProperties(src, supplier);
        return supplier;
    }

    public static <T, R> List<R> copyFrom(List<T> srcList, Supplier<R> supplier) {
        if (CollectionUtils.isEmpty(srcList)) {
            return new ArrayList<>();
        }
        return srcList.stream().map(src -> copyFrom(src, supplier)).collect(Collectors.toList());
    }

    public static <T, R> R copyFrom(T src, Supplier<R> supplier) {
        if (src == null) {
            return null;
        }
        R dst = supplier.get();
        BeanUtils.copyProperties(src, dst);
        return dst;
    }
}
