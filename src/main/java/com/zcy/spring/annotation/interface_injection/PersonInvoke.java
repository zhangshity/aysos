package com.zcy.spring.annotation.interface_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class PersonInvoke {

    @Autowired
    @Qualifier("allen")
//    @Qualifier("bruce")
    private Person person;

    public void say() {
        System.out.println(person);
    }




    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonInvoke personInvoke = (PersonInvoke) applicationContext.getBean("personInvoke");
        personInvoke.say();
    }


}
