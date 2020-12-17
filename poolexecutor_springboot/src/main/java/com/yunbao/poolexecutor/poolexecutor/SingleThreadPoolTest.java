package com.yunbao.poolexecutor.poolexecutor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Author: djl
 * @Date: 2020/6/1 10:52
 * @Version 1.0
 */
public class SingleThreadPoolTest {

    public static void main(String[] args) {
        Executors.newSingleThreadExecutor();

        ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("fixedThreadPool-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor( 1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(), factory, new ThreadPoolExecutor.AbortPolicy());
        //new Executors.FinalizableDelegatedExecutorService(threadPoolExecutor);
    }
}
