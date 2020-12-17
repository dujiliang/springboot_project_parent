package com.yunbao.designpattern.circledependency;

/**
 * @Author: djl
 * @Date: 2020/7/15 14:29
 * @Version 1.0
 */
public class B {

    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}
