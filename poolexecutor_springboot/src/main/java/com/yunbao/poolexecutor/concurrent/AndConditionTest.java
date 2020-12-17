package com.yunbao.poolexecutor.concurrent;

/**
 * @Author: djl
 * @Date: 2020/6/11 15:51
 * @Version 1.0
 */
public class AndConditionTest {

    boolean getEqqualFlag (int i) {
        System.out.println("判断");
        int a = 3;
        return i == a;
    }

    public static void main(String[] args) {
        AndConditionTest andConditionTest = new AndConditionTest();
        if (!false && andConditionTest.getEqqualFlag(3)) {
            System.out.println("ddd");
        }
    }
}
