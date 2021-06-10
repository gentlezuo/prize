package com.github.zzx.prize.service.dao.impl;

import com.github.zzx.prize.service.dal.entity.PrizeMetaInfoDO;
import com.github.zzx.prize.service.dal.mapper.PrizeMetaInfoMapper;
import com.github.zzx.prize.service.dao.PrizeMetaInfoDAO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午12:02
 */
@Repository
public class PrizeMetaInfoDAOImpl implements PrizeMetaInfoDAO {

    @Resource
    private PrizeMetaInfoMapper prizeMetaInfoMapper;

    @Override
    public void insert(PrizeMetaInfoDO prizeMetaInfoDO) {
        prizeMetaInfoMapper.insert(prizeMetaInfoDO);
    }

    @Override
    public PrizeMetaInfoDO selectById(Long id) {
        return prizeMetaInfoMapper.selectById(id);
    }

    @Override
    public List<PrizeMetaInfoDO> selectByPrizeId(Long prizeId) {
        return prizeMetaInfoMapper.selectByPrizeId(prizeId);
    }
}
