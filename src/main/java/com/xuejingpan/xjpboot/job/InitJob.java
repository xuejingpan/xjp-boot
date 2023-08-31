package com.xuejingpan.xjpboot.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @ClassName InitJob
 * @Description TODO
 * @Author xuejingpan
 */
@Slf4j
@Component
public class InitJob implements ApplicationRunner {
    
    @Override
    public void run(ApplicationArguments args) {
        log.info("--- 开始初始化 ---");
        // TODO
        log.info("--- 初始化完成 ---");
    }
}
