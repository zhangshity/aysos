package com.gateway.demo.basic_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class TestProcessor implements ItemProcessor<Person, Person> {
    private static final Logger log = LoggerFactory.getLogger(TestProcessor.class);

    @Override
    public Person process(Person item) throws Exception {


        log.info("处理数据 {}", item);


        item.setFirstName("名"+item.getFirstName());
        item.setLastName("姓"+item.getLastName());

        return item;
    }
}
