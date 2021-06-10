package com.github.zzx.prize.service.biz.model;

import com.github.zzx.prize.api.dto.PrizeDTO;
import com.github.zzx.prize.api.dto.req.RiskContextDTO;
import lombok.Data;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午11:00
 */
@Data
public class ExecuteContext {

    private Long userId;
    private Long prizeId;
    private String uniqueKey;
    private Integer cityId;
    private RiskContextDTO riskContext;
    private PrizeDTO prizeDTO;
}
