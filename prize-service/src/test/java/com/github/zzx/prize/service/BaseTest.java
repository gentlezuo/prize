package com.github.zzx.prize.service;

import com.github.zzx.prize.service.dal.mapper.PrizeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 下午4:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BaseTest {

    @Test
    public void baseTest(){
        System.out.println("test");
    }

}
