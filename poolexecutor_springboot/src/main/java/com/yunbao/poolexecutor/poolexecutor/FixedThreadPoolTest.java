package com.yunbao.poolexecutor.poolexecutor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Author: djl
 * @Date: 2020/6/1 9:35
 * @Version 1.0
 */
public class FixedThreadPoolTest {

    public static void main(String[] args) {

        //创建定长线程池，可控制线程最大的并发数，超出的线程会在队列中等待
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//
//        executorService.execute(() -> {
//            System.out.println(Thread.currentThread().getName());
//        });

        // 手动创建
        ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("fixedThreadPool-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor( 20,
                                                                        100,
                                                                        0L,
                                                                        TimeUnit.MILLISECONDS,
                                                                        new LinkedBlockingDeque<>(100),
                                                                        factory, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0 ; i < 1000; i++) {
            int num  = i;
            threadPoolExecutor.execute(()->{
                System.out.println(1/0);
                System.out.println(Thread.currentThread().getName()  + "打印-" + num);
            });

            /*threadPoolExecutor.submit(()->{
                System.out.println(1/0);
                System.out.println(Thread.currentThread().getName()  + "打印-" + num);
            });*/
        }
        // 任务执行完毕后打印"Done"
        System.out.println("Done");

    }
}
