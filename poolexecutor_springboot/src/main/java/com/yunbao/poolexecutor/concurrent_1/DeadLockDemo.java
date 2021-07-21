package com.yunbao.poolexecutor.concurrent_1;

/**
 * @Author: djl
 * @Date: 2021/07/21/10:25
 * @Description:
 */
public class DeadLockDemo {

    static String a = "a";
    static String b = "b";

    public void dealLock () {

        Thread thread1 = new Thread(() -> {
            synchronized (a) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println("1");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (b) {
                synchronized (a) {
                    System.out.println(2);
                }
            }
        });
        thread1.start();
        thread2.start();

    }

    public static void main(String[] args) {
        DeadLockDemo deadLockDemo = new DeadLockDemo();
        deadLockDemo.dealLock();
    }
}
