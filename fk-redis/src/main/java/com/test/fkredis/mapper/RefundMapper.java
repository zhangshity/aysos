package com.test.fkredis.mapper;

import com.oceanpayment.opgateway.pojo.bo.RefundInfoBO;
import com.oceanpayment.opgateway.pojo.bo.RefundQueryGatewayBO;
import com.oceanpayment.opgateway.pojo.dto.refund.RefundInfoDTO;
import com.oceanpayment.opgateway.pojo.dto.refund.RefundInfoQueryConditionDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 退款Mapper
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2021 版权</p>
 * <p>Company: Oceanpayment</p>
 * @author Allen.C.Y.Zhang
 * @version V1.0
 * @date 2021-02-26 16:53:06
 */
@Mapper
public interface RefundMapper {

    /**
     * 查询退款信息
     * @description
     * @author Allen.C.Y.Zhang
     * @date 2021-02-26 16:53:06
     * @param condition 查询条件
     * @return {@link RefundInfoDTO} 退款信息
     */
    RefundInfoBO selectRefundInfo(RefundInfoQueryConditionDTO condition);

    /**
     * 查询退款请求终端号信息
     * @description 退款请求终端号信息
     * @author Allen.C.Y.Zhang
     * @date 2021-03-02 17:11:50
     * @param gwNo 终端号
     * @return {@link RefundQueryGatewayBO} 退款请求网关信息列表
     */
    RefundQueryGatewayBO selectRefundQueryGatewayInfo(Long gwNo);

    /**
     * 根据终端号查询IP地址校验标志 (是否开启IP校验)
     * @description
     * @author Allen.C.Y.Zhang
     * @date 2021-03-01 14:32:50
     * @param gwNo 终端号
     * @return {@link Byte} IP地址校验标志 1-开启 0-关闭
     */
     Integer selectIpCheckFlagByGwNo(Long gwNo);

    /**
     * 根据商户号和IP地址统计数量
     * @description
     * @author Allen.C.Y.Zhang
     * @date 2021-03-02 09:57:50
     * @param merNo 商户号
     * @param ip    IP地址
     * @return int 记录数量
     */
    int countRecordByMerNoAndIp(@Param("merNo") Long merNo, @Param("ip") String ip);
}
