package com.gateway.demo.trigger_demo.basic;

import com.gateway.demo.trigger_demo.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Reader implements ItemReader<Person> {
    public static final AtomicInteger count = new AtomicInteger(0);

    @Override
    public Person read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (count.getAndIncrement() < 100) {
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
