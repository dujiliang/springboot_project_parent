package com.yb.redisrule.RuleDataExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Author: djl
 * @Date: 2021/6/22 9:42
 * @Version 1.0
 */
@Configuration
@ConditionalOnClass(RuleRedisProcesser.class)
public class RuleRedisProcesserAutoConfig {

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Bean
    public RuleRedisProcesser ruleRedisProcesser () {
        RuleRedisProcesser ruleRedisProcesser = new RuleRedisProcesser(redisTemplate);
        ruleRedisProcesser.initHopital();
        return ruleRedisProcesser;
    }
}
