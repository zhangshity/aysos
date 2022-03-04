package com.zcy.fkcameldatax;


import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 文件路由 路由配置
 */
@Component
public class FileRoute extends RouteBuilder {
    private static final Logger logger = LoggerFactory.getLogger(FileRoute.class);
//    @Value("${ftp.url}")
    private String url = "file:\\D:\\data\\camel";
//    private String url = "file:\\D:\\data\\server\\data\\sftp\\datax\\demo.txt";

    @Autowired
    private DataXProcessor dataXProcessor;

    @Override
    public void configure() {
        from(url)
                .log(LoggingLevel.INFO, logger, "begin to handler ${file:name}.")
                .process(dataXProcessor)
                .end();
    }

}
