package com.github.zzx.prize.service.util;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午10:29
 */
public class PrizeLoggerFactory {

    public static PrizeLogger getLogger(String name){
        return new PrizeLogger(name);
    }

    public static PrizeLogger getLogger(Class<?> clazz){
        return new PrizeLogger(clazz);
    }
}
