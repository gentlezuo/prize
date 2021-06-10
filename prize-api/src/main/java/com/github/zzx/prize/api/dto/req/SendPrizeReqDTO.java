package com.github.zzx.prize.api.dto.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午9:29
 */
@Data
public class SendPrizeReqDTO implements Serializable {

    private static final long serialVersionUID = -6455326443099666672L;

    private Long userId;
    private Long prizeId;
    private String uniqueKey;
    private Integer cityId;
    private RiskContextDTO riskContext;


}
