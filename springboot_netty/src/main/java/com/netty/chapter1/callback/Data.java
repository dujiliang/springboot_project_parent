package com.netty.chapter1.callback;

/**
 * @Author: djl
 * @Date: 2021/10/19/9:42
 * @Description:
 */
public class Data {

    private int n;
    private int m;

    public Data(int n, int m) {
        this.n = n;
        this.m = m;
    }

    @Override
    public String toString() {
        int r = n / m;
        return n + "/" + m + " = " + r;
    }
}
