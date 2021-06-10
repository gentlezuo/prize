package com.github.zzx.prize.service.wrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 下午12:17
 */
@Component
public class StockWrapper {

    public static final Logger logger = LoggerFactory.getLogger(StockWrapper.class);

    public boolean lockStock(Long prizeId){
        return true;
    }

    public boolean consumeStock(Long prizeId){
        return true;
    }

    public boolean rollbackStock(Long prizeId){
        return true;
    }

}
