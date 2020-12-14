package com.zcy.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForEach {

    private static final Logger logger = LoggerFactory.getLogger(ForEach.class);

    /**
     * 测试循环打印异常会不会中断for循环
     */

    private String m1 () {
        return String.valueOf(1 / 0);
    }

    private String m2() {
        String m2Result;
        try {
            m2Result = this.m1();
        } catch (Exception e) {
            throw new IllegalArgumentException("m2方法出现异常：", e);
        }
        return m2Result;
    }

    private String m3() {
        String m3Result;
        try {
            m3Result = this.m2();
        } catch (Exception e) {
            throw new IllegalStateException("m3方法出现异常：", e);
        }
        return m3Result;
    }


    //Main
    public static void main(String[] args) {
        ForEach forEach = new ForEach();
        String finalResult = null;
//        try {
//            for (int i = 0; i <= 5; i++) {
//                finalResult = forEach.m3();
//            }
//        } catch (Exception e) {
//            logger.error("Main测试方法最终结果：{} ,方法执行出现异常", finalResult, e);
//        }


        for (int i = 0; i <= 5; i++) {
            try {
                finalResult = forEach.m3();
            } catch (Exception e) {
                logger.error("Main测试方法最终结果：{} ,方法执行出现异常", finalResult, e);
            }
        }



        logger.info("Main测试方法最终结果：{}", finalResult);
    }
}
