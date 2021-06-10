package com.github.zzx.prize.service.biz.model.prize;

import com.github.zzx.prize.api.dto.MerchantCouponDTO;
import com.github.zzx.prize.api.dto.resp.SendPrizeResp;
import com.github.zzx.prize.service.biz.model.ExecuteContext;
import com.github.zzx.prize.service.wrapper.MerchantCouponWrapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 下午3:08
 */
@Component("MERCHANT_COUPON")
public class MerchantCouponSender implements PrizeSender {

    @Resource
    private MerchantCouponWrapper merchantCouponWrapper;

    @Override
    public SendPrizeResp send(ExecuteContext executeContext) {
        SendPrizeResp sendPrizeResp = new SendPrizeResp();
        sendPrizeResp.setSuccess(true);
        sendPrizeResp.setPrizeType(executeContext.getPrizeDTO().getType());
        sendPrizeResp.setCommonPrize(MerchantCouponDTO.mock());
        return sendPrizeResp;
    }
}
