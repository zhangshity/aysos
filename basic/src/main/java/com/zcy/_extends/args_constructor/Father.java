package com.zcy._extends.args_constructor;

public class Father {

    String name;

    {
        name = "{father}";
    }

    public Father() {
        System.out.println("father empty constructor");
    }

    public Father(String name) {
        System.out.println("father" + name);
    }


}
