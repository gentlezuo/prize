package com.github.zzx.prize.service.dal.entity;

import lombok.Data;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/9 下午11:27
 */
@Data
public class PrizeDO {

    private Long id;
    private String name;
    private Integer type;
    private Long startTime;
    private Long endTime;
    private Integer status;
    private Long createTime;
    private Long updateTime;
    private String creator;
    private String updater;
}
