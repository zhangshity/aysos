package com.zcy.desgin_pattern.singleton.practice;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Person person = Person.getInstance();
        Person person1 = Person.getInstance();
        person.echo();
        person1.echo();

        System.out.println(person == person1);


        //=========================反射方法私有测试======================================
        System.out.println("=======射方法私有测试============(需要starve模式)");
        // 1.获取类
        Class clazz = Class.forName("com.zcy.desgin_pattern.singleton.practice.Cat");
//        System.out.println(clazz);
        // 2.强制获取字段
        Field field = clazz.getDeclaredField("catSingleton");
        field.setAccessible(true);
//        System.out.println(field);

        // 3.强制获取构造器 并实例化
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
//        System.out.println(constructor);
        Object object = constructor.newInstance();
//        System.out.println(object);

        // 4.获取字段值
        Cat cat = (Cat) field.get(object);
//        System.out.println(cat);

        // 5.得到字段中的引用值 并调用其方法
        cat.echo();
    }
}
