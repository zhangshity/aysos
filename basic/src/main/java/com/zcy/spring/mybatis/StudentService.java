package com.zcy.spring.mybatis;

import com.zcy.spring.transaction.dao.Mapper;
import com.zcy.spring.transaction.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentService {

    @Autowired
    private Mapper mapper;

    //========================= 补充测试 查询表返回list是空对象还是 null =========================
    public void testListResultOfEmptyData() {
        List<Student> studentList = mapper.selectAll();
        int size = studentList.size();
        log.info("学生表:{} ,学生表尺寸: {}", studentList, size);
        studentList.forEach(student -> log.info("学生信息: {}", student.getId()));
    }
}
