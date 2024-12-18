package com.test.fkredis.pojo.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 退款信息
 * <p>Title: </p>
 * <p>Description: </p>
 * @author Allen.C.Y.Zhang
 * @version V2.0
 * @date 2021-04-01 15:28
 */
@Getter
@Setter
@ToString
public class RefundInfoBO {

    /**
     * 我司退款ID
     */
    private Long refundId;

    /**
     * 商户退款ID
     */
    private String merchantRefundId;

    /**
     * 银行退款ID
     */
    private String bankRefundId;

    /**
     * 交易币种
     */
    private String currency;

    /**
     * 退款金额
     */
    private BigDecimal amount;

    /**
     * 异常交易处理状态
     */
    private Integer processingStatus;

    /**
     * 退款原因
     */
    private String refundReason;
}
