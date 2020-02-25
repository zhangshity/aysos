package com.zcy.spring.annotation.configuration_bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfiguration {

    @Autowired
    @Qualifier("configAllen")
    private Person person;

    @Bean
    public Person getPerson() {
        if (person != null && person.getName() == "Allen") {
            return person;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "PersonConfiguration{" +
                "person=" + person +
                '}';
    }
}
