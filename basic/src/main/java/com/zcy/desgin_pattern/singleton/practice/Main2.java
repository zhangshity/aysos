package com.zcy.desgin_pattern.singleton.practice;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main2 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class clazz = Class.forName("com.zcy.desgin_pattern.singleton.practice.Cat");

        Field field = clazz.getDeclaredField("catSingleton");
        field.setAccessible(true);

        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Constructor constructor2 = clazz.getDeclaredConstructor();
        constructor2.setAccessible(true);
        Object object = constructor.newInstance();
        Object object2 = constructor2.newInstance();

        Cat cat = (Cat) field.get(object);
        Cat cat2 = (Cat) field.get(object2);
        cat.echo();
        cat2.echo();

        System.out.println("对比: >> " + "cat: " + cat + " cat2: " + cat2);
        //反射获取的两个值是一个对象

        //正常取到获取单利对象
        Object objNormal = Cat.getInstance();
        System.out.println("对比: >> " + "object: " + object + " objNormal: " + objNormal);


    }
}
