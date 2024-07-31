package com.gateway.demo.list_demo;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class ConsoleItemWriter implements ItemWriter<Person> {

    @Override
    public void write(List<? extends Person> items) throws Exception {
        System.out.println("写数据"+ items);
//        for (Person person : items) {
//            System.out.println("写数据"+person);
//        }
    }
}
