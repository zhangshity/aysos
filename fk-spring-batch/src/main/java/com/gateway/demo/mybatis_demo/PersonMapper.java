package com.gateway.demo.mybatis_demo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PersonMapper {

    @Select("SELECT id, first_name, last_name FROM person")
    List<Person> selectAll();

    @Insert("INSERT INTO person (id, first_name, last_name) VALUES (#{id}, #{firstName}, #{lastName})")


    void insertPerson(Person person);
}
