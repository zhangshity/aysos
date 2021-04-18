package com.zcy.log.slf4j.extendsQA;

import org.springframework.stereotype.Component;

@Component
public class SonClass extends FatherClass {

    //private static final Logger logger = LoggerFactory.getLogger(FatherClass.class);


    @Override
    protected void execute() {
        logger.info("我是子类的 execute() 方法");
    }
}
