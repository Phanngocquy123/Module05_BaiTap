package com.example.bai4.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AppScheduler {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppScheduler.class);

    @Scheduled(cron = "*/5 * * * * *")
    public void scheduleTest(){
        LOGGER.info("[JOB] AppScheduler scheduler process");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
