package com.test.fkredis.common.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.oceanpayment.opgateway.common.config.datasource.framework.DataSourceContext;
import com.oceanpayment.opgateway.common.config.datasource.framework.DynamicDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 动态数据源配置
 * <p>Title: DynamicDataSourceConfiguration </p>
 * <p>Description: Spring根据此配置类,路由数据源. 连接池{@link DruidConfiguration},{@link HikariConfiguration}二选一</p>
 * <p>Copyright: Copyright (c) 2021 版权</p>
 * <p>Company: Oceanpayment</p>
 * @author Allen.C.Y.Zhang
 * @version V1.0
 * @date 2021-02-03 10:20:26
 */
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@Lazy
@Configuration
public class DynamicDataSourceConfiguration {

    private final Logger logger = LoggerFactory.getLogger(DynamicDataSourceConfiguration.class);

    private DataSource druidMaster;
    private DataSource druidSlave;
    private DataSource hikariMaster;
    private DataSource hikariSlave;

    @Autowired(required = false)
    public void setDruidMaster(@Qualifier(DataSourceContext.MASTER) DruidDataSource druidMaster) {
        this.druidMaster = druidMaster;
    }

    @Autowired(required = false)
    public void setDruidSlave(@Qualifier(DataSourceContext.SLAVE) DruidDataSource druidSlave) {
        this.druidSlave = druidSlave;
    }

    @Autowired(required = false)
    public void setHikariMaster(@Qualifier(DataSourceContext.MASTER) HikariDataSource hikariMaster) {
        this.hikariMaster = hikariMaster;
    }

    @Autowired(required = false)
    public void setHikariSlave(@Qualifier(DataSourceContext.SLAVE) HikariDataSource hikariSlave) {
        this.hikariSlave = hikariSlave;
    }

    @Primary
    @Bean
    public DynamicDataSource dynamicDataSource() {
        // ## 设置目标数据源Map ##
        Map<Object, Object> targetDataSources = new HashMap<>(8);
        // 1.druid master 数据源
        Optional.ofNullable(druidMaster).ifPresent(ds -> targetDataSources.put(DataSourceContext.MASTER, ds));
        // 2.druid slave 数据源
        Optional.ofNullable(druidSlave).ifPresent(ds -> targetDataSources.put(DataSourceContext.SLAVE, ds));
        // 3.hikari master 数据源
        Optional.ofNullable(hikariMaster).ifPresent(ds -> targetDataSources.put(DataSourceContext.MASTER, ds));
        // 4.hikari slave 数据源
        Optional.ofNullable(hikariSlave).ifPresent(ds -> targetDataSources.put(DataSourceContext.SLAVE, ds));
        // 5.其他连接池和数据源...

        // ## 设置默认数据源 ##
        Object defaultTargetDataSource = Optional.ofNullable(druidMaster).orElse(hikariMaster);


        // -- 定义动态数据源 --
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(defaultTargetDataSource);

        logger.info("Data sources maintained by DynamicDataSource: The 'targetDataSources' is {}. The 'defaultTargetDataSource' is [{}]", targetDataSources.keySet(), Optional.ofNullable(defaultTargetDataSource).map((x) -> x.getClass().getName()).orElse(""));
        return dynamicDataSource;
    }
}
