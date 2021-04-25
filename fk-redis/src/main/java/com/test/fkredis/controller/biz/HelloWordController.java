package com.test.fkredis.controller.biz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.xml.XmlMapper;
//import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.test.fkredis.mapper.DemoMapper;
import com.test.fkredis.pojo.bo.Student;
import com.test.fkredis.service.impl.TestServiceImpl;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

@RestController
public class HelloWordController {

    public static final Logger logger = LoggerFactory.getLogger(HelloWordController.class);

    private static final int VOLUME = 10_0000;

    private static int num = VOLUME;

    private static int consume = 0;

    @Resource
    private RedisLockRegistry redisLockRegistry;

    @Autowired
    private DemoMapper demoMapper;

    @Autowired
    private TestServiceImpl service;

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping(path = "/hi")
    public String helloWorld() {
        logger.debug("hello,world!!! !!!! ");
        List<Map<String, String>> record = service.demoServiceMaster();
        List<Map<String, String>> record2 = service.demoServiceSlave();
        String s = RandomStringUtils.randomAlphanumeric(5);
        return "hello,world! _______ " + s + "_____________" + record.toString() + "\n" + record2.toString();
    }

    @GetMapping(path = "/json")
    public Student json() {
        logger.debug("json() !!! !!!! ");
        Student student = new Student();
        student.setName("Json" + RandomStringUtils.randomAlphanumeric(3)).setAge(18).setScore(98.66).setTimestampUtc(Instant.now());
        return student;
    }

//    @GetMapping(path = "/xml", produces = {MediaType.APPLICATION_XML_VALUE})
//    public Student xml() {
//        logger.debug("xml() !!! !!!! ");
//        Student student = new Student();
//        student.setName("Xml" + RandomStringUtils.randomAlphanumeric(3)).setAge(21).setScore(95.88).setTimestampUtc(Instant.now());
//        return student;
//    }

//    @GetMapping(path = "/xml/jaxb", produces = {MediaType.APPLICATION_XML_VALUE})
//    public String xmlJaxb() {
//        logger.debug("xml() !!! !!!! ");
//        Student student = new Student();
//        student.setName("Xml" + RandomStringUtils.randomAlphanumeric(3)).setAge(21).setScore(95.88).setTimestampUtc(Instant.now());
//        return XmlUtils.ObjectToXmlWhitProlog(student);
//    }

//    @GetMapping(path = "/xml/prolog", produces = {MediaType.APPLICATION_XML_VALUE})
//    public String xmlProlog() throws JsonProcessingException {
//        logger.debug("xml() !!! !!!! ");
//        Student student = new Student();
//        student.setName("Xml" + RandomStringUtils.randomAlphanumeric(3)).setAge(21).setScore(95.88).setTimestampUtc(Instant.now());
//
//        ObjectMapper mapper = new XmlMapper().configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
//
//        return mapper.writeValueAsString(student);
//    }

    @GetMapping(path = "bean",produces = {MediaType.APPLICATION_XML_VALUE})
    public String[] beanNamesInSpringContext() {
        logger.info("---------------------- getBeanDefinitionNames() ----------------------");
        return applicationContext.getBeanDefinitionNames();
    }

    @GetMapping(path = "/redisLock")
    public String redisLock() throws InterruptedException {
        logger.debug("redisLock() !!! !!!! ");
        Lock redisLock = redisLockRegistry.obtain("test");
        boolean isLocked = redisLock.tryLock(500, TimeUnit.MILLISECONDS);

        if (isLocked) {
            num--; // 库存-1
            consume++; // 消耗+1
            logger.info("获取锁成功: 库存总量:{} ,库存剩余:{} ,消耗:1", VOLUME, num);
        }

        return "获取锁成功: 库存总量:" + VOLUME + " ,库存剩余:" + num + " ,消耗:1";
    }

    @GetMapping(path = "/redisLockCheck")
    public String redisLockCheck() {
        return "获取锁成功: 库存总量:" + VOLUME + " ,库存剩余:" + num + " ,库存消耗:" + consume;
    }
}
