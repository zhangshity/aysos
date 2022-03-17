package com.zcy.spring.transaction.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.beans.PropertyVetoException;

@Configuration
//@PropertySource("classpath:mybatis/opdb.properties") //相当于<context:property-placeholder location="db.properties"/>
@PropertySource("classpath:mybatis/local-db.properties") //相当于<context:property-placeholder location="db.properties"/>
@MapperScan("com.zcy.spring.transaction.dao")//配置mybatis mapper扫描路径
public class DataSourceConfiguration {

    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    //Spring IOC容器 管理 dataSource(注解方式)
    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {

        //创建ComboPooledDataSource对象(存储数据库连接信息)
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        //jdbc驱动
        dataSource.setDriverClass(jdbcDriver);
        //数据库url
        dataSource.setJdbcUrl(jdbcUrl);
        //数据库 用户名
        dataSource.setUser(jdbcUsername);
        //数据库 密码
        dataSource.setPassword(jdbcPassword);
        //自动提交关闭。(关闭连接后,数据库不自动commit)
        dataSource.setAutoCommitOnClose(false);

        return dataSource;
    }
}
