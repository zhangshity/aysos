package com.test.fkredis.pojo.dto.customs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 海关上送查询条件DTO
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2021 版权</p>
 * <p>Company: Oceanpayment</p>
 * @author Allen.C.Y.Zhang
 * @version V2.0
 * @date 2021-02-24 19:20:39
 */
@Getter
@Setter
@ToString
public class CustomsQueryConditionDTO {

    /**
     *  账户号 (商户号)
     */
    private String account;

    /**
     * 终端号 (商户号下终端号)
     */
    private String terminal;

    /**
     * 签名信息
     */
    private String signValue;

    /**
     * 交易订单号
     */
    private String paymentId;

    /**
     * 远端IP (请求方IP)
     */
    private String remoteIp;
}
