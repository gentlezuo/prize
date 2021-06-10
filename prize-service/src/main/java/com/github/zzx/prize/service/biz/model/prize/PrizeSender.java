package com.github.zzx.prize.service.biz.model.prize;

import com.github.zzx.prize.api.dto.resp.SendPrizeResp;
import com.github.zzx.prize.service.biz.model.ExecuteContext;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 下午12:32
 */
public interface PrizeSender {

    SendPrizeResp send(ExecuteContext executeContext);
}
