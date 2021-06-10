package com.github.zzx.prize.service.wrapper;

import org.springframework.stereotype.Component;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 下午2:46
 */
@Component
public class UssWrapper {

    public boolean match(Integer ussCode, Long userId) {
        return true;
    }
}
