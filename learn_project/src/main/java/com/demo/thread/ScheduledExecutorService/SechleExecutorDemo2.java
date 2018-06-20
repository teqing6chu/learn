package com.demo.thread.ScheduledExecutorService;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SechleExecutorDemo2 {

    /**
     * scheduleAtFixedRate (Runnable, long initialDelay, long period,TimeUnit timeunit)
     * 这个方法可以周期性的执行任务。任务在initialDelay时间后第一次执行，然后每次周期循环执行。
     * 如果执行的【任务抛出了异常，任务不会再执行】，如果没有抛出异常，任务将继续执行直到 ScheduledExecutorService
     * 如果任务执行时间超过了任务之间间隔的时间，下个任务将会在当前任务完成后再执行。
     * 【执行任务的线程每次不会超过一个】
     */
    private static void testScheduleAtFixedRate() {
        System.out.println(new Date());
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        scheduler.scheduleAtFixedRate(new MyRunnable("hi"), 5, 2, TimeUnit.SECONDS);

    }

    /**
     * scheduleAtFixedRate()方法的period指的是上一个任务开始执行到下一个任务开始执行的时间间隔。
     *然而，这个方法的period指的是上一个任务执行完到下一个任务开始执行之间的时间间隔。
     *
     */
    private static void testScheduleWithFixedDelay() {
        System.out.println(new Date());
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        scheduler.scheduleWithFixedDelay(new MyRunnable("hi"), 5, 2, TimeUnit.SECONDS);
    }

    private static volatile int runCount = 0;

    private static class MyRunnable implements Runnable {
        String str;
        public MyRunnable(String str) {
            this.str = str;
        }

        @Override
        public void run(){
            System.out.println(str + " " + new Date());
            SechleExecutorDemo2.runCount++;
        }
    }

    public static void main(String[] args) {
        System.out.println("哈喽======");
        testScheduleAtFixedRate();
      //  testScheduleWithFixedDelay();
    }
}
