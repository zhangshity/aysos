package com.zcy.test_interface.override_annotation;

import com.zcy.test_interface.override_annotation.abstract_class.Assole;
import com.zcy.test_interface.override_annotation.abstract_class.People;
import com.zcy.test_interface.override_annotation.interface_class.Car;
import com.zcy.test_interface.override_annotation.interface_class.CarImpl;

public class demoMain {
    public static void main(String[] args) {

        //==========inerface======================
        Car car = new CarImpl();

        System.out.println(car.doSomething(1));


        String noOverideAnnotation = ((CarImpl) car).doShit();
        System.out.println(noOverideAnnotation);

        //==========abstract Class================

        People people = new Assole();
        people.doSomeShit();

        ((Assole) people).doNothing();
    }
}
