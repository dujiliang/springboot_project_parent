package com.yunbao.poolexecutor.poolexecutor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @Author: djl
 * @Date: 2020/5/29 17:59
 * @Version 1.0
 */
public class ScheduleExecutorTest {

    public static void main(String[] args) {

        // 定时任务线程池
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
//
//        for (int i = 0 ; i < 100; i++ ) {
//            int delay = i+ 1;
//            scheduledExecutorService.schedule(()->{
//                System.out.println(Thread.currentThread().getName() + "打印-" + delay);
//            },delay,TimeUnit.SECONDS);
//        }

        // 手动创建
        ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("schedule-ThreadPool-%d").build();
        ScheduledExecutorService scheduledExecutorService1 = new ScheduledThreadPoolExecutor(10, factory);
        for (int i = 0 ; i < 1000; i++) {
            int delay = i ;
            scheduledExecutorService1.schedule(()->{
                System.out.println(Thread.currentThread().getName() + "打印-" + delay);
            },2,TimeUnit.SECONDS);
        }
    }
}
