package com.user.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {

    @Scheduled(fixedRate = 10000) // can be scheduled in cron/timer
    public void scheduleTask() {
        //define task
    }
}
