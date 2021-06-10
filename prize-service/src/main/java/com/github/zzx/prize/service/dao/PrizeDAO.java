package com.github.zzx.prize.service.dao;

import com.github.zzx.prize.service.dal.entity.PrizeDO;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/9 下午11:53
 */
public interface PrizeDAO {

    void insert(PrizeDO prizeDO);

    PrizeDO selectById(Long id);
}
