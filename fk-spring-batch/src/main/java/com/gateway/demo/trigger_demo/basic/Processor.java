package com.gateway.demo.trigger_demo.basic;

import com.gateway.demo.trigger_demo.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class Processor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person item) throws Exception {
        log.info("处理数据 {}", item);

        // 姓 名变大写
        item.setFirstName(item.getFirstName().toUpperCase());
        item.setLastName(item.getLastName().toUpperCase());

        return item;
    }
}
