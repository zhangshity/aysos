package com.shit.springboottestcontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWordController extends AbstractController {

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {

        logger.info("Invoke hello()");

        return "{\n" +
                "  \"ret\": 200,\n" +
                "  \"people\": \"zhangsan\"\n" +
                "}";
    }

}
