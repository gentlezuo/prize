package com.github.zzx.prize.api.exception;

import lombok.Data;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午9:00
 */
@Data
public class PrizeBizException extends RuntimeException{

    private static final long serialVersionUID = -6757909233212311707L;

    private final String code;
    private final String msg;

    PrizeBizException(String code,String msg){
        super();
        this.code=code;
        this.msg=msg;
    }

}
