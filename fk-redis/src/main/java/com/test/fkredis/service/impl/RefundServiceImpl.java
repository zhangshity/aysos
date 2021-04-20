package com.test.fkredis.service.impl;

import com.oceanpayment.opgateway.common.constant.AbnormalTrxnProcessingStatusConsts;
import com.oceanpayment.opgateway.common.constant.IpValidationEnum;
import com.oceanpayment.opgateway.common.constant.RefundQueryRespEnum;
import com.oceanpayment.opgateway.mapper.RefundMapper;
import com.oceanpayment.opgateway.pojo.bo.RefundInfoBO;
import com.oceanpayment.opgateway.pojo.bo.RefundQueryGatewayBO;
import com.oceanpayment.opgateway.pojo.dto.refund.RefundInfoDTO;
import com.oceanpayment.opgateway.pojo.dto.refund.RefundInfoQueryConditionDTO;
import com.oceanpayment.opgateway.service.RefundService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 退款Service
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2021 版权</p>
 * <p>Company: Oceanpayment</p>
 * @author Allen.C.Y.Zhang
 * @version V2.0
 * @date 2021-02-26 16:45:27
 */
@Service
public class RefundServiceImpl implements RefundService {

    private final Logger logger = LoggerFactory.getLogger(RefundServiceImpl.class);

    private final RefundMapper refundMapper;

    @Autowired
    public RefundServiceImpl(RefundMapper refundMapper) {
        this.refundMapper = refundMapper;
    }

    /**
     * 查询退款信息
     * @title
     * @description
     * @author Allen.C.Y.Zhang
     * @date 2021-02-26 18:17:41
     * @param condition 查询条件
     * @return RefundInfoDTO 退款信息列表
     */
    @Override
    public RefundInfoDTO findRefundInfo(RefundInfoQueryConditionDTO condition) { // TODO 为什么退款查询还要这么多校验？ 岂不是拖慢性能？？？ 一个简单的查询竟然要3次 IO ？？？？？？？？
        // 1.返回对象定义
        RefundInfoDTO refundInfoDTO = new RefundInfoDTO();
//        refundInfoDTO.setMerchantNo(condition.getMerchantNo());
//        refundInfoDTO.setGatewayNo(condition.getGatewayNo());
//        refundInfoDTO.setRefundId(condition.getRefundId());
//        refundInfoDTO.setMerchantRefundId(condition.getMerchantRefundId());


        // 2.业务层参数校验
        // 2.(1)终端号校验
        RefundQueryGatewayBO gatewayInfo = refundMapper.selectRefundQueryGatewayInfo(condition.getGatewayNo()); // TODO 是不是只是为了获取salt ？ 是否只查询salt
        if (gatewayInfo == null) {
            refundInfoDTO.setCode(RefundQueryRespEnum.INVALID_TERMINAL.getCode());
            refundInfoDTO.setDescription(RefundQueryRespEnum.INVALID_TERMINAL.getDescription());
            logger.warn("[RefundId:{},MerchantRefundId:{}]退款查询,终端号错误", condition.getRefundId(),condition.getMerchantRefundId());
            return refundInfoDTO;
        }
        // 2.(2)账户号校验
        if(!Objects.equals(condition.getMerchantNo(),gatewayInfo.getMerNo())){		//商户号错误   // TODO 既然会校验签名 ？干嘛还要校验 终端号 和 账户号？
            refundInfoDTO.setCode(RefundQueryRespEnum.INVALID_TERMINAL.getCode());
            refundInfoDTO.setDescription(RefundQueryRespEnum.INVALID_TERMINAL.getDescription());
            logger.warn("[RefundId:{},MerchantRefundId:{}]退款查询,商户号错误", condition.getRefundId(),condition.getMerchantRefundId());
            return refundInfoDTO;
        }
        // 2.(3)签名校验
        else {
            //获取签名信息
            String signRawData = condition.getMerchantNo() + condition.getGatewayNo() + condition.getRefundId() + condition.getMerchantRefundId() + gatewayInfo.getMd5key();
            String sign = DigestUtils.sha256Hex(signRawData);
            if(!sign.equals(condition.getSignature())){
                refundInfoDTO.setCode(RefundQueryRespEnum.SIGNATURE_MISMATCH.getCode());
                refundInfoDTO.setDescription(RefundQueryRespEnum.SIGNATURE_MISMATCH.getDescription());
                logger.warn("[RefundId:{},MerchantRefundId:{}]退款查询,签名不匹配. 正确签名:{}", condition.getRefundId(), condition.getMerchantRefundId(), sign);
                return refundInfoDTO;
            }
        }


//        String signRawData = condition.getMerchantNo() + condition.getGatewayNo() + condition.getRefundId() +
//                Optional.ofNullable(condition.getMerchantRefundId()).orElse("") +
//                Optional.ofNullable(refundInfoDTO.getCode()).orElse("") +
//                Optional.ofNullable(refundInfoDTO.getDescription()).orElse("") +
//                Optional.ofNullable(refundInfoDTO.getSignKey()).orElse("");
//        refundInfoDTO.setSignature(DigestUtils.sha256Hex(signRawData));
//        if (refundInfoDTO.getCode() != null) {
//            return refundInfoDTO;
//        }
        // 2.(3)IP校验校验
        Integer ipCheckFlag = refundMapper.selectIpCheckFlagByGwNo(condition.getGatewayNo());
        if (Objects.equals(ipCheckFlag, IpValidationEnum.ENABLE.getFlag()) && condition.getClientIp() != null) {
            int recordQuantity = refundMapper.countRecordByMerNoAndIp(condition.getMerchantNo(), condition.getClientIp());  //TODO 这段sql 要理解下 ！要不要修改？
            if (recordQuantity == 0) {
                refundInfoDTO.setCode(RefundQueryRespEnum.IP_NOT_REGISTERED.getCode());
                refundInfoDTO.setDescription(String.format(RefundQueryRespEnum.IP_NOT_REGISTERED.getDescription(), condition.getClientIp()));
                logger.warn("[RefundId:{},MerchantRefundId:{}]退款查询,IP校验未通过", condition.getRefundId(),condition.getMerchantRefundId());
                return refundInfoDTO;
            }
        }


        // 3.查询交易信息
        RefundInfoBO refundInfo = refundMapper.selectRefundInfo(condition);
        // 3.(1)判断交易是否存在
        if (refundInfo == null) {
            refundInfoDTO.setCode(RefundQueryRespEnum.REFUND_RECORD_DOES_NOT_EXIST.getCode());
            refundInfoDTO.setDescription(RefundQueryRespEnum.REFUND_RECORD_DOES_NOT_EXIST.getDescription());
            logger.warn("[RefundId:{},MerchantRefundId:{}]退款查询,交易信息不存在", condition.getRefundId(),condition.getMerchantRefundId());
            return refundInfoDTO;
        }
        // 3.(2)根据退款交易处理状态,设置响应信息
        if (refundInfo.getProcessingStatus() == AbnormalTrxnProcessingStatusConsts.AUDIT_SUCCESSFUL_ALREADY_PROCESSED) {
            refundInfoDTO.setCode(RefundQueryRespEnum.REFUNDED.getCode());
            refundInfoDTO.setDescription(RefundQueryRespEnum.REFUNDED.getDescription());
        } else if (refundInfo.getProcessingStatus() == AbnormalTrxnProcessingStatusConsts.AUDIT_SUCCESSFUL_NOT_PROCESSED) {
            refundInfoDTO.setCode(RefundQueryRespEnum.AUDIT_SUCCESSFUL_NOT_PROCESSED.getCode());
            refundInfoDTO.setDescription(RefundQueryRespEnum.AUDIT_SUCCESSFUL_NOT_PROCESSED.getDescription());
        } else if (refundInfo.getProcessingStatus() == AbnormalTrxnProcessingStatusConsts.TO_BE_AUDITED) {
            refundInfoDTO.setCode(RefundQueryRespEnum.TO_BE_AUDITED.getCode());
            refundInfoDTO.setDescription(RefundQueryRespEnum.TO_BE_AUDITED.getDescription());
        } else if (refundInfo.getProcessingStatus() == AbnormalTrxnProcessingStatusConsts.FAILURE) {
            refundInfoDTO.setCode(RefundQueryRespEnum.AUDIT_FAILURE.getCode());
            refundInfoDTO.setDescription(RefundQueryRespEnum.AUDIT_FAILURE.getDescription());
        }


        // 4.返回业务信息
        refundInfoDTO.setBankRefundId(refundInfo.getBankRefundId());
//        refundInfoDTO.setRefundId(refundInfo.getRefundId());
//        refundInfoDTO.setMerchantRefundId(refundInfo.getMerchantRefundId());
//        refundInfoDTO.setCurrency(refundInfo.getCurrency());
//        refundInfoDTO.setAmount(refundInfo.getAmount());
//        refundInfoDTO.setRefundReason(refundInfo.getRefundReason());  // TODO 原因未使用 要不要在实体类中，

        return refundInfoDTO;
    }
}
