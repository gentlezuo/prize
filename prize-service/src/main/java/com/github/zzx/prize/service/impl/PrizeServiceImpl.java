package com.github.zzx.prize.service.impl;

import com.github.zzx.prize.api.dto.CommonResponse;
import com.github.zzx.prize.api.dto.req.QueryPrizeReqDTO;
import com.github.zzx.prize.api.dto.req.SendPrizeReqDTO;
import com.github.zzx.prize.api.dto.resp.SendPrizeResp;
import com.github.zzx.prize.api.enums.RespCodeEnum;
import com.github.zzx.prize.api.exception.PrizeBizException;
import com.github.zzx.prize.api.service.PrizeService;
import com.github.zzx.prize.service.biz.PrizeBizService;
import com.github.zzx.prize.service.util.PrizeChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午9:48
 */
public class PrizeServiceImpl implements PrizeService {

    private static final Logger logger = LoggerFactory.getLogger(PrizeServiceImpl.class);

    @Resource
    private PrizeBizService prizeBizService;


    @Override
    public CommonResponse<SendPrizeResp> sendPrize(SendPrizeReqDTO sendPrizeReqDTO) {
        logger.info("prizeService sendPrize enter. sendPrizeReqDTO = {}", sendPrizeReqDTO);
        CommonResponse<SendPrizeResp> response = new CommonResponse<>();
        try {
            PrizeChecker.checkSendPrizeReqDTO(sendPrizeReqDTO);
            response = prizeBizService.sendPrize(sendPrizeReqDTO);
            logger.info("prizeService sendPrize end. resp = {}", response);
            return response;
        } catch (IllegalArgumentException iae) {
            logger.warn("prizeService sendPrize param error. sendPrizeReqDTO = {}", sendPrizeReqDTO, iae);
            return response.fail(RespCodeEnum.PARAM_ERROR);
        } catch (PrizeBizException pbe) {
            logger.error("prizeService sendPrize biz error. sendPrizeReqDTO = {}", sendPrizeReqDTO, pbe);
            return response.fail(pbe.getCode(), pbe.getMsg());
        } catch (Exception e) {
            logger.error("prizeService sendPrize system error. sendPrizeReqDTO = {}", sendPrizeReqDTO, e);
            return response.fail(RespCodeEnum.SYSTEM_ERROR);
        }
    }

    @Override
    public CommonResponse<List<SendPrizeResp>> queryPrize(QueryPrizeReqDTO queryPrizeReqDTO) {
        logger.info("prizeService queryPrize enter. queryPrizeReqDTO = {}", queryPrizeReqDTO);
        CommonResponse<List<SendPrizeResp>> response = new CommonResponse<>();
        try {
            PrizeChecker.checkQueryPrizeReqDTO(queryPrizeReqDTO);
            response = prizeBizService.queryPrize(queryPrizeReqDTO);
            logger.info("prizeService queryPrize end. resp = {}", response);
            return response;
        } catch (IllegalArgumentException iae) {
            logger.warn("prizeService queryPrize param error. queryPrizeReqDTO = {}", queryPrizeReqDTO, iae);
            return response.fail(RespCodeEnum.PARAM_ERROR);
        } catch (PrizeBizException pbe) {
            logger.error("prizeService queryPrize biz error. queryPrizeReqDTO = {}", queryPrizeReqDTO, pbe);
            return response.fail(pbe.getCode(), pbe.getMsg());
        } catch (Exception e) {
            logger.error("prizeService queryPrize system error. queryPrizeReqDTO = {}", queryPrizeReqDTO, e);
            return response.fail(RespCodeEnum.SYSTEM_ERROR);
        }

    }
}
