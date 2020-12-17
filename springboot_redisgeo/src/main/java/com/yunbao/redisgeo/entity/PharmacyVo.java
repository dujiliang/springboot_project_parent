package com.yunbao.redisgeo.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: djl
 * @Date: 2020/9/29 15:33
 * @Version 1.0
 */
@Data
@Builder
public class PharmacyVo {

    private Long id;

    /** 药店名称 */
    private String pharmacyName;

    /** 药店经度 */
    private Double longitude;

    /** 药店纬度 */
    private Double latitude;

    private Long distance;
}
