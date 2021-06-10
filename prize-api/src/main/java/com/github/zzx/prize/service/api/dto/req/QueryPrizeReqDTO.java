package com.github.zzx.prize.api.dto.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午9:40
 */
@Data
public class QueryPrizeReqDTO implements Serializable {

    private static final long serialVersionUID = 1129011169331127127L;

    private Long userId;
    private Long prizeId;
}
