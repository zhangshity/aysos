package com.test.fkredis.pojo.vo.refundv2;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 退款信息查询VO -v2
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2021 版权</p>
 * <p>Company: Oceanpayment</p>
 * @author Allen.C.Y.Zhang
 * @version V2.0
 * @date 2021-04-02 18:00
 */
@Data
@ApiModel(value = "RefundInfoVO",description = "退款信息")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RefundInfoVO {

    /**
     * 账户号 (Oceanpayment账户)
     */
    @ApiModelProperty(value = "商户号", name = "account", dataType = "String")
    private String account;

    /**
     * 终端号 (账户号下的终端号)
     */
    @ApiModelProperty(value = "终端号", name = "terminal", dataType = "String")
    private String terminal;

    /**
     * 签名信息
     */
    @ApiModelProperty(value = "签名信息", name = "signature", dataType = "String")
    private String signature;

    /**
     * 退款订单号 (退款ID，Oceanpayment的唯一退款编号)
     */
    @ApiModelProperty(value = "退款订单号", name = "refund_id", dataType = "String")
    private String refundId;

    /**
     * 商户退款订单号 (商户网站系统内部的退款流水号)
     */
    @ApiModelProperty(value = "商户退款订单号", name = "merchant_refund_id", dataType = "String")
    private String merchantRefundId;

    /**
     * 退款凭证 (发卡银行端提供的退款凭证号码，并非所有发卡行都会进行提供)
     */
    @ApiModelProperty(value = "退款凭证", name = "bank_refund_id", dataType = "String")
    private String bankRefundId;

    /**
     * 结果代码
     */
    @ApiModelProperty(value = "退款凭证", name = "result_code", dataType = "String")
    private String resultCode;

    /**
     * 原因说明
     */
    @ApiModelProperty(value = "退款凭证", name = "result_message", dataType = "String")
    private String resultMessage;
}
