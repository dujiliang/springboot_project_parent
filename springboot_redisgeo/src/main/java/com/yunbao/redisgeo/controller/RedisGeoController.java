package com.yunbao.redisgeo.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.yunbao.redisgeo.entity.DriverPosition;
import com.yunbao.redisgeo.entity.Pharmacy;
import com.yunbao.redisgeo.entity.PharmacyVo;
import com.yunbao.redisgeo.utils.RedisGeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: djl
 * @Date: 2020/9/29 10:33
 * @Version 1.0
 */
@RestController
@RequestMapping("redisGeo")
public class RedisGeoController {

    @Autowired
    private RedisGeoService redisGeoService;

    private final String GEO_KEY = "geo_key";

    /**
     * 使用redis+GEO，上报司机位置
     */
    @PostMapping("addDriverPosition")
    public Long addDriverPosition(String cityId, String driverId, Double lng, Double lat) throws Exception {
        String redisKey = GEO_KEY + ":" + cityId;
        DriverPosition dr = new DriverPosition();
        dr.setCityCode(cityId);
        dr.setDriverId(driverId);
        dr.setName("司机" + driverId);
        dr.setImgUrl("www.baodu.com");
        ObjectMapper mapper=new ObjectMapper();
        String driver =mapper.writeValueAsString(dr);
        Long addnum = redisGeoService.geoAdd(redisKey, new Point(lng, lat), driver);
        List<Point> points = redisGeoService.geoGet(redisKey, driver);
        System.out.println("添加位置坐标点：" + points);

        return addnum;
    }

    /**
     * 使用redis+GEO，查询附近司机位置
     */
    @GetMapping("getNearDrivers")
    public List<DriverPosition> getNearDrivers(String cityId, Double lng, Double lat) throws Exception{
        String redisKey = GEO_KEY + ":" + cityId;

        Circle circle = new Circle(lng, lat, Metrics.KILOMETERS.getMultiplier());
        GeoResults<RedisGeoCommands.GeoLocation<String>> results = redisGeoService.nearByXY(redisKey, circle, 5);
        System.out.println("查询附近司机位置：" + results);

        List<DriverPosition> list = new ArrayList<>();
        results.forEach(item -> {
            RedisGeoCommands.GeoLocation<String> location = item.getContent();
            Point point = location.getPoint();
            String driver = location.getName();
            ObjectMapper mapper=new ObjectMapper();
            DriverPosition driverPosition = null;
            try {
                driverPosition = mapper.readValue(driver, DriverPosition.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Double distance = item.getDistance().getValue();
            DriverPosition position = DriverPosition.builder().cityCode(cityId).driverId(driverPosition.getDriverId()).name(driverPosition.getName()).distance(distance)
                    .lng(point.getX()).lat(point.getY()).build();
            list.add(position);
        });

        return list;
    }


    @GetMapping("getNearPharmacy")
    public List<PharmacyVo> getNearDrivers(Double lng, Double lat,Integer count) throws Exception{
        String redisKey = "pharmacy_geo";

        //Circle circle = new Circle(lng, lat, Metrics.KILOMETERS.getMultiplier());

        Circle circle = new Circle(lng, lat, 10000);
        GeoResults<RedisGeoCommands.GeoLocation<String>> results = redisGeoService.nearByXY(redisKey, circle, count);
        System.out.println("查询附近药店位置：" + results);

        List<PharmacyVo> list = new ArrayList<>();
        results.forEach(item -> {
            RedisGeoCommands.GeoLocation<String> location = item.getContent();
            Point point = location.getPoint();
            String pharmacyJson = location.getName();
            ObjectMapper mapper=new ObjectMapper();
            Pharmacy pharmacy = null;
            try {
                pharmacy = mapper.readValue(pharmacyJson, Pharmacy.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Long distance = Math.round(item.getDistance().getValue());
            PharmacyVo position = PharmacyVo.builder().id(pharmacy.getId()).pharmacyName(pharmacy.getPharmacyName()).distance(distance)
                    .longitude(point.getX()).latitude(point.getY()).build();
            list.add(position);
        });

        return list;
    }


    public static void main(String[] args) throws Exception{
        DriverPosition dr = new DriverPosition();
        dr.setCityCode("111");
        dr.setDriverId("3333");
        dr.setName("司机" + "3333");
        dr.setImgUrl("www.baodu.com");
        ObjectMapper mapper=new ObjectMapper();
        String jsonStr=mapper.writeValueAsString(dr);
        System.out.println(jsonStr);
    }

}
