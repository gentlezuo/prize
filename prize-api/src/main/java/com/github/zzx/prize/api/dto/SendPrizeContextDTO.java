package com.github.zzx.prize.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午9:32
 */
@Data
public class SendPrizeContextDTO implements Serializable {
    private static final long serialVersionUID = -7962638868336192166L;

    private Integer cityId;

}
