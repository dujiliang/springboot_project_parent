package com.yb.redisrule.RuleDataExecutor;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author: djl
 * @Date: 2021/6/21 15:43
 * @Version 1.0
 */
@Document(collection = "m_rule")
public class Rule {

    private String name;

    private String code;

    private String ruleType;

    private String checkType;

    public Rule() {
    }

    public Rule(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }
}
