package com.zcy.spring.transaction.dao;

import com.zcy.spring.transaction.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {

    @Insert("insert into student(name,age) values(#{name},#{age})")
    int insert(Student student);

    @Select("select * from student")
    List<Student> selectAll();
}
