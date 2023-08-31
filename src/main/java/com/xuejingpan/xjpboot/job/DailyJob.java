package com.xuejingpan.xjpboot.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName DailyJob
 * @Description TODO
 * @Author xuejingpan
 */
@Slf4j
@Component
@EnableScheduling
public class DailyJob {

    @Scheduled(cron = "0 0 2 * * ?")
    public void day() {
        log.info("每天凌晨2点的定时任务");
        // TODO
    }
}
