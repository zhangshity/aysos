package com.gateway.demo.basic_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class TestWriter implements ItemWriter<Person> {
    private static final Logger log = LoggerFactory.getLogger(TestWriter.class);

    @Override
    public void write(List<? extends Person> items) throws Exception {
        log.info("写入数据 {}", items);
    }
}
