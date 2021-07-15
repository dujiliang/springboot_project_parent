package com.yb.redisrule.RuleDataExecutor;

import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: djl
 * @Date: 2021/6/22 10:19
 * @Version 1.0
 */
public class RuleExecutorContext {

    private MongoTemplate mongoTemplate;

    public final static List<Rule> ruleList = new ArrayList();

    public void initRuleList () {
        List<Rule> all = mongoTemplate.findAll(Rule.class);
        all.stream().forEach(rule -> ruleList.add(rule));
    }

    public RuleExecutorContext() {

    }

    public RuleExecutorContext(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public  List<Rule> getRuleList() {
        return ruleList;
    }
}
