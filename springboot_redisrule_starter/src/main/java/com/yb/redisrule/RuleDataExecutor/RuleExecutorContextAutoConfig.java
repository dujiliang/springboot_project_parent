package com.yb.redisrule.RuleDataExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @Author: djl
 * @Date: 2021/6/22 10:22
 * @Version 1.0
 */
@Configuration
@ConditionalOnClass(RuleExecutorContext.class)
public class RuleExecutorContextAutoConfig {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private Environment environment;

    @Bean
    public RuleExecutorContext ruleExecutorContext() {
        System.out.println(environment.getProperty("spring.data.mongodb.uri"));
        RuleExecutorContext ruleExecutorContext = new RuleExecutorContext(mongoTemplate);
        ruleExecutorContext.initRuleList();
        return ruleExecutorContext;
    }
}
