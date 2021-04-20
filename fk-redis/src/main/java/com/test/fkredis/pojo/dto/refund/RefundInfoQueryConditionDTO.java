package com.test.fkredis.pojo.dto.refund;

import lombok.Data;

/**
 * 退款信息查询条件DTO
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2021 版权</p>
 * <p>Company: Oceanpayment</p>
 * @author Allen.C.Y.Zhang
 * @version V2.0
 * @date 2021-02-26 19:20:39
 */
@Data
public class RefundInfoQueryConditionDTO {

    /**
     *  商户号 (账户号)
     */
    private Long merchantNo;

    /**
     * 终端号 (商户号下终端号)
     */
    private Long gatewayNo;

    /**
     * 签名信息
     */
    private String signature;

    /**
     * 客户端IP地址
     */
    private String clientIp;

    /**
     * 退款订单号
     */
    private Long refundId;

    /**
     * 商户退款订单号
     */
    private String merchantRefundId;
}
