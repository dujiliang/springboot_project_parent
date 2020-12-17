package com.yunbao.redisgeo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: djl
 * @Date: 2020/9/29 14:53
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pharmacy {

    private Long id;

    /** 药店名称 */
    private String pharmacyName;

    /** 药店经度 */
    private BigDecimal longitude;

    /** 药店纬度 */
    private BigDecimal latitude;

    /** 药店评分 */
    private Short commentScore;

    /** 介绍语 */
    private String introduceDesc;

    /** 药品推荐1 */
    private Long medicineRecomd1;

    /** 药品推荐2 */
    private Long medicineRecomd2;

    /** 药品推荐3 */
    private Long medicineRecomd3;

    /** 药品推荐4 */
    private Long medicineRecomd4;

    /** 主键id1 */
    private Long advert1;

    /** 主键id2 */
    private Long advert2;

    /** 主键id3 */
    private Long advert3;

    /** 是否品牌 */
    private Short brandFlag;

    /** 是否医保定点 */
    private Short healthcareFlag;

    /** 是否24小时营业 */
    private Short allDayaroundFlag;

    /** 是否优惠 */
    private Short onsaleFlag;

    /** 可预约 */
    private Short bookFlag;

    /** 可送药的 */
    private Short deliveryFlag;

    /** 可以合作 */
    private Short cooperativeFlag;

    /** 返利 */
    private Integer rebate;

    /** 主药店id */
    private Long mainPharmacy;

    /** 图片路径 */
    private String picturePath;

    /** 唯一识别码 */
    private String uniqueCode;

    /** 豆豆 */
    private Long doudou;

    /** 创建人 */
    private Date createTime;

    /** 创建时间 */
    private String createBy;

    /** 更新人 */
    private Date updateTime;

    /** 更新时间 */
    private String updateBy;

    /** 热度 */
    private Integer heat;

    /** 运费 */
    private BigDecimal carriage;

    /** 开始营业时间 */
    private String startTime;

    /* 结束营业时间 */
    private String endTime;

    /** 地址 */
    private String address;

    /** 联系方式 */
    private String phone;

    private String logoPath;

    /** 营业执照 */
    private String licensePic;

    /** 药品经营许可证 */
    private String lmedicinePic;

    /** GSP认证*/
    private String gspPic;

    /** 食品流通许可证*/
    private String spltPic;

    /** 医疗器械经营许可证 */
    private String ylqxPic;
}
