package com.github.zzx.prize.service.biz;

import com.github.zzx.prize.api.dto.CommonResponse;
import com.github.zzx.prize.api.dto.req.QueryPrizeReqDTO;
import com.github.zzx.prize.api.dto.req.SendPrizeReqDTO;
import com.github.zzx.prize.api.dto.resp.SendPrizeResp;

import java.util.List;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午10:16
 */
public interface PrizeBizService {


    CommonResponse<SendPrizeResp> sendPrize(SendPrizeReqDTO sendPrizeReqDTO);

    CommonResponse<List<SendPrizeResp>> queryPrize(QueryPrizeReqDTO queryPrizeReqDTO);
}
