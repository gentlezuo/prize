package com.github.zzx.prize.service;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/9 下午10:55
 */
@MapperScan("com.github.zzx.prize.service.dal.mapper")
@SpringBootApplication(scanBasePackages = {"com.github.zzx.prize.service"})
public class PrizeApplication {

    private static final Logger logger = LoggerFactory.getLogger(PrizeApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PrizeApplication.class, args);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> logger.info("prize server shutdown!!!")));
    }

}
