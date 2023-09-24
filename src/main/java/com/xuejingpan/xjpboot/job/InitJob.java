package com.xuejingpan.xjpboot.job;

import com.xuejingpan.xjpboot.common.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName InitJob
 * @Description TODO
 * @Author xuejingpan
 */
@Slf4j
@Component
public class InitJob implements ApplicationRunner {

    @Resource
    private RedisUtil<String> redisUtil;
    
    @Override
    public void run(ApplicationArguments args) {
        log.info("----- 开始初始化 -----");
        redisUtil.set("hello", "Redis: Hello World !");
        log.info(redisUtil.get("hello"));
        log.info("----- 完成初始化 -----");
    }
}
