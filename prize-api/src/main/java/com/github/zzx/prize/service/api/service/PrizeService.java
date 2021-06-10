package com.github.zzx.prize.api.service;

import com.github.zzx.prize.api.dto.CommonResponse;
import com.github.zzx.prize.api.dto.req.QueryPrizeReqDTO;
import com.github.zzx.prize.api.dto.req.SendPrizeReqDTO;
import com.github.zzx.prize.api.dto.resp.SendPrizeResp;

import java.util.List;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午8:58
 */
public interface PrizeService {

    CommonResponse<SendPrizeResp> sendPrize(SendPrizeReqDTO sendPrizeReqDTO);

    CommonResponse<List<SendPrizeResp>> queryPrize(QueryPrizeReqDTO queryPrizeReqDTO);
}
