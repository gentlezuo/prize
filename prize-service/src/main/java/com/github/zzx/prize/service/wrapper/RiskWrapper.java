package com.github.zzx.prize.service.wrapper;

import com.github.zzx.prize.api.dto.req.RiskContextDTO;
import com.github.zzx.prize.service.util.DynamicConfigUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午11:45
 */
@Component
public class RiskWrapper {
    public static final Logger logger = LoggerFactory.getLogger(RiskWrapper.class);

    public boolean check(RiskContextDTO riskContextDTO) {
        if (!DynamicConfigUtils.isExecRisk()) {
            return true;
        }
        //do risk logic
        return true;
    }
}
