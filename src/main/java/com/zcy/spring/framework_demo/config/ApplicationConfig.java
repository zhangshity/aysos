package com.zcy.spring.framework_demo.config;

import com.zcy.spring.framework_demo.entity.Person;
import org.codehaus.plexus.component.annotations.Configuration;

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
