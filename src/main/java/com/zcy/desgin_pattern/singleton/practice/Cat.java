package com.zcy.desgin_pattern.singleton.practice;

public class Cat {

    private Cat() {
    }

    private static Cat catSingleton = new Cat();

    public synchronized Cat getInstance() {
        return catSingleton;
    }

    public void echo() {
        System.out.println("Singleton Pattern,starve model");
    }

}
