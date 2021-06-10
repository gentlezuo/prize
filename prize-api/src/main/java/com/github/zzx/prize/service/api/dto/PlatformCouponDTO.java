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
 * @date 2021/6/10 下午3:01
 */
@Data
public class PlatformCouponDTO extends CommonPrize {
    private static final long serialVersionUID = -2559426527386862803L;

    private BigDecimal amount;
    private BigDecimal amountLimit;
    private Long startTime;
    private Long endTime;
    private String desc;
    private List<Integer> categories;

    public static PlatformCouponDTO mock(){
        PlatformCouponDTO platformCouponDTO = new PlatformCouponDTO();
        platformCouponDTO.setAmount(new BigDecimal("1"));
        platformCouponDTO.setAmountLimit(new BigDecimal("10"));
        platformCouponDTO.setStartTime(System.currentTimeMillis()- TimeUnit.DAYS.toMillis(10));
        platformCouponDTO.setEndTime(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(10));
        platformCouponDTO.setDesc("恭喜您获得优惠券");
        List<Integer> categoryIds = new ArrayList<>();
        categoryIds.add(3);
        categoryIds.add(4);
        categoryIds.add(5);
        platformCouponDTO.setCategories(categoryIds);
        return platformCouponDTO;
    }
}
