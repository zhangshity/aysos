package com.test.fkredis.service.impl;

import com.oceanpayment.opgateway.common.config.datasource.framework.DataSourceContext;
import com.oceanpayment.opgateway.common.config.datasource.switcher.SwitchDataSource;
import com.oceanpayment.opgateway.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl {

    @Autowired
    private DemoMapper demoMapper;

    public List<Map<String, String>> demoServiceMaster() {
        List<Map<String, String>> record = demoMapper.selectTradeRecord();
        return record;
    }

    @SwitchDataSource(DataSourceContext.SLAVE)
    public List<Map<String, String>> demoServiceSlave() {
//        DataSourceContext.setDataSource(DataSourceContext.DATASOURCE_SLAVE);
        List<Map<String, String>> record = demoMapper.selectTradeRecord();
//        DataSourceContext.clearDataSource();
        return record;
    }
}
