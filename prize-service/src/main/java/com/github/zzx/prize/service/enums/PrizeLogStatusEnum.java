package com.github.zzx.prize.service.enums;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 下午2:06
 */
public enum PrizeLogStatusEnum {
    INIT(1, "初始化"),
    FAIL(2, "发送失败"),
    SUCCESS(3, "发送成功");

    public final Integer code;
    public final String desc;

    PrizeLogStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static PrizeLogStatusEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (PrizeLogStatusEnum prizeLogStatus : values()) {
            if (prizeLogStatus.code.equals(code)) {
                return prizeLogStatus;
            }
        }
        return null;
    }

    public static boolean isFinalState(Integer code) {
        PrizeLogStatusEnum prizeLogStatusEnum = getByCode(code);
        return prizeLogStatusEnum == FAIL || prizeLogStatusEnum == SUCCESS;
    }
}
