package com.github.zzx.prize.service.dal.mapper;

import com.github.zzx.prize.service.dal.entity.PrizeMetaInfoDO;

import java.util.List;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/9 下午11:46
 */
public interface PrizeMetaInfoMapper {

    void insert (PrizeMetaInfoDO prizeMetaInfoDO);

    PrizeMetaInfoDO selectById(Long id);

    List<PrizeMetaInfoDO> selectByPrizeId(Long prizeId);
}
