package com.yunbao.redission.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: djl
 * @Date: 2020/6/5 10:44
 * @Version 1.0
 */
@RestController
@RequestMapping("redisson")
public class RedissonController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedissonClient redisson;

    @RequestMapping("getSkuvalue")
    @ResponseBody
    public String getSkuvalue (Long id) {
        String key = "sku-" + id;
        String sku = redisTemplate.opsForValue().get(key);
        if (sku == null) {
            RLock lock = redisson.getLock("skulock-" + id);
            try{
                lock.lock(3, TimeUnit.SECONDS);
                sku = getSkuByBase(id);
                redisTemplate.opsForValue().set(key,sku);
            } finally {
                lock.unlock();
            }
        }
        return sku;
    }



    public String getSkuByBase (Long id) {
        System.out.println("进入数据库查询sku信息");
        return String.valueOf(id);
    }
}
