package com.github.zzx.prize.service.dao.impl;

import com.github.zzx.prize.service.dal.entity.PrizeLogDO;
import com.github.zzx.prize.service.dal.mapper.PrizeLogMapper;
import com.github.zzx.prize.service.dao.PrizeLogDAO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午12:02
 */
@Repository
public class PrizeLogDAOImpl implements PrizeLogDAO {

    @Resource
    private PrizeLogMapper prizeLogMapper;

    @Override
    public void insert(PrizeLogDO prizeLogDO) {
        prizeLogMapper.insert(prizeLogDO);
    }

    @Override
    public PrizeLogDO selectById(Long id) {
        return prizeLogMapper.selectById(id);
    }

    @Override
    public List<PrizeLogDO> selectByUserIdAndPrizeId(Long userId, Long prizeId) {
        return prizeLogMapper.selectByUserAndPrizeId(userId,prizeId);
    }

    @Override
    public boolean update(PrizeLogDO prizeLog) {
        return prizeLogMapper.update(prizeLog)>0;
    }
}
