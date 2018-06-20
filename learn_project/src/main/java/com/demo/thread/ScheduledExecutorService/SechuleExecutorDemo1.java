package com.demo.thread.ScheduledExecutorService;

import java.util.concurrent.*;

public class SechuleExecutorDemo1 {

    /**
     *  1.schedule (Callable task, long delay, TimeUnit timeunit)
     *  这个方法将在给定的延迟时间后执行Callable。
     *
     *  2.schedule (Runnable task, long delay, TimeUnit timeunit)
     *  这个方法类似于用Callable作为参数的版本（上面的方法），
     *  ScheduledFuture.get()方法在任务执行完毕时返回null。
     * @param
     * @throws Exception
     * @throws
     */
    public static void test1() throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(
                new Callable() {
                    public Object call() throws Exception {
                        System.out.println("Executed!");
                        return "Called!";
                    }
                }, 5, TimeUnit.SECONDS);

        System.out.println("result="+scheduledFuture.get().toString());
        scheduledExecutorService.shutdown();
    }



    public static void main(String[] args) throws Exception {
        //在给定的延迟时间后执行Callable
        test1();
    }
}

