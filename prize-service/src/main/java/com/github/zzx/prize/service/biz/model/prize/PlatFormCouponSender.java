package com.github.zzx.prize.service.biz.model.prize;

import com.github.zzx.prize.api.dto.PlatformCouponDTO;
import com.github.zzx.prize.api.dto.resp.SendPrizeResp;
import com.github.zzx.prize.service.biz.model.ExecuteContext;
import com.github.zzx.prize.service.wrapper.PlatFormCouponWrapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 下午2:58
 */
@Component("PLATFORM_COUPON")
public class PlatFormCouponSender implements PrizeSender {

    @Resource
    private PlatFormCouponWrapper platFormCouponWrapper;

    @Override
    public SendPrizeResp send(ExecuteContext executeContext) {
        SendPrizeResp sendPrizeResp = new SendPrizeResp();
        sendPrizeResp.setSuccess(true);
        sendPrizeResp.setPrizeType(executeContext.getPrizeDTO().getType());
        sendPrizeResp.setCommonPrize(PlatformCouponDTO.mock());
        return sendPrizeResp;
    }
}
