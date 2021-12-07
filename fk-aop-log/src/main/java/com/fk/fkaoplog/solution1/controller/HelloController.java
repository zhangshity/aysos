package com.fk.fkaoplog.solution1.controller;

import com.fk.fkaoplog.solution1.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @PostMapping("/hello")
    public Student getStudent(@RequestBody Student param) {
        log.info("===手工日志=== req param：{}", param);

        Student student = new Student();
        student.setName("张三");
        student.setAge(18);
        student.setBankCardNo("62140000000000932");
        student.setIdCardNo("441231215435345");
        student.setMobilePhone("1542421412");

        log.info("===手工日志=== resp param：{}", student);

        return student;
    }
}
