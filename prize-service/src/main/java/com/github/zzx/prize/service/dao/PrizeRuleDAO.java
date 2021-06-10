package com.github.zzx.prize.service.dao;

import com.github.zzx.prize.service.dal.entity.PrizeRuleDO;

import java.util.List;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/9 下午11:53
 */
public interface PrizeRuleDAO {

    void insert(PrizeRuleDO prizeRuleDO);

    PrizeRuleDO selectById(Long id);

    List<PrizeRuleDO> selectByPrizeId(Long prizeId);
}
