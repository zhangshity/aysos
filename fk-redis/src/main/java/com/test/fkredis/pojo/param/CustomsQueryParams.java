package com.test.fkredis.pojo.param;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 海关上送查询参数实体
 * <p>Title: </p>
 * <p>Description: 请求参数实体</p>
 * @author Allen.C.Y.Zhang
 * @version V2.0
 * @date 2021-02-24 19:20:39
 */
@Getter
@Setter
@ToString
@ApiModel
public class CustomsQueryParams {

    /**
     *  账户号 (商户号)
     */
    @ApiModelProperty(value = "商户号")
    private String account;

    /**
     * 终端号 (商户号下终端号)
     */
    @ApiModelProperty(value = "终端号")
    private String terminal;

    /**
     * 签名信息
     */
    @ApiModelProperty(value = "签名信息")
    private String signValue;

    /**
     * 交易订单号
     */
    @ApiModelProperty(value = "交易订单号")
    @JsonProperty("payment_id")
    private String paymentId;
}
