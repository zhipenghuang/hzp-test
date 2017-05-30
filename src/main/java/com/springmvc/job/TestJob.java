package com.springmvc.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestJob {

    @Scheduled(cron = "*/3 * * * * *")
    public void test() {
        System.out.println("test executed ...");
    }

    @Scheduled(cron = "*/3 * * * * *")
    public void test1() {
        System.out.println("I love you ...");
    }

}
