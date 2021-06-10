package com.github.zzx.prize.api.enums;

/**
 * @author zuozhixin
 * @description: 奖品类型
 * @date 2021/6/10 上午9:12
 */
public enum PrizeTypeEnum {

    PLATFORM_COUPON(1, "平台券"),
    MERCHANT_COUPON(2, "商家券"),
    THANKS(99, "谢谢惠顾");

    private final Integer type;
    private final String desc;

    PrizeTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static PrizeTypeEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (PrizeTypeEnum prizeType : values()) {
            if (prizeType.type.equals(code)) {
                return prizeType;
            }
        }
        return null;
    }

    public static boolean validate(Integer code) {
        return getByCode(code) != null;
    }
}
