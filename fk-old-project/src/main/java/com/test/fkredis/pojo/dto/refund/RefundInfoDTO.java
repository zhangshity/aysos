package com.test.fkredis.pojo.dto.refund;

import lombok.Data;

/**
 * 退款信息查询结果DTO
 * <p>Title: </p>
 * <p>Description: </p>
 * @author Allen.C.Y.Zhang
 * @version V2.0
 * @date 2021-02-26 19:20:39
 */
@Data
public class RefundInfoDTO {

//    /**
//     *  商户号
//     */
//    private Long merchantNo;
//
//    /**
//     * 终端号
//     */
//    private Long gatewayNo;
//
//    /**
//     * 我司退款ID
//     */
//    private Long refundId;
//
//    /**
//     * 商户退款ID
//     */
//    private String merchantRefundId;

    /**
     * 银行退款ID
     */
    private String bankRefundId;

//    /**
//     * 交易币种
//     */
//    private String currency;
//
//    /**
//     * 退款金额
//     */
//    private BigDecimal amount;

    /**
     * 响应码
     */
    private String code;

    /**
     * 响应描述
     */
    private String description;
}
