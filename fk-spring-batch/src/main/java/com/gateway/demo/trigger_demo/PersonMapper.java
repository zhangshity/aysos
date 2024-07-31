package com.gateway.demo.trigger_demo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PersonMapper {

    @Select("SELECT id, first_name, last_name FROM person limit #{limit}")
    List<Person> selectAllLimit(@Param("limit") Integer limit);

    @Select("SELECT id, first_name, last_name FROM person")
    List<Person> selectAll();



    // -------------------------------------

    @Select("SELECT id, first_name, last_name FROM person where status = #{status} limit #{limit}")
    List<Person> selectAllLimitEnabled(@Param("status") Integer status,@Param("limit") Integer limit);

    @Select("SELECT id, first_name, last_name FROM person where status = #{status}")
    List<Person> selectAllEnabled(@Param("status") Integer status);

    @Update("update person set first_name = #{firstName}, last_name = #{lastName}, status = #{status}, gmt_time = #{gmtTime} where id = #{id}")
    int update(Person person);

    // -------------------------------------




//    @Insert("INSERT INTO person (id, first_name, last_name) VALUES (#{id}, #{firstName}, #{lastName})")
//    void insertPerson(Person person);
//


    void updateBatch(@Param("list") List<? extends Person> list);



}
