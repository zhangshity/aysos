package com.zcy.desgin_pattern.singleton.practice;

import java.io.File;
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
        Object object = constructor.newInstance();


        Cat cat = (Cat) field.get(object);
        cat.echo();

    }
}
