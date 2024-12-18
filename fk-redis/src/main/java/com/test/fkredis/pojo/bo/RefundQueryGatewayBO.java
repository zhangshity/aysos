package com.test.fkredis.pojo.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 退款查询-网关信息BO
 * <p>Title: </p>
 * <p>Description: </p>
 * @author Allen.C.Y.Zhang
 * @version V2.0
 * @date 2021-03-02 03:02:53
 */
@Getter
@Setter
@ToString
public class RefundQueryGatewayBO {

    /**
     * 网关接入号
     */
    private Long gwNo;

    /**
     * 商户号
     */
    private Long merNo;

    /**
     * MD5Key
     */
    private String md5key;

    /**
     * 状态
     */
    private Integer gwStatus;

    /**
     * 商户的清算状态
     */
    private Integer merClearStatus;
}
