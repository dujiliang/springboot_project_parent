package com.netty.chapter1.callback;

/**
 * @Author: djl
 * @Date: 2021/10/19/9:39
 * @Description:
 */
public class Worker {

    public void doWork () {
        Data data = new Data(1,0);
        Fetcher myFetcher = new MyFetcher(data);
        myFetcher.fetchData(new FetchCallback() {
            @Override
            public void onData(Data data) {
                System.out.println(data.toString());
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getMessage());
            }
        });
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.doWork();
    }
}
