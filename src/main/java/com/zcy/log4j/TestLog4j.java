package com.zcy.log4j;

import org.apache.log4j.Logger;

/**
 * @ Author: chunyang.zhang
 * @ Description: log4j测试, 使用log4j-v1.2,默认加载log4j.properties
 * @ Date: Created in 14:14 2019-03-20
 * @ Modified: By:
 */
public class TestLog4j {

//    private static Logger logger = Logger.getLogger("TestLog4j.class");

    public static void main(String[] args) {

        Logger logger = Logger.getLogger("TestLog4j.class");

        //测试用例
        int i = 3, j = 0;
        String s = "2";

        //开始
        logger.debug("main function start >>>");

        try {
            s = Integer.toString(i / j);
            System.out.println("s = " + s);
        } catch (Exception e) {
            logger.error("Error Message:", e);
        }

        logger.debug("main function end <<<");
    }
}
