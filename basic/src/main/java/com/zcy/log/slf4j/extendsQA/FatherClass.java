package com.zcy.log.slf4j.extendsQA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class FatherClass {

    protected static final Logger logger = LoggerFactory.getLogger(FatherClass.class);

    protected abstract void execute();

    public void print() {
        logger.info("我是抽象父类的 print() 方法");
        this.execute();
    }
}
