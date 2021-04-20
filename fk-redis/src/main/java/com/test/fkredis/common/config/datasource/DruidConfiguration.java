package com.test.fkredis.common.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.oceanpayment.opgateway.common.config.datasource.framework.DataSourceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import java.util.Collections;

/**
 * Druid配置
 * <p>Title: DruidConfiguration</p>
 * <p>Description: DruidCP数据源配置(多数据源) </p>
 * <p>Copyright: Copyright (c) 2021 版权</p>
 * <p>Company: Oceanpayment</p>
 * @author Allen.C.Y.Zhang
 * @version V1.0
 * @date 2021-02-03 10:20:26
 */
@ConditionalOnProperty(prefix = "spring.datasource", name = "type", havingValue = "com.alibaba.druid.pool.DruidDataSource")
@Configuration
public class DruidConfiguration {

    private final Logger logger = LoggerFactory.getLogger(DruidConfiguration.class);

    @Bean(name = DataSourceContext.MASTER)
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    public DruidDataSource masterDataSource() {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        logger.info("Enabling Druid [master] Data Source.");
        return dataSource;
    }

    @Bean(name = DataSourceContext.SLAVE)
    @ConfigurationProperties(prefix = "spring.datasource.druid.slave")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.slave", name = "enabled", havingValue = "true")
    public DruidDataSource slaveDataSource() {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        logger.info("Enabling Druid [slave] Data Source.");
        return dataSource;
    }


//    /**
//     * ========================  Druid 数据源后置处理  ========================
//     */
//    private DruidDataSource druidMaster;
//    private DruidDataSource druidSlave;
//
//    @Autowired
//    public void setDruidMaster(@Qualifier(DataSourceContext.MASTER) DruidDataSource druidMaster) {
//        this.druidMaster = druidMaster;
//    }
//
//    @Autowired(required = false)
//    public void setDruidSlave(@Qualifier(DataSourceContext.SLAVE) DruidDataSource druidSlave) {
//        this.druidSlave = druidSlave;
//    }
//
//    @PostConstruct
//    public void init() {
//        // 数据源(url/username/password)解密
//        logger.debug("Decrypting the Data Source using @PostConstruct.");
//
//        // master数据源
//        if (druidMaster != null) {
//            logger.info("Druid [master] Data Source information: {}", druidMaster.getStatDataForMBean());
//            druidMaster.setUrl(SecUtils.decrypt(druidMaster.getUrl()));
//            druidMaster.setUsername(SecUtils.decrypt(druidMaster.getUsername()));
//            druidMaster.setPassword(SecUtils.decrypt(druidMaster.getPassword()));
//            logger.debug("@PostConstruct decrypts Druid [master] Data Source information: [{},{},{}]", druidMaster.getUrl(), druidMaster.getUsername(), druidMaster.getPassword());
//        }
//
//        // slave数据源
//        if (druidSlave != null) {
//            logger.info("Druid [slave] Data Source information: {}", druidSlave.getStatDataForMBean());
//            druidSlave.setUrl(SecUtils.decrypt(druidSlave.getUrl()));
//            druidSlave.setUsername(SecUtils.decrypt(druidSlave.getUsername()));
//            druidSlave.setPassword(SecUtils.decrypt(druidSlave.getPassword()));
//            logger.debug("@PostConstruct decrypts Druid [slave] Data Source information: [{},{},{}]", druidSlave.getUrl(), druidSlave.getUsername(), druidSlave.getPassword());
//        }
//    }


    /**
     * ========================  Druid 监控配置  ========================
     */
    @Bean
    public ServletRegistrationBean<Servlet> servletRegistrationBean() { // 主要实现WEB监控的配置处理
        //ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*"); // 现在要进行druid监控的配置处理操作
        ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<>();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.setUrlMappings(Collections.singletonList("/druid/*"));
        // 白名单
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1,10.1.1.1");
        // 黑名单
        // servletRegistrationBean.addInitParameter("deny", "192.168.1.200");
        // 用户名
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        // 密码
        servletRegistrationBean.addInitParameter("loginPassword", "admin");
        // 是否可以重置数据源
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        // 所有请求进行监控处理
        filterRegistrationBean.addUrlPatterns("/*");
        // 排除
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
