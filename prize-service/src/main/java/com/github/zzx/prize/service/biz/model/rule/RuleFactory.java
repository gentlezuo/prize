package com.github.zzx.prize.service.biz.model.rule;

import com.github.zzx.prize.api.enums.PrizeRuleTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午11:57
 */
@Component
public class RuleFactory implements ApplicationContextAware {
    public static final Logger logger = LoggerFactory.getLogger(RuleFactory.class);

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    public RuleFilter getFilter(Integer ruleType) {
        try {
            return applicationContext.getBean(PrizeRuleTypeEnum.getByCode(ruleType).name(), RuleFilter.class);
        } catch (BeansException be) {
            logger.error("ruleFactory get filter error. ruleType = {}", ruleType, be);
            return null;
        }
    }

}
