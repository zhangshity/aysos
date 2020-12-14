package com.zcy.spring.ioc.annotation.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.beans.PropertyVetoException;

//@Component
@Configuration  //一句话概括就是 @Configuration 中所有带 @Bean 注解的方法都会被动态代理，因此调用该方法返回的都是同一个实例。
@PropertySource("classpath:db.properties") //相当于<context:property-placeholder location="db.properties"/>
public class DataSourceConfiguration {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean("dataSource")
    public MysqlDataSource mysqlDatasource() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(url);
        mysqlDataSource.setUser(username);
        mysqlDataSource.setPassword(password);
        return mysqlDataSource;
    }

    @Bean("dataSource2")
    public ComboPooledDataSource comboPooledDataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setAutoCommitOnClose(false);
        return comboPooledDataSource;
    }
}
