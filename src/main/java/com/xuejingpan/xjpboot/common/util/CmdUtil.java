package com.xuejingpan.xjpboot.common.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName CmdUtil
 * @Description TODO
 * @Author xuejingpan
 */
@Slf4j
public class CmdUtil {

    private static final String TIMEOUT_INFO = "Terminated";

    public static String exec(String cmd) {
        return exec(cmd, 10);
    }

    public static String exec(String cmd, int timeout) {
        String command = String.format("timeout %d %s", timeout, cmd);
        StringBuilder result = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
            if (TIMEOUT_INFO.equals(result.toString())) {
                log.error("命令行执行超时: {}", cmd);
                return null;
            }
        } catch (IOException e) {
            log.error("命令行执行失败: {}", cmd);
            e.printStackTrace();
            return null;
        }
        return result.toString();
    }
}
