package com.github.zzx.prize.service.biz.model.rule;

import com.github.zzx.prize.api.dto.PrizeRuleDTO;
import com.github.zzx.prize.service.biz.model.ExecuteContext;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 下午2:39
 */
@Component("CITY")
public class CityRuleFilter implements RuleFilter {
    @Override
    public boolean filter(ExecuteContext executeContext, PrizeRuleDTO prizeRuleDTO) {
        Integer cityId = Integer.parseInt(prizeRuleDTO.getDetail());
        return NumberUtils.INTEGER_ZERO.equals(cityId) || cityId.equals(executeContext.getCityId());
    }
}
