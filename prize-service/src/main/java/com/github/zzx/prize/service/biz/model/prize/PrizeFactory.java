package com.github.zzx.prize.service.biz.model.prize;

import com.github.zzx.prize.api.enums.PrizeTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 下午12:30
 */
@Component
public class PrizeFactory implements ApplicationContextAware {
    public static final Logger logger = LoggerFactory.getLogger(PrizeFactory.class);

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public PrizeSender getSender(Integer prizeType) {
        try {
            return applicationContext.getBean(PrizeTypeEnum.getByCode(prizeType).name(), PrizeSender.class);
        } catch (BeansException be) {
            logger.error("PrizeFactory get prizeSender error. prizeType = {}", prizeType, be);
            return null;
        }
    }

}
