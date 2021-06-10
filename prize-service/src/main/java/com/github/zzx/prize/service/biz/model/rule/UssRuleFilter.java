package com.github.zzx.prize.service.biz.model.rule;

import com.github.zzx.prize.api.dto.PrizeRuleDTO;
import com.github.zzx.prize.service.biz.model.ExecuteContext;
import com.github.zzx.prize.service.wrapper.UssWrapper;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 下午2:45
 */
@Component("USS")
public class UssRuleFilter implements RuleFilter {

    @Resource
    private UssWrapper ussWrapper;

    @Override
    public boolean filter(ExecuteContext executeContext, PrizeRuleDTO prizeRuleDTO) {
        Integer ussCode = Integer.valueOf(prizeRuleDTO.getDetail());
        if (NumberUtils.INTEGER_ZERO.equals(ussCode)){
            return true;
        }
        return ussWrapper.match(ussCode,executeContext.getUserId());
    }
}
