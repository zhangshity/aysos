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
        System.out.println("单个获取字段: " + fieldName);


        System.out.println("反射接口forName()获取的对象: " + clazz.toString() + "\n"
                + "Reflection new object: " + object);


        // Jan.2.2019 ======反射常用方法梳理
        Class clazz1 = Class.forName("com.zcy.reflect.Person");
        Class clazz2 = Person.class;
        Person person1 = new Person();
        Class clazz3 = person1.getClass();
        System.out.println("\n\n======Jan.2.2019 --------反射常用方法梳理=============class反射: ");
        System.out.println("Class1: " + clazz1);
        System.out.println("Class2: " + clazz2);
        System.out.println("Class3: " + clazz3);

        System.out.println("=============构造器========================");
        Constructor constructor_new = clazz1.getConstructor();
        System.out.println("构造器返回: " + constructor_new);

        System.out.println("=============实例化========================");
        Object object1 = clazz1.newInstance();
        Object object2 = constructor_new.newInstance();
        System.out.println("Class类实例化: " + object1);
        System.out.println("构造器实例化: " + object2);

        System.out.println("=============成员方法========================");
        Method method_11 = clazz1.getMethod("setId", int.class);
        Method method_12 = clazz1.getMethod("setName", String.class);
        Method[] methods_new = clazz1.getMethods();
        for (Method m : methods_new) {
            System.out.println("methods循环输出 " + m);
        }
        System.out.println("setId方法: " + method_11);
        System.out.println("setName: " + method_12);

        System.out.println("=============成员变量========================");
        Field field_11 = clazz1.getDeclaredField("id");
        Field field_12 = clazz1.getDeclaredField("name");
        Field[] fields_new = clazz1.getDeclaredFields();
        for (Field f : fields_new) {
            System.out.println("fields循环输出: " + f);
        }
        System.out.println("id属性: " + field_11);
        System.out.println("name属性: " + field_12);


        System.out.println("=============变量和方法的调用========================");
        method_11.invoke(object1, 3141);
        method_12.invoke(object1, "彭于晏");
//        field_11.set(object2, 1234);
//        field_12.set(object2, "吴彦祖");
        System.out.println(object1 + "\n" + object2);
    }
}
