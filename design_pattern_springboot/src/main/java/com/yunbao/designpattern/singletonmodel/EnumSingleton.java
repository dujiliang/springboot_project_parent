package com.yunbao.designpattern.singletonmodel;

/**
 * @Author: djl
 * @Date: 2020/9/5 17:26
 * @Version 1.0
 */
public enum EnumSingleton {

    INSTANCE;

    private Object data;

    public Object getData () {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static EnumSingleton getinstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println(EnumSingleton.INSTANCE);
    }
}
