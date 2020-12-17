package com.yunbao.poolexecutor.future;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: djl
 * @Date: 2020/6/2 15:37
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String brand;


    public Product (Long id,String name, String brand) {
        this.id = id;
        this.name = name;
        this.brand = brand;
    }
}
