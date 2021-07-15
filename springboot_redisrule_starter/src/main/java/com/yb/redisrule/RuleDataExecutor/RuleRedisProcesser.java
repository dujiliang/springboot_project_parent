package com.yb.redisrule.RuleDataExecutor;

import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: djl
 * @Date: 2021/6/22 9:37
 * @Version 1.0
 */
public class RuleRedisProcesser {

    private StringRedisTemplate redisTemplate;

    public static Set<String> hospitalSet = new HashSet<>();

    public RuleRedisProcesser(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void initHopital () {
        hospitalSet = redisTemplate.opsForSet().members("ez_health_center_list");
    }

    public  Set<String> getHospitalSet() {
        return hospitalSet;
    }
}
