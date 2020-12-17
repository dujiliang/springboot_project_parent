package com.yunbao.designpattern.observe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * @Author: djl
 * @Date: 2020/7/14 14:31
 * @Version 1.0
 */

public class Teacher extends Observable {

    private String name;

    private List<String> homework;

    public Teacher(String name) {
       this.name = name;
       this.homework = new ArrayList<>();
    }

    public String getName() {
        return name;
    }



    public void setHomework(String homework) {
        System.out.printf("%s布置了作业%s \n", this.name, homework);
        this.homework.add(homework);
        setChanged();
        notifyObservers(homework);
    }

    public static void main(String[] args) {
        Student stu1 = new Student("张三");
        Student stu2 = new Student("李四");

        Teacher teacher = new Teacher("田老师");
        teacher.addObserver(stu1);
        teacher.addObserver(stu2);
        teacher.setHomework("数学作业");
    }
}
