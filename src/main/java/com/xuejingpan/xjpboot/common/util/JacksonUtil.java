package com.xuejingpan.xjpboot.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @ClassName JacksonUtil
 * @Description TODO
 * @Author xuejingpan
 */
public class JacksonUtil {

    private final static ObjectMapper MAPPER = new ObjectMapper();

    public static String toJson(Object object) {
        try {
            return MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return MAPPER.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isJson(String str) {
        try {
            JsonNode node = MAPPER.readTree(str);
            return node.size() > 0;
        } catch (IOException e) {
            return false;
        }
    }
}
