package com.github.zzx.prize.api.service;

import com.github.zzx.prize.api.dto.CommonResponse;
import com.github.zzx.prize.api.dto.PrizeDTO;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午8:57
 */
public interface PrizeManageService {

    CommonResponse<Long> save(PrizeDTO prizeDTO);

    CommonResponse<PrizeDTO> queryById(Long prizeId);

    CommonResponse<Long> update(PrizeDTO prizeDTO);

    CommonResponse<Boolean> operate(Long prizeId,Integer operateType);
}
