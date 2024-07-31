package com.gateway.demo.list_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person person) throws Exception {
        String firstName = person.getFirstName().toUpperCase();
        String lastName = person.getLastName().toUpperCase();

        System.out.println("处理数据 "+ person);
        return new Person(firstName, lastName);
    }
}
