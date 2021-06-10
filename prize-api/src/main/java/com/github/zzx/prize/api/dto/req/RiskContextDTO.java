package com.github.zzx.prize.api.dto.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午9:35
 */
@Data
public class RiskContextDTO implements Serializable {
    private static final long serialVersionUID = -310342651470723101L;

    private String env;
    private String ip;
    private String userAgent;
    private String reqUrl;
    private String referUrl;
    private String fingerprint;
    private String uuid;
}
