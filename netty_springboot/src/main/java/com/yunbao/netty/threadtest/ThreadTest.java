package com.yunbao.netty.threadtest;

/**
 * @Author: djl
 * @Date: 2020/7/11 15:56
 * @Version 1.0
 */
public class ThreadTest {

    public static void main(String[] args) throws Exception{
        System.out.println("main 执行");
        new Thread(() -> {
            try {
                Thread.sleep(10000);
                System.out.println("线程执行");
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        //new Thread(thread).start();
        System.out.println("main结束");
    }


}
