package com.github.zzx.prize.service.util;

/**
 * @author zuozhixin
 * @description: 模拟动态配置
 * @date 2021/6/10 上午11:48
 */
public class DynamicConfigUtils {

    public static boolean isExecRisk(){
        return false;
    }

    public static int getMaxLimiterNum(){
        return 100;
    }

    public static int getLimitPermits(){
        return 300;
    }

    public static boolean ruleNullPass(){
        return false;
    }
}
