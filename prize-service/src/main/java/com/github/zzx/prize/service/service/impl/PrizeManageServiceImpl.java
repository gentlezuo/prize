package com.github.zzx.prize.service.service.impl;

import com.github.zzx.prize.api.dto.CommonResponse;
import com.github.zzx.prize.api.dto.PrizeDTO;
import com.github.zzx.prize.api.service.PrizeManageService;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午9:23
 */
public class PrizeManageServiceImpl implements PrizeManageService {

    @Override
    public CommonResponse<Long> save(PrizeDTO prizeDTO) {
        return null;
    }

    @Override
    public CommonResponse<PrizeDTO> queryById(Long prizeId) {
        return null;
    }

    @Override
    public CommonResponse<Long> update(PrizeDTO prizeDTO) {
        return null;
    }

    @Override
    public CommonResponse<Boolean> operate(Long prizeId, Integer operateType) {
        return null;
    }
}
