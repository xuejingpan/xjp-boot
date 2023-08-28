package com.xuejingpan.xjpboot.common.util;

import java.util.UUID;

/**
 * @ClassName UUIDUtil
 * @Description TODO
 * @Author xuejingpan
 */
public class UUIDUtil {

    /**
     * 获取一个UUID
     * @return UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获取指定数目的UUID
     * @param num 生成的UUID个数
     * @return UUID数组
     */
    public static String[] getUUID(int num) {
        if (num < 1) {
            return null;
        }
        String[] uuidArray = new String[num];
        for (int i = 0; i < num; i++) {
            uuidArray[i] = getUUID();
        }
        return uuidArray;
    }
}
