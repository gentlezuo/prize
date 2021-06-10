package com.github.zzx.prize.service.util;

import com.github.zzx.prize.api.dto.PrizeDTO;
import com.github.zzx.prize.api.dto.PrizeRuleDTO;
import com.github.zzx.prize.service.dal.entity.PrizeDO;
import com.github.zzx.prize.service.dal.entity.PrizeRuleDO;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 下午3:33
 */
public class PrizeConverter {

    public static PrizeDTO convertPrizeDO2DTO(PrizeDO prizeDO) {
        return PrizeDTO.builder()
                .id(prizeDO.getId())
                .name(prizeDO.getName())
                .status(prizeDO.getStatus())
                .type(prizeDO.getType())
                .startTime(prizeDO.getStartTime())
                .endTime(prizeDO.getEndTime())
                .createTime(prizeDO.getCreateTime())
                .updateTime(prizeDO.getUpdateTime())
                .creator(prizeDO.getCreator())
                .updater(prizeDO.getUpdater())
                .build();
    }

    public static PrizeRuleDTO convertPrizeRuleDO2DTO(PrizeRuleDO prizeRuleDO) {
        return PrizeRuleDTO.builder()
                .id(prizeRuleDO.getId())
                .prizeId(prizeRuleDO.getPrizeId())
                .type(prizeRuleDO.getType())
                .createTime(prizeRuleDO.getCreateTime())
                .updateTime(prizeRuleDO.getUpdateTime())
                .detail(prizeRuleDO.getDetail())
                .build();
    }

    public static List<PrizeRuleDTO> convertPrizeRuleDTOs2DOs(List<PrizeRuleDO> prizeRuleDOS) {
        if (CollectionUtils.isEmpty(prizeRuleDOS)){
            return new ArrayList<>();
        }
        List<PrizeRuleDTO> ruleDTOS = new ArrayList<>(prizeRuleDOS.size());
        for (PrizeRuleDO prizeRuleDO: prizeRuleDOS){
            PrizeRuleDTO dto = convertPrizeRuleDO2DTO(prizeRuleDO);
            if (dto!=null){
                ruleDTOS.add(dto);
            }
        }
        return ruleDTOS;
    }
}
