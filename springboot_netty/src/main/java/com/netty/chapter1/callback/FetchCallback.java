package com.netty.chapter1.callback;

/**
 * @Author: djl
 * @Date: 2021/10/19/9:41
 * @Description:
 */
public interface FetchCallback {

    void onData(Data data);

    void onError(Throwable throwable);
}
