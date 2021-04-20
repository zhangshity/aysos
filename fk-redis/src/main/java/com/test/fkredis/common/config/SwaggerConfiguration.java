package com.test.fkredis.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置
 * <p>Title: SwaggerConfiguration</p>
 * <p>Description: Swagger API文档配置 </p>
 * <p>Copyright: Copyright (c) 2021 版权</p>
 * <p>Company: Oceanpayment</p>
 * @author Allen.C.Y.Zhang
 * @version V1.0
 * @date 2021-02-24 15:05:00
 */
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    private final Logger logger = LoggerFactory.getLogger(SwaggerConfiguration.class);

    @Bean
    public Docket docket(Environment environment) {
        // 设置Swagger启用环境
        Profiles profiles = Profiles.of("dev", "test");
        // 判断Swagger是否启用 (读取spring.profiles.active获取当前环境,匹配启用环境)
        boolean enableSwaggerFlag = environment.acceptsProfiles(profiles);


        // 配置ApiInfo
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("OP-GATEWAY API文档")
                .description("JavaInUse API reference for developers")
                .termsOfServiceUrl("https://asdasd.cccc.cn")
                .contact(new Contact("Allen.C.Y.Zhang", "www.aaa.com", "a65d4a6s54@qw.com"))
                .license("OP License")
                .licenseUrl("https://op.license.com")
                .version("1.0")
                .build();

        // 配置Docket
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .enable(enableSwaggerFlag)
                .groupName("Public-API")
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.oceanpayment.opgateway.controller"))
                .paths(PathSelectors.any())
                .build();

        logger.info("Enabling Swagger configuration. Set 'enable' property to '{}'", enableSwaggerFlag);
        return docket;
    }
}
