package com.test.fkredis.common.config.datasource;

import com.oceanpayment.opgateway.common.config.datasource.framework.DataSourceContext;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Hikari配置
 * <p>Title: HikariConfiguration</p>
 * <p>Description: HikariCP数据源配置(多数据源) </p>
 * <p>Copyright: Copyright (c) 2021 版权</p>
 * <p>Company: Oceanpayment</p>
 * @author Allen.C.Y.Zhang
 * @version V1.0
 * @date 2021-03-09 10:55:50
 */
@ConditionalOnProperty(prefix = "spring.datasource", name = "type", havingValue = "com.zaxxer.hikari.HikariDataSource")
@Configuration
public class HikariConfiguration {

    private final Logger logger = LoggerFactory.getLogger(HikariConfiguration.class);

    @Bean(DataSourceContext.MASTER)
    @ConfigurationProperties(prefix = "spring.datasource.hikari.master")
    public HikariDataSource masterDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        logger.info("Enabling Hikari [master] Data Source.");
        return dataSource;
    }

    @Bean(DataSourceContext.SLAVE)
    @ConfigurationProperties(prefix = "spring.datasource.hikari.slave")
    @ConditionalOnProperty(prefix = "spring.datasource.hikari.slave", name = "enabled", havingValue = "true")
    public HikariDataSource slaveDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        logger.info("Enabling Hikari [slave] Data Source.");
        return dataSource;
    }


//    /**
//     * ========================  Hikari 数据源后置处理  ========================
//     */
//    private HikariDataSource hikariMaster;
//    private HikariDataSource hikariSlave;
//
//    @Autowired
//    public void setHikariMaster(@Qualifier(DataSourceContext.MASTER) HikariDataSource hikariMaster) {
//        this.hikariMaster = hikariMaster;
//    }
//
//    @Autowired(required = false)
//    public void setHikariSlave(@Qualifier(DataSourceContext.SLAVE) HikariDataSource hikariSlave) {
//        this.hikariSlave = hikariSlave;
//    }
//
//    @PostConstruct
//    public void init() {
//        // 数据源(url/username/password)解密
//        logger.debug("Decrypting the Data Source using @PostConstruct.");
//
//        // master数据源
//        if (hikariMaster != null) {
//            logger.info("Hikari [slave] Data Source information: {}", hikariMaster);
//            hikariMaster.setJdbcUrl(SecUtils.decrypt(hikariMaster.getJdbcUrl()));
//            hikariMaster.setUsername(SecUtils.decrypt(hikariMaster.getUsername()));
//            hikariMaster.setPassword(SecUtils.decrypt(hikariMaster.getPassword()));
//            logger.debug("@PostConstruct decrypts Hikari [slave] Data Source information: [{},{},{}]", hikariMaster.getJdbcUrl(), hikariMaster.getUsername(), hikariMaster.getPassword());
//        }
//
//        // slave数据源
//        if (hikariSlave != null) {
//            logger.info("Hikari [slave] Data Source information: {}", hikariSlave);
//            hikariSlave.setJdbcUrl(SecUtils.decrypt(hikariSlave.getJdbcUrl()));
//            hikariSlave.setUsername(SecUtils.decrypt(hikariSlave.getUsername()));
//            hikariSlave.setPassword(SecUtils.decrypt(hikariSlave.getPassword()));
//            logger.debug("@PostConstruct decrypts Hikari [slave] Data Source information: [{},{},{}]", hikariSlave.getJdbcUrl(), hikariSlave.getUsername(), hikariSlave.getPassword());
//        }
//    }
}
