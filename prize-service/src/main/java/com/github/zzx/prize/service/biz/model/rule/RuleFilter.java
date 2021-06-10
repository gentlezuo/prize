package com.github.zzx.prize.service.biz.model.rule;

import com.github.zzx.prize.api.dto.PrizeRuleDTO;
import com.github.zzx.prize.service.biz.model.ExecuteContext;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 下午12:02
 */
public interface RuleFilter {

    boolean filter(ExecuteContext executeContext, PrizeRuleDTO prizeRuleDTO);
}
