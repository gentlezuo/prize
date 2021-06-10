package com.github.zzx.prize.service.util;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午11:31
 */
public class LimiterUtils {

    private static ConcurrentHashMap<Long, RateLimiter> sendPrizeLimiterMap = new ConcurrentHashMap<>();

    public static RateLimiter getLimiter(Long prizeId) {
        RateLimiter rateLimiter = sendPrizeLimiterMap.get(prizeId);
        if (rateLimiter == null) {
            rateLimiter = RateLimiter.create(DynamicConfigUtils.getLimitPermits());
            sendPrizeLimiterMap.put(prizeId, rateLimiter);
        }
        return rateLimiter;
    }

}
