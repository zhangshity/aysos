package com.zcy.spring.ioc.annotation.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, PropertyVetoException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        System.out.println("dataSource > " + dataSource);


        DataSource dataSource2 = (DataSource) applicationContext.getBean("dataSource2");
        System.out.println("dataSource2 > " + dataSource2);

        //======================
        DataSourceConfiguration dataSourceConfiguration = (DataSourceConfiguration) applicationContext.getBean("dataSourceConfiguration");
        System.out.println(dataSourceConfiguration);


        MysqlDataSource mysqlDataSource = dataSourceConfiguration.mysqlDatasource();
        ComboPooledDataSource comboPooledDataSource = dataSourceConfiguration.comboPooledDataSource();
        System.out.println("mysqlDataSource > " + mysqlDataSource);
        System.out.println("comboPooledDataSource > " + comboPooledDataSource);


        System.out.println(dataSource == mysqlDataSource);
        System.out.println(dataSource2 == comboPooledDataSource);

    }
}
