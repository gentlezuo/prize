package com.github.zzx.prize.service.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/9 下午11:39
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrizeLogDO {

    private Long id;
    private Long prizeId;
    private Long userId;
    private String uniqueKey;
    private Integer status;
    private String detail;
    private String memo;
    private Long createTime;
    private Long updateTime;

}
