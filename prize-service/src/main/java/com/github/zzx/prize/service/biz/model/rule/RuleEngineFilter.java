package com.github.zzx.prize.service.biz.model.rule;

import com.github.zzx.prize.api.dto.PrizeRuleDTO;
import com.github.zzx.prize.service.biz.model.ExecuteContext;
import com.github.zzx.prize.service.wrapper.RuleEngineWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 下午2:50
 */
@Component("RULE_ENGINE")
public class RuleEngineFilter implements RuleFilter {

    @Resource
    private RuleEngineWrapper ruleEngineWrapper;


    @Override
    public boolean filter(ExecuteContext executeContext, PrizeRuleDTO prizeRuleDTO) {
        if (StringUtils.isBlank(prizeRuleDTO.getDetail())){
            return true;
        }
        return ruleEngineWrapper.exec();
    }
}
