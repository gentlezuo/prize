package com.github.zzx.prize.service.dao.impl;

import com.github.zzx.prize.service.dal.entity.PrizeRuleDO;
import com.github.zzx.prize.service.dal.mapper.PrizeRuleMapper;
import com.github.zzx.prize.service.dao.PrizeRuleDAO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午12:03
 */
@Repository
public class PrizeRuleDAOImpl implements PrizeRuleDAO {

    @Resource
    private PrizeRuleMapper prizeRuleMapper;

    @Override
    public void insert(PrizeRuleDO prizeRuleDO) {
        prizeRuleMapper.insert(prizeRuleDO);
    }

    @Override
    public PrizeRuleDO selectById(Long id) {
        return prizeRuleMapper.selectById(id);
    }

    @Override
    public List<PrizeRuleDO> selectByPrizeId(Long prizeId) {
        return prizeRuleMapper.selectByPrizeId(prizeId);
    }
}
