package com.github.zzx.prize.api.enums;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午10:04
 */
public enum RespCodeEnum {

    SUCCESS("000000","成功"),

    PARAM_ERROR("100001","参数错误"),

    //业务错误
    NO_PRIZE("200001","无此奖品"),
    PRIZE_EXPIRED("200002","奖品已过期或已下线"),
    PRIZE_NOT_START("200003","奖品发放时间暂未开始"),
    NOT_MATCH_RULE("200004","不匹配规则"),
    LIMIT("200005","被限流"),
    LOCK_STOCK_FAIL("200006","锁库存失败"),
    CONSUME_STOCK_FAIL("200007","消费库存失败"),
    PRIZE_CONFIG_ERROR("200008","奖品配置错误"),

    RISK("300001","被风控"),

    SYSTEM_ERROR("999999","系统错误")
    ;

    public final String code;
    public final String desc;

    RespCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
