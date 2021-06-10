package com.github.zzx.prize.api.enums;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午9:20
 */
public enum PrizeRuleTypeEnum {

    CITY(1, "城市"),
    USS(2, "用户画像"),
    RULE_ENGINE(3, "规则引擎");

    public final Integer code;
    public final String desc;

    PrizeRuleTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static PrizeRuleTypeEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (PrizeRuleTypeEnum prizeRuleType : values()) {
            if (prizeRuleType.code.equals(code)) {
                return prizeRuleType;
            }
        }
        return null;
    }

    public static boolean validate(Integer code) {
        return getByCode(code) != null;
    }
}
