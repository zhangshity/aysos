package com.zcy._classloader.zcy_classloader;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        MyClassLoader myClassLoader = new MyClassLoader("/Users/zhangchunyang/Desktop/", "ZCY's ClassLoader");
//        Class clazz = myClassLoader.findClass("Student");
        Class clazz = myClassLoader.loadClass("Student");
        System.out.println(clazz.getClassLoader());
        Object instance = clazz.newInstance();
        System.out.println(instance);

    }
}
