package com.test.fkredis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DemoMapper {

    @Select("SELECT oef_email_title,oef_email_content\n" +
            "FROM oms_email_format\n" +
            "WHERE oef_email_status = 1 AND oef_email_type = 1 AND oef_email_language = 1")
    List<Map<String, String>> selectTradeRecord();
}
