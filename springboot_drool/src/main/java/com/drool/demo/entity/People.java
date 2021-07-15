package com.drool.demo.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    private Integer score;

    public People(int sex, String name, String drlType,Integer score) {
        this.sex = sex;
        this.name = name;
        this.drlType = drlType;
        this.score = score;
    }

    public People() {
    }


    public static void main(String[] args) {
        People people = new People(1, "aa", "drl", 1);
        People people1 = new People(1, "bb", "drl", 2);
        People people2 = new People(2, "cc", "drl", 3);
        People people3 = new People(2, "dd", "drl", 4);
        People people4 = new People(1, "affa", "drl", 5);
        List<People> peoples = new ArrayList<>();
        peoples.add(people);
        peoples.add(people1);
        peoples.add(people2);
        peoples.add(people3);
        peoples.add(people4);

        Map<Integer, List<People>> collect = peoples.stream().collect(Collectors.groupingBy(People::getSex, Collectors.toList()));

        Map<Integer, List<People>> collect2 = peoples.stream().collect(Collectors.groupingBy(People::getSex));
        Map<String, Integer> collect3 = peoples.stream().collect(Collectors.toMap(People::getName, People::getScore));
        System.out.println(collect3);


        Map<Integer, List<Integer>> collect1 = peoples.stream().collect(Collectors.groupingBy(People::getSex, Collectors.mapping(People::getScore, Collectors.toList())));
        System.out.println(collect);
        System.out.println(collect1);

        Map<Integer, List<Integer>> collect5 =peoples.stream().collect(Collectors.groupingBy(People::getSex, Collectors.mapping(People::getScore, Collectors.toList())));

    }




}
