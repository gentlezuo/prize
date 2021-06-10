package com.github.zzx.prize.api.dto;

import com.github.zzx.prize.api.enums.RespCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午8:58
 */
@Data
public class CommonResponse<T> implements Serializable {

    private static final long serialVersionUID = -9121788042647766786L;

    private String code;

    private String msg;

    private T data;

    public CommonResponse<T> fail(String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
        return this;
    }

    public CommonResponse<T> fail(RespCodeEnum respCodeEnum) {
        this.code = respCodeEnum.code;
        this.msg = respCodeEnum.desc;
        this.data = null;
        return this;
    }

    public CommonResponse<T> success(T t) {
        this.code = RespCodeEnum.SUCCESS.code;
        this.msg = RespCodeEnum.SUCCESS.desc;
        this.data = t;
        return this;
    }

}
