package com.github.zzx.prize.service.dal.mapper;

import com.github.zzx.prize.service.BaseTest;
import com.github.zzx.prize.service.dal.entity.PrizeDO;
import org.junit.Test;


import javax.annotation.Resource;


public class PrizeMapperTest extends BaseTest {

    @Resource
    PrizeMapper prizeMapper;

    @Test
    public void insert() {
    }

    @Test
    public void selectById() {
        System.out.println(prizeMapper);
         PrizeDO prizeDO = prizeMapper.selectById(1L);
        System.out.println(prizeDO);
    }
}