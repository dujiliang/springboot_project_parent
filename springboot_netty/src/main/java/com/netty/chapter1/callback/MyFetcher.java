package com.netty.chapter1.callback;

/**
 * @Author: djl
 * @Date: 2021/10/19/9:44
 * @Description:
 */
public class MyFetcher implements Fetcher{

    final Data data;

    public MyFetcher(Data data) {
        this.data = data;
    }

    @Override
    public void fetchData(FetchCallback fetchCallback) {
        try {
            fetchCallback.onData(data);
        } catch (Exception e) {
            fetchCallback.onError(e);
        }
    }
}
