package com.netty.chapter1.callback;

/**
 * @Author: djl
 * @Date: 2021/10/19/9:40
 * @Description:
 */
public interface Fetcher {

    void fetchData(FetchCallback fetchCallback);
}
