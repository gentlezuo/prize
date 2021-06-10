package com.github.zzx.prize.api.dto.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午9:45
 */
@Data
public class SendPrizeResp implements Serializable {
    private static final long serialVersionUID = 2173843541930592397L;

    private boolean success;

    private Integer prizeType;

    private CommonPrize commonPrize;
}
