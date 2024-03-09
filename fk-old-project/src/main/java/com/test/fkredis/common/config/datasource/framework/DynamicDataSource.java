//package com.test.fkredis.common.config.datasource.framework;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
//import java.util.Optional;
//
///**
// * 动态数据源
// * <p>Title: DynamicDataSource </p>
// * <p>Description: Spring路由数据源,调用getConnection(),选取此方法</p>
// * @author Allen.C.Y.Zhang
// * @version V1.0
// * @date 2021-03-04 18:12:09
// */
//public class DynamicDataSource extends AbstractRoutingDataSource {
//
//    private final Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);
//
//    @Override
//    protected Object determineCurrentLookupKey() {
//        String lookupKey = DataSourceContext.getDataSource();
//        logger.debug("Current data source is '{}'", Optional.ofNullable(lookupKey).orElse("default"));
//        return lookupKey;
//    }
//}
