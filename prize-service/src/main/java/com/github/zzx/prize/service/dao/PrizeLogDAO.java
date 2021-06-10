package com.github.zzx.prize.service.dao;

import com.github.zzx.prize.service.dal.entity.PrizeLogDO;

import java.util.List;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/9 下午11:54
 */
public interface PrizeLogDAO {

    void insert(PrizeLogDO prizeLogDO);

    PrizeLogDO selectById(Long id);

    List<PrizeLogDO> selectByUserIdAndPrizeId(Long userId, Long prizeId);

    boolean update(PrizeLogDO prizeLog);
}
