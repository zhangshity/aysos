package com.zcy.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo {


    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {

        //==============正常调用一个类==============================================
        Person person = new Person();
        person.setId(123);
        person.setName("龚嘉阳");

        System.out.println("Person Info:  -->\n" +
                "ID:" + person.getId() + ",Name:" + person.getName() + "\n" +
                person + "\n");


        //==============反射调用==============================================

        //获取class对象实例 (因为在运行时,只能先从实例中拿)
        Class clazz = Class.forName("com.zcy.reflect.Person");
//        Class clazz = com.zcy.reflect.Person.class;
//        Class clazz = person.getClass();

        //获取构造函数对象
        Constructor constructor = clazz.getConstructor();

        //构造函数对象获取 反射类对象 (实际就就是一个新对象)
        Object object = constructor.newInstance();

//        System.out.println("====反射新实例化对象之前比较 person ?= clazz  " + (person.equals(clazz)));
        //获取方法对象
        Method method = clazz.getMethod("setId", int.class);
        Method method1 = clazz.getMethod("setName", String.class);

        //调用对象方法(多个)
        method.invoke(object, 3141);
        method1.invoke(object, "Young");

        //调用对象字段(单个)
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Field field = clazz.getDeclaredField("id");
        String fieldName = field.getName();
        System.out.println("单个获取字段: "+fieldName);


        System.out.println("反射接口forName()获取的对象: " + clazz.toString() + "\n"
                + "Reflection new object: " + object);
    }
}
