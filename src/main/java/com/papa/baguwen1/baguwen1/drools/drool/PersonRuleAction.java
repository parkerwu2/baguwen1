package com.papa.baguwen1.baguwen1.drools.drool;

import org.drools.core.definitions.rule.impl.RuleImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 触发Person相关的规则后的处理类
 *
 * @author yuwen
 *
 */
public class PersonRuleAction {
    private static Logger LOG = LoggerFactory.getLogger(PersonRuleAction.class);

    // 目前只实现记录日志功能
    public static void doParse(Person person, RuleImpl rule) {
        LOG.debug("{} is matched Rule[{}]!", person, rule.getName());
    }
}
