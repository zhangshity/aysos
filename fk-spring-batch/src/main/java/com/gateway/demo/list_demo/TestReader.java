package com.gateway.demo.list_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.concurrent.atomic.AtomicInteger;

public class TestReader implements ItemReader<Person> {

    public static final AtomicInteger count = new AtomicInteger(0);


    private static final Logger log = LoggerFactory.getLogger(TestReader.class);

    @Override
    public Person read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        if (count.getAndIncrement() < 5) {
            count.incrementAndGet();

            Person person = new Person();
            person.setFirstName("John" + count.get());
            person.setLastName("Doe"+ count.get());
            log.info("读取数据 {}", person);

            return person;
        } else {
            log.warn("数据读取完成");
            return null;
        }
    }
}
