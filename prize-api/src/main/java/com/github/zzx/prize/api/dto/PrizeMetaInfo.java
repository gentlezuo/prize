package com.github.zzx.prize.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午9:11
 */
@Data
public class PrizeMetaInfo implements Serializable {

    private static final long serialVersionUID = 4863608822691428209L;

    private Long id;
    private Long prizeId;
    private Integer type;
    private String content;
    private Long createTime;
    private Long updateTime;
}
