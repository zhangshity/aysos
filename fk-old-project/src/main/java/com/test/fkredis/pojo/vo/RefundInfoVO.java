//package com.test.fkredis.pojo.vo;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
///**
// * 退款信息查询VO
// * <p>Title: </p>
// * <p>Description: </p>
// * <p>Copyright: Copyright (c) 2021 版权</p>
// * <p>Company: Oceanpayment</p>
// * @author Allen.C.Y.Zhang
// * @version V1.0
// * @date 2021-02-26 14:42:23
// */
//@Getter
//@Setter
//@ToString
//@ApiModel(value = "RefundInfoVO",description = "")
//@JacksonXmlRootElement(localName = "response")
//public class RefundInfoVO {
//
//    /**
//     * 账户号 (Oceanpayment账户)
//     */
//    @ApiModelProperty(value = "商户号", name = "account", dataType = "String")
//    private String account;
//
//    /**
//     * 终端号 (账户号下的终端号)
//     */
//    @ApiModelProperty(value = "终端号", name = "signValue", dataType = "String")
//    private String terminal;
//
//    /**
//     * 签名信息
//     */
//    @ApiModelProperty(value = "签名信息", name = "signValue", dataType = "String")
//    private String signValue;
//
//    /**
//     * 退款订单号 (退款ID，Oceanpayment的唯一退款编号)
//     */
//    @ApiModelProperty(value = "退款订单号", name = "refund_id", dataType = "String")
//    @JsonProperty("refund_id")
//    private String refundId;
//
//    /**
//     * 商户退款订单号 (商户网站系统内部的退款流水号)
//     */
//    @ApiModelProperty(value = "商户退款订单号", name = "refund_number", dataType = "String")
//    @JsonProperty("refund_number")
//    private String refundNumber;
//
//    /**
//     * 退款凭证 (发卡银行端提供的退款凭证号码，并非所有发卡行都会进行提供)
//     */
//    @ApiModelProperty(value = "退款凭证", name = "refund_queryNo", dataType = "String")
//    @JsonProperty("refund_queryNo")
//    private String refundQueryNo;
//
//    /**
//     * 结果代码
//     */
//    @ApiModelProperty(value = "退款凭证", name = "refund_check", dataType = "String")
//    @JsonProperty("refund_check")
//    private String refundCheck;
//
//    /**
//     * 原因说明
//     */
//    @ApiModelProperty(value = "退款凭证", name = "refund_description", dataType = "String")
//    @JsonProperty("refund_description")
//    private String refundDescription;
//}
