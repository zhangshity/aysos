package com.zcy.spring.ioc.framework_demo.config;

import com.zcy.spring.ioc.framework_demo.entity.Person;

//@Configuration()
public class ApplicationConfig {

    //@Bean(name="person")
    public Person initPerson() {
        Person person = new Person();
        person.setId(1L);
        person.setName("Jack");
        return person;
    }

}
