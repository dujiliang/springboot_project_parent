package com.yunbao.poolexecutor.poolexecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: djl
 * @Date: 2020/6/1 10:48
 * @Version 1.0
 */
public class CacheThreadPoolTest {

    public static void main(String[] args) {

        Executors.newCachedThreadPool();
    }
}
