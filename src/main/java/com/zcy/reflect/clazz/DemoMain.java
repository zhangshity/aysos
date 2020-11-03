package com.zcy.reflect.clazz;

import java.lang.reflect.Field;

public class DemoMain {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //第一种方式获取Class对象
        Student stu1 = new Student();//这一new 产生一个Student对象，一个Class对象。
        Class stuClass = stu1.getClass();//获取Class对象
        System.out.println(stuClass.getName());

        //第二种方式获取Class对象
        Class stuClass2 = Student.class;
        System.out.println(stuClass == stuClass2);//判断第一种方式获取的Class对象和第二种方式获取的是否是同一个

        //第三种方式获取Class对象
        try {
            Class stuClass3 = Class.forName("com.zcy.reflect.clazz.Student");//注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
            System.out.println(stuClass3 == stuClass2);//判断三种方式是否获取的是同一个Class对象
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }







        //================获取字段====================
        System.out.println("================获取字段====================\n");
        Student student = new Student();
        student.setId(3141906);
        student.setName("CY爹");

        Class<? extends Student> clazz = student.getClass();
        Field id = clazz.getDeclaredField("id");
        Field name = clazz.getDeclaredField("name");
        id.setAccessible(true);
        name.setAccessible(true);

        System.out.println(id);
        System.out.println((int) id.get(student));
        System.out.println((String) name.get(student));
    }
}
