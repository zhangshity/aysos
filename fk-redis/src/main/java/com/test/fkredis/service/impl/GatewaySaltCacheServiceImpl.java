package com.test.fkredis.service.impl;

import com.oceanpayment.opgateway.mapper.RefundMapper;
import com.oceanpayment.opgateway.service.GatewaySaltCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 终端号-盐 缓存Service
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2021 版权</p>
 * <p>Company: Oceanpayment</p>
 * @author Allen.C.Y.Zhang
 * @version V1.0
 * @date 2021-04-09 15:45
 */
@Service
public class GatewaySaltCacheServiceImpl implements GatewaySaltCacheService {

    private final RefundMapper refundMapper;

    @Autowired
    public GatewaySaltCacheServiceImpl(RefundMapper refundMapper) {
        this.refundMapper = refundMapper;
    }

    /**
     *
     * @title
     * @description
     * @author Allen.C.Y.Zhang
     * @date 2021-04-09 15:37
     * @param gatewayNo 终端号
     * @return {@link Map} 终端号-盐 映射
     */
    @Cacheable("'SALT_'+#gatewayNo")
    @Override
    public Map<Long, String> findSaltByGatewayNo(Long gatewayNo) {

        refundMapper.selectRefundQueryGatewayInfo(gatewayNo);

        return null;
    }

    /**
     *
     * @title
     * @description
     * @author Allen.C.Y.Zhang
     * @date 2021-04-09 15:37
     * @param gatewayNo 终端号
     * @return {@link Map} 终端号-盐 映射
     */
    @CachePut("'SALT_'+#gatewayNo")
//    @Override
    public Map<Long, String> saveSaltByGatewayNo(Long gatewayNo) {

        refundMapper.selectRefundQueryGatewayInfo(gatewayNo);

        return null;
    }

    /**
     *
     * @title
     * @description
     * @author Allen.C.Y.Zhang
     * @date 2021-04-09 15:37
     * @param gatewayNo 终端号
     * @return {@link Map} 终端号-盐 映射
     */
    @CacheEvict("'SALT_'+ #gatewayNo")
//    @Override
    public Map<Long, String> deleteSaltByGatewayNo(Long gatewayNo) {

        refundMapper.selectRefundQueryGatewayInfo(gatewayNo);

        return null;
    }
}
