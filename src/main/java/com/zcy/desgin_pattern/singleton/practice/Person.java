package com.zcy.desgin_pattern.singleton.practice;

public class Person {

    private Person() {
    }

    private static Person singeltonPerson;

    public static synchronized Person getInstance() {
        if (singeltonPerson == null) {
            return singeltonPerson = new Person();
        } else {
            return singeltonPerson;
        }
    }

    public void echo() {
        System.out.println("Private method in Person Class");
    }
}


