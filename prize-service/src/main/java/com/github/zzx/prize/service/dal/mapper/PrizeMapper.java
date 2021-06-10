package com.github.zzx.prize.service.dal.mapper;

import com.github.zzx.prize.service.dal.entity.PrizeDO;
import org.springframework.stereotype.Repository;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/9 下午11:42
 */
public interface PrizeMapper {

    void insert(PrizeDO prizeDO);

    PrizeDO selectById(Long id);

}
