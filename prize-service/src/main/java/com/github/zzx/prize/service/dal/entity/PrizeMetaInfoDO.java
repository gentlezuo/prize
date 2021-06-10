package com.github.zzx.prize.service.dal.entity;

import lombok.Data;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/9 下午11:35
 */
@Data
public class PrizeMetaInfoDO {

    private Long id;
    private Long prizeId;
    private Integer type;
    private String content;
    private Long createTime;
    private Long updateTime;
}
