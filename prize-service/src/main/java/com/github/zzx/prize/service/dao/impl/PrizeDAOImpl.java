package com.github.zzx.prize.service.dao.impl;

import com.github.zzx.prize.service.dal.entity.PrizeDO;
import com.github.zzx.prize.service.dal.mapper.PrizeMapper;
import com.github.zzx.prize.service.dao.PrizeDAO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午12:02
 */
@Repository
public class PrizeDAOImpl implements PrizeDAO {

    @Resource
    private PrizeMapper prizeMapper;

    @Override
    public void insert(PrizeDO prizeDO) {
        prizeMapper.insert(prizeDO);
    }

    @Override
    public PrizeDO selectById(Long id) {
        return prizeMapper.selectById(id);
    }
}
