package com.yunbao.designpattern.observe;

import lombok.Data;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author: djl
 * @Date: 2020/7/14 14:30
 * @Version 1.0
 */

public class Student implements Observer {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {

    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Teacher teacher = (Teacher) o;
        System.out.printf("学生%s观察到（实际是被通知）%s布置了作业《%s》 \n", this.name, teacher.getName(), arg);
    }
}
