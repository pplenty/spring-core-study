package com.jason.springcorestudy.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CronScheduler {
 
    @Scheduled(cron = "0 1/2 * * * *")
    public void run() {
        log.info("@@@");
    }
 
}