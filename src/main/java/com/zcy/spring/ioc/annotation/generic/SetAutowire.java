package com.zcy.spring.ioc.annotation.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SetAutowire {

    @Autowired
    private List<Car> carList;

    @Autowired
    private Map<String, Car> carMap;

    public void say() {
        for (Car car : carList) {
            System.out.println(car.getClass().getName());
        }
        for (Map.Entry entry : carMap.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SetAutowire setAutowire = (SetAutowire) applicationContext.getBean("setAutowire");
        setAutowire.say();
    }
}
