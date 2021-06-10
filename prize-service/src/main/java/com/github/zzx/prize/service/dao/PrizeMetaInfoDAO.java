package com.github.zzx.prize.service.dao;

import com.github.zzx.prize.service.dal.entity.PrizeMetaInfoDO;

import java.util.List;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/9 下午11:53
 */
public interface PrizeMetaInfoDAO {

    void insert (PrizeMetaInfoDO prizeMetaInfoDO);

    PrizeMetaInfoDO selectById(Long id);

    List<PrizeMetaInfoDO> selectByPrizeId(Long prizeId);
}
