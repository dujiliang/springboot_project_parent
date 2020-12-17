package com.drool.demo.entity;

import lombok.Data;

/**
 * @Author: djl
 * @Date: 2020/12/4 9:36
 * @Version 1.0
 */
@Data
public class People {

    private int sex;

    private String name;

    private String drlType;

    public People(int sex, String name, String drlType) {
        this.sex = sex;
        this.name = name;
        this.drlType = drlType;
    }

    public People() {
    }
}
