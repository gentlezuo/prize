package com.github.zzx.prize.service.dal.entity;

import lombok.Data;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/9 下午11:30
 */
@Data
public class PrizeRuleDO {

    private Long id;
    private Long prizeId;
    private Integer type;
    private String detail;
    private Long createTime;
    private Long updateTime;
}
