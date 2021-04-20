package com.test.fkredis.pojo.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.oceanpayment.opgateway.common.constant.RefundQueryRespConsts;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * 退款信息查询参数实体
 * <p>Title: </p>
 * <p>Description: 请求参数实体</p>
 * <p>Copyright: Copyright (c) 2021 版权</p>
 * <p>Company: Oceanpayment</p>
 * @author Allen.C.Y.Zhang
 * @version V1.0
 * @date 2021-02-26 14:42:23
 */
@ApiModel(value = "InquiryRefundParams", description = "退款信息查询请求参数实体类 (refund_number和refund_id 二选一,均有值以refund_id进行查询退款结果)")
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class InquiryRefundParams {

    /**
     * 账户号 (Oceanpayment账户)
     */
    @ApiModelProperty(value = "商户号", name = "account", allowableValues = "range[6,6]", dataType = "String", required = true)
    @NotNull(message = RefundQueryRespConsts.EMPTY_ACCOUNT)
    @Range(min = 10_0000L, max = 99_9999L, message = RefundQueryRespConsts.INVALID_ACCOUNT)
    @JsonProperty("account")
    private String merchantNo;

    /**
     * 终端号 (账户号下的终端号)
     */
    @ApiModelProperty(value = "终端号", name = "terminal", allowableValues = "range[8,8]", dataType = "String", required = true)
    @NotNull(message = RefundQueryRespConsts.EMPTY_TERMINAL)
    @Range(min = 1000_0000L, max = 9999_9999L, message = RefundQueryRespConsts.INVALID_TERMINAL)
    @JsonProperty("terminal")
    private String gatewayNo;

    /**
     * 签名信息
     */
    @ApiModelProperty(value = "签名信息", name = "signature", allowableValues = "range[64,64]", dataType = "String", required = true)
    @NotBlank(message = RefundQueryRespConsts.SIGNATURE_MISMATCH)
    @Size(min = 64, max = 64, message = RefundQueryRespConsts.SIGNATURE_MISMATCH)
    private String signature;

    /**
     * 退款订单号 (退款ID，Oceanpayment的唯一退款编号)
     */
    @ApiModelProperty(value = "退款订单号", name = "refund_id", allowableValues = "range[10,10]", dataType = "String", required = true)
    @Range(min = 10_0000_0000L, max = 99_9999_9999L, message = RefundQueryRespConsts.INVALID_REFUND_ID)
    private String refundId;

    /**
     * 商户退款订单号 (商户网站系统内部的退款ID)
     */
    @ApiModelProperty(value = "商户退款订单号", name = "merchant_refund_id", allowableValues = "range[1,50]", dataType = "String", required = true)
    @Size(min = 1, max = 50, message = RefundQueryRespConsts.INVALID_MERCHANT_REFUND_ID)
    private String merchantRefundId;
}
