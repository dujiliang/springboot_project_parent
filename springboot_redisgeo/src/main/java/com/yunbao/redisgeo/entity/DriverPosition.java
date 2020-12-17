package com.yunbao.redisgeo.entity;

import lombok.*;

/**
 * @Author: djl
 * @Date: 2020/9/29 10:31
 * @Version 1.0
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverPosition {

    /** 司机id */
    private String driverId;

    /** 城市编码 */
    private String cityCode;

    /** 经度 */
    private double lng;

    /** 纬度 */
    private double lat;

    private String name;

    private String imgUrl;

    private Double distance;
}