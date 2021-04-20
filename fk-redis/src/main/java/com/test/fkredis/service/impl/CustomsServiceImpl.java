package com.test.fkredis.service.impl;

import com.oceanpayment.opgateway.mapper.CustomsMapper;
import com.oceanpayment.opgateway.pojo.dto.customs.CustomsQueryConditionDTO;
import com.oceanpayment.opgateway.pojo.dto.customs.CustomsQueryResultDTO;
import com.oceanpayment.opgateway.service.CustomsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 海关信息Service
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2021 版权</p>
 * <p>Company: Oceanpayment</p>
 * @author Allen.C.Y.Zhang
 * @version V2.0
 * @date 2021-02-25 16:45:27
 */
@Service
public class CustomsServiceImpl implements CustomsService {

    private final Logger logger = LoggerFactory.getLogger(CustomsServiceImpl.class);

    private final CustomsMapper customsMapper;

    @Autowired
    public CustomsServiceImpl(CustomsMapper customsMapper) {
        this.customsMapper = customsMapper;
    }

    /**
     * 查询海关上送信息
     * @title
     * @description
     * @author Allen.C.Y.Zhang
     * @date 2021-02-23 18:17:41
     * @param condition 查询条件
     * @return List<CustomsQueryResultDTO> 海关上送信息列表
     */
    @Override
    public   List<CustomsQueryResultDTO> findCustomsInfo(CustomsQueryConditionDTO condition) {
        return customsMapper.selectCustomsInfo(condition);
    }
}
