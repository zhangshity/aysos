package com.zcy._extends.args_constructor;

public class Son extends Father {

    String name;

    public Son() {
        System.out.println("son empty constructor");
    }

    public Son(String name) {
        this.name = name;
        System.out.println("son" + name);
    }

}
