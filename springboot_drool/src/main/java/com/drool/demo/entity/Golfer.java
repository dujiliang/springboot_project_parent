package com.drool.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: djl
 * @Date: 2021/6/17 15:45
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Golfer {

    private String name;
    private String color;
    private int position;
}
