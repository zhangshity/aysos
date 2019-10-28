package com.zcy.reflect.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = Class.forName("com.zcy.reflect.demo.Person");//反射获取类
        Object object = clazz.newInstance();//实例化类，获取对象
        Method method = clazz.getDeclaredMethod("privateMethodInPerson");//反射强制获取私有方法
        method.setAccessible(true);//是私有方法可用
        Object o = method.invoke(object);//执行方法
        System.out.println(o);

        //===================================
        Method method2 = clazz.getDeclaredMethod("privateMethodInPersonWithArgs", String.class);
        method2.setAccessible(true);
        Object o1 = method2.invoke(object, "我是一个傻逼反射参数");
        System.out.println(o1);
        //===================================
        Class clazz2 = Person.class;
        Constructor constructor = clazz.getConstructor();
        Object object2 = constructor.newInstance();
        Method meth = clazz2.getDeclaredMethod("privateMethodInPersonWithArgs", String.class);
        meth.setAccessible(true);
        Object o22 = meth.invoke(object2, "sdaasd");
        System.out.println(o22);
    }
}
