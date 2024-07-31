package com.gateway.demo.trigger_demo.basic;

import com.gateway.demo.trigger_demo.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

@Slf4j
public class Writer implements ItemWriter<Person> {

    @Override
    public void write(List<? extends Person> items) throws Exception {


        log.info("写入数据 {}", items);
    }
}
