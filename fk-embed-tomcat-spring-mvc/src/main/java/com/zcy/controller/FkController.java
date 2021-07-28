package com.zcy.controller;

import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class FkController {

    private static final Logger logger = LoggerFactory.getLogger(FkController.class);

    @Autowired(required = false)
    ApplicationContext applicationContext;

    @Autowired
    FkService fkService;

    @GetMapping("/hello")
    public String Hello() {
        double random = Math.random() * 100;
        logger.info("------------ 测试 {} -----------------", random);
        System.out.println("------------ 测试 Hello {} ----------------- " + random);
        return "------------ 测试 " + random + " -----------------";
    }

    @GetMapping("/hello2")
    public Map<String, String> Hello2() {

        Map<String, String> map = fkService.getValue();
        String hhh = (String) SpringContextUtil.getBean("hhh");


        System.out.println("------------ 测试 Hello2 {} -----------------  bean: " + hhh);
        return map;
    }

}
