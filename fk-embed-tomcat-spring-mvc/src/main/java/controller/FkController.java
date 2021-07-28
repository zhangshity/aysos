package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FkController {

    private static final Logger logger = LoggerFactory.getLogger(FkController.class);

    @GetMapping("/hello")
    public String Hello() {
        double random = Math.random() * 100;
        logger.info("------------ 测试 {} -----------------", random);
        return "------------ 测试 " + random + " -----------------";
    }


}
