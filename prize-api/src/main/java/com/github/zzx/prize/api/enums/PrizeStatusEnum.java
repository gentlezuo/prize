package com.github.zzx.prize.api.enums;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午9:17
 */
public enum PrizeStatusEnum {

    DRAFT(1, "草稿"),
    ONLINE(2, "在线"),
    OFFLINE(3, "下线");

    public final Integer code;
    public final String desc;

    PrizeStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
