package com.demo.thread;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledDemo {

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> scheduledFuture;
        System.out.println(new Date());
        scheduledFuture = scheduler.scheduleWithFixedDelay(new TestTask(), 5, 2, TimeUnit.SECONDS);
        System.out.println(scheduledFuture.isDone());
        //scheduler.shutdown();
    }

    private static class TestTask implements Runnable{

        @Override
        public void run() {
            System.out.println("-----"+new Date());
        }
    }
}
