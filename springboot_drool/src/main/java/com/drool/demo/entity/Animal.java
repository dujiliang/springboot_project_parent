package com.drool.demo.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: djl
 * @Date: 2020/12/4 14:43
 * @Version 1.0
 */
@Data
public class Animal {

    private Integer level;

    private List<People> peoples;

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("aa","aa");
        System.out.println(map.get(null));
        System.out.println(map.get("aa"));
    }
}
