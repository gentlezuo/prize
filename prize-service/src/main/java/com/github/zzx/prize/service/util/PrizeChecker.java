package com.github.zzx.prize.service.util;

import com.github.zzx.prize.api.dto.req.SendPrizeReqDTO;
import com.google.common.base.Preconditions;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.StringUtils;

/**
 * @author zuozhixin
 * @description:
 * @date 2021/6/10 上午10:18
 */
public class PrizeChecker {

    public static void checkSendPrizeReqDTO(SendPrizeReqDTO sendPrizeReqDTO) {
        checkNotNull(sendPrizeReqDTO);
        Preconditions.checkArgument(sendPrizeReqDTO.getUserId() != null && sendPrizeReqDTO.getUserId() > 0, "userId should not be null and gt 0");
        Preconditions.checkArgument(sendPrizeReqDTO.getPrizeId()!=null&&sendPrizeReqDTO.getPrizeId()>0,"prizeId should not be null and gt 0");
        Preconditions.checkArgument(Strings.isNotBlank(sendPrizeReqDTO.getUniqueKey()),"uniqueKey should not be empty");
    }


    public static <T> void checkNotNull(T t) {
        Preconditions.checkNotNull(t, "param should not be null");
    }
}
