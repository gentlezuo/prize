package com.github.zzx.prize.service.biz.impl;

import com.github.zzx.prize.api.dto.CommonResponse;
import com.github.zzx.prize.api.dto.PrizeDTO;
import com.github.zzx.prize.api.dto.PrizeRuleDTO;
import com.github.zzx.prize.api.dto.req.SendPrizeReqDTO;
import com.github.zzx.prize.api.dto.resp.SendPrizeResp;
import com.github.zzx.prize.api.enums.PrizeStatusEnum;
import com.github.zzx.prize.api.enums.RespCodeEnum;
import com.github.zzx.prize.service.biz.PrizeBizService;
import com.github.zzx.prize.service.biz.model.prize.PrizeFactory;
import com.github.zzx.prize.service.biz.model.prize.PrizeSender;
import com.github.zzx.prize.service.biz.model.rule.RuleFactory;
import com.github.zzx.prize.service.biz.model.rule.RuleFilter;
import com.github.zzx.prize.service.dal.entity.PrizeLogDO;
import com.github.zzx.prize.service.dao.PrizeDAO;
import com.github.zzx.prize.service.dao.PrizeLogDAO;
import com.github.zzx.prize.service.dao.PrizeRuleDAO;
import com.github.zzx.prize.service.biz.model.ExecuteContext;
import com.github.zzx.prize.service.util.DynamicConfigUtils;
import com.github.zzx.prize.service.util.LimiterUtils;
import com.github.zzx.prize.service.wrapper.RiskWrapper;
import com.github.zzx.prize.service.wrapper.StockWrapper;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisAccessor;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午10:40
 */
public class PrizeBizServiceImpl implements PrizeBizService {

    private static final Logger logger = LoggerFactory.getLogger(PrizeBizServiceImpl.class);

    @Resource
    private PrizeDAO prizeDAO;
    @Resource
    private PrizeRuleDAO prizeRuleDAO;
    @Resource
    private PrizeLogDAO prizeLogDAO;
    @Resource
    RedisAccessor redisAccessor;
    @Resource
    private RiskWrapper riskWrapper;
    @Resource
    private RuleFactory ruleFactory;
    @Resource
    private PrizeFactory prizeFactory;
    @Resource
    private StockWrapper stockWrapper;




    @Override
    public CommonResponse<SendPrizeResp> sendPrize(SendPrizeReqDTO sendPrizeReqDTO) {
        CommonResponse<SendPrizeResp> response = new CommonResponse<>();

        //1.查奖品、规则
        PrizeDTO prizeDTO = getPrizeDTO(sendPrizeReqDTO.getPrizeId());

        //2.校验
        Pair<Boolean,RespCodeEnum> checkRes = checkPrizeDTO(prizeDTO);
        if (!checkRes.getLeft()){
            return response.fail(checkRes.getRight());
        }

        //3.限流
        if(!LimiterUtils.getLimiter(sendPrizeReqDTO.getPrizeId()).tryAcquire()){
            return response.fail(RespCodeEnum.LIMIT);
        }

        //4.风控
        if (!riskWrapper.check(sendPrizeReqDTO.getRiskContext())){
            return response.fail(RespCodeEnum.RISK);
        }

        //4.构建发放上下文
        ExecuteContext executeContext = buildExecuteContext(sendPrizeReqDTO,prizeDTO);

        //5.策略模式过滤
        boolean filterRes = filterByRules(executeContext);
        if (!filterRes){
            return response.fail(RespCodeEnum.NOT_MATCH_RULE);
        }

        //6.发奖
        return issuePrize(executeContext);

    }

    private CommonResponse<SendPrizeResp> issuePrize(ExecuteContext executeContext) {

        CommonResponse<SendPrizeResp> response = new CommonResponse<>();

        //扣减
        boolean lockRes = stockWrapper.consumeStock(executeContext.getPrizeId());
        if (!lockRes){
            return response.fail(RespCodeEnum.CONSUME_STOCK_FAIL);
        }

        //记录流水
        PrizeLogDO prizeLog = buildInitPrizeLog(executeContext);
        prizeLogDAO.insert(prizeLog);
        if (prizeLog.getId()==null){
            stockWrapper.rollbackStock(executeContext.getPrizeId());
            return response.fail(RespCodeEnum.SYSTEM_ERROR);
        }

        //发放奖品
        PrizeSender sender = prizeFactory.getSender(executeContext.getPrizeDTO().getType());
        if (sender==null){
            stockWrapper.rollbackStock(executeContext.getPrizeId());
            return response.fail(RespCodeEnum.PRIZE_CONFIG_ERROR);
        }

        SendPrizeResp sendResp = sender.send(executeContext);
        if (!sendResp.isSuccess()){
            stockWrapper.rollbackStock(executeContext.getPrizeId());
            prizeLog.setStatus(2);

            prizeLogDAO.update(prizeLog);
        }

        //更新记录
        prizeLog.setStatus(3);
        boolean updateRes = prizeLogDAO.update(prizeLog);
        if (!updateRes){
            logger.error("");
        }
        return response.success(sendResp);

    }

    private PrizeLogDO buildInitPrizeLog(ExecuteContext executeContext) {
        return PrizeLogDO.builder()
                .userId(executeContext.getUserId())
                .prizeId(executeContext.getPrizeId())
                .createTime(System.currentTimeMillis())
                .detail("")
                .status(1)
                .build();
    }

    private boolean filterByRules(ExecuteContext executeContext) {
        List<PrizeRuleDTO> rules = executeContext.getPrizeDTO().getPrizeRules();
        for(PrizeRuleDTO rule:rules){
            RuleFilter filter = ruleFactory.getFilter(rule.getType());
            if (filter == null){
                if(!DynamicConfigUtils.ruleNullPass()){
                    return false;
                }else {
                    continue;
                }
            }
            boolean filterRes = filter.filter(executeContext);
            if (!filterRes){
                return false;
            }

        }
        return true;
    }

    private PrizeDTO getPrizeDTO(Long prizeId) {
        PrizeDTO prizeDTO = getFromRedis(prizeId);
        if (prizeDTO != null){
            return prizeDTO;
        }
        prizeDTO = getFromDB(prizeId);
        if (prizeDTO!=null){
            //set redis
        }
        return prizeDTO;
    }

    private ExecuteContext buildExecuteContext(SendPrizeReqDTO sendPrizeReqDTO, PrizeDTO prizeDTO) {
        ExecuteContext executeContext = new ExecuteContext();
        executeContext.setUserId(sendPrizeReqDTO.getUserId());
        executeContext.setPrizeId(sendPrizeReqDTO.getPrizeId());
        executeContext.setCityId(sendPrizeReqDTO.getCityId());
        executeContext.setUniqueKey(sendPrizeReqDTO.getUniqueKey());
        executeContext.setRiskContext(sendPrizeReqDTO.getRiskContext());
        executeContext.setPrizeDTO(prizeDTO);
        return executeContext;
    }

    private Pair<Boolean, RespCodeEnum> checkPrizeDTO(PrizeDTO prizeDTO) {

        if (prizeDTO ==null){
            return Pair.of(Boolean.FALSE,RespCodeEnum.NO_PRIZE);
        }

        long now=System.currentTimeMillis();
        if (!prizeDTO.getStatus().equals(PrizeStatusEnum.ONLINE.code)){
            return Pair.of(Boolean.FALSE,RespCodeEnum.PRIZE_EXPIRED);
        }
        if(prizeDTO.getEndTime()>now){
            return Pair.of(Boolean.FALSE,RespCodeEnum.PRIZE_EXPIRED);
        }
        if (prizeDTO.getStartTime()<now){
            return Pair.of(Boolean.FALSE,RespCodeEnum.PRIZE_NOT_START);
        }
        return Pair.of(Boolean.TRUE,null);
    }
}
