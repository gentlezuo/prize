package com.github.zzx.prize.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午9:10
 */
@Data
public class PrizeRuleDTO implements Serializable {

    private static final long serialVersionUID = -7559042904556794975L;

    private Long id;
    private Long prizeId;
    private Integer type;
    private String detail;
    private Long createTime;
    private Long updateTime;

}
