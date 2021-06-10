package com.github.zzx.prize.service.dal.mapper;

import com.github.zzx.prize.service.dal.entity.PrizeLogDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/9 下午11:48
 */
public interface PrizeLogMapper {

    void insert(PrizeLogDO prizeLogDO);

    PrizeLogDO selectById(Long id);

    List<PrizeLogDO> selectByUserAndPrizeId(Long userId,Long prizeId);

    int update(PrizeLogDO prizeLog);

    PrizeLogDO selectByUnique(String uniqueKey);
}
