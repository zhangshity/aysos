package com.test.fkredis.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis配置
 * <p>Title: MybatisConfiguration</p>
 * <p>Description: 使用默认mybatis-spring-boot-starter的autoconfigure,此处仅配置扫描路径 </p>
 * <p>Copyright: Copyright (c) 2021 版权</p>
 * <p>Company: Oceanpayment</p>
 * @author Allen.C.Y.Zhang
 * @version V1.0
 * @date 2021-03-04 13:55:05
 */
@MapperScan("com.oceanpayment.opgateway.mapper")
@Configuration
public class MybatisConfiguration {
}
