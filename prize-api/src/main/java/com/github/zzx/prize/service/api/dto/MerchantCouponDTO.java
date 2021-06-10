package com.github.zzx.prize.api.dto;

import com.github.zzx.prize.api.dto.resp.CommonPrize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 下午3:08
 */
@Data
public class MerchantCouponDTO extends CommonPrize {
    private static final long serialVersionUID = -1956582770475964498L;

    private BigDecimal amount;
    private BigDecimal amountLimit;
    private Long startTime;
    private Long endTime;
    private String desc;
    List<Long> limitShopIds;

    public static MerchantCouponDTO mock() {
        MerchantCouponDTO merchantCouponDTO = new MerchantCouponDTO();
        merchantCouponDTO.setAmount(new BigDecimal("5"));
        merchantCouponDTO.setAmount(new BigDecimal("20"));
        merchantCouponDTO.setStartTime(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(5));
        merchantCouponDTO.setEndTime(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(5));
        merchantCouponDTO.setDesc("恭喜");
        ArrayList<Long> shopIds = new ArrayList<>();
        shopIds.add(1L);
        shopIds.add(2L);
        shopIds.add(3L);
        merchantCouponDTO.setLimitShopIds(shopIds);
        return merchantCouponDTO;
    }

}
