package com.zcy.spring.annotation.generic2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Execute {

    @Autowired
    private Audi audi;

    @Autowired
    private Bmw bmw;

    @Bean
    public Audi getAudi() {
        return new Audi();
    }

    @Bean
    public Bmw getBmw() {
        return new Bmw();
    }


    
}
