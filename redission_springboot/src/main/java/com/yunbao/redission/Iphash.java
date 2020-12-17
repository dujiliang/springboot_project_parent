package com.yunbao.redission;

/**
 * @Author: djl
 * @Date: 2020/6/8 16:33
 * @Version 1.0
 */
public class Iphash {


    public static void main(String[] args) {

        int index = "192.168.3.45".hashCode() % 2;

        int index1 = "192.168.3.59".hashCode() % 2;
        System.out.println("index:" + index);
        System.out.println("index:" + index1);
    }
}
