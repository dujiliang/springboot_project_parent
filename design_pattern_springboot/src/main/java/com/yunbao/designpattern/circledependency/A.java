package com.yunbao.designpattern.circledependency;

/**
 * @Author: djl
 * @Date: 2020/7/15 14:29
 * @Version 1.0
 */
public class A {

    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}
