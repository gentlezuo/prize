package com.github.zzx.prize.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午9:05
 */
@Data
public class PrizeDTO implements Serializable {

    private static final long serialVersionUID = 9175407791086482034L;

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

    List<PrizeRuleDTO> prizeRules;
    List<PrizeMetaInfo> prizeMetaInfos;
}
